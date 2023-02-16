package rest;

import io.javalin.Javalin;
import io.javalin.http.ContentType;
import io.javalin.http.HttpCode;
import org.json.JSONObject;
import utilities.CharFormatConverter;
import utilities.Constants;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static utilities.Constants.ONE_MILLION;

/**
 * Clase para operaciones de conversión entre ASCII y EBCDIC.
 * @author Equipo de desarrollo de Switch Capa de Integración - Ecosistemas digitales
 * Líder Técnico: Wilson Martinez.
 */
public class CharFormatConverterRestController {
    Javalin app;
    private Map<String, Object> statusInformation = new ConcurrentHashMap<>();
    private java.time.LocalDateTime elapsedDateTime;
    private static Integer serverPortRunning;
    private AtomicInteger succesfulConvertions = new AtomicInteger(0);
    private AtomicInteger unsuccesfulConvertions = new AtomicInteger(0);
    public static final String DATA_EBCDIC_KEY = "DATA_EBCDIC";
    public static final String DATA_ASCII_KEY = "DATA_ASCII";
    private static final String PROCESS_TIME_KEY = "PROCESS_TIME";
    private static final String ERROR_MESSAGE_KEY = "ERROR_MESSAGE";
    private static final String MICROSERVICE_STATUS_KEY = "MICROSERVICE_STATUS";
    private static final String MICROSERVICE_IS_ABLE_TO_OPERATE_KEY = "MICROSERVICE_IS_ABLE_TO_OPERATE";
    private boolean microserviceIsAbleToOperate = false;
    public static final String ENDPOINT_STATUS = "/status";
    public static final String ENDPOINT_ASCII_TO_EBCDIC = "/ascii-to-ebcdic";
    public static final String ENDPOINT_EBCDIC_TO_ASCII = "/ebcdic-to-ascii";

    /**
     * Método para ejecutar el microservicio.
     * @param serverPort Número de puerto para la ejecución del microservicio. Si no se ingresa un número de puerto válido, se asignará por defecto el puerto 8080, o en caso contrario, un puerto aleatorio.
     */
    public void loadRestController(Integer serverPort){

        //Configuración de número de puerto personalizado para este microservicio.
        if(serverPort!=null && serverPort > 1023 && serverPort < 65536) {
            try{
                app = Javalin.create().start(serverPort);
            }
            catch(Exception serverPortException) {
                System.out.println("\nNo es posible utilizar el número de puerto especificado.\n");
                try{
                    app = Javalin.create().start();
                }
                catch (Exception busyServerPortException){
                    app = Javalin.create().start(0);// Ejecución del microservicio en un puerto aleatorio.
                }
            }
        }
        else {
            try{
                app = Javalin.create().start();
            }
            catch (Exception javalinAppDefaultPortException){
                app = Javalin.create().start(0);// Ejecución del microservicio en un puerto aleatorio.
            }
        }
        microserviceIsAbleToOperate = true;
        serverPortRunning = app.port();
        elapsedDateTime = LocalDateTime.now(ZoneId.systemDefault());

        // Endpoint para mostrar el estado de este microservicio.
        app.get(ENDPOINT_STATUS,
                ctx -> {
                    Long initialTimeInNanos = System.nanoTime();
                    statusInformation.put("Microservice elapsed since", elapsedDateTime);
                    statusInformation.put(MICROSERVICE_IS_ABLE_TO_OPERATE_KEY, microserviceIsAbleToOperate ? "Microservicio "+this.getClass().getSimpleName()+" está operando normalmente." : "Microservicio "+this.getClass().getSimpleName()+" no está operando normalmente.");
                    statusInformation.put("succesfulConvertions", succesfulConvertions.get());
                    if(unsuccesfulConvertions.get()>0) statusInformation.put("unsuccessfulConvertions", unsuccesfulConvertions.get());
                    Map<String, Object> response = new HashMap<>();
                    response.put(Constants.Z_STATUS_KEY, Constants.Z_STATUS_ENUM.SUCCESS);
                    response.put(MICROSERVICE_STATUS_KEY, this.statusInformation);
                    response.put(PROCESS_TIME_KEY, generateProcessTimeMessageFrom(initialTimeInNanos));
                    ctx.status(HttpCode.OK)
                            .contentType(ContentType.APPLICATION_JSON)
                            .result( new JSONObject( response ).toString() );
                }
        );

        // Endpoint de conversión de ASCII a EBCDIC.
        app.get(ENDPOINT_ASCII_TO_EBCDIC,
                ctx -> {
                    Long initialTimeInNanos = System.nanoTime();
                    Map<String, Object> response = new HashMap<>();
                    String data = ctx.queryParam("data");
                    //System.out.println("data - longitud: "+data.length()+"\tdata:\t"+data);
                    data = data.replace(" ", "");
                    //System.out.println("data - longitud sin espacios: "+data.length()+"\tdata:\t"+data);
                    try{
                        if(data!=null && !data.isEmpty()){
                            String dataEbcdic = CharFormatConverter.convertHexaASCII2HexaEBCDIC(data);
                            response.put(DATA_EBCDIC_KEY, dataEbcdic);
                            response.put(Constants.Z_STATUS_KEY, Constants.Z_STATUS_ENUM.SUCCESS);
                            succesfulConvertions.incrementAndGet();
                        }
                        else {
                            throw new NullPointerException();
                        }
                    }
                    catch (IllegalArgumentException illegalArgumentException){
                        response.put(Constants.Z_STATUS_KEY, Constants.Z_STATUS_ENUM.FAILED);
                        response.put(ERROR_MESSAGE_KEY, "El dato a convertir no es válido. Debe ser un valor en Hexadecimal y tener longitud par.");
                    }
                    catch (NullPointerException nullPointerException){
                        response.put(Constants.Z_STATUS_KEY, Constants.Z_STATUS_ENUM.FAILED);
                        response.put(ERROR_MESSAGE_KEY, "El dato a convertir no es válido. Debe tener valor no nulo.");
                    }
                    catch (Exception otherException){
                        response.put(Constants.Z_STATUS_KEY, Constants.Z_STATUS_ENUM.FAILED);
                        response.put(ERROR_MESSAGE_KEY, "" + otherException.getMessage());
                    }
                    response.put(PROCESS_TIME_KEY, generateProcessTimeMessageFrom(initialTimeInNanos));
                    ctx.status(HttpCode.OK)
                            .contentType(ContentType.APPLICATION_JSON)
                            .result(new JSONObject(response).toString());
                }
        );

        // Endpoint de conversión de EBCDIC a ASCII.
        app.get(ENDPOINT_EBCDIC_TO_ASCII,
                ctx -> {
                    Long initialTimeInNanos = System.nanoTime();
                    Map<String, Object> response = new HashMap<>();
                    String data = ctx.queryParam("data");
                    //System.out.println("data - longitud: "+data.length()+"\tdata:\t"+data);
                    data = data.replace(" ", "");
                    //System.out.println("data - longitud sin espacios: "+data.length()+"\tdata:\t"+data);
                    try{
                        if(data!=null && !data.isEmpty()){
                            String dataAscii = CharFormatConverter.convertHexaEBCDIC2HexaASCII(data);
                            response.put(DATA_ASCII_KEY, dataAscii);
                            response.put(Constants.Z_STATUS_KEY, Constants.Z_STATUS_ENUM.SUCCESS);
                            succesfulConvertions.incrementAndGet();
                            //System.out.println(DATA_ASCII_KEY + ":\t" + dataAscii);
                        }
                        else {
                            throw new NullPointerException();
                        }
                    }
                    catch (IllegalArgumentException illegalArgumentException){
                        response.put(Constants.Z_STATUS_KEY, Constants.Z_STATUS_ENUM.FAILED);
                        response.put(ERROR_MESSAGE_KEY, "El dato a convertir no es válido. Debe ser un valor en Hexadecimal y tener longitud par.");
                    }
                    catch (NullPointerException nullPointerException){
                        response.put(Constants.Z_STATUS_KEY, Constants.Z_STATUS_ENUM.FAILED);
                        response.put(ERROR_MESSAGE_KEY, "El dato a convertir no es válido. Debe tener valor no nulo.");
                    }
                    catch (Exception otherException){
                        response.put(Constants.Z_STATUS_KEY, Constants.Z_STATUS_ENUM.FAILED);
                        response.put(ERROR_MESSAGE_KEY, "" + otherException.getMessage());
                    }
                    response.put(PROCESS_TIME_KEY, generateProcessTimeMessageFrom(initialTimeInNanos));
                    ctx.status(HttpCode.OK)
                            .contentType(ContentType.APPLICATION_JSON)
                            .result(new JSONObject(response).toString());
                }
        );
    }

    private String generateProcessTimeMessageFrom(Long initialTimeInNanos){
        return ((double)(System.nanoTime()-initialTimeInNanos)/ONE_MILLION)+" milliseconds";
    }

    /**
     * Retorna el número del puerto en que se está ejecutando el microservicio.
     * @return Número de puerto de ejecución del microservicio.
     */
    public Integer getServerPort(){
        return serverPortRunning;
    }
}

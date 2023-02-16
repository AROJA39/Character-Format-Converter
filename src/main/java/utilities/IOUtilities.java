package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Clase utilitaria para operaciones de lectura y escritura, útil para leer desde microservicios externos.
 * @author Equipo de desarrollo de Switch Capa de Integración - Ecosistemas digitales
 * Líder Técnico: Wilson Martinez.
 */
public class IOUtilities {

    /**
     * Método que recibe un flujo de entrada y lo retorna en una cadena de caracteres.
     * @param is Flujo de entrada.
     * @return Cadena de caracteres con el contenido del fluo de entrada.
     * @throws IOException En caso de no poder leerse el flujo de entrada o no poderse almacenar en una cadena de caracteres.
     */
    public static final String readFullyAsString(InputStream is ) throws IOException {
        BufferedReader brBufferedReader = new BufferedReader(new InputStreamReader(is));
        StringBuffer stringBuffer = new StringBuffer();
        String aux = null;
        while ((aux = brBufferedReader.readLine()) != null) {
            stringBuffer.append(aux);
        }
        return stringBuffer.toString();
    }
}

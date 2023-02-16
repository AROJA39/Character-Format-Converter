package utilities;

import javax.xml.bind.DatatypeConverter;

/**
 * Clase para conversión entre formatos ASCII y EBCDIC.
 * @author Equipo de desarrollo de Switch Capa de Integración - Ecosistemas digitales
 * Líder Técnico: Wilson Martinez.
 */
public class CharFormatConverter {
	/**
	 * Arreglo de bytes en formato ASCII con índice en formato EBCDIC.
	 */
	public static final byte[] EBCDIC2ASCII;
	/**
	 * Arreglo de bytes en formato EBCDIC con índice en formato ASCII.
	 */
	public static final byte[] ASCII2EBCDIC;
	static {
		EBCDIC2ASCII = new byte[256];
		/*EBCDIC2ASCII[0x00] = (byte) 0x00;
		EBCDIC2ASCII[0x01] = (byte) 0x01;
		EBCDIC2ASCII[0x02] = (byte) 0x02;
		EBCDIC2ASCII[0x03] = (byte) 0x03;
		EBCDIC2ASCII[0x04] = (byte) 0x37;
		EBCDIC2ASCII[0x05] = (byte) 0x2D;
		EBCDIC2ASCII[0x06] = (byte) 0x2E;
		EBCDIC2ASCII[0x07] = (byte) 0x2F;
		EBCDIC2ASCII[0x08] = (byte) 0x16;
		EBCDIC2ASCII[0x09] = (byte) 0x05;
		EBCDIC2ASCII[0x0A] = (byte) 0x25;
		EBCDIC2ASCII[0x0B] = (byte) 0x0B;
		EBCDIC2ASCII[0x0C] = (byte) 0x0C;
		EBCDIC2ASCII[0x0D] = (byte) 0x0D;
		EBCDIC2ASCII[0x0E] = (byte) 0x0E;
		EBCDIC2ASCII[0x0F] = (byte) 0x0F;
		EBCDIC2ASCII[0x10] = (byte) 0x10;
		EBCDIC2ASCII[0x11] = (byte) 0x11;
		EBCDIC2ASCII[0x12] = (byte) 0x12;
		EBCDIC2ASCII[0x13] = (byte) 0x13;
		EBCDIC2ASCII[0x14] = (byte) 0x3C;
		EBCDIC2ASCII[0x15] = (byte) 0x3D;
		EBCDIC2ASCII[0x16] = (byte) 0x32;
		EBCDIC2ASCII[0x17] = (byte) 0x26;
		EBCDIC2ASCII[0x18] = (byte) 0x18;
		EBCDIC2ASCII[0x19] = (byte) 0x19;
		EBCDIC2ASCII[0x1A] = (byte) 0x3F;
		EBCDIC2ASCII[0x1B] = (byte) 0x27;
		EBCDIC2ASCII[0x1C] = (byte) 0x1C;
		EBCDIC2ASCII[0x1D] = (byte) 0x1D;
		EBCDIC2ASCII[0x1E] = (byte) 0x1E;
		EBCDIC2ASCII[0x1F] = (byte) 0x1F;
		EBCDIC2ASCII[0x20] = (byte) 0x40;
		EBCDIC2ASCII[0x21] = (byte) 0x4F;
		EBCDIC2ASCII[0x22] = (byte) 0x7F;
		EBCDIC2ASCII[0x23] = (byte) 0x7B;
		EBCDIC2ASCII[0x24] = (byte) 0x5B;
		EBCDIC2ASCII[0x25] = (byte) 0x6C;
		EBCDIC2ASCII[0x26] = (byte) 0x50;
		EBCDIC2ASCII[0x27] = (byte) 0x7D;
		EBCDIC2ASCII[0x28] = (byte) 0x4D;
		EBCDIC2ASCII[0x29] = (byte) 0x5D;
		EBCDIC2ASCII[0x2A] = (byte) 0x5C;
		EBCDIC2ASCII[0x2B] = (byte) 0x4E;
		EBCDIC2ASCII[0x2C] = (byte) 0x6B;
		EBCDIC2ASCII[0x2D] = (byte) 0x60;
		EBCDIC2ASCII[0x2E] = (byte) 0x4B;
		EBCDIC2ASCII[0x2F] = (byte) 0x61;
		EBCDIC2ASCII[0x30] = (byte) 0xF0;
		EBCDIC2ASCII[0x31] = (byte) 0xF1;
		EBCDIC2ASCII[0x32] = (byte) 0xF2;
		EBCDIC2ASCII[0x33] = (byte) 0xF3;
		EBCDIC2ASCII[0x34] = (byte) 0xF4;
		EBCDIC2ASCII[0x35] = (byte) 0xF5;
		EBCDIC2ASCII[0x36] = (byte) 0xF6;
		EBCDIC2ASCII[0x37] = (byte) 0xF7;
		EBCDIC2ASCII[0x38] = (byte) 0xF8;
		EBCDIC2ASCII[0x39] = (byte) 0xF9;
		EBCDIC2ASCII[0x3A] = (byte) 0x7A;
		EBCDIC2ASCII[0x3B] = (byte) 0x5E;
		EBCDIC2ASCII[0x3C] = (byte) 0x4C;
		EBCDIC2ASCII[0x3D] = (byte) 0x7E;
		EBCDIC2ASCII[0x3E] = (byte) 0x6E;
		EBCDIC2ASCII[0x3F] = (byte) 0x6F;
		EBCDIC2ASCII[0x40] = (byte) 0x7C;
		EBCDIC2ASCII[0x41] = (byte) 0xC1;
		EBCDIC2ASCII[0x42] = (byte) 0xC2;
		EBCDIC2ASCII[0x43] = (byte) 0xC3;
		EBCDIC2ASCII[0x44] = (byte) 0xC4;
		EBCDIC2ASCII[0x45] = (byte) 0xC5;
		EBCDIC2ASCII[0x46] = (byte) 0xC6;
		EBCDIC2ASCII[0x47] = (byte) 0xC7;
		EBCDIC2ASCII[0x48] = (byte) 0xC8;
		EBCDIC2ASCII[0x49] = (byte) 0xC9;
		EBCDIC2ASCII[0x4A] = (byte) 0xD1;
		EBCDIC2ASCII[0x4B] = (byte) 0xD2;
		EBCDIC2ASCII[0x4C] = (byte) 0xD3;
		EBCDIC2ASCII[0x4D] = (byte) 0xD4;
		EBCDIC2ASCII[0x4E] = (byte) 0xD5;
		EBCDIC2ASCII[0x4F] = (byte) 0xD6;
		EBCDIC2ASCII[0x50] = (byte) 0xD7;
		EBCDIC2ASCII[0x51] = (byte) 0xD8;
		EBCDIC2ASCII[0x52] = (byte) 0xD9;
		EBCDIC2ASCII[0x53] = (byte) 0xE2;
		EBCDIC2ASCII[0x54] = (byte) 0xE3;
		EBCDIC2ASCII[0x55] = (byte) 0xE4;
		EBCDIC2ASCII[0x56] = (byte) 0xE5;
		EBCDIC2ASCII[0x57] = (byte) 0xE6;
		EBCDIC2ASCII[0x58] = (byte) 0xE7;
		EBCDIC2ASCII[0x59] = (byte) 0xE8;
		EBCDIC2ASCII[0x5A] = (byte) 0xE9;
		EBCDIC2ASCII[0x5B] = (byte) 0x4A;
		EBCDIC2ASCII[0x5C] = (byte) 0xE0;
		EBCDIC2ASCII[0x5D] = (byte) 0x5A;
		EBCDIC2ASCII[0x5E] = (byte) 0x5F;
		EBCDIC2ASCII[0x5F] = (byte) 0x6D;
		EBCDIC2ASCII[0x60] = (byte) 0x79;
		EBCDIC2ASCII[0x61] = (byte) 0x81;
		EBCDIC2ASCII[0x62] = (byte) 0x82;
		EBCDIC2ASCII[0x63] = (byte) 0x83;
		EBCDIC2ASCII[0x64] = (byte) 0x84;
		EBCDIC2ASCII[0x65] = (byte) 0x85;
		EBCDIC2ASCII[0x66] = (byte) 0x86;
		EBCDIC2ASCII[0x67] = (byte) 0x87;
		EBCDIC2ASCII[0x68] = (byte) 0x88;
		EBCDIC2ASCII[0x69] = (byte) 0x89;
		EBCDIC2ASCII[0x6A] = (byte) 0x91;
		EBCDIC2ASCII[0x6B] = (byte) 0x92;
		EBCDIC2ASCII[0x6C] = (byte) 0x93;
		EBCDIC2ASCII[0x6D] = (byte) 0x94;
		EBCDIC2ASCII[0x6E] = (byte) 0x95;
		EBCDIC2ASCII[0x6F] = (byte) 0x96;
		EBCDIC2ASCII[0x70] = (byte) 0x97;
		EBCDIC2ASCII[0x71] = (byte) 0x98;
		EBCDIC2ASCII[0x72] = (byte) 0x99;
		EBCDIC2ASCII[0x73] = (byte) 0xA2;
		EBCDIC2ASCII[0x74] = (byte) 0xA3;
		EBCDIC2ASCII[0x75] = (byte) 0xA4;
		EBCDIC2ASCII[0x76] = (byte) 0xA5;
		EBCDIC2ASCII[0x77] = (byte) 0xA6;
		EBCDIC2ASCII[0x78] = (byte) 0xA7;
		EBCDIC2ASCII[0x79] = (byte) 0xA8;
		EBCDIC2ASCII[0x7A] = (byte) 0xA9;
		EBCDIC2ASCII[0x7B] = (byte) 0xC0;
		EBCDIC2ASCII[0x7C] = (byte) 0x6A;
		EBCDIC2ASCII[0x7D] = (byte) 0xD0;
		EBCDIC2ASCII[0x7E] = (byte) 0xA1;
		EBCDIC2ASCII[0x7F] = (byte) 0x07;
		EBCDIC2ASCII[0x80] = (byte) 0x20;
		EBCDIC2ASCII[0x81] = (byte) 0x21;
		EBCDIC2ASCII[0x82] = (byte) 0x22;
		EBCDIC2ASCII[0x83] = (byte) 0x23;
		EBCDIC2ASCII[0x84] = (byte) 0x24;
		EBCDIC2ASCII[0x85] = (byte) 0x15;
		EBCDIC2ASCII[0x86] = (byte) 0x06;
		EBCDIC2ASCII[0x87] = (byte) 0x17;
		EBCDIC2ASCII[0x88] = (byte) 0x28;
		EBCDIC2ASCII[0x89] = (byte) 0x29;
		EBCDIC2ASCII[0x8A] = (byte) 0x2A;
		EBCDIC2ASCII[0x8B] = (byte) 0x2B;
		EBCDIC2ASCII[0x8C] = (byte) 0x2C;
		EBCDIC2ASCII[0x8D] = (byte) 0x09;
		EBCDIC2ASCII[0x8E] = (byte) 0x0A;
		EBCDIC2ASCII[0x8F] = (byte) 0x1B;
		EBCDIC2ASCII[0x90] = (byte) 0x30;
		EBCDIC2ASCII[0x91] = (byte) 0x31;
		EBCDIC2ASCII[0x92] = (byte) 0x1A;
		EBCDIC2ASCII[0x93] = (byte) 0x33;
		EBCDIC2ASCII[0x94] = (byte) 0x34;
		EBCDIC2ASCII[0x95] = (byte) 0x35;
		EBCDIC2ASCII[0x96] = (byte) 0x36;
		EBCDIC2ASCII[0x97] = (byte) 0x08;
		EBCDIC2ASCII[0x98] = (byte) 0x38;
		EBCDIC2ASCII[0x99] = (byte) 0x39;
		EBCDIC2ASCII[0x9A] = (byte) 0x3A;
		EBCDIC2ASCII[0x9B] = (byte) 0x3B;
		EBCDIC2ASCII[0x9C] = (byte) 0x04;
		EBCDIC2ASCII[0x9D] = (byte) 0x14;
		EBCDIC2ASCII[0x9E] = (byte) 0x3E;
		EBCDIC2ASCII[0x9F] = (byte) 0xE1;
		EBCDIC2ASCII[0xA0] = (byte) 0x41;
		EBCDIC2ASCII[0xA1] = (byte) 0x42;
		EBCDIC2ASCII[0xA2] = (byte) 0x43;
		EBCDIC2ASCII[0xA3] = (byte) 0x44;
		EBCDIC2ASCII[0xA4] = (byte) 0x45;
		EBCDIC2ASCII[0xA5] = (byte) 0x46;
		EBCDIC2ASCII[0xA6] = (byte) 0x47;
		EBCDIC2ASCII[0xA7] = (byte) 0x48;
		EBCDIC2ASCII[0xA8] = (byte) 0x49;
		EBCDIC2ASCII[0xA9] = (byte) 0x51;
		EBCDIC2ASCII[0xAA] = (byte) 0x52;
		EBCDIC2ASCII[0xAB] = (byte) 0x53;
		EBCDIC2ASCII[0xAC] = (byte) 0x54;
		EBCDIC2ASCII[0xAD] = (byte) 0x55;
		EBCDIC2ASCII[0xAE] = (byte) 0x56;
		EBCDIC2ASCII[0xAF] = (byte) 0x57;
		EBCDIC2ASCII[0xB0] = (byte) 0x58;
		EBCDIC2ASCII[0xB1] = (byte) 0x59;
		EBCDIC2ASCII[0xB2] = (byte) 0x62;
		EBCDIC2ASCII[0xB3] = (byte) 0x63;
		EBCDIC2ASCII[0xB4] = (byte) 0x64;
		EBCDIC2ASCII[0xB5] = (byte) 0x65;
		EBCDIC2ASCII[0xB6] = (byte) 0x66;
		EBCDIC2ASCII[0xB7] = (byte) 0x67;
		EBCDIC2ASCII[0xB8] = (byte) 0x68;
		EBCDIC2ASCII[0xB9] = (byte) 0x69;
		EBCDIC2ASCII[0xBA] = (byte) 0x70;
		EBCDIC2ASCII[0xBB] = (byte) 0x71;
		EBCDIC2ASCII[0xBC] = (byte) 0x72;
		EBCDIC2ASCII[0xBD] = (byte) 0x73;
		EBCDIC2ASCII[0xBE] = (byte) 0x74;
		EBCDIC2ASCII[0xBF] = (byte) 0x75;
		EBCDIC2ASCII[0xC0] = (byte) 0x76;
		EBCDIC2ASCII[0xC1] = (byte) 0x77;
		EBCDIC2ASCII[0xC2] = (byte) 0x78;
		EBCDIC2ASCII[0xC3] = (byte) 0x80;
		EBCDIC2ASCII[0xC4] = (byte) 0x8A;
		EBCDIC2ASCII[0xC5] = (byte) 0x8B;
		EBCDIC2ASCII[0xC6] = (byte) 0x8C;
		EBCDIC2ASCII[0xC7] = (byte) 0x8D;
		EBCDIC2ASCII[0xC8] = (byte) 0x8E;
		EBCDIC2ASCII[0xC9] = (byte) 0x8F;
		EBCDIC2ASCII[0xCA] = (byte) 0x90;
		EBCDIC2ASCII[0xCB] = (byte) 0x9A;
		EBCDIC2ASCII[0xCC] = (byte) 0x9B;
		EBCDIC2ASCII[0xCD] = (byte) 0x9C;
		EBCDIC2ASCII[0xCE] = (byte) 0x9D;
		EBCDIC2ASCII[0xCF] = (byte) 0x9E;
		EBCDIC2ASCII[0xD0] = (byte) 0x9F;
		EBCDIC2ASCII[0xD1] = (byte) 0xA0;
		EBCDIC2ASCII[0xD2] = (byte) 0xAA;
		EBCDIC2ASCII[0xD3] = (byte) 0xAB;
		EBCDIC2ASCII[0xD4] = (byte) 0xAC;
		EBCDIC2ASCII[0xD5] = (byte) 0xAD;
		EBCDIC2ASCII[0xD6] = (byte) 0xAE;
		EBCDIC2ASCII[0xD7] = (byte) 0xAF;
		EBCDIC2ASCII[0xD8] = (byte) 0xB0;
		EBCDIC2ASCII[0xD9] = (byte) 0xB1;
		EBCDIC2ASCII[0xDA] = (byte) 0xB2;
		EBCDIC2ASCII[0xDB] = (byte) 0xB3;
		EBCDIC2ASCII[0xDC] = (byte) 0xB4;
		EBCDIC2ASCII[0xDD] = (byte) 0xB5;
		EBCDIC2ASCII[0xDE] = (byte) 0xB6;
		EBCDIC2ASCII[0xDF] = (byte) 0xB7;
		EBCDIC2ASCII[0xE0] = (byte) 0xB8;
		EBCDIC2ASCII[0xE1] = (byte) 0xB9;
		EBCDIC2ASCII[0xE2] = (byte) 0xBA;
		EBCDIC2ASCII[0xE3] = (byte) 0xBB;
		EBCDIC2ASCII[0xE4] = (byte) 0xBC;
		EBCDIC2ASCII[0xE5] = (byte) 0xBD;
		EBCDIC2ASCII[0xE6] = (byte) 0xBE;
		EBCDIC2ASCII[0xE7] = (byte) 0xBF;
		EBCDIC2ASCII[0xE8] = (byte) 0xCA;
		EBCDIC2ASCII[0xE9] = (byte) 0xCB;
		EBCDIC2ASCII[0xEA] = (byte) 0xCC;
		EBCDIC2ASCII[0xEB] = (byte) 0xCD;
		EBCDIC2ASCII[0xEC] = (byte) 0xCE;
		EBCDIC2ASCII[0xED] = (byte) 0xCF;
		EBCDIC2ASCII[0xEE] = (byte) 0xDA;
		EBCDIC2ASCII[0xEF] = (byte) 0xDB;
		EBCDIC2ASCII[0xF0] = (byte) 0xDC;
		EBCDIC2ASCII[0xF1] = (byte) 0xDD;
		EBCDIC2ASCII[0xF2] = (byte) 0xDE;
		EBCDIC2ASCII[0xF3] = (byte) 0xDF;
		EBCDIC2ASCII[0xF4] = (byte) 0xEA;
		EBCDIC2ASCII[0xF5] = (byte) 0xEB;
		EBCDIC2ASCII[0xF6] = (byte) 0xEC;
		EBCDIC2ASCII[0xF7] = (byte) 0xED;
		EBCDIC2ASCII[0xF8] = (byte) 0xEE;
		EBCDIC2ASCII[0xF9] = (byte) 0xEF;
		EBCDIC2ASCII[0xFA] = (byte) 0xFA;
		EBCDIC2ASCII[0xFB] = (byte) 0xFB;
		EBCDIC2ASCII[0xFC] = (byte) 0xFC;
		EBCDIC2ASCII[0xFD] = (byte) 0xFD;
		EBCDIC2ASCII[0xFE] = (byte) 0xFE;
		EBCDIC2ASCII[0xFF] = (byte) 0xFF;*/
		EBCDIC2ASCII[0x00] = (byte) 0x00;
		EBCDIC2ASCII[0x01] = (byte) 0x01;
		EBCDIC2ASCII[0x02] = (byte) 0x02;
		EBCDIC2ASCII[0x03] = (byte) 0x03;
		EBCDIC2ASCII[0x04] = (byte) 0x9C;
		EBCDIC2ASCII[0x05] = (byte) 0x09;
		EBCDIC2ASCII[0x06] = (byte) 0x86;
		EBCDIC2ASCII[0x07] = (byte) 0x7F;
		EBCDIC2ASCII[0x08] = (byte) 0x97;
		EBCDIC2ASCII[0x09] = (byte) 0x8D;
		EBCDIC2ASCII[0x0A] = (byte) 0x8E;
		EBCDIC2ASCII[0x0B] = (byte) 0x0B;
		EBCDIC2ASCII[0x0C] = (byte) 0x0C;
		EBCDIC2ASCII[0x0D] = (byte) 0x0D;
		EBCDIC2ASCII[0x0E] = (byte) 0x0E;
		EBCDIC2ASCII[0x0F] = (byte) 0x0F;
		EBCDIC2ASCII[0x10] = (byte) 0x10;
		EBCDIC2ASCII[0x11] = (byte) 0x11;
		EBCDIC2ASCII[0x12] = (byte) 0x12;
		EBCDIC2ASCII[0x13] = (byte) 0x13;
		EBCDIC2ASCII[0x14] = (byte) 0x9D;
		EBCDIC2ASCII[0x15] = (byte) 0x85;
		EBCDIC2ASCII[0x16] = (byte) 0x08;
		EBCDIC2ASCII[0x17] = (byte) 0x87;
		EBCDIC2ASCII[0x18] = (byte) 0x18;
		EBCDIC2ASCII[0x19] = (byte) 0x19;
		EBCDIC2ASCII[0x1A] = (byte) 0x92;
		EBCDIC2ASCII[0x1B] = (byte) 0x8F;
		EBCDIC2ASCII[0x1C] = (byte) 0x1C;
		EBCDIC2ASCII[0x1D] = (byte) 0x1D;
		EBCDIC2ASCII[0x1E] = (byte) 0x1E;
		EBCDIC2ASCII[0x1F] = (byte) 0x1F;
		EBCDIC2ASCII[0x20] = (byte) 0x80;
		EBCDIC2ASCII[0x21] = (byte) 0x81;
		EBCDIC2ASCII[0x22] = (byte) 0x82;
		EBCDIC2ASCII[0x23] = (byte) 0x83;
		EBCDIC2ASCII[0x24] = (byte) 0x84;
		EBCDIC2ASCII[0x25] = (byte) 0x0A;
		EBCDIC2ASCII[0x26] = (byte) 0x17;
		EBCDIC2ASCII[0x27] = (byte) 0x1B;
		EBCDIC2ASCII[0x28] = (byte) 0x88;
		EBCDIC2ASCII[0x29] = (byte) 0x89;
		EBCDIC2ASCII[0x2A] = (byte) 0x8A;
		EBCDIC2ASCII[0x2B] = (byte) 0x8B;
		EBCDIC2ASCII[0x2C] = (byte) 0x8C;
		EBCDIC2ASCII[0x2D] = (byte) 0x05;
		EBCDIC2ASCII[0x2E] = (byte) 0x06;
		EBCDIC2ASCII[0x2F] = (byte) 0x07;
		EBCDIC2ASCII[0x30] = (byte) 0x90;
		EBCDIC2ASCII[0x31] = (byte) 0x91;
		EBCDIC2ASCII[0x32] = (byte) 0x16;
		EBCDIC2ASCII[0x33] = (byte) 0x93;
		EBCDIC2ASCII[0x34] = (byte) 0x94;
		EBCDIC2ASCII[0x35] = (byte) 0x95;
		EBCDIC2ASCII[0x36] = (byte) 0x96;
		EBCDIC2ASCII[0x37] = (byte) 0x04;
		EBCDIC2ASCII[0x38] = (byte) 0x98;
		EBCDIC2ASCII[0x39] = (byte) 0x99;
		EBCDIC2ASCII[0x3A] = (byte) 0x9A;
		EBCDIC2ASCII[0x3B] = (byte) 0x9B;
		EBCDIC2ASCII[0x3C] = (byte) 0x14;
		EBCDIC2ASCII[0x3D] = (byte) 0x15;
		EBCDIC2ASCII[0x3E] = (byte) 0x9E;
		EBCDIC2ASCII[0x3F] = (byte) 0x1A;
		EBCDIC2ASCII[0x40] = (byte) 0x20;
		EBCDIC2ASCII[0x41] = (byte) 0xA0;
		EBCDIC2ASCII[0x42] = (byte) 0xE2;
		EBCDIC2ASCII[0x43] = (byte) 0xE4;
		EBCDIC2ASCII[0x44] = (byte) 0xE0;
		EBCDIC2ASCII[0x45] = (byte) 0xE1;
		EBCDIC2ASCII[0x46] = (byte) 0xE3;
		EBCDIC2ASCII[0x47] = (byte) 0xE5;
		EBCDIC2ASCII[0x48] = (byte) 0xE7;
		EBCDIC2ASCII[0x49] = (byte) 0xF1;
		EBCDIC2ASCII[0x4A] = (byte) 0xA2;
		EBCDIC2ASCII[0x4B] = (byte) 0x2E;
		EBCDIC2ASCII[0x4C] = (byte) 0x3C;
		EBCDIC2ASCII[0x4D] = (byte) 0x28;
		EBCDIC2ASCII[0x4E] = (byte) 0x2B;
		EBCDIC2ASCII[0x4F] = (byte) 0x7C;
		EBCDIC2ASCII[0x50] = (byte) 0x26;
		EBCDIC2ASCII[0x51] = (byte) 0xE9;
		EBCDIC2ASCII[0x52] = (byte) 0xEA;
		EBCDIC2ASCII[0x53] = (byte) 0xEB;
		EBCDIC2ASCII[0x54] = (byte) 0xE8;
		EBCDIC2ASCII[0x55] = (byte) 0xED;
		EBCDIC2ASCII[0x56] = (byte) 0xEE;
		EBCDIC2ASCII[0x57] = (byte) 0xEF;
		EBCDIC2ASCII[0x58] = (byte) 0xEC;
		EBCDIC2ASCII[0x59] = (byte) 0xDF;
		EBCDIC2ASCII[0x5A] = (byte) 0x21;
		EBCDIC2ASCII[0x5B] = (byte) 0x24;
		EBCDIC2ASCII[0x5C] = (byte) 0x2A;
		EBCDIC2ASCII[0x5D] = (byte) 0x29;
		EBCDIC2ASCII[0x5E] = (byte) 0x3B;
		EBCDIC2ASCII[0x5F] = (byte) 0xAC;
		EBCDIC2ASCII[0x60] = (byte) 0x2D;
		EBCDIC2ASCII[0x61] = (byte) 0x2F;
		EBCDIC2ASCII[0x62] = (byte) 0xC2;
		EBCDIC2ASCII[0x63] = (byte) 0xC4;
		EBCDIC2ASCII[0x64] = (byte) 0xC0;
		EBCDIC2ASCII[0x65] = (byte) 0xC1;
		EBCDIC2ASCII[0x66] = (byte) 0xC3;
		EBCDIC2ASCII[0x67] = (byte) 0xC5;
		EBCDIC2ASCII[0x68] = (byte) 0xC7;
		EBCDIC2ASCII[0x69] = (byte) 0xD1;
		EBCDIC2ASCII[0x6A] = (byte) 0xA6;
		EBCDIC2ASCII[0x6B] = (byte) 0x2C;
		EBCDIC2ASCII[0x6C] = (byte) 0x25;
		EBCDIC2ASCII[0x6D] = (byte) 0x5F;
		EBCDIC2ASCII[0x6E] = (byte) 0x3E;
		EBCDIC2ASCII[0x6F] = (byte) 0x3F;
		EBCDIC2ASCII[0x70] = (byte) 0xF8;
		EBCDIC2ASCII[0x71] = (byte) 0xC9;
		EBCDIC2ASCII[0x72] = (byte) 0xCA;
		EBCDIC2ASCII[0x73] = (byte) 0xCB;
		EBCDIC2ASCII[0x74] = (byte) 0xC8;
		EBCDIC2ASCII[0x75] = (byte) 0xCD;
		EBCDIC2ASCII[0x76] = (byte) 0xCE;
		EBCDIC2ASCII[0x77] = (byte) 0xCF;
		EBCDIC2ASCII[0x78] = (byte) 0xCC;
		EBCDIC2ASCII[0x79] = (byte) 0x60;
		EBCDIC2ASCII[0x7A] = (byte) 0x3A;
		EBCDIC2ASCII[0x7B] = (byte) 0x23;
		EBCDIC2ASCII[0x7C] = (byte) 0x40;
		EBCDIC2ASCII[0x7D] = (byte) 0x27;
		EBCDIC2ASCII[0x7E] = (byte) 0x3D;
		EBCDIC2ASCII[0x7F] = (byte) 0x22;
		EBCDIC2ASCII[0x80] = (byte) 0xD8;
		EBCDIC2ASCII[0x81] = (byte) 0x61;
		EBCDIC2ASCII[0x82] = (byte) 0x62;
		EBCDIC2ASCII[0x83] = (byte) 0x63;
		EBCDIC2ASCII[0x84] = (byte) 0x64;
		EBCDIC2ASCII[0x85] = (byte) 0x65;
		EBCDIC2ASCII[0x86] = (byte) 0x66;
		EBCDIC2ASCII[0x87] = (byte) 0x67;
		EBCDIC2ASCII[0x88] = (byte) 0x68;
		EBCDIC2ASCII[0x89] = (byte) 0x69;
		EBCDIC2ASCII[0x8A] = (byte) 0xAB;
		EBCDIC2ASCII[0x8B] = (byte) 0xBB;
		EBCDIC2ASCII[0x8C] = (byte) 0xF0;
		EBCDIC2ASCII[0x8D] = (byte) 0xFD;
		EBCDIC2ASCII[0x8E] = (byte) 0xFE;
		EBCDIC2ASCII[0x8F] = (byte) 0xB1;
		EBCDIC2ASCII[0x90] = (byte) 0xB0;
		EBCDIC2ASCII[0x91] = (byte) 0x6A;
		EBCDIC2ASCII[0x92] = (byte) 0x6B;
		EBCDIC2ASCII[0x93] = (byte) 0x6C;
		EBCDIC2ASCII[0x94] = (byte) 0x6D;
		EBCDIC2ASCII[0x95] = (byte) 0x6E;
		EBCDIC2ASCII[0x96] = (byte) 0x6F;
		EBCDIC2ASCII[0x97] = (byte) 0x70;
		EBCDIC2ASCII[0x98] = (byte) 0x71;
		EBCDIC2ASCII[0x99] = (byte) 0x72;
		EBCDIC2ASCII[0x9A] = (byte) 0xAA;
		EBCDIC2ASCII[0x9B] = (byte) 0xBA;
		EBCDIC2ASCII[0x9C] = (byte) 0xE6;
		EBCDIC2ASCII[0x9D] = (byte) 0xB8;
		EBCDIC2ASCII[0x9E] = (byte) 0xC6;
		EBCDIC2ASCII[0x9F] = (byte) 0xA4;
		EBCDIC2ASCII[0xA0] = (byte) 0xB5;
		EBCDIC2ASCII[0xA1] = (byte) 0x7E;
		EBCDIC2ASCII[0xA2] = (byte) 0x73;
		EBCDIC2ASCII[0xA3] = (byte) 0x74;
		EBCDIC2ASCII[0xA4] = (byte) 0x75;
		EBCDIC2ASCII[0xA5] = (byte) 0x76;
		EBCDIC2ASCII[0xA6] = (byte) 0x77;
		EBCDIC2ASCII[0xA7] = (byte) 0x78;
		EBCDIC2ASCII[0xA8] = (byte) 0x79;
		EBCDIC2ASCII[0xA9] = (byte) 0x7A;
		EBCDIC2ASCII[0xAA] = (byte) 0xA1;
		EBCDIC2ASCII[0xAB] = (byte) 0xBF;
		EBCDIC2ASCII[0xAC] = (byte) 0xD0;
		EBCDIC2ASCII[0xAD] = (byte) 0xDD;
		EBCDIC2ASCII[0xAE] = (byte) 0xDE;
		EBCDIC2ASCII[0xAF] = (byte) 0xAE;
		EBCDIC2ASCII[0xB0] = (byte) 0x5E;
		EBCDIC2ASCII[0xB1] = (byte) 0xA3;
		EBCDIC2ASCII[0xB2] = (byte) 0xA5;
		EBCDIC2ASCII[0xB3] = (byte) 0xB7;
		EBCDIC2ASCII[0xB4] = (byte) 0xA9;
		EBCDIC2ASCII[0xB5] = (byte) 0xA7;
		EBCDIC2ASCII[0xB6] = (byte) 0xB6;
		EBCDIC2ASCII[0xB7] = (byte) 0xBC;
		EBCDIC2ASCII[0xB8] = (byte) 0xBD;
		EBCDIC2ASCII[0xB9] = (byte) 0xBE;
		EBCDIC2ASCII[0xBA] = (byte) 0x5B;
		EBCDIC2ASCII[0xBB] = (byte) 0x5D;
		EBCDIC2ASCII[0xBC] = (byte) 0xAF;
		EBCDIC2ASCII[0xBD] = (byte) 0xA8;
		EBCDIC2ASCII[0xBE] = (byte) 0xB4;
		EBCDIC2ASCII[0xBF] = (byte) 0xD7;
		EBCDIC2ASCII[0xC0] = (byte) 0x7B;
		EBCDIC2ASCII[0xC1] = (byte) 0x41;
		EBCDIC2ASCII[0xC2] = (byte) 0x42;
		EBCDIC2ASCII[0xC3] = (byte) 0x43;
		EBCDIC2ASCII[0xC4] = (byte) 0x44;
		EBCDIC2ASCII[0xC5] = (byte) 0x45;
		EBCDIC2ASCII[0xC6] = (byte) 0x46;
		EBCDIC2ASCII[0xC7] = (byte) 0x47;
		EBCDIC2ASCII[0xC8] = (byte) 0x48;
		EBCDIC2ASCII[0xC9] = (byte) 0x49;
		EBCDIC2ASCII[0xCA] = (byte) 0xAD;
		EBCDIC2ASCII[0xCB] = (byte) 0xF4;
		EBCDIC2ASCII[0xCC] = (byte) 0xF6;
		EBCDIC2ASCII[0xCD] = (byte) 0xF2;
		EBCDIC2ASCII[0xCE] = (byte) 0xF3;
		EBCDIC2ASCII[0xCF] = (byte) 0xF5;
		EBCDIC2ASCII[0xD0] = (byte) 0x7D;
		EBCDIC2ASCII[0xD1] = (byte) 0x4A;
		EBCDIC2ASCII[0xD2] = (byte) 0x4B;
		EBCDIC2ASCII[0xD3] = (byte) 0x4C;
		EBCDIC2ASCII[0xD4] = (byte) 0x4D;
		EBCDIC2ASCII[0xD5] = (byte) 0x4E;
		EBCDIC2ASCII[0xD6] = (byte) 0x4F;
		EBCDIC2ASCII[0xD7] = (byte) 0x50;
		EBCDIC2ASCII[0xD8] = (byte) 0x51;
		EBCDIC2ASCII[0xD9] = (byte) 0x52;
		EBCDIC2ASCII[0xDA] = (byte) 0xB9;
		EBCDIC2ASCII[0xDB] = (byte) 0xFB;
		EBCDIC2ASCII[0xDC] = (byte) 0xFC;
		EBCDIC2ASCII[0xDD] = (byte) 0xF9;
		EBCDIC2ASCII[0xDE] = (byte) 0xFA;
		EBCDIC2ASCII[0xDF] = (byte) 0xFF;
		EBCDIC2ASCII[0xE0] = (byte) 0x5C;
		EBCDIC2ASCII[0xE1] = (byte) 0xF7;
		EBCDIC2ASCII[0xE2] = (byte) 0x53;
		EBCDIC2ASCII[0xE3] = (byte) 0x54;
		EBCDIC2ASCII[0xE4] = (byte) 0x55;
		EBCDIC2ASCII[0xE5] = (byte) 0x56;
		EBCDIC2ASCII[0xE6] = (byte) 0x57;
		EBCDIC2ASCII[0xE7] = (byte) 0x58;
		EBCDIC2ASCII[0xE8] = (byte) 0x59;
		EBCDIC2ASCII[0xE9] = (byte) 0x5A;
		EBCDIC2ASCII[0xEA] = (byte) 0xB2;
		EBCDIC2ASCII[0xEB] = (byte) 0xD4;
		EBCDIC2ASCII[0xEC] = (byte) 0xD6;
		EBCDIC2ASCII[0xED] = (byte) 0xD2;
		EBCDIC2ASCII[0xEE] = (byte) 0xD3;
		EBCDIC2ASCII[0xEF] = (byte) 0xD5;
		EBCDIC2ASCII[0xF0] = (byte) 0x30;
		EBCDIC2ASCII[0xF1] = (byte) 0x31;
		EBCDIC2ASCII[0xF2] = (byte) 0x32;
		EBCDIC2ASCII[0xF3] = (byte) 0x33;
		EBCDIC2ASCII[0xF4] = (byte) 0x34;
		EBCDIC2ASCII[0xF5] = (byte) 0x35;
		EBCDIC2ASCII[0xF6] = (byte) 0x36;
		EBCDIC2ASCII[0xF7] = (byte) 0x37;
		EBCDIC2ASCII[0xF8] = (byte) 0x38;
		EBCDIC2ASCII[0xF9] = (byte) 0x39;
		EBCDIC2ASCII[0xFA] = (byte) 0xB3;
		EBCDIC2ASCII[0xFB] = (byte) 0xDB;
		EBCDIC2ASCII[0xFC] = (byte) 0xDC;
		EBCDIC2ASCII[0xFD] = (byte) 0xD9;
		EBCDIC2ASCII[0xFE] = (byte) 0xDA;
		EBCDIC2ASCII[0xFF] = (byte) 0x9F;
		ASCII2EBCDIC = new byte[256];
		// Use the current table to create the reverse conversion table.
		for (int i = 0; i < 256; ++i) {
			ASCII2EBCDIC[EBCDIC2ASCII[i] & 0xFF] = (byte) i;
		}
	}

	/**
	 * Convierte un byte de formato ASCII a EBCDIC.
	 * @param in Valor de un byte en formato ASCII.
	 * @return Valor de un byte en formato EBCDIC.
	 */
	public static final byte convertByteA2E(byte in) {
		return ASCII2EBCDIC[in & 0xFF];
	}

	/**
	 * Convierte un byte de formato EBCDIC a ASCII.
	 * @param in Valor de un byte en formato EBCDIC.
	 * @return Valor del byte en formato ASCII.
	 */
	public static final byte convertByteE2A(byte in) {
		return EBCDIC2ASCII[in & 0xFF];
	}

	/**
	 * Convierte un arreglo de bytes de ASCII a EBCDIC. Si el parámetro tiene valor null, se retornará null.
	 * @param in Arreglo de ytes en formato ASCII.
	 * @return Arreglo de bytes en formato EBCDIC.
	 */
	public static final byte[] convertASCII2EBCDIC(byte[] in) {
		if (in != null) {
			byte[] out = new byte[in.length];
			for (int i = 0; i < in.length; ++i) {
				out[i] = convertByteA2E(in[i]);
			}
			return out;
		}
		return null;
	}

	/**
	 * Convierte un arreglo de bytes de EBCDIC a ASCII. Si el parámetro tiene valor null, se retornará null.
	 * @param in Arreglo de bytes en formato EBCDIC.
	 * @return Arreglo de bytes en formato ASCII.
	 */
	public static final byte[] convertEBCDIC2ASCII(byte[] in) {
		if (in != null) {
			byte[] out = new byte[in.length];
			for (int i = 0; i < in.length; ++i) {
				out[i] = convertByteE2A(in[i]);
			}
			return out;
		}
		return null;
	}

	/**
	 * Convierte una cadena de caracteres que contenga valores hexadecimales de ASCII a EBCDIC.
	 * @param in Cadena de caracteres hexadecimales en ASCII.
	 * @return Cadena de caracteres hexadecimales en EBCDIC.
	 */
	public static final String convertHexaASCII2HexaEBCDIC(String in) {
		byte data[] = DatatypeConverter.parseHexBinary(in);
		data = convertASCII2EBCDIC(data);
		return DatatypeConverter.printHexBinary(data);
	}

	/**
	 * Convierte una cadena de caracteres que contenga valores hexadecimales de EBCDIC a ASCII.
	 * @param in Cadena de caracteres hexadecimales en EBCDIC.
	 * @return Cadena de caracteres en ASCII.
	 */
	public static final String convertHexaEBCDIC2HexaASCII(String in) {
		byte data[] = DatatypeConverter.parseHexBinary(in);
		data = convertEBCDIC2ASCII(data);
		return DatatypeConverter.printHexBinary(data);
	}
}
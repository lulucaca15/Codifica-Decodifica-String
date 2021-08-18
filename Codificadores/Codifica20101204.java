package Codificadores;

import java.util.Base64;

public class Codifica20101204 implements Codifica {

    public String getNomeAutor() {
        return "Alexei Abianna";
    };

    public String getMatriculaAutor() {
        return "20101204";
    };

    public String codifica(String str) {
        String strSerializado = Base64.getEncoder().encodeToString(str.getBytes());

        return strSerializado;
    };

    public String decodifica(String str) {
        String strDeserializado = new String(Base64.getDecoder().decode(str));
        return strDeserializado;
    };
}

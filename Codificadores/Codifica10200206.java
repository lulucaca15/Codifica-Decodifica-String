package Codificadores;

import java.util.Base64;

public class Codifica10200206 implements Codifica {

    @Override
    public String getNomeAutor() {
        return "Felipe Armborst Rodrigues";
    }

    @Override
    public String getMatriculaAutor() {
        return "10200206";
    }
//utiliza a API do Java 8 para codificar a string em base64 
    @Override
    public String codifica(String str) {
        String encodedString = Base64.getEncoder().encodeToString(str.getBytes());
        return encodedString;
    }
//Utiliza a API do Java 8 para decodificar a string de base64 para plain text
    @Override
    public String decodifica(String str) {
        byte[] decodedBytes = Base64.getDecoder().decode(str);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }
    
}
package Codificadores;

import java.util.Random;

public class Codifica20181044 implements Codifica {

    @Override
    public String getNomeAutor() {
        return "Rafael Dias Coll Oliveira";
    }

    @Override
    public String getMatriculaAutor() {
        return "20181044";
    }

    @Override
    public String codifica(String str) {
        Random random = new Random();
        int chave = random.nextInt(3) + 4;
        String codificada = String.valueOf((char)chave);
        for (char c : str.toCharArray()) {
            codificada += (char)(c * chave);
        }
        return codificada;
    }

    @Override
    public String decodifica(String str) {
        char chave = str.charAt(0);
        String aux = str.substring(1, str.length());
        String decodificada = "";
        for (char c : aux.toCharArray()) {
            decodificada += (char)(c / chave);
        }
        return decodificada;
    }
}
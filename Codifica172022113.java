package Codificadores;


import java.util.*;
public class Codifica172022113 implements Codifica {

    @Override
    public String codifica(String str) {
        String codificada = "";
	codificada = Base64.getEncoder().encodeToString(str.getbytes());
        return codificada;
    }

    @Override
    public String decodifica(String str) {
        String decodificada = "";
	byte[] stringdecod = Base64.getDecoder().decode(str);
	decodificada = new String(stringdecod);
        return decodificada;
    }

    @Override
    public String getMatriculaAutor() {
        return "172022113";
    }

    @Override
    public String getNomeAutor() {
        return "Juliano Terra";
    }

}

//package Codificadores;

public class Codifica14104892 implements Codifica {

    //Coloca todos os caracteres em letra maiuscula
    @Override
    public String codifica(String str) {
        String codificada = "";
        for (char s : str.toCharArray()) {
            codificada = codificada.toUpperCase();           
        }
        return codificada;
    }

    //Coloca todos os caracteres em letra minuscula
    @Override
    public String decodifica(String str) {
        String codificada = "";
        for (char s : str.toCharArray()) {
            codificada = codificada.toLowerCase();     
        }
        return codificada;
    }

    @Override
    public String getMatriculaAutor() {
        return "14104892";
    }

    @Override
    public String getNomeAutor() {
        return "Felipe Roll";
    }

}
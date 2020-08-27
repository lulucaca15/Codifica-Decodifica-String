package Codificadores;

public class Codifica18105913 implements Codifica {
    //Decodificando a palavra
    @Override
    public String codifica(String word) {
        System.out.println("String codificada: ");
        String stringCodificada = "";
        for (int i = word.length() - 1; i >=0 ; i--) {
            stringCodificada += word.charAt(i);            
        }
        return stringCodificada.toUpperCase();
    }

    //Codificando a palavra
    @Override
    public String decodifica(String word) {
        System.out.println("String decodificada: ");
        String stringDecodificada = "";
        for (int i = word.length() - 1; i >=0 ; i--) {
            stringDecodificada += word.charAt(i);            
        }
        return stringDecodificada.toUpperCase();
    }

    @Override
    public String getMatriculaAutor() {
        return "18105913";
    }

    @Override
    public String getNomeAutor() {
        return "Renata Mottin";
    }
}
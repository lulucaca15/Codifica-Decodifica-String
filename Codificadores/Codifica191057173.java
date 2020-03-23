package Codificadores;

public class Codifica191057173 implements Codifica {

    //A frase codificada ficará de traz para frente.
    @Override
    public String codifica(String str) {
        String codificada = "";
        for (int i = str.length() - 1; i >=0 ; i--) {
            codificada += str.charAt(i);            
        }
        return codificada;
    }

    //Agora voltaremos ao normal.
    @Override
    public String decodifica(String str) {
        String codificada = "";
        for (int i = str.length() - 1; i >=0 ; i--) {
            codificada += str.charAt(i);            
        }
        return codificada;
    }

    @Override
    public String getMatriculaAutor() {
        return "19105717-3";
    }

    @Override
    public String getNomeAutor() {
        return "Jonathan Cardarelli Barbosa";
    }

}
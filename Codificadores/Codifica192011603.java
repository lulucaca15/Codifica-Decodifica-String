package Codificadores;

public class Codifica192011603 implements Codifica{

    @Override
    public String getMatriculaAutor() {
        return "192011603";
    }

    @Override
    public String getNomeAutor() {
        return "Ruan Flesch Pereira";
    }

    @Override
    public String codifica(String str) {
       String codificada = "";
       String insere01 = "ua";
       String criptografa01 = "@!#$Df";

       String insere02 = "an";
       String criptografa02= "FWW32r23";

        if (str.contains(insere01)){
            str += criptografa01;
        }

        if (str.contains(insere02)){
            str += criptografa02;
        }

        str = codificada;

        return codificada;
    }

    @Override
    public String decodifica(String str) {
        String decodificada = "";
        String criptografado01 = "@!#$Df";
        String retira01 = "ua";
 
        String retira02 = "FWW32r23";
        String criptografado02= "an";

        if (str.contains(criptografado01)){
            str += retira01;
        }
        
        if (str.contains(criptografado02)){
            str += retira02;
        }

        str = decodificada;

        return decodificada;
    }

}
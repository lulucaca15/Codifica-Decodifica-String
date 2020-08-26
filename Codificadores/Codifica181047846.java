package Codificadores;

public class Codifica181047846 implements Codifica {

    @Override
    public String codifica(String str) {
        String s = new StringBuffer(str).reverse().toString();
        String codificada = "//"+s+"\\\\";
        return codificada;
    }

     @Override
     public String decodifica(String str) {
          String aux = str.substring(2,str.length()-2);
          String decodificada = new StringBuffer(aux).reverse().toString();
          return decodificada;
     }

    @Override
    public String getMatriculaAutor() {
        return "18104784-6";
    }

    @Override
    public String getNomeAutor() {
        return "Rafael Mattone";
    }

}
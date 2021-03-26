package Codificadores;

public class Codifica201034287 implements Codifica {

    @Override
    public String codifica(String str) {
       String codificada = "";
        for (char c : str.toCharArray()){
            if (c=='a'){
                codificada=codificada+"^";
            }else if (c=='e'){
                codificada=codificada+"*";
            }else if (c=='i'){
                codificada=codificada+"~";
            }else if(c=='o'){
                codificada=codificada+"#";
            }else if(c=='u'){
                codificada=codificada+"@";
            }else{
                codificada=codificada+""+c;
            }
       }
        return codificada;
    }

    @Override
    public String decodifica(String str) {
        String original="";
        for (char c : str.toCharArray()){
            if (c=='^'){
                original=original+"a";
            }else if (c=='*'){
                original=original+"e";
            }else if (c=='~'){
                original=original+"i";
            }else if(c=='#'){
                original=original+"o";
            }else if(c=='@'){
                original=original+"u";
            }else{
                original=original+""+c;
            }
       }
        return original;
    }

    @Override
    public String getMatriculaAutor() {
        return "201034287";
    }

    @Override
    public String getNomeAutor() {
        return "Manoella Jarces de Azevedo";
    }
}


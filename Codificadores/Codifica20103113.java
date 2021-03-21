package Codificadores;


public class Codifica20103113 implements Codifica {

    private final String sheet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz@#";

    @Override
    public String getNomeAutor() {
        return "João Gabriel Dalla Lasta Bergamaschi";
    }

    @Override
    public String getMatriculaAutor() {
        return "20103113";
    }

    @Override
    public String codifica(String str) {
        String codificada = "";
        if(str.length() % 2 == 0) {
            for(int i = (int)(str.length() / 2); i > 0; i--) {
                codificada += str.charAt(i- 1);
            }
            for(int i = str.length(); i > (int)(str.length() / 2); i--) {
                codificada += str.charAt(i- 1);
            }
        } else {
            for(int i = (int)((str.length()) / 2); i > 0; i--) {
                codificada += str.charAt(i- 1);
            }
            codificada += str.charAt((int)((str.length()) / 2));
            for(int i = str.length(); i > (int)(str.length() / 2) + 1; i--) {
                codificada += str.charAt(i- 1);
            }
        }
        return codificada;
    }

    @Override
    public String decodifica(String str) {
        String codificada = "";
        if(str.length() % 2 == 0) {
            for(int i = (int)(str.length() / 2); i > 0; i--) {
                codificada += str.charAt(i- 1);
            }
            for(int i = str.length(); i > (int)(str.length() / 2); i--) {
                codificada += str.charAt(i- 1);
            }
        } else {
            for(int i = (int)((str.length()) / 2); i > 0; i--) {
                codificada += str.charAt(i- 1);
            }
            codificada += str.charAt((int)((str.length()) / 2));
            for(int i = str.length(); i > (int)(str.length() / 2) + 1; i--) {
                codificada += str.charAt(i- 1);
            }
        }
        return codificada;
    }
    
}

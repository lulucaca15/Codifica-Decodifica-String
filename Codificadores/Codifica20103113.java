package Codificadores;


public class Codifica20103113 implements Codifica {

    private final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz@#";
    private final String KEYCHARS = "@# AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890";

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
        String codifica1 = "";
        if(str.length() % 2 == 0) {
            for(int i = (int)(str.length() / 2); i > 0; i--) {
                codifica1 += str.charAt(i- 1);
            }
            for(int i = str.length(); i > (int)(str.length() / 2); i--) {
                codifica1 += str.charAt(i- 1);
            }
        } else {
            for(int i = (int)((str.length()) / 2); i > 0; i--) {
                codifica1 += str.charAt(i- 1);
            }
            codifica1 += str.charAt((int)((str.length()) / 2));
            for(int i = str.length(); i > (int)(str.length() / 2) + 1; i--) {
                codifica1 += str.charAt(i- 1);
            }
        }
        String codifica2 = "";
        for(int i = 0; i < codifica1.length(); i++){
            char letra = codifica1.charAt(i);
            char letraCodificada = KEYCHARS.charAt(ALPHABET.indexOf(letra));
            codifica2 += letraCodificada;
        }

        return codifica2;
    }

    @Override
    public String decodifica(String str) {
        String decodifica1 = "";
        for(int i = 0; i < str.length(); i++){
            char letraCodificada = str.charAt(i);
            char letra = ALPHABET.charAt(KEYCHARS.indexOf(letraCodificada));
            decodifica1 += letra;
        }
        String decodifica2 = "";
        if(decodifica1.length() % 2 == 0) {
            for(int i = (int)(decodifica1.length() / 2); i > 0; i--) {
                decodifica2 += decodifica1.charAt(i- 1);
            }
            for(int i = decodifica1.length(); i > (int)(decodifica1.length() / 2); i--) {
                decodifica2 += decodifica1.charAt(i- 1);
            }
        } else {
            for(int i = (int)((decodifica1.length()) / 2); i > 0; i--) {
                decodifica2 += decodifica1.charAt(i- 1);
            }
            decodifica2 += decodifica1.charAt((int)((decodifica1.length()) / 2));
            for(int i = decodifica1.length(); i > (int)(decodifica1.length() / 2) + 1; i--) {
                decodifica2 += decodifica1.charAt(i- 1);
            }
        }
        return decodifica2;
    }
    
}

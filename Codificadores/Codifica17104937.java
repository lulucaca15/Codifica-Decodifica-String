package Codificadores;

public class Codifica17104937 implements Codifica {
    private static final String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
    private static final int KEY = 5;

    // Retorna o autor do codificador
    public String getNomeAutor() {
        return "victoria fraga";
    }

    // Retorna a matrícula do autor do codificador
    public String getMatriculaAutor() {
        return "17104937";
    }

    public String codifica(String palavra) {
        char[] letras = palavra.toCharArray();
        for (int i = 0; i < letras.length; i++) {
            if (Character.isLetterOrDigit(letras[i])) {
                int pos = ALFABETO.indexOf(letras[i]) + KEY;
                letras[i] = codificaChar(pos);
            }
        }
        return new String(letras);
    }

    public char codificaChar(Integer pos) {
        if (pos < ALFABETO.length()) {
            return ALFABETO.charAt(pos);
        }
        pos -= ALFABETO.length();
        return codificaChar(pos);
    }

    public String decodifica(String palavra) {
        char[] letras = palavra.toCharArray();
        for (int i = 0; i < letras.length; i++) {
            if (Character.isLetterOrDigit(letras[i])) {
                Integer pos = ALFABETO.indexOf(letras[i]) - KEY;
                letras[i] = decodificaChar(pos);
            }
        }
        return new String(letras);
    }

    public char decodificaChar(Integer pos) {
        if (pos >= 0) {
            return ALFABETO.charAt(pos);
        }
        pos += ALFABETO.length();
        return decodificaChar(pos);
    }
}
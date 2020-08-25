package Codificadores;

// This class swaps first and second characters on a String

public class Codifica12104893 implements Codifica {

    ;
    

    @Override
    public String codifica(String str) {

        char[] c = str.toCharArray();

// Replace with a "swap" function, if desired:
        char temp = c[0];
        c[0] = c[1];
        c[1] = temp;

String swappedString = new String(c);

        return swappedString;

    }

    @Override
    public String decodifica(String str) {
        
        
        char[] c = str.toCharArray();

// Replace with a "swap" function, if desired:
        char temp = c[0];
        c[0] = c[1];
        c[1] = temp;

String unSwappedString = new String(c);

        return unSwappedString;
    }

    @Override
    public String getMatriculaAutor() {
        return "12104893";
    }

    @Override
    public String getNomeAutor() {
        return "Lucas Piatnicki";
    }

}
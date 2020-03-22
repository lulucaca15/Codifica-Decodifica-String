package Codificadores;

public class Codifica172120149 implements Codifica{

    //Codifica a frase transformando cada caracter para seu valor hexadecimal correspondente em ASCII.
    @Override
    public String codifica(String str) {
        String codificada = "";
        int asciiDec = 0;
        String asciiHex = "";
        for (int i = 0; i < str.length() ; i++) {
            asciiDec = (int)str.charAt(i); //Passa o caracter para um numero inteiro decimal.
            asciiHex = Integer.toHexString(asciiDec); //Transforma o inteiro decimal para hexadecimal.
            codificada += asciiHex; //Concatena o hexadecimal a string codificada.
        }
        return codificada;
    }

    //Decodifica a frase.
    @Override
    public String decodifica(String str) {
        String decodificada = "";   
        String asciiHex = "";
        int asciiDec = 0; 
        int intervalo = 2; //Todo caracter do teclado pode ser representado por dois digitos em hexadecimal, por isso percorrer a string de 2 em 2.
        int j = 0; //Variavel que facilita percorrer a string de 2 em 2.
        int tamString = str.length() / 2; //Como cada caracter equivale a dois digitos em hexadecimal, a string codificada e' duas vezes maior que a string decodificada.
        char caracter;

        for (int i = 0; i < tamString; i++) {
            asciiHex = str.substring(j, j + intervalo); //Obtem o numero em hexadecimal do primeiro caracter e assim por diante.
            asciiDec = Integer.parseInt(asciiHex, 16); //Converte o numero de hexadecimal para decimal.
            caracter = (char)asciiDec; //Converte o numero decimal para seu caracter correspondente em ASCII.
            decodificada = decodificada + caracter; //Concatena o caracter a string decodificada.
            j += intervalo; //Atualiza a variavel que percorre a string.
        }
        return decodificada;
    }

    @Override
    public String getMatriculaAutor() {
        return "17212014-9";
    }

    @Override
    public String getNomeAutor() {
        return "Vicente Vivian";
    }

}
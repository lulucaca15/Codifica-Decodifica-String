package Codificadores;
public class Codifica19280020 implements Codifica{
    
    public String getNomeAutor(){
        return "Bárbara Vilela";
    }

    public String getMatriculaAutor(){
        return "19280020";
    }

    public String codifica(String str){
        String codificada = str;
        codificada = str.replaceAll("a", "1");
        codificada = str.replaceAll("A", "9");
        codificada = str.replaceAll("e", "2");
        codificada = str.replaceAll("E", "8");
        codificada = str.replaceAll("i", "3");
        codificada = str.replaceAll("I", "7");
        codificada = str.replaceAll("o", "4");
        codificada = str.replaceAll("O", "6");
        codificada = str.replaceAll("u", "5");
        codificada = str.replaceAll("U", "0");

        StringBuilder sb = new StringBuilder(codificada);
        return sb.reverse().toString();
    }

    public String decodifica(String str){
        String codificada = str;
        codificada = str.replaceAll("1", "a");
        codificada = str.replaceAll("9", "A");
        codificada = str.replaceAll("2", "e");
        codificada = str.replaceAll("8", "E");
        codificada = str.replaceAll("3", "i");
        codificada = str.replaceAll("7", "I");
        codificada = str.replaceAll("4", "o");
        codificada = str.replaceAll("6", "O");
        codificada = str.replaceAll("5", "u");
        codificada = str.replaceAll("0", "U");

        StringBuilder sb = new StringBuilder(codificada);
        return sb.reverse().toString();
    }
}

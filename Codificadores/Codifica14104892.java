//package Codificadores;

public class Codifica14104892 implements Codifica {

    //Coloca todos os caracteres em letra maiuscula
    @Override
    public String codifica(String str) {//package Codificadores;

public class Codifica14104892 implements Codifica {

    //Coloca todos os caracteres comecado em a,e,i,o em 4,3,1,0 respectivamente
    public String codifica(String str) {
        String codificada = "";
         for (char s : str.toCharArray()){
            codificada = str.replace('a', '4');
            codificada = codificada.replace('i', '1');
            codificada = codificada.replace('e', '3');
            codificada = codificada.replace('o', '0');    
        }
        return codificada;
    }

    //Coloca todos os caracteres comecado em 4,3,1,0 em a,e,i,o respectivamente
    public String decodifica(String str) {
        String codificada = "";
        for (char s : str.toCharArray()){
            codificada = str.replace('4', 'a');
            codificada = codificada.replace('1', 'i');
            codificada = codificada.replace('3', 'e');
            codificada = codificada.replace('0', 'o'); 
        }
        return codificada;
    }

    public String getMatriculaAutor() {
        return "14104892";
    }

    public String getNomeAutor() {
        return "Felipe Roll";
    }
   

}
        String codificada = "";
        for (char s : str.toCharArray()) {
            codificada = codificada.toUpperCase();           
        }
        return codificada;
    }

    //Coloca todos os caracteres em letra minuscula
    @Override
    public String decodifica(String str) {
        String codificada = "";
        for (char s : str.toCharArray()) {
            codificada = codificada.toLowerCase();     
        }
        return codificada;
    }

    @Override
    public String getMatriculaAutor() {
        return "14104892";
    }

    @Override
    public String getNomeAutor() {
        return "Felipe Roll";
    }

}

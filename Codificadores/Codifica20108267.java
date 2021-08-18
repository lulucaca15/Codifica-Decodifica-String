package Codificadores;

import java.nio.charset.StandardCharsets;

public class Codifica20108267 implements Codifica {
    private int chave = 12;
    // Retorna o autor do codificador
    public String getNomeAutor(){
        return "Renan Frantz";
    }

    // Retorna a matrícula do autor do codificador
    public String getMatriculaAutor(){
        return "20108267";
    }

    // Recebe um string e retorna o correspondente codificado
    public String codifica(String str){
        byte[] bytes = str.getBytes();
        byte[] bytescod = new byte[bytes.length];
        int intcod;
        for(int i = 0; i < bytes.length; i++){
            int x = bytes[i];
            if(x+chave > 127){
                intcod = (x+chave) - 107;
            }else{
                intcod = x+chave;
            }
            byte bytecod = (byte) intcod;
            bytescod[i] = bytecod;
        }
        String s = new String(bytescod, StandardCharsets.UTF_8);
        return s;
    }

    // Recebe um string codificado e retorna o correspondente decodificado
    public String decodifica(String str){
        byte[] bytes = str.getBytes();
        byte[] bytesdecod = new byte[bytes.length];
        int intdecod;
        for(int i = 0; i < bytes.length; i++){
            int x = bytes[i];
            if(x-chave < 20){
                intdecod = (x-chave) + 107;
            }else{
                intdecod = x-chave;
            }
            byte bytedecod = (byte) intdecod;
            bytesdecod[i] = bytedecod;
        }
        String s = new String(bytesdecod, StandardCharsets.UTF_8);
        return s;
    }
}
package Codificadores;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Codifica17111131 implements Codifica {

    @Override
    public String getNomeAutor() {
        return "José Francisco Dias Venturini";
    }

    @Override
    public String getMatriculaAutor() {
        return "17111131";
    }

    @Override
    public String codifica(String str) {
        char[] charArray = str.toCharArray();
        List<Character> charList = new ArrayList<Character>();
        for(char aux : charArray) {
            charList.add(aux);
        }
        String keyString = "Isto é uma chave :D";
        byte[] bin = keyString.getBytes();
        ByteBuffer wrapped = ByteBuffer.wrap(bin);
        Integer num = wrapped.getInt();
        List<Character> result = charList.stream().map((Character a)-> (char)(a+num)).collect(Collectors.toList());;
        String aux = "";
        for(Character c : result){
            aux = aux + c;
        }
        return aux;
    }

    @Override
    public String decodifica(String str) {
        char[] charArray = str.toCharArray();
        List<Character> charList = new ArrayList<Character>();
        for(char aux : charArray) {
            charList.add(aux);
        }
        String keyString = "Isto é uma chave :D";
        byte[] bin = keyString.getBytes();
        ByteBuffer wrapped = ByteBuffer.wrap(bin);
        Integer num = wrapped.getInt();
        List<Character> result = charList.stream().map((Character a)-> (char)(a-num)).collect(Collectors.toList());
        String aux = "";
        for(Character c : result){
            aux = aux + c;
        }
        return aux;    
    }

}

package Codificadores;

import java.lang.reflect.Array;
import java.util.ArrayList;

//Codificando
            //Passo 1 -> Quebrar a string original em partes de 4 caracteres.(A ultima parte pode ter 3,2 ou 1 char)
            //Passo 2 -> Reorganizar as partes ao contrário. (ex: 3 partes -> 3,2,1);
            //Passo 3 -> Em cada uma das partes, reorganizar os caracteres (posições dos caracteres): 0,1,2,3 para 3,1,0,2. 
                //Caso a parte final tenha 3 caracteres -> 0,1,2 -> 2,0,1. 
                //Caso a parte final tenha 2 caracteres -> 0,1 -> 1,0.
                //Caso a parte final tenha 1 caracteres, nada deve ser feito.  
        

        //Decodificando
            //Passo 1 -> Quebrar a mensagem criptografada em partes de 4 caracteres A ultima parte pode ter 3,2 ou 1 char).
            //Passo 2 -> Reorganizar as partes ao contrário. (ex: 3 partes -> 3,2,1);
            //Passo 3 -> Em cada uma das partes, reorganizar os caracteres (posições dos caracteres): 0,1,2,3 para 3,1,0,2. 
                //Caso a parte final tenha 3 caracteres -> 0,1,2 -> 2,0,1. 
                //Caso a parte final tenha 2 caracteres -> 0,1 -> 1,0.
                //Caso a parte final tenha 1 caracteres, nada deve ser feito.  

public class Codifica201011350 implements Codifica {
    //length = 64 + espaço = 65
    private static String base = "ABCDEFGHIJKLMNOPQRS TUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz@#";
    
    String frase = "Hoje e dia 10 de marco de 2020";

    @Override
    public String codifica(String str) {
        String strCodificada = "";

        ArrayList<String> strSplited = splitStringEvery("0123456789@", 4);

        String[] strSplitedReverse;

        System.out.println("Ultimo bloco do split - "+ strSplited.get(strSplited.size() - 1));
        /*
        for (int i = strSplited.size() - 1; i >= 0 ; i--) {
            strSplitedReverse[i] = strSplited.get(strSplited.size());
            System.out.println(strSplitedReverse[i]);
        }*/
/*
        for (String block : strSplited) {
            System.out.println(block);
            if(block.length() == 4){
                holder = basetest[2];
                basetest[2] = basetest[0];
                basetest[0] = holder;
            }
        }*/
        char[] basetest = ("0123").toCharArray();
        char holder;

        
        //Encode - Passo 3
            //start -> 0,1,2,3

            //0 -> 2
            //2 -> 0
            holder = basetest[2];
            basetest[2] = basetest[0];
            basetest[0] = holder;

            //0 -> 3
            //3 -> 0
            holder = basetest[3];
            basetest[3] = basetest[0];
            basetest[0] = holder;

            //end -> 3,1,0,2

        

        System.out.println("Encoded: "+String.valueOf(basetest));
        int test = 18/4;
        System.out.println("test"+test);
        

        for (char letra : str.toCharArray()) {
            for (char letraBase : base.toCharArray()) {
                if (letra == letraBase){
                    strCodificada += "a";
                }
            }
        }
        return base.length()+ "";
    }

    @Override
    public String decodifica(String str) {
        char[] basetest = ("3102").toCharArray();
        char holder;
       //Decode
        //start 3,1,0,2
           
        //2,1,0,3
        holder = basetest[3];
        basetest[3] = basetest[0];
        basetest[0] = holder;

        //0,1,2,3
        holder = basetest[2];
        basetest[2] = basetest[0];
        basetest[0] = holder;

        System.out.println("Decoded: "+String.valueOf(basetest));


        //end 0,1,2,3
        return null;
    }

    @Override
    public String getNomeAutor() {
        return "Bruno Simm Alves";
    }

    @Override
    public String getMatriculaAutor() {
        return "201011350";
    }

    public ArrayList<String> splitStringEvery(String s, int interval) {
        int arrayLength = (int) Math.ceil(((s.length() / (double)interval)));
        ArrayList<String> result = new ArrayList<>(arrayLength);
    
        int j = 0;
        int lastIndex = arrayLength - 1;
        for (int i = 0; i < lastIndex; i++) {
            result.add(i, s.substring(j, j + interval));
            j += interval;
        }
        result.add(lastIndex, s.substring(j));
    
        return result;
    }
}

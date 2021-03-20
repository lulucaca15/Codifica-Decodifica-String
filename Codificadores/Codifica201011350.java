package Codificadores;

import java.util.ArrayList;
import java.util.Collections;

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
    private static String base = "ABCDEFGHIJKLMNOPQRS TUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz@#";
    
    String frase = "Hoje e dia 10 de marco de 2020112";

    @Override
    public String codifica(String str) {
        String strCodificada = "";

        //Passo 1
        ArrayList<String> strSplited = splitStringEvery(str, 4);
        
        
        //Passo 2
        ArrayList<String> strSplitedReverse = strSplited;
        Collections.reverse(strSplitedReverse);

        /* Desenvertendo
        System.out.println("Frase invertida:"+ strSplitedReverse.toString());
        Collections.reverse(strSplitedReverse);
        System.out.println("Frase desenvertida:"+ strSplitedReverse.toString());
        */

        //Passo 3
        for (String bloco : strSplitedReverse) {
            char holder;
            char[] blocoArray = bloco.toCharArray();

                if(blocoArray.length == 4){
                    //start -> 0,1,2,3
                        //0 -> 2
                        //2 -> 0
                    holder = blocoArray[2];
                    blocoArray[2] = blocoArray[0];
                    blocoArray[0] = holder;

                        //0 -> 3
                        //3 -> 0
                    holder = blocoArray[3];
                    blocoArray[3] = blocoArray[0];
                    blocoArray[0] = holder;
                    //end -> 3,1,0,2
                    
                    strCodificada += String.copyValueOf(blocoArray);
                    System.out.println("Str Cod.++ (4)=> "+strCodificada);
                } else if(blocoArray.length == 3){
                    //Caso a parte final tenha 3 caracteres -> 0,1,2 -> 2,0,1. 
                    //start -> 0,1,2
                        //0 -> 2
                        //2 -> 0
                        holder = blocoArray[0];
                        blocoArray[0] = blocoArray[2];
                        blocoArray[2] = holder;
                        //2,1,0
                            //0 -> 3
                            //3 -> 0
                        holder = blocoArray[2];
                        blocoArray[2] = blocoArray[1];
                        blocoArray[1] = holder;
                        //end -> 2,0,1
                        strCodificada += String.copyValueOf(blocoArray);
                        System.out.println("Str Cod.++ (3)=> "+strCodificada);
                } else if (blocoArray.length == 2){
                    //Caso a parte final tenha 2 caracteres -> 0,1 -> 1,0.
                    holder = blocoArray[0];
                    blocoArray[0] = blocoArray[1];
                    blocoArray[1] = holder;
                    strCodificada += String.copyValueOf(blocoArray);
                    System.out.println("Str Cod.++ (2)=> "+strCodificada);
                } else {
                    strCodificada += String.copyValueOf(blocoArray);
                    System.out.println("Str Cod.++ (1)=> "+strCodificada);
                }
        }
        return strCodificada;
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

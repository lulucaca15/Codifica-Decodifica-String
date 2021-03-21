package Codificadores;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.stream.events.Characters;

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

    @Override
    public String codifica(String str) {
        String encodedString = "";

        // Passo 1 e 2 - 
            //1) "Quebrar" a string original em partes de 4 caracteres.(A ultima parte pode ter 3,2 ou 1 char). 
            //2) Reorganizar as partes ao contrário. (ex: 3 partes -> 3,2,1); 
        ArrayList<String> strSplitedReverse = splitStringEvery(str, 4);
        Collections.reverse(strSplitedReverse);

        // Passo 3 - Em cada uma das partes, reorganizar os caracteres (posições dos
        // caracteres)
        for (String bloco : strSplitedReverse) {
            char holder;
            char[] blocoArray = bloco.toCharArray();
            if (blocoArray.length == 4) {
                // start -> 0,1,2,3
                // 0 -> 2
                // 2 -> 0
                holder = blocoArray[2];
                blocoArray[2] = blocoArray[0];
                blocoArray[0] = holder;

                // 0 -> 3
                // 3 -> 0
                holder = blocoArray[3];
                blocoArray[3] = blocoArray[0];
                blocoArray[0] = holder;
                // end -> 3,1,0,2

                encodedString += String.copyValueOf(blocoArray);
            } else if (blocoArray.length == 3) {
                // Caso a parte final tenha 3 caracteres -> 0,1,2 -> 2,0,1.
                // start -> 0,1,2 (posições)
                // 0 -> 2
                // 2 -> 0
                holder = blocoArray[0];
                blocoArray[0] = blocoArray[2];
                blocoArray[2] = holder;
                // 2,1,0
                // 0 -> 3
                // 3 -> 0
                holder = blocoArray[2];
                blocoArray[2] = blocoArray[1];
                blocoArray[1] = holder;
                // end -> 2,0,1

                encodedString += String.copyValueOf(blocoArray);
            } else if (blocoArray.length == 2) {
                // Caso a parte final tenha 2 caracteres -> 0,1 -> 1,0.
                holder = blocoArray[0];
                blocoArray[0] = blocoArray[1];
                blocoArray[1] = holder;
                encodedString += String.copyValueOf(blocoArray);
            } else {
                // Caso a parte final tenha 1 caracteres, nada deve ser feito.
                encodedString += String.copyValueOf(blocoArray);
            }
        }
        
        return changeCharacters("0"+encodedString);
    }

    @Override
    public String decodifica(String str) {
        String originalString = "";
        ArrayList<String> strToDecode = new ArrayList<>();

        for (char ch : str.toCharArray()) { 
            strToDecode.add(Character.toString(ch)); 
        }
        
        //Passo 1 -> Reorganizar as partes ao contrário. (ex: 3 partes -> 3,2,1);
        Collections.reverse(strToDecode);
        
        //Passo 2 - "Quebrar" a mensagem criptografada em partes de 4 caracteres. A ultima parte pode ter 3,2 ou 1 char).
        strToDecode = splitStringEvery(String.join(",", strToDecode).replaceAll(",", ""), 4);

        // Passo 3 - Em cada uma das partes, reorganizar os caracteres (posições dos
        // caracteres originais)
        for (String bloco : strToDecode) {
            char holder;
            char[] blocoArray = bloco.toCharArray();
            if (blocoArray.length == 4) {
                // start -> 2
                // 0 -> 1
                // 1 -> 0
                holder = blocoArray[0];
                blocoArray[0] = blocoArray[1];
                blocoArray[1] = holder;

                // 0 -> 3
                // 3 -> 0
                //0213
                holder = blocoArray[1];
                blocoArray[1] = blocoArray[2];
                blocoArray[2] = holder;
                // end -> 3,1,0,2

                originalString += String.copyValueOf(blocoArray);
            } else if (blocoArray.length == 3) {
                // Caso a parte final tenha 3 caracteres -> 0,1,2 -> 2,0,1.
                // start -> 0,1,2 (posições)
                // 0 -> 2
                // 2 -> 0
                holder = blocoArray[2];
                blocoArray[2] = blocoArray[0];
                blocoArray[0] = holder;
                // 2,1,0
                // 0 -> 3
                // 3 -> 0
                holder = blocoArray[1];
                blocoArray[1] = blocoArray[2];
                blocoArray[2] = holder;
                // end -> 2,0,1

                originalString += String.copyValueOf(blocoArray);
            } else if (blocoArray.length == 2) {
                /*
                // Caso a parte final tenha 2 caracteres -> 0,1 -> 1,0.
                holder = blocoArray[1];
                blocoArray[1] = blocoArray[0];
                blocoArray[0] = holder;
                */
                originalString += String.copyValueOf(blocoArray);
            } else {
                // Caso a parte final tenha 1 caracteres, nada deve ser feito.
                originalString += String.copyValueOf(blocoArray);
            }
        }
        return changeCharacters("1"+ originalString);
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
        int arrayLength = (int) Math.ceil(((s.length() / (double) interval)));
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

    public String changeCharacters(String str){
        final String  originalTable = " ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        final String changedTable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz~";

        List<String> originalAsList = Arrays.asList(originalTable.split(""));
        List<String> changedAsList = Arrays.asList(changedTable.split(""));
        Collections.reverse(changedAsList);
        
        if (str.startsWith("1")){//Cracateres já alterados, revertendo mudanças.
            //TODO -> IMPLEMENTAR
            str = str.substring(1,str.length());
            List<String> strAsList = Arrays.asList(str.split(""));

            for (int i = 0; i < originalAsList.size(); i++) {
                str = str.replaceAll(changedAsList.get(i),originalAsList.get(i));
            } 
            return str;
        } else if (str.startsWith("0")){ //Caracteres não alterados, realizando mudanças de caracteres.
            str = str.substring(1,str.length());
            List<String> strAsList = Arrays.asList(str.split(""));
            
            for (String element : strAsList) {
                int positionAtOriginal = originalAsList.indexOf(element);
                str = str.replaceAll(element, changedAsList.get(positionAtOriginal));
            }
            return str;
        }
        
        return str;
    }
}

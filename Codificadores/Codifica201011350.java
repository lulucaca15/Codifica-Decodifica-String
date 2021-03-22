package Codificadores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*  Nome: Bruno Simm Alves
    Matricula: 201011350

    Codificando
        Passo 1 -> Modificar caracteres.
        Passo 2 -> Quebrar a string original em partes de 4 caracteres.(A ultima parte pode ter 3,2 ou 1 char)
        Passo 3 -> Reorganizar as partes ao contrário. (ex: 3 partes -> 3,2,1);
        Passo 4 -> Em cada uma das partes, reorganizar os caracteres (posições dos caracteres): 0,1,2,3 para 3,1,0,2. 
            * Caso a parte final tenha 3 caracteres -> 0,1,2 -> 2,0,1. 
            * Caso a parte final tenha 2 caracteres -> 0,1 -> 1,0.
            * Caso a parte final tenha 1 caracteres, nada deve ser feito.  

    Decodificando
        //Passo 1 -> "Traduzir" os caracteres modificados ao padrão original.
        //Passo 2 -> Reorganizar as partes ao contrário. (ex: 3 partes -> 3,2,1);
        //Passo 3 -> Quebrar a mensagem criptografada em partes de 4 caracteres A ultima parte pode ter 3,2 ou 1 char).
        //Passo 4 -> Em cada uma das partes, reorganizar os caracteres (posições dos caracteres): 0,1,2,3 para 3,1,0,2. 
            //Caso a parte final tenha 3 caracteres -> 0,1,2 -> 2,0,1. 
            //Caso a parte final tenha 2 caracteres -> 0,1 -> 1,0.
            //Caso a parte final tenha 1 caracteres, nada deve ser feito.  
*/
public class Codifica201011350 implements Codifica {

    @Override
    public String codifica(String str) {
        String encodedString = "";

        //Passo 1
        str = changeCharacters(str,true);

        // Passo 2 e 3
        ArrayList<String> strSplitedReverse = splitStringEvery(str, 4);
        Collections.reverse(strSplitedReverse);
        
        // Passo 4
        for (String block : strSplitedReverse) {
            char holder;
            char[] blockArray = block.toCharArray();
            if (blockArray.length == 4) {

                holder = blockArray[2];
                blockArray[2] = blockArray[0];
                blockArray[0] = holder;

                holder = blockArray[3];
                blockArray[3] = blockArray[0];
                blockArray[0] = holder;

                encodedString += String.copyValueOf(blockArray);

            } else if (blockArray.length == 3) {
                // Caso a parte final tenha 3 caracteres -> 0,1,2 -> 2,0,1.
                holder = blockArray[0];
                blockArray[0] = blockArray[1];
                blockArray[1] = holder;
                
                holder = blockArray[2];
                blockArray[2] = blockArray[0];
                blockArray[0] = holder;

                encodedString += String.copyValueOf(blockArray);
            } else if (blockArray.length == 2) {
                // Caso a parte final tenha 2 caracteres -> 0,1 -> 1,0.
                holder = blockArray[0];
                blockArray[0] = blockArray[1];
                blockArray[1] = holder;
                encodedString += String.copyValueOf(blockArray);
            } else if (blockArray.length == 1) {
                // Caso a parte final tenha 1 caracteres, nada deve ser feito.
                encodedString += String.copyValueOf(blockArray);
            }
        }
        return encodedString;
    }

    @Override
    public String decodifica(String str) {
        String originalString = "";

        //Passo 1
        str = changeCharacters(str,false);

        ArrayList<String> strToDecode = new ArrayList<>();
        for (char ch : str.toCharArray()) { 
            strToDecode.add(Character.toString(ch)); 
        }
        
        //Passo 2 -> Reorganizar as partes ao contrário. (ex: 3 partes -> 3,2,1);
        Collections.reverse(strToDecode);
        
        //Passo 3 - "Quebrar" a mensagem criptografada em partes de 4 caracteres. A ultima parte pode ter 3,2 ou 1 char).
        StringBuilder strToDecodeAsString = new StringBuilder();
        for (String element : strToDecode) {
			strToDecodeAsString.append(element);
		}
        strToDecode = splitStringEvery(strToDecodeAsString.toString(), 4);
        
        // Passo 4 - Em cada uma das partes, reorganizar os caracteres (posições dos
        // caracteres originais)
        for (String block : strToDecode) {
            char holder;
            char[] blockArray = block.toCharArray();
            if (blockArray.length == 4) {

                holder = blockArray[0];
                blockArray[0] = blockArray[1];
                blockArray[1] = holder;

                holder = blockArray[1];
                blockArray[1] = blockArray[2];
                blockArray[2] = holder;

                originalString += String.copyValueOf(blockArray);
            } else if (blockArray.length == 3) {
                // Caso a parte final tenha 3 caracteres ->   2,0,1 -> 0,1,2
                holder = blockArray[0];
                blockArray[0] = blockArray[1];
                blockArray[1] = holder;
    
                originalString += String.copyValueOf(blockArray);
            } else if (blockArray.length == 2) {
                originalString += String.copyValueOf(blockArray);
            }  else if (blockArray.length == 1){
                // Caso a parte final tenha 1 caracteres, nada deve ser feito.
                originalString += String.copyValueOf(blockArray);
            }
        }
        return originalString;
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

    public String changeCharacters(String str,boolean needChanges){
        final String originalTable = " ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        final String changedTable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz~";

        List<String> originalAsList = Arrays.asList(originalTable.split(""));
        List<String> changedAsList = Arrays.asList(changedTable.split(""));
        Collections.reverse(changedAsList);
        
        if (needChanges == false){//Cracateres já alterados, revertendo mudanças.
            List<String> strAsList = Arrays.asList(str.split(""));
            for (String element : strAsList) {
                int positionAtChanged = changedAsList.indexOf(element);
                
                if (positionAtChanged != -1){
                    //Troca o elemento alterado pelo da mesma posição correspondente na lista original.
                    str = str.replaceFirst(element, originalAsList.get(positionAtChanged));
                }
            }
            return str;
        } else if (needChanges == true){ //Caracteres não alterados, realizando mudanças.
            List<String> strAsList = Arrays.asList(str.split(""));

            for (String element : strAsList) {
                int positionAtOriginal = originalAsList.indexOf(element);
                
                if (positionAtOriginal != -1){
                    //Troca o elemento original pelo da posição correspondente na lista invertida.
                    str = str.replaceFirst(element, changedAsList.get(positionAtOriginal));
                   
                }
            }
            return str;
        }
        return str;
    }
}

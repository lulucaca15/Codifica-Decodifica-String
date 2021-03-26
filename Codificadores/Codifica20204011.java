package Codificadores;

import java.util.Map;
import java.util.HashMap;

public class Codifica20204011 implements Codifica{
    
    @Override
    public String getNomeAutor() {
        return "Gilberto Luis Koerbes Junior";
    }

    @Override
    public String getMatriculaAutor() {
        return "20204011";
    }

    @Override
    public String codifica(String str){
            String Saida = "";
            String entrada = str;
            for (int i=0; i<entrada.length(); i++){
                Saida += hashMapvalues(Character.toString(entrada.charAt(i)),"v");
            }
            return Saida;

    }

    @Override
    public String decodifica(String str){
        String Saida = "";
        String entrada = str;
        for (int i=0; i<entrada.length(); ){
            Saida += hashMapvalues(entrada.substring(i,i+2),"k");            
            i=i+2;
        }
        return Saida;
    }

    //recebe um valor e qual o tipo deste valor ( key ou value)
    private String hashMapvalues(String input, String type){
        
        Map<String,String> Codf = new HashMap<String,String>();
        Codf.put("k1", "a");
        Codf.put("k2", "e");
        Codf.put("k3", "i");
        Codf.put("k4", "o");
        Codf.put("k5", "u");
        //inserir conforme necessidade

        for (Map.Entry<String, String> entry : Codf.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            
            if(type.equals("v")&& input.equals(value)) return key;
            if(type.equals("k")&& input.equals(key)) return value;
        }
        return "ERROR";
        
    }



    
}

package Codificadores;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Codifica18203068 implements Codifica {
    Random random = new Random();
    int chave = random.nextInt(Integer.parseInt(getMatriculaAutor()));

    @Override
    public String getNomeAutor() {
        return "Alex Elias Guimarães Leite";
    }

    @Override
    public String getMatriculaAutor() {
        return "18203068";
    }

    @Override
    public String codifica(String str) {
        byte[] bytes = converte(str);
        String codificado ="";
        for (byte b : bytes) {
            codificado=codificado+b+chave;
        }
        return codificado;
    }

    private static byte[] converte(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException error) {
            throw new AssertionError(error);
        }
    }

    @Override
    public String decodifica(String str) {
        String[] test=str.split(Integer.toString(chave));
        byte[] bytes = new byte[test.length];
        int i =0;
        for (String s : test) {
            int teste=Integer.parseInt(s);
            bytes[i]= (byte)teste;
            i++;
        }
        
        String msgdecode = "";
        try {
            msgdecode = new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return msgdecode;
    }
        
}
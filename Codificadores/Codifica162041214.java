package Codificadores;
import java.util.Base64;

public class Codifica162041214 implements Codifica {
<<<<<<< HEAD

 Base64.Encoder codificador = Base64.getEncoder();
  Base64.Decoder decodifcar = Base64.getDecoder();

    @Override
    public String codifica(String str) {
      String codificado = codificador.encodeToString(str.getBytes());
      return codificado;
    }
  
    @Override
    public String decodifica(String str) {
      String decodificado = new String(decodificador.decode(str));
      return decodificado;
    }
=======
    
    @Override
    public String getNomeAutor() { che
      return "João Vitor Narciso";
     }
>>>>>>> ft-nomeAutor
}
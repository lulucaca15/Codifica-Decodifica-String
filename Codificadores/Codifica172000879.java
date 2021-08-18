package Codificadores;
public class Codifica172000879 implements Codifica {
    // Retorna o autor do codificador
    @Override
    public String getNomeAutor(){
        return "Arthur Pretto";
    }
    // Retorna a matrícula do autor do codificador
    @Override
    public String getMatriculaAutor(){
        return "172000879";
    }

    // Recebe um string e retorna o correspondente codificado
    String codifica(String str){
 
    String codificada = Base64.getMimeEncoder().encodeToString( str.getBytes( "utf-8" ) );
        return = codificada;
    }  
    
    // Recebe um string codificado e retorna o correspondente decodificado
    String decodifica(String str){
    byte[] decodedString = Base64.getMimeDecoder().decode( str );
    decodificada = new String(decodedString);
        return = decodificada;
    }

}

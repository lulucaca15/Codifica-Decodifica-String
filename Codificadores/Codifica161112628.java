package Codificadores;

public class Codifica161112628 implements Codifica {

    @Override
    public String getNomeAutor() {
        String nome = "Josias Melo Vidal";
        return nome;
    }

    @Override
    public String getMatriculaAutor() {
        String matricula = "16111262-8";
        return matricula;
    }

    @Override
    public String codifica(String str) {
       String codificada = "";
       String caracteres_na_string_01 = "os";
       String criptografando_caracteres_01 = "asdasfdsfkjh";

       String caracteres_na_string_02 = "as";
       String criptografando_caracteres_02= "klhsasddfssdf";

        if (str.contains(caracteres_na_string_01)){
            str += criptografando_caracteres_01;
        }

        if (str.contains(caracteres_na_string_02)){
            str += criptografando_caracteres_02;
        }

        str = codificada;

        return codificada;
    }

    @Override
    public String decodifica(String str) {
        String decodificada = "";
        String caracteres_criptografados_01 = "asdasfdsfkjh";
        String caracteres_resolvidos_01 = "os";
 
        String caracteres_resolvidos_02 = "klhsasddfssdf";
        String caracteres_criptografados_02= "as";

        if (str.contains(caracteres_criptografados_01)){
            str += caracteres_resolvidos_01;
        }
        
        if (str.contains(caracteres_criptografados_02)){
            str += caracteres_resolvidos_02;
        }

        str = decodificada;

        return decodificada;
    }

}
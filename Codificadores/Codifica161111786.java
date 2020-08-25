package Codificadores;

public class Codifica161111786 implements Codifica {

    private final int chave = 161111786;

    // Retorna o autor do codificador
    public String getNomeAutor(){
        return "Alisson Kissel";
    }

    // Retorna a matrícula do autor do codificador
    public String getMatriculaAutor(){
        return "16111178-6";
    }

    // Recebe um string e retorna o correspondente codificado
    public String codifica(String str){
        StringBuilder textoCifrado = new StringBuilder();
        int tamanhoTexto = str.length();
 
        for(int c=0; c < tamanhoTexto; c++){
            int letraCifradaASCII = ((int) str.charAt(c)) + chave;
            while(letraCifradaASCII > 126)
                letraCifradaASCII -= 94;
            textoCifrado.append( (char)letraCifradaASCII );
        }
 
        return textoCifrado.toString();
    }

    // Recebe um string codificado e retorna o correspondente decodificado
    public String  decodifica(String str){
        StringBuilder texto = new StringBuilder();
        int tamanhoTexto = str.length();
 
        for(int c=0; c < tamanhoTexto; c++){
            int letraDecifradaASCII = ((int) str.charAt(c)) - chave;
            while(letraDecifradaASCII < 32)
                letraDecifradaASCII += 94;
            texto.append( (char)letraDecifradaASCII );
        }

        return texto.toString();
    }
}
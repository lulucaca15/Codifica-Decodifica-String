package Codificadores;

public class Codifica2 implements Codifica{
    // Retorna o autor do codificador
    @Override
    public String getNomeAutor() {
        return "Julia Alberti";
    }

    // Retorna a matrícula do autor do codificador
    @Override
    public String getMatriculaAutor() {
        return "18106160";
    }

    int space = 2;

    // Recebe um string e retorna o correspondente codificado
    @Override
    public String codifica(String str){
        String newMe = "";

        for(int i = 0; i < str.length();i++){
            int letraCASCII = ((int) str.charAt(i)) + space;
            newMe += (char)letraCASCII;
        }
        return newMe;
    }

    // Recebe um string codificado e retorna o correspondente decodificado
    @Override
    public String decodifica(String str){
        String newMe = "";
        
        for(int i = 0; i < str.length();i++){
            int letraCASCIIT = ((int) str.charAt(i)) - space;
            newMe += (char)letraCASCIIT;
        }
        return newMe;
    }
}

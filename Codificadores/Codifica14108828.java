package Codificadores;

public class Codifica14108828 implements Codifica {

    @Override
    public String codifica(String str) {
        String codificada = "";
        for (char s : str.toCharArray()) {
            codificada+= (char)((int)s + 1);
        }
        return codificada;
    }

    @Override
    public String decodifica(String str) {
        String decodificada = "";
        for (char s : str.toCharArray()) {
            decodificada+= (char)((int)s - 1);
        }
        return decodificada;
    }

    @Override
    public String getMatriculaAutor() {
        return "14108828";
    }

    @Override
    public String getNomeAutor() {
        return "Ísis Vargas";
    }
}

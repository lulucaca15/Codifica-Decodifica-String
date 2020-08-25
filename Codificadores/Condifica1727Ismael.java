package Codificadores;

public class Condifica1727Ismael implements Codifica{

    @Override
    public String getNomeAutor() {
        return "Ismael Vargas";
    }

    @Override
    public String getMatriculaAutor() {
        return "18110156-9";
    }

    @Override
    public String codifica(String str) {
        return "SS<<" + str + ">>SS";
    }

    @Override
    public String decodifica(String str) {
        return null;
    }
}

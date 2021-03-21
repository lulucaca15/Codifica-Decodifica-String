package Codificadores;

public class Codifica17204140 implements Codifica {   
    private static final String tabela = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
    private static final int deslc = 8;

    @Override
    public String codifica(String str) {
        String codificada = "";
        for (char s : str.toCharArray()) {
            if (!Character.isLetterOrDigit(s)) {
                codificada += s;
            } else {
                for (int i = 0; i < tabela.length(); i++) {
                    if (tabela.charAt(i) == s) {
                        int pos = Math.floorMod((i+deslc), tabela.length());
                        codificada += tabela.charAt(pos);
                    }
                }
            }
        }
        return codificada;
    }

    @Override
    public String decodifica(String str) {
        String decodificada = "";
        for (char s : str.toCharArray()) {
            if (!Character.isLetterOrDigit(s)) {
                decodificada += s;
            } else {
                for (int i = 0; i < tabela.length(); i++) {
                    if (tabela.charAt(i) == s) {
                        int pos = Math.floorMod((i-deslc), tabela.length());
                        decodificada += tabela.charAt(pos);
                    }
                }
            }
        }
        return decodificada;
    }

    @Override
    public String getNomeAutor() {
        return "Brenda David da Silveira";
    }

    @Override
    public String getMatriculaAutor() {
        return "17204140";
    }

    
}
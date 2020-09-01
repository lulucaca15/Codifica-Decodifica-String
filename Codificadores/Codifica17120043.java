package Codificadores;

public class Codifica17120043 implements Codifica {
    private static String tabela = "abcdefghijklmnopqrstuvwxyz@#EFGHIJKLMNOPQRSTUVWXYZABCD1234567890";
    private static int deslocamento = 2;

    @Override
    public String codifica(String str) {
        String codificada = "";
        for (char s : str.toCharArray()) {
            if (!Character.isLetterOrDigit(s)) {
                codificada += s;
            } else {
                for (int i = 0; i < tabela.length(); i++) {
                    if (tabela.charAt(i) == s) {
                        codificada += tabela.charAt(i + deslocamento);
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
                        decodificada += tabela.charAt(i - deslocamento);
                    }
                }
            }
        }
        return decodificada;
    }

    @Override
    public String getNomeAutor() {
        return "Roselaine Moreira";
    }

    @Override
    public String getMatriculaAutor() {
        return "17120043";
    }

}

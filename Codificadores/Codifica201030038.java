package Codificadores;

public class Codifica201030038 implements  Codifica{
    private static String tab = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
    private static int deslc = 13;
    int p;

    @Override
    public String getNomeAutor() {
        
        return "Gustavo Lisboa Molina";
    }

    @Override
    public String getMatriculaAutor() {
        
        return "201030038";
    }

    @Override
    public String codifica(String str) {
        String codificada = "";
        for (char x : str.toCharArray()) {

            if (!Character.isLetterOrDigit(x)) {
                codificada += x;

            } else {

                for (int e = 0; e < tab.length(); e++) {

                    if (tab.charAt(e) == x) {

                    p=Math.floorMod((e+deslc),tab.length());
                        codificada += tab.charAt(p);
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

                for (int i = 0; i < tab.length(); i++) {

                    if (tab.charAt(i) == s) {

                        int p = Math.floorMod((i-deslc), tab.length());
                        decodificada += tab.charAt(p);
                    }
                }
            }
        }
        return decodificada;
    }
    
}

package Codificadores;


public class Codifica181105495 implements Codifica {
    private static String tabela = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
    private static int mult = 7;
    String phrase;
    double posicao = 0;
    int desloc;

    @Override
    public String codifica(String str) {
        desloc = calculaDesloc(str);
        
        for (char s : str.toCharArray()) {
            if (!Character.isLetterOrDigit(s)) {
                phrase += s;
            } else {
                for (int i = 0; i < tabela.length(); i++) {
                    if (tabela.charAt(i) == s) {
                        posicao = desloc + i;
                        while(posicao >= tabela.length()){
                            posicao = posicao - tabela.length();
                        }
                        phrase += tabela.charAt((int)posicao);
                    }
                }
            }
        }
        return phrase;
    }

    @Override
    public String decodifica(String str) {
        desloc = calculaDesloc(str);
        

        for (char s : str.toCharArray()) {
            if (!Character.isLetterOrDigit(s)) {
                phrase += s;
            } else {

                for (int i = 0; i < tabela.length(); i++) {
                    if (tabela.charAt(i) == s) {
                        posicao = i - desloc;
                        while(posicao < 0){
                            posicao = posicao + tabela.length();
                        }
                        phrase += tabela.charAt((int)posicao);
                    }
                }
            }

        }
        
        return phrase;
    }

    private int calculaDesloc(String str) {
        phrase = "";
        int desloc = mult * str.length();
        
        if(desloc > tabela.length()){
            desloc = desloc / tabela.length();
        }

        return desloc;
    }    

    @Override
    public String getMatriculaAutor() {
        return "181105495";
    }

    @Override
    public String getNomeAutor() {
        return "Daniela Rigoli";
    }

}
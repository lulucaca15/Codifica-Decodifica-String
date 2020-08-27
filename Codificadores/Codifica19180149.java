package Codificadores;

public class Codifica19180149 implements Codifica {    
    @Override
    public String codifica(String str) {
        StringBuilder stringCodificada = new StringBuilder();        
        for(int i = 0; i < str.length(); i++) {
            int ascii = (int) str.charAt(i);
            if(ascii < 100) {
                stringCodificada.append("0");
            }            
            String asciiString = Integer.toString(ascii);            
            stringCodificada.append(asciiString);
        }
        return stringCodificada.toString();
    }

    @Override
    public String decodifica(String str) {
        StringBuilder stringDecodificada = new StringBuilder();
        for(int i = 0; i < str.length()-1; i+=3) {
            StringBuilder letra = new StringBuilder();
            letra.append(str.charAt(i));
            letra.append(str.charAt(i+1));
            letra.append(str.charAt(i+2));
            int ascii = Integer.valueOf(letra.toString());            
            stringDecodificada.append(Character.toString(ascii));
        }
        return stringDecodificada.toString();
    }

    @Override
    public String getMatriculaAutor() {
        return "19180149";
    }

    @Override
    public String getNomeAutor() {
        return "Luiz Carvalho";
    }

}
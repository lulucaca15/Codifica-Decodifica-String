package Codificadores;

public class Codifica15109536 implements Codifica {

    @Override
    public String getNomeAutor() {
        return "Miguel Zanela";
    }

    @Override
    public String getMatriculaAutor() {
        return "15109536";
    }

    @Override
    public String codifica(String str) {
        String codificada = "";
        for (char s : str.toCharArray()) {
            if(s == 'h'){
                codificada = codificada + '/';
            }
            else if(s == 'H'){
                codificada = codificada + '-';
            }
            else if(s == '1'){
                codificada = codificada + '*';
            }
            else if(s == '0'){
                codificada = codificada + '+';
            }
            else if(s == 'j'){
                codificada = codificada + '=';
            }
            else if(s == 'J'){
                codificada = codificada + '.';
            }
            else if(s == 'e'){
                codificada = codificada + '?';
            }
            else if(s == 'E'){
                codificada = codificada + '^';
            }
            else{
                codificada = codificada + s;
            }
        }
        return codificada;
    }

    @Override
    public String decodifica(String str) {
        String decodificada = "";
        for (char s : str.toCharArray()) {
            if(s == '/'){
                decodificada = decodificada + 'h';
            }
            else if(s == '-'){
                decodificada = decodificada + 'H';
            }
            else if(s == '*'){
                decodificada = decodificada + '1';
            }
            else if(s == '+'){
                decodificada = decodificada + '0';
            }
            else if(s == '='){
                decodificada = decodificada + 'j';
            }
            else if(s == '.'){
                decodificada = decodificada + 'J';
            }
            else if(s == '?'){
                decodificada = decodificada + 'e';
            }
            else if(s == '^'){
                decodificada = decodificada + 'E';
            }
            else{
                decodificada = decodificada + s;
            }
        }
        return decodificada;
    }
    
}
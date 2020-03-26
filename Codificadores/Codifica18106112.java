package Codificadores;
//binary converter .
public class Codifica18106112 implements Codifica {

    //Transforma as letras em binário
    public String codifica(final String str) {
        String cod = "";
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'a':
                    cod += "01100001 ";
                    break;
                case 'b':
                    cod += "01100010 ";
                    break;
                case 'c':
                    cod += "01100011 ";
                    break;
                case 'd':
                    cod += "01100100 ";
                    break;
                case 'e':
                    cod += "01100101 ";
                    break;
                case 'f':
                    cod += "01100110 ";
                    break;
                case 'g':
                    cod += "01100111 ";
                    break;
                case 'h':
                    cod += "01101000 ";
                    break;
                case 'i':
                    cod += "01101001 ";
                    break;
                case 'j':
                    cod += "01101010 ";
                    break;
                case 'k':
                    cod += "01101011 ";
                    break;
                case 'l':
                    cod += "01101100 ";
                    break;
                case 'm':
                    cod += "01101101 ";
                    break;
                case 'n':
                    cod += "01101110 ";
                    break;
                case 'o':
                    cod += "01101111 ";
                    break;
                case 'p':
                    cod += "01110000 ";
                    break;
                case 'q':
                    cod += "01110001 ";
                    break;
                case 'r':
                    cod += "01110010 ";
                    break;
                case 's':
                    cod += "01110011 ";
                    break;
                case 't':
                    cod += "01110100 ";
                    break;
                case 'u':
                    cod += "01110101 ";
                    break;
                case 'v':
                    cod += "01110110 ";
                    break;
                case 'w':
                    cod += "01110111 ";
                    break;
                case 'x':
                    cod += "01111000 ";
                    break;
                case 'y':
                    cod += "01111001 ";
                    break;
                case 'z':
                    cod += "01111010 ";
                    break;
                default:
                    cod += str.charAt(i);
            }
        }
        return cod;
    }

    //transforma binário em letra
    public String decodifica(final String str) {
        String dcod = "";
        for (int i = 0; i < str.length(); i++) {
            switch (str) {
                case "01100001":
                    dcod += "a";
                    break;
                case "01100010":
                    dcod += "b";
                    break;
                case "01100011":
                    dcod += "c";
                    break;
                case "01100100":
                    dcod += "d";
                    break;
                case "01100101":
                    dcod += "e";
                    break;
                case "01100110":
                    dcod += "f";
                    break;
                case "01100111":
                    dcod += "g";
                    break;
                case "01101000":
                    dcod += "h";
                    break;
                case "01101001":
                    dcod += "i";
                    break;
                case "01101010":
                    dcod += "j";
                    break;
                case "01101011":
                    dcod += "k";
                    break;
                case "01101100":
                    dcod += "l";
                    break;
                case "01101101":
                    dcod += "m";
                    break;
                case "01101110":
                    dcod += "n";
                    break;
                case "01101111":
                    dcod += "o";
                    break;
                case "01110000":
                    dcod += "p";
                    break;
                case "01110001":
                    dcod += "q";
                    break;
                case "01110010":
                    dcod += "r";
                    break;
                case "01110011":
                    dcod += "s";
                    break;
                case "01110100":
                    dcod += "t";
                    break;
                case "01110101":
                    dcod += "u";
                    break;
                case "01110110":
                    dcod += "v";
                    break;
                case "01110111":
                    dcod += "w";
                    break;
                case "01111000":
                    dcod += "x";
                    break;
                case "01111001":
                    dcod += "y";
                    break;
                case "01111010":
                    dcod += "z";
                    break;
                default:
                    dcod += str.charAt(i);
            }
        }
        return dcod;

    }
    public String getMatriculaAutor() {
        return "18106112";
    }
    public String getNomeAutor() {
        return "Bruno Abbad";
    }

}
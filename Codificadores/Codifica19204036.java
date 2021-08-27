package Codificadores;

import java.util.Random;

public class Codifica19204036 implements Codifica {

    // Afim de dificultar a decodificação por um terceiro as letras do alfabeto romano (Romaji) serão convertidas em caracteres japoneses basicos (Kana)
    // Numerais arabes são usados nos dois alfabetos, logo se repetem na lista, porém na codificação o número tem grandes chances de não representar ele mesmo
    private static String romaji = "ABCDEFGHIJKLMNOPQRSTUVWXYZÇÁÀÃÂÍÌÎÚÙÛÉÈÊÓÒÕÔabcdefghijklmnopqrstuvwxyzçáàãâíìîúùûéèêóòõô1234567890!?.,: ";
    private static String kana = "あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをアイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲ1234567890.,: ";

    //O Diferencial do meu código é a possibilidade de gerar uma codificação diferente a cada nova execução, para isso eu utilizo o Random
    Random escolheKana = new Random();
    int numeroRandom = escolheKana.nextInt(100);

    //A Lógica por trás do código é simples, um número de 0 a 99 é escolhido, para efeito de ilustração utilizaremos o número 4
    // Suponha-se que o numero 4 foi escolhido pelo Random, ele corresponde ao Hiragana da letra O (お)
    // Quando o numero 4 for passado ao "ordenaKana" o お se torna o indice zero e os indices anteriormente 0, 1, 2 e 3 são ordenados no fim da nova lista de Kana
    // Após isso é iniciado a troca de caracteres, a letra T (Maiusculo) está na posição 19 na String romaji, será substituido pelo Kana na posição 19 da nova ordem iniciada por お
    public String codifica(String str) {
        String codificado = "";
        String kanaFormatado = "";
        insereCharDesconhecido(str);
        boolean iniciador = false;
        for (char k : str.toCharArray()) {
            for (int i = 0; i < romaji.length(); i++) {
                if (k == romaji.charAt(i)) {
                    if (!iniciador) {
                        iniciador = true;
                        kanaFormatado = ordenaKana(numeroRandom);
                    }
                    codificado += kanaFormatado.charAt(i);
                }
            }
        }
        return codificado;
    }

    // A Decodificação apenas faz o processo inverso ao explicado anteriormente, trocando o Kana da nova ordem pela letra romana
    public String decodifica(String str) {
        String decodificado = "";
        String kanaFormatado = ordenaKana(numeroRandom);
        for (char k : str.toCharArray()) {
            for (int i = 0; i < kana.length(); i++) {
                if (k == kanaFormatado.charAt(i)) {
                    decodificado += romaji.charAt(i);
                }
            }
        }
        return decodificado;
    }

    //ordemInicial é a nova string iniciada por お até o fim da lista de kana
    //ordemFinal são os kana anteriores ao お que são jogados ao final
    //novaOrdem é a nova lista de Kana
    public String ordenaKana(int iniciador) {
        String novaOrdem;
        String ordemInicial = "";
        String ordemFinal = "";
        boolean gatilho = false;
        for (int i = 0; i < kana.length(); i++) {
            if (iniciador == i || gatilho) {
                ordemInicial += kana.charAt(i);
                gatilho = true;
            } else {
                ordemFinal += kana.charAt(i);
            }
        }
        novaOrdem = ordemInicial + ordemFinal;
        return novaOrdem;
    }
    
    // Caso a frase a ser codificada contenha caracteres não existentes na lista de Romaji e/ou Kana, o método adicionará em ambas as listas 
    public void insereCharDesconhecido(String str) {
        boolean encontrou = false;
        for (char k : str.toCharArray()) {
            if(encontrou){
                encontrou = false;
            }
            for (int i = 0; i < romaji.length(); i++) {
                if (k == romaji.charAt(i)||k == kana.charAt(i)) {
                    encontrou = true;
                }
            }
            if(!encontrou){
                romaji += k;
                kana += k;
            }
        }
    }

    @Override
    public String getMatriculaAutor() {
        return "19204036";
    }

    @Override
    public String getNomeAutor() {
        return "Marcio Menezes";
    }

}

package Codificadores;

import java.lang.Character;

public class Codifica20106788 implements Codifica{

    private String vogais = "aeiouAEIOU";
    private static String consoantes = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
     
      public String getNomeAutor(){
          return "Júlia Leuze Godoy";
      }

      public String getMatriculaAutor(){
          return "20106788";
      }
  
      /*
        Como funciona:
        --alfabeto
         vogais: aeiou -> cifra de cesar valor 1
         cosoantes:    -> cifra de cesar valor 3
        --numeros
         cada algorismo coloca entre hífens e multiplica por 13
        --caracteres especiais 
          inalterados
      */

        /*
            Este método é responsável por codificar/descodificar as vogais da mensagem
            O primeiro parâmetro é o caractere a ser (des)codificado
            O segundo parâmetro informa se é para codificar (positivo) ou descodificar(negativo)
        */
      private char deslocandoVogal(char cod, int x){
        int origem = vogais.indexOf(cod);
        char resultado;
        int posicao;
        if (x>0){
            if (origem+1 >= vogais.length())
               posicao = vogais.length() - origem -1;
            else
                posicao = origem+1;          
            resultado = vogais.charAt(posicao);
        }
        else{
            if (origem-1 < 0)
               posicao = vogais.length() - origem -1;
            else
                posicao = origem - 1;
            resultado = vogais.charAt(posicao);
        }
        return resultado;
      }

      /*
            Este método funciona de maneira análoga ao "deslocandoVogal"
            Difere apenas no valor da chave
      */
      private char deslocandoConsoante(char cod, int x){
        int origem = consoantes.indexOf(cod);
        char resultado;
        int posicao;
        if (x>0){
            if (origem+3 >= consoantes.length())
               posicao = consoantes.length() - origem -1;
            else
                posicao = origem +3;
            resultado = consoantes.charAt(posicao);
        }
        else{
            if (origem-3 < 0)
               posicao = consoantes.length() - origem -1;
            else
                posicao = origem -3;
            resultado = consoantes.charAt(posicao);
        }
        return resultado;
      }

      /*
        Este método codifica o digito informado por parâmetro
        Coloca entre hifens e multiplica por 13
      */
      private String codificaDigito(int cod){
        String resultado = "-" + (cod*13) + "-";
        return resultado;
      }

      /*
        Este método decodifica a string informada por parâmetro
        Retira o primeiro hifen e divide por 13 o valor numérico
      */
      private int decodificaDigito(String cod){
        int valor = Integer.parseInt(cod.substring(1));
        valor = valor/13;
        return valor;
      }

      // Recebe um string e retorna o correspondente codificado
      public String codifica(String str) {
          String codificado = "";

          for (int i=0; i<str.length(); i++){
              Character c = str.charAt(i);
              
              if (vogais.contains(c.toString())){ //caso Vogal
                char alterado = deslocandoVogal(c, +1);
                codificado = codificado + alterado;
              }
              else if (consoantes.contains(c.toString())){ //caso Consoante
                char alterado = deslocandoConsoante(c, +1);
                codificado = codificado + alterado;
              }
              else if (Character.isDigit(c)){ //caso Digito
                  String alterado = codificaDigito(Character.getNumericValue(c));
                  codificado = codificado + alterado;
              }
              else{ //caso caractere especial
                  codificado = codificado + c;
              }
          }
          return codificado;
      }
  
      // Recebe um string codificado e retorna o correspondente decodificado
      public String decodifica(String str){
        String descodificado = "";

        for (int i=0; i<str.length(); i++){
            Character c = str.charAt(i);
            
            if (vogais.contains(c.toString())){
              char alterado = deslocandoVogal(c, -1);
              descodificado = descodificado + alterado;
            }
            else if (consoantes.contains(c.toString())){
              char alterado = deslocandoConsoante(c, -1);
              descodificado = descodificado + alterado;
            }
            else if (c == '-' && (i+1)<str.length() && Character.isDigit(str.charAt(i+1)) && str.indexOf('-', i+1)!=-1){ //verifica se há hifen seguido por digito seguido por hífen--o que caracteriza um digito codificado
                
              String valor = str.substring(i, str.indexOf('-', i+1));//pega "-<digitos>"
      
              int alterado = decodificaDigito(valor);
              descodificado = descodificado + alterado;

              i = str.indexOf('-', i+1);
          }
            else{
                descodificado = descodificado + c;
            }
        }
        return descodificado;
      }
    
}

package Codificadores;

public class Codifica121113971 implements Codifica {

    @Override
    public String getNomeAutor() {
        // TODO Auto-generated method stub
        return "Douglas Pacheco";
    }

    @Override
    public String getMatriculaAutor() {
        // TODO Auto-generated method stub
        //testes superiores
        return "12111397-1";
    }

    @Override
    public String codifica(String str) {
        // TODO Auto-generated method stub
        StringBuffer sb = new StringBuffer(str); /*cria uma StringBuffer que
        recebe a String que é passada como argumento no método.
        */
        String a = sb.reverse().toString(); /*Cria uma string que armazena
        a string buffer revertida*/
        
        StringBuilder sc = new StringBuilder(a);/*cria uma stringbuilder que
        armazena a String revertida*/
        
        String p =  sc.insert(1, "GñopDS1G 978F 7CS7F-{54").toString();/*
        Adiciona os seguintes caracteres entre o primeiro e segundo caractere 
        (no caso, a partir da posição 1, indo até a posição 24)*/ 
        p = sc.insert(0, "D(GS G9õmoga16*.98F {´´´798!?").toString();/*adiciona
        os seguintes caracteres antes da palavra (a partir da posição 0, indo
        até a posição 29)*/
        p = sc.insert(p.length() - 1, "´´sg  dg5d4àóîís g2dg9s7").toString();/*
        adiciona os seguintes caracteres entre o penúltimo e último*/
        p = sc.insert(p.length(), "kl sco pesaox").toString();/*adiciona os
        seguintes caracteres depois do último*/
        
        return p.toUpperCase(); //retorna a mensagem criptografada maiúscula

    }

    @Override
    public String decodifica(String str) {
        // TODO Auto-generated method stub
        StringBuilder sl = new StringBuilder(str);/*Cria uma StringBuilder que
        recebe a mensagem criptografada*/
        
        sl.delete(0, 29);/*elimina os caracteres da posição 0 à 29, onde foi
        adicionado caractere*/
        sl.delete(1, 24);/*elimina os caracteres da posição 1 à 24, onde foi
        adicionado caractere*/
        sl.delete(sl.length() - 13, sl.length());/*elimina os caracteres apartir
        da posição, onde foi adicionado caractere*/
        sl.delete(sl.length() - 25, sl.length() - 1);/*elimina os caracteres
        localizados antes do último caractere até o caractere localizado na
        posição da subtração entre o tamanho do caractere subtraido à 25, 
        onde foi adicionado caractere*/
        
        StringBuffer sf = new StringBuffer(sl.toString());/*Cria uma
        StringBuffer, que armazena a StringBuilder com a mensagem que foi
        passada para String*/
        
        String x = sf.reverse().toString();/*cria uma String que armazena a
        StringBuffer revertida, na qual foi passada para String*/
        
        return x;//retorna a mensagem descriptografada
    }

    
}
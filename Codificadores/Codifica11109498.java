/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codificadores;  

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

/**
 *
 * @author p-karol
 */
public class Codifica11109498 implements Codifica{
    
    private String palavraChave = "naovaisaberjamais12!!!!";
    private static byte[] chave;
    private static SecretKeySpec chaveSecreta;
    
    // Retorna o autor do codificador
    public String getNomeAutor(){
        return "Priscilla de Azevedo Karolczak";
    }

    // Retorna a matrícula do autor do codificador
    public String getMatriculaAutor(){
        return "11109498";
    }

    // Recebe um string e retorna o correspondente codificado
    public String codifica(String str){
        
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, setChave(palavraChave));
            return Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes("UTF-8")));    
        }
        catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        
        return null;
    }

    // Recebe um string codificado e retorna o correspondente decodificado
    public String decodifica(String str){
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, setChave(palavraChave));
            return new String(cipher.doFinal(Base64.getDecoder().decode(str)));
        } 
        catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }   
        return null;
    }
        
    //Recebe uma string e retorna obj SecretKeySpec para utilizar no algoritmo de criptografia/descriptografia AES
    public static SecretKeySpec setChave(String palavraChave){
       
        MessageDigest sha = null;
       
        try {
            chave = palavraChave.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            chave = sha.digest(chave);
            chave = Arrays.copyOf(chave, 16); 
            chaveSecreta = new SecretKeySpec(chave, "AES");
            return chaveSecreta;
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package br.com.wlsnprogramming.aprendendojava.javacore.u000expressoesregurares.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {

        // \d todos os digitos
        // \D tudo o que não for digito
        // \s espaços em branco \t \n \f \r
        // \S todo o caracter que não é espaço em branco
        // \w caracteres de palavras a-z A-Z, digitos e _
        // \W tudo o que não for racter de palavras
        // []
        // ? 0 ou uma
        // * 0 ou mais
        // + uma ou mais
        //  {n, n} n ate n
        // ( ) agrupamento
        // | ou
        // $ fim de linha
        // . coringa
        // ^ [^abc]


        int numeroHex = 0x100f;
//        String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";
//        String texto = "12 0x 0X 0xFFABC 0x10G 0x1";
        String regex = "([a-zA-Z0-9\\.-_])+@[a-zA-Z]+(\\.([a-zA-Z])+)+";
        String texto = "fulando@gmail.com, 102Abc@gmail.com, #@!abrao@mail, teste@gmail.br, teste@mail, welson@simpatiabrasileira.com.br";
        System.out.println("E-mail valido? " + "#@!abrao@mail".matches(regex));
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        String regexData = "\\d{1,2}/\\d{1,2}/\\d{2,4}";
        System.out.println("23/7/98".matches(regexData));

        System.out.println("Texto:  " + texto);
        System.out.println("Indice: 01234567890123456789");
        System.out.println("Expressão: " + matcher.pattern());
        System.out.println("Posições encotradas: ");

        while(matcher.find()) {
            System.out.println(matcher.start() + ": " + matcher.group());
        }
    }
}

package com.example.lecture_spring_2_crudproject.service.textTransfer;

import org.springframework.stereotype.Service;

@Service
public class TextTransfer {

    public String transferText3Word(String text) throws Exception {

        //split example
//        String str = "js code example 20220828";
//
//        String[] result = str.split(" ");
//        String[] result2 = str.split(" ", 2);
//        String[] result3 = str.split(" ", 3);
//
//        System.out.println(Arrays.toString(result));
//        System.out.println(Arrays.toString(result2));
//        System.out.println(Arrays.toString(result3));

        //substring example
//        String str = "Hi student. This is split example";
//        String result = str.substring(17);
//        String result2 = str.substring(17, 22);
//
//        System.out.println(result);
//        System.out.println(result2);

        //substring indexof
//        String str = "This is macbook is beautiful";
//        int beginIndex = str.indexOf("is");
//        int endIndex = str.length();
//        String result = str.substring(beginIndex, endIndex);
//
//        System.out.println(result);

        //replace example (. = 모든 문자)
//        SString a = "무궁화. 삼천리. 화려강산. 대한사람. 대한으로. 길이. 보전하세 ";
////replaceAll([정규식],[바꿀문자])
//        a = a.replaceAll(".", "/");
//        System.out.println(a);

        String wordFirst3 = text.substring(0,3);
        String wordLast = text.substring(4,text.length());
        wordLast = wordLast.replaceAll(".", "*");
        System.out.println(wordFirst3);
        System.out.println(wordLast);

//        text.replace()
        return wordFirst3+wordLast;
    }
}

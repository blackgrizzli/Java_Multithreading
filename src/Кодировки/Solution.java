package Кодировки;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/*
Смена кодировки
*/
//Charset koi8 = Charset.forName("KOI8-R");
//        Charset windows1251 = Charset.forName("Windows-1251");
//
//        byte[] buffer = new byte[1000];
//        inputStream.read(buffer);
//        String s = new String(buffer, koi8);
//        buffer = s.getBytes(windows1251);
//        outputStream.write(buffer);
public class Solution {
    public static void main(String[] args) throws IOException {
        try(FileInputStream fis = new FileInputStream(args[0]);
            FileOutputStream fos = new FileOutputStream(args[1])){
            Charset win = Charset.forName("Windows-1251");
            Charset utf = StandardCharsets.UTF_8;
            byte[]buff = new byte[1000];
            fis.read(buff);
            String s = new String(buff,win);
            buff = s.getBytes(StandardCharsets.UTF_8);
            fos.write(buff);

        }
    }
}

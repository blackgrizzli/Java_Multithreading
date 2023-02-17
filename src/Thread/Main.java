package Thread;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
//        ZipOutputStream zipOutputStream = new ZipOutputStream(
//                new FileOutputStream("/Users/evgeniagerasimenko/Desktop/catalog/arhive.zip"));
//        zipOutputStream.putNextEntry(new ZipEntry("document.txt"));
//
//        Path path = Path.of("/Users/evgeniagerasimenko/Desktop/catalog/file1.txt");
//        Files.copy(path,zipOutputStream);
//        zipOutputStream.close();
        ZipFile zipFile = new ZipFile("/Users/evgeniagerasimenko/Desktop/catalog/arhive.zip");
        Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
        while (enumeration.hasMoreElements()) {
            ZipEntry zipEntry = enumeration.nextElement();
            System.out.println(zipEntry.getName());
            System.out.println(zipEntry.getComment());
            System.out.println(zipEntry.getCrc());
            System.out.println(zipEntry.getSize());

            ZipFile zipFile2 = new ZipFile("/Users/evgeniagerasimenko/Desktop/catalog/arhive.zip");
            final Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry1 = entries.nextElement();
                if (!zipEntry.isDirectory()) {
                    BufferedReader bf = new BufferedReader(new InputStreamReader(zipFile.getInputStream(zipEntry)));
                    while (bf.ready()) {
                        System.out.println(bf.readLine());
                    }
                }
            }
        }
    }
}
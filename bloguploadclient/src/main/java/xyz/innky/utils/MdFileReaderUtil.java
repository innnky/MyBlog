package xyz.innky.utils;

import xyz.innky.Config;

import java.io.*;

public class MdFileReaderUtil {
    public static String readFile(File file){
        try {
            StringBuilder sb = new StringBuilder();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s = bufferedReader.readLine();
            while (s!=null){
                sb.append(s);
                sb.append("\n");
                s = bufferedReader.readLine();
            }
            bufferedReader.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}

package PaperPass;

import java.io.*;
import java.util.Scanner;

public class PaperPassCount {
    public static void main(String[] args) {

        String originalPath;
        String[] OriginalArray = new String[1000];
        Reader reader = null;

        Scanner in = new Scanner(System.in);
        System.out.println("请输入原文路径:");
        originalPath = in.nextLine();

        try {
            reader = new InputStreamReader(new FileInputStream(new File(originalPath)));
            int tempchar;
            int n = 0;
            String sentence = "";
            while ((tempchar = reader.read()) != -1) {
                switch (JudgeType(tempchar)) {
                    case 1:
                        if (sentence.equals("")) break;
                        OriginalArray[n++] = sentence;
                        sentence = "";
                        break;
                    case 2:
                        sentence = sentence + (char) (tempchar);
                    default:
                        break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int JudgeType(int tempchar) {
        if ((char) tempchar == ' ' || (char) tempchar == '，' || (char) tempchar == '\r' || (char) tempchar == '\t' ||
                (char) tempchar == '、' || (char) tempchar == '/' || (char) tempchar == '.' || (char) tempchar == '-'
                || (char) tempchar == '[' || (char) tempchar == ']')
            return 0;   //忽略
        else if ((char) tempchar == '。' || (char) tempchar == '!' || (char) tempchar == '?' || (char) tempchar == '\n'
                || (char) tempchar == ';')
            return 1;   //判定为句子
        else return 2;
    }

}


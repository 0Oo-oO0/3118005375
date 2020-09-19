package PaperPass;

import java.io.*;
import java.util.Scanner;

public class PaperPassCount {
    public static void main(String[] args) {

        String paperPath;
        Scanner in = new Scanner(System.in);
        Reader reader = null;

        System.out.println("请输入原文路径:\n");
        paperPath = in.nextLine();

        try {
            reader = new InputStreamReader(new FileInputStream(new File(paperPath)));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                System.out.print((char) tempchar);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil{
    //读整数
    public static int readInt(Scanner sc,String prompt){
        while (true){
            System.out.println(prompt);
            try {
                int v = sc.nextInt();
                sc.nextLine();
                return v;
            } catch (InputMismatchException e) {
                System.out.println("输入不合法，请重新输入~");
                sc.nextLine();
            }
        }
    }

    //读小数
    public static Double readdouble(Scanner sc,String prompt){
        System.out.println(prompt);
        while (true){
            try {
                Double d = sc.nextDouble();
                sc.nextLine();
                return d;
            } catch (InputMismatchException e) {
                System.out.println("输入不合法，请重新输入~");
                sc.nextLine();
            }
        }
    }

    //读文本
    public static String readString(Scanner sc,String prompt){
        while (true){
            System.out.println(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()){
                return s;
            }
            System.out.println("输入不能为空~");
        }
    }
}

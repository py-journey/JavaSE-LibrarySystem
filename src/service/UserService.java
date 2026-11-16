package service;
import entity.User;
import util.InputUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    //用户登录和注册逻辑

    public static ArrayList<User> list = new ArrayList<>();
    //注册逻辑
    public static void rigester(){
        //ArrayList存放用户信息

        //注册逻辑
        Scanner sc = new Scanner(System.in);
        /*System.out.println("请输入用户名：");
        String uname =sc.next();
        */
        String uname = InputUtil.readString(sc,"请输入用户名：");

        /*
        System.out.println("请输入密码：");
        String passwd = sc.next();
        */
        String passwd = InputUtil.readString(sc,"请输入密码：");

        //默认用户不存在
        boolean hasSameName = false;
        //遍历集合是否出现重复用户
        for (User user : list) {
            if (user.getUsername().equals(uname)){
                hasSameName=true;
                break;
            }
        }
        if (hasSameName) {
            System.out.println("该用户已注册~");
            return;
        }
        //密码长度进行校验
        if (passwd.length()<6){
            System.out.println("密码长度不能小于6位~");
            return;
        }
        //密码难度进行校验(由数字和字母组成)
        boolean hasLetter = false;
        boolean hasDigit = false;
        for (int i = 0; i < passwd.length(); i++) {
            char c = passwd.charAt(i);
            if (Character.isDigit(c)){
                hasDigit=true;
            }
            if (Character.isLetter(c)){
                hasLetter=true;
            }
        }
        if (!hasDigit||!hasLetter){
            System.out.println("密码过于简单，必须由数字和字母组成~");
            return;
        }
        User user = new User();
        user.setUsername(uname);
        user.setPassword(passwd);
        list.add(user);
        System.out.println(uname+"用户注册成功~");
    }

    //登录逻辑
    public static boolean login(){
        Scanner sc = new Scanner(System.in);
        boolean loginSuccess = false;
        int chance = 3;

        while (chance>0){
            /*System.out.println("请输入用户名：");
            String uname = sc.next();
            */
            String uname = InputUtil.readString(sc,"请输入用户名：");

            /*
            System.out.println("请输入密码：");
            String passwd = sc.next();
            */
            String passwd = InputUtil.readString(sc,"请输入密码：");

            boolean findUser = false;
            boolean pwdCorrect = false;

            //遍历用户
            for (User user : list) {
                //判断用户是否存在
                if (user.getUsername().equals(uname)){
                    //判断用户密码是否正确
                    findUser=true;
                    if (user.getPassword().equals(passwd)){
                        pwdCorrect=true;
                    }
                    break;
                }
            }
            if (!findUser){
                chance--;
                if (chance>0){
                    System.out.println("用户名不存在，还剩："+chance+"次机会~");
                }
            } else if (pwdCorrect) {
                System.out.println("登录成功~");
                loginSuccess=true;
                break;
            }else {
                chance--;
                if (chance>0){
                    System.out.println("密码错误，还剩："+chance+"次机会~");
                }
            }
        }
        if (!loginSuccess) {           // 只有失败才打印锁定
            System.out.println("登录次数超过三次，账户已被锁~");
        }
        return loginSuccess;
    }
}

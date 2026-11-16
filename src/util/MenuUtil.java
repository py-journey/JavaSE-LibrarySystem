package util;

import java.util.Scanner;

import service.UserService;
import service.BookService;

public class MenuUtil {
    //控制台菜单展示
    //登录菜单
    public static void showLoginMenu(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("=========Welcome to Library System==========");
            System.out.println("1.用户登录");
            System.out.println("2.用户注册");
            System.out.println("0.退出系统");
            //System.out.println("请选择：");
            int choice = InputUtil.readInt(sc,"请选择：");

            switch (choice){
                case 1:
                    //调用登录方法
                    boolean success = UserService.login();
                    //登录成功再调用菜单页面
                    if (success){
                        showMenu();
                    }
                    break;
                case 2:
                    UserService.rigester();
                    break;
                case 0:
                    System.out.println("退出本系统~");
                    return;
                default:
                    System.out.println("请输入错误~");
            }
        }
    }

    //书籍菜单
    public static void showMenu(){
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("=========Welcome to Menu==========");
            System.out.println("1.增加图书");
            System.out.println("2.删除图书");
            System.out.println("3.修改图书");
            System.out.println("4.查询图书");
            System.out.println("5.显示所有图书");
            System.out.println("0.退出图书管理系统");
            //System.out.println("请选择：");
            int chioce = InputUtil.readInt(sc,"请选择：");
            switch (chioce){
                case 1:
                    //调用增加图书函数
                    BookService.add_book();
                    break;
                case 2:
                    //调用删除图书函数
                    BookService.delete_book();
                    break;
                case 3:
                    //调用修改图书函数
                    BookService.update_book();
                    break;
                case 4:
                    //调用查询图书函数
                    BookService.search_book();
                    break;
                case 5:
                    //调用显示所有图书函数
                    BookService.showAll();
                    break;
                case 0:
                    //退出图书管理系统
                    System.out.println("成功退出图书管理系统~");
                    return;
                default:
                    System.out.println("输入错误~");
            }
        }
    }
}


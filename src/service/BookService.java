package service;

import entity.Book;
import util.InputUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class BookService {
    //图书：增删改查逻辑

    //1.增加图书
    //用集合存储书籍
    public static ArrayList<Book> list = new ArrayList<>();
    public static void add_book() {
        Scanner sc = new Scanner(System.in);
        /*
        System.out.println("请输入添加书籍ID：");
        int id = sc.nextInt();
        */
        int id = InputUtil.readInt(sc,"请输入书籍ID：");
        boolean isRepeat = false;
        for (Book b : list) {
            if (b.getId()==id){
                isRepeat=true;
                break;
            }
        }
        if (isRepeat){
            System.out.println("添加失败，添加书籍已经存在~");
            return;
        }else {
            /*
            System.out.println("请输入书名：");
            String bookname = sc.next();
            */
            String bookname = InputUtil.readString(sc,"请输入书名：");

            /*
            System.out.println("请输入书价格：");
            Double bookprice = sc.nextDouble();
            */
            Double bookprice = InputUtil.readdouble(sc,"请输入书籍价格：");

            /*
            System.out.println("请输入书作者：");
            String bookauthor = sc.next();
            */
            String bookauthor = InputUtil.readString(sc,"请输入作者：");

            Book book = new Book();
            book.setId(id);
            book.setBookname(bookname);
            book.setPrice(bookprice);
            book.setAuthor(bookauthor);
            list.add(book);
            System.out.println("添加书籍成功~");
            return;
        }
    }

    //2.删除图书
    public static void delete_book(){
        Scanner sc = new Scanner(System.in);
        /*
        System.out.println("请输入删除书籍ID：");
        int id = sc.nextInt();
        */
        int id = InputUtil.readInt(sc,"请输入书籍ID：");

        //假设书籍不存在
        boolean found = false;
        //判断书籍是否存在
        for (int i = 0; i < list.size(); i++) {
            //根据索引获取每个元素
            Book b = list.get(i);
            if (b.getId()==id){
                list.remove(i);
                found=true;
                break;
            }
        }
        if (found){
            System.out.println("书籍成功删除~");
            return;
        }else {
            System.out.println("删除失败，删除书籍不存在~");
            return;
        }
    }


    //3.修改书籍
    public static void update_book(){
        Scanner sc = new Scanner(System.in);

        /*
        System.out.println("请输入修改书籍的ID：");
        int editId = sc.nextInt();
        */
        int editId = InputUtil.readInt(sc,"请输入修改书籍的ID：");

        for (int i = 0; i < list.size(); i++) {
            Book b = list.get(i);
            if (b.getId()==editId){
                /*
                System.out.println("请输入书名：");
                String bookName = sc.next();
                */
                String bookname = InputUtil.readString(sc,"请输入书名：");

                /*
                System.out.println("请输入书价格：");
                Double bookPrice = sc.nextDouble();
                */
                Double bookprice = InputUtil.readdouble(sc,"请输入书籍价格：");

                /*
                System.out.println("请输入书作者：");
                String bookAuthor = sc.next();
                 */
                String bookauthor = InputUtil.readString(sc,"请输入作者：");

                b.setBookname(bookname);
                b.setPrice(bookprice);
                b.setAuthor(bookauthor);
                b.setId(editId);

                //修改不需要list.add()，如果添加后会新增一条数据
                //list.add(b);

                System.out.println("书籍修改成功~");
                return;
            }
        }
        System.out.println("修改失败，修改书籍不存在~");
    }

    //查询图书
    public static void search_book(){
        Scanner sc = new Scanner(System.in);
        /*
        System.out.println("请输入查询书籍ID：");
        int searchId = sc.nextInt();
        */
        int searchId = InputUtil.readInt(sc,"请输入查询书籍ID：");

        for (int i = 0; i < list.size(); i++) {
            Book b = list.get(i);
            if (b.getId()==searchId){
                System.out.println("书籍ID："+b.getId());
                System.out.println("书籍名称："+b.getBookname());
                System.out.println("书籍价格："+b.getPrice());
                System.out.println("书籍作者："+b.getAuthor());
                return;
            }
        }
        System.out.println("查询失败，查询书籍不存在~");
    }

    public static void showAll(){
        if (list.isEmpty()){
            System.out.println("暂无书籍~");
            return;
        }else {
            for (int i = 0; i < list.size(); i++) {
                Book b = list.get(i);
                System.out.println(b);
                //System.out.println("所有书籍查询成功~");
            }
            System.out.println("所有书籍查询成功~");
            return;
        }
    }
}

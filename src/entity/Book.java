package entity;

public class Book {
    //ID、书名、价格、作者
    private int id;
    private  String bookname;
    private Double price;
    private String author;

    //构造方法
    public Book(){
    }
    public Book(int id,String bookname,Double price,String author){
        this.id=id;
        this.bookname=bookname;
        this.price=price;
        this.author=author;
    }

    //Getter/Setter方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "书籍：{" +
                "书籍ID=" + id +
                ", 书籍名称='" + bookname + '\'' +
                ", 书籍价格=" + price +
                ", 书籍作者='" + author + '\'' +
                '}';
    }
}

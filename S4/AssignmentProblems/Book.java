class Book {
    String title,author,isbn; boolean isAvailable;
    Book(){this("NA","NA","000",true);}
    Book(String t,String a){this(t,a,"000",true);}
    Book(String t,String a,String i){this(t,a,i,true);}
    Book(String t,String a,String i,boolean av){title=t;author=a;isbn=i;isAvailable=av;}
    void borrowBook(){isAvailable=false;}
    void returnBook(){isAvailable=true;}
    void displayBookInfo(){System.out.println(title+" | "+author+" | "+isbn+" | Available:"+isAvailable);}
    public static void main(String[] args){
        Book b1=new Book();
        Book b2=new Book("1984","Orwell");
        Book b3=new Book("Hamlet","Shakespeare","1234");
        b2.borrowBook();b3.borrowBook();b3.returnBook();
        b1.displayBookInfo();b2.displayBookInfo();b3.displayBookInfo();
    }
}

class MovieTicket {
    String movieName, theatreName; int seatNumber; double price;
    MovieTicket(){this("Unknown","NA",0,0);}
    MovieTicket(String movieName){this(movieName,"NA",0,200);}
    MovieTicket(String movieName,int seat){this(movieName,"PVR",seat,200);}
    MovieTicket(String m,String t,int s,double p){movieName=m;theatreName=t;seatNumber=s;price=p;}
    void printTicket(){System.out.println(movieName+" | "+theatreName+" | Seat:"+seatNumber+" | Rs."+price);}
    public static void main(String[] args){
        MovieTicket t1=new MovieTicket();
        MovieTicket t2=new MovieTicket("Inception");
        MovieTicket t3=new MovieTicket("Avatar",5);
        MovieTicket t4=new MovieTicket("Batman","IMAX",10,450);
        t1.printTicket();t2.printTicket();t3.printTicket();t4.printTicket();
    }
}

import java.sql.DriverManager;

// what does Class.forName do?
//before creating the object it first load the class and while loading the class it will call the static method and while creatinng the object it call the instance block.
// but if we want to call the static block without creating the object then we load the class
public class fourth {
    public static void main(String[] args) throws Exception{

        Class.forName("Pqr");
        Class.forName("Pqr").newInstance();

        //we load the driver using
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //the above line is called as a static block which register the driver


    }
}

class Pqr{
    static {
        System.out.println("From Static Block");
    }
    {
        //********Instance Block
        System.out.println("From Instance Block");
    }
}

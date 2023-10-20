import java.sql.*;

public class second {
    public static void main(String[] args)throws ClassNotFoundException, SQLException {
        String url ="jdbc:mysql://localhost:3306/student";
        String un = "root";
        String pass = "********";
        String query = "select * from stud";



        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,un,pass);
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query);

        String userData ="";
        while(resultSet.next()){
            userData = resultSet.getInt(1) + " " + resultSet.getString(2);
            System.out.println(userData);
        }
        st.close();
        con.close();
    }
}

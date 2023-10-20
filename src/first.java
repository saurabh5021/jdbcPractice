import java.sql.*;


public class first {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url ="jdbc:mysql://localhost:3306/student";
        String un = "root";
        String pass = "********";
        String query = "Select name from stud where id=3";



            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,un,pass);
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            resultSet.next();
            String name = resultSet.getString("name");
            System.out.println(name);

            st.close();
            con.close();








    }
}

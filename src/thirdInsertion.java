import java.sql.*;

public class thirdInsertion {
    public static void main(String[] args) throws SQLException,ClassNotFoundException {
        String url ="jdbc:mysql://localhost:3306/student";
        String un = "root";
        String pass = "12345678";
        int val = 5;
        String name = "Yogesh";
        String query = "insert into stud values(?, ?)";



        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,un,pass);
        //Statement st = con.createStatement();
        //int resultSet = st.executeUpdate(query);
        // if there are more than one query we can use prepare statement

        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, val);
        st.setString(2, name);
        int resultSet = st.executeUpdate();

        System.out.println("rows affected: " + resultSet);

        st.close();
        con.close();
    }
}

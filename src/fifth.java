import java.sql.*;

public class fifth {
    public static void main(String[] args) throws Exception{
        studentDAO dao = new studentDAO();
//        student s1 = dao.getStudent(12);
//        System.out.println(s1.name);

        student s2 = new student();
        s2.name = "Yuvraj";
        s2.rollno = 15;
        dao.connect();
        dao.addStudent(s2);



    }

    static class studentDAO{
        Connection con;
        public void connect(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/saurabh", "root", "********");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public student getStudent(int rollno){
            try {

                String query = "Select name from student where rollno ="+rollno;

                student s = new student();
                s.rollno = rollno;


                Statement st = con.createStatement();
                ResultSet resultSet = st.executeQuery(query);
                resultSet.next();
                s.name = resultSet.getString(1);

                return s;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return null;

        }

        public void addStudent(student s){
            String query = "Insert into student values(?,?)";
            PreparedStatement pst = null;
            try {
                pst = con.prepareStatement(query);
                pst.setInt(1, s.rollno);
                pst.setString(2, s.name);
                int rs = pst.executeUpdate();
                if(rs ==1){
                    System.out.println("Inserted successfully");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    static class student{
        int rollno;
        String name;
    }
}

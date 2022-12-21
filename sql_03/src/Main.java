import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try{
            String url       = "jdbc:mysql://localhost:3306/newdb";
            String user      = "developer";
            String password  = "devpass";

            conn = DriverManager.getConnection(url, user, password);

            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT first_name, last_name FROM students");

            ArrayList<String> surnames = new ArrayList<>();
            System.out.println("The students names are: ");
            while(resultSet.next()){

                System.out.println(resultSet.getString("first_name"));
                surnames.add(resultSet.getString("last_name"));
            }
            System.out.println("The surnames are: ");
            for (String surname :surnames) {
                System.out.println(surname);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try{
                if (conn != null) {
                    conn.close();
                }
            }catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
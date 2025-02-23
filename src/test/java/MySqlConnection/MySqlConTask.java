package MySqlConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConTask {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/guvitask";
        String user = "root"; 
        String password = "Goldchild07*";
        
        String createTableSQL = "CREATE TABLE IF NOT EXISTS EmployeeInsert ("
                + "empcode INT PRIMARY KEY, "
                + "empname VARCHAR(50), "
                + "empage INT, "
                + "esalary DECIMAL(10,2))";

        try (Connection conn = DriverManager.getConnection(url, user, password)) 
        {
            // Create the Employee table
           Statement stmt= conn.createStatement();
          {		      
                    // Execute a query
                    System.out.println("Inserting records into the table...");  
                    stmt.execute(createTableSQL);
                    String sql = "INSERT INTO EmployeeInsert VALUES (101, 'Jenny', 25, 10000)";
                    stmt.executeUpdate(sql);
                    sql = "INSERT INTO EmployeeInsert VALUES (102, 'Jacky', 30, 20000)";
                    stmt.executeUpdate(sql);
                    sql ="INSERT INTO EmployeeInsert VALUES (103, 'Joe', 20, 40000)";
                    stmt.executeUpdate(sql);
                    sql = "INSERT INTO EmployeeInsert VALUES (104, 'John', 40, 80000)";
                    stmt.executeUpdate(sql);
                    sql = "INSERT INTO EmployeeInsert VALUES (105, 'Shameer', 25, 90000)";
                    stmt.executeUpdate(sql);
                    System.out.println("Inserted records into the table...");   	  
                 } 
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
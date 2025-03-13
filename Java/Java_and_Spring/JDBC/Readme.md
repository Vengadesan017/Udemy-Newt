# JBDC - java database connectivity
- api way to connect to db
- easy to switch db
- step
  1. import packages - install java.sql
  2. load driver  - jar
  3. Register driver
  4. create connection
  5. create statement
  6. Execute statement
  7. close
- implementation
  1. go https://jdbc.postgresql.org/ download jar file
  2. in intellij in file in project structure in libraries
```
import java.sql.*;

public class JavaJDBCs {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/java_spring";
        String uname = "postgres";
        String password = "123456";
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url,uname,password);
        Statement st = con.createStatement();

        System.out.println("Connected...");

        String query = "select * from curd";
        ResultSet rs = st.executeQuery(query);    // for select
        System.out.println(rs.next());   // return true or false and the cursor move to first row
        System.out.println(rs.getString("curd_name"));
        System.out.print(rs.getString(1));
        System.out.println(rs.getString(2));



        while (rs.next()){
            System.out.print(rs.getString(1));
            System.out.println(rs.getString(2));
        }

        //        inserting
        String query2 = "INSERT INTO public.curd(curd_id,curd_name) VALUES (10, 'sureah')";
        boolean status = st.execute(query2);
        System.out.println(status);  // return false

        //        Update
        String query3 = "update public.curd set curd_name = 'SAMPLE' where curd_id = 4";
        boolean status2 = st.execute(query3);
        System.out.println(status2);  // return false

        //        delete
        String query4 = "delete from public.curd where curd_id = 6";
        boolean status3 = st.execute(query4);
        System.out.println(status2);  // return false


//        use ariable inside " "
        String query5 = "INSERT INTO public.curd(curd_id,curd_name) VALUES (8, "+ uname + ")";

        String query6 = "INSERT INTO public.curd(curd_id,curd_name) VALUES (?,?)";


//      parameterized
        PreparedStatement st2 = con.prepareStatement(query6);
        st2.setInt(1,11);
        st2.setString(2,"Testing");

        con.close();


    }
}

```

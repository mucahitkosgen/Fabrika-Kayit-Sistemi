import java.sql.*;

public class database {
    public static Connection connect=null ;
    public static Statement statement=null ;
    public static ResultSet resultSet=null ;
    public static String url = "jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public static String user = "root", pass = "Kule1845";


    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try{
                 connect = DriverManager.getConnection(url, user, pass);
            }
            catch (SQLException e){
                System.out.println("fail");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("not found");
        }


        return connect;
}}

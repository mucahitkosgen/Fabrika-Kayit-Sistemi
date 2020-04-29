import javax.swing.*;
import javax.swing.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class yonetici {
    private JPanel yonetici;
    private JLabel yoneticiisimLabel;
    private JTextField yoneticiisimtextField1;
    private JLabel sıfreLabel;
    private JPasswordField sıfrepasswordField1;
    private JButton okbutton1;

    public static Connection connect = null;
    public static Statement statement = null;
    public static ResultSet resultSet = null;
    public static String url = "jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public static String user = "root", pass = "Kule1845";

    public yonetici(String title) {


        okbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = yoneticiisimtextField1.getText();
                String y = sıfrepasswordField1.getText();

                try {
                    statement.executeUpdate("INSERT INTO yonetici VALUES ('" + x + "','" + y + "',)");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        });

    }





    public static void main(String[] args) {
        JFrame frame = new musteri("Yönetici giriş");
        frame.setVisible(true);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, pass);
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from yonetici");
            while (resultSet.next()) {
                String yoneticiisim = resultSet.getString(1);
                String sifre = resultSet.getString(2);
                String testyeri = resultSet.getString(3);
                System.out.println(yoneticiisim + " " + sifre + " " );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}



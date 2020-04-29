import javax.swing.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class musteri extends JFrame{


    private JLabel musteriLabel;
    private JTextField musteritextField1;
    private JLabel projeadiLabel;
    private JTextField projeaditextField1;
    private JLabel testyeriLabel;
    private JTextField testyeritextField1;
    private JButton okbutton1;
    private JPanel musteri;

    public static Connection connect=null;
    public static Statement statement=null;
    public static ResultSet resultSet=null;
    public static String url="jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public  static String user="root",pass="Kule1845";
    public musteri(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(musteri);
        okbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = musteritextField1.getText();
                String y =projeaditextField1.getText();
                String z =testyeritextField1.getText();

                try {
                    statement.executeUpdate("INSERT INTO musteri_ekleme VALUES ('" + x + "','" + y + "','" + z + "')");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        });


    }

    public static void main(String[] args) {
        JFrame frame = new musteri("Müşteri ekleme");
        frame.setVisible(true);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, pass);
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from musteri_ekleme");
            while (resultSet.next()) {
                String musteri = resultSet.getString(1);
                String projeadi = resultSet.getString(2);
                String testyeri = resultSet.getString(3);
                System.out.println(musteri + " " + projeadi + " " + testyeri);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }}

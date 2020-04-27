import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class mainpanel extends JFrame {
    private JPanel mainpanel;
    private JLabel adisoyadiLabel;
    private JTextField adisoyaditextField1;
    private JLabel seviyeLabel;
    private JTextField seviyetextField1;
    private JLabel tarihLabel;
    private JTextField tarihtextField1;
    private JButton okbutton1;
    private JButton silbutton1;

    public static Connection connect=null;
    public static Statement statement=null;
    public static ResultSet resultSet=null;
    public static String url="jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public  static String user="root",pass="Kule1845";

    public mainpanel(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainpanel);
        okbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x=adisoyaditextField1.getText();
                String y=seviyetextField1.getText();
                String z=tarihtextField1.getText();

                try {
                    statement.executeUpdate("INSERT INTO personal_information VALUES ('"+x+"','"+y+"','"+z+"')");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        silbutton1.removeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x=adisoyaditextField1.getText();
                String y=seviyetextField1.getText();
                String z=tarihtextField1.getText();

                try {
                    statement.executeUpdate("DELETE FROM personal_information where adisoyadi='"+x+"'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

    }



    public static void main(String[] args) {
        JFrame frame=new mainpanel("Gözetim Muayene Raporu");
        frame.setVisible(true);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, pass);
             statement = connect.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from personal_information");
                while (resultSet.next()) {
                    String adisoyadi = resultSet.getString(1);
                    String seviye = resultSet.getString(2);
                    String tarih = resultSet.getString(3);
                    System.out.println(adisoyadi + " " + seviye + " " + tarih);
        }
    } catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


    }


}
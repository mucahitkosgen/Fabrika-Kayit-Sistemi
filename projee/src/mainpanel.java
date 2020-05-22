import com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import static java.sql.DriverManager.getConnection;
// personal bilgilerini hallettim burada.
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
    private JButton guncellebutton1;
    private JTable table;

    public static Connection connect=null;
    public static Statement statement=null;
    public static ResultSet resultSet=null;
    public static String url="jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public  static String user="root",pass="Kule1845";





    public mainpanel(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainpanel);
        silbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String x = adisoyaditextField1.getText();
                String y = seviyetextField1.getText();
                String z = tarihtextField1.getText();
                try {

                    statement.executeUpdate("DELETE FROM mainpanel where adisoyadi='"+x+"'");

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
        //silme içinde addAction yapacağız .remove değil
        okbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = adisoyaditextField1.getText();
                String y = seviyetextField1.getText();
                String z = tarihtextField1.getText();

                try {
                    statement.executeUpdate("INSERT INTO mainpanel VALUES ('" + x + "','" + y + "','" + z + "')");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        });
        guncellebutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = adisoyaditextField1.getText();
                String y = seviyetextField1.getText();
                String z = tarihtextField1.getText();

                try {
                    statement.executeUpdate("UPDATE mainpanel set seviye='"+y+"',tarih='"+z+"'where adisoyadi='"+x+"'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

//

    }
    public static void main(String[] args) {
        JFrame frame = new mainpanel("Gözetim Muayene Raporu");






        frame.setVisible(true);
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            //connect = DriverManager.getConnection(url, user, pass);
            Connection connect = database.getConnection();
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from mainpanel");
            while (resultSet.next()) {
                String adisoyadi = resultSet.getString(1);//personal bilgileri.
                String seviye = resultSet.getString(2);
                String tarih = resultSet.getString(3);
                System.out.println(adisoyadi + " " + seviye + " " + tarih);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }//catch (ClassNotFoundException e) {
           // e.printStackTrace();

        //}


    }}
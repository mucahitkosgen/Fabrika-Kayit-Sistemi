import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class musteri extends JFrame {


    private JPanel musteri;
    private JLabel adisoyadiLabel;
    private JTextField adisoyaditextField1;
    private JLabel seviyeLabel;
    private JTextField seviyetextField1;
    private JLabel tarihLabel;
    private JButton okbutton1;
    private JButton silbutton1;
    private JButton guncellebutton1;
    private JTextField tarihtextField1;

    public static Connection connect=null;
    public static Statement statement=null;
    public static ResultSet resultSet=null;
    public static String url="jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public  static String user="root",pass="Kule1845";

    public musteri(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(musteri);

        silbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String x = adisoyaditextField1.getText();
                String y = seviyetextField1.getText();
                String z = tarihtextField1.getText();
                try {

                    statement.executeUpdate("DELETE FROM musteri where adisoyadi='" + x + "'");

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
        okbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = adisoyaditextField1.getText();
                String y = seviyetextField1.getText();
                String z = tarihtextField1.getText();

                try {
                    statement.executeUpdate("INSERT INTO musteri VALUES ('" + x + "','" + y + "','" + z + "')");
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
                    statement.executeUpdate("UPDATE musteri set seviye='" + y + "',tarih='" + z + "'where adisoyadi='" + x + "'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
        public static void main(String[] args) {
            JFrame frame = new musteri("Gözetim Muayene Raporu");

            frame.setVisible(true);
            try {
                // Class.forName("com.mysql.cj.jdbc.Driver");
                //connect = DriverManager.getConnection(url, user, pass);
                Connection connect = database.getConnection();
                statement = connect.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from musteri");
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



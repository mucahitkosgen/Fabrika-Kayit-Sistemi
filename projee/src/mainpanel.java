import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class mainpanel extends JFrame {


    private JPanel mainpanel;
    private JLabel adisoyadiLabel;
    private JLabel seviyeLabel;
    private JButton okbutton1;
    private JLabel tarihLabel;
    private JTextField tarihtextField1;
    private JTextField adisoyaditextField1;
    private JTextField seviyetextField1;
    private JButton silbutton1;

    private static Connection connect=null;
    private static Statement statement=null;
    private static ResultSet resultset=null;
    private static String url="jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    private static String user="root",pass="Kule1845";

    public mainpanel(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainpanel);
        okbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = adisoyaditextField1.getText();
                String y = seviyetextField1.getText();
                String z = tarihtextField1.getText();
                try {
                    statement.executeUpdate("INSERT INTO personal_information VALUES('" + x + "','" + y + "','" + z + "')");
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
                    statement.executeUpdate("DELETE FROM personal_information where adisoyadi='" + x + "'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args){

        JFrame frame=new mainpanel("Gözetim Muayene Raporu");
        frame.setVisible(true);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url,user,pass);
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from personal_information");
            while (resultSet.next()){
                String  adısoyadı=resultSet.getString(1);
                String seviye=resultSet.getString(2);
                String tarih=resultSet.getString(3);
                System.out.println(adısoyadı +""+seviye+""+tarih);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}

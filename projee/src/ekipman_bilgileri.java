import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ekipman_bilgileri extends JFrame {
    private JPanel ekipman_bilgileri;
    private JLabel cihazLabel;
    private JTextField cihaztextField1;
    private JLabel tasiyiciortamLabel;
    private JTextField tasiyiciortamtextField1;
    private JLabel muayenebolgesiLabel;
    private JTextField muayenebolgesitextField1;
    private JLabel akimtipiLabel;
    private JTextField akimtipitextField1;
    private JLabel yuzeyLabel;
    private JTextField yuzeytextField1;
    private JLabel kaldirmatestitarihiLabel;
    private JTextField kaldirmatestitarihitextField1;
    private JButton okbutton1;
    private JButton silbutton1;
    private JButton guncellebutton1;

    public static Connection connect=null;
    public static Statement statement=null;
    public static ResultSet resultSet=null;
    public static String url="jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public  static String user="root",pass="Kule1845";
    public ekipman_bilgileri(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(ekipman_bilgileri);
        okbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = cihaztextField1.getText();
                String y =tasiyiciortamtextField1.getText();
                String z =muayenebolgesitextField1.getText();
                String a=akimtipitextField1.getText();
                String b=yuzeytextField1.getText();
                String c=kaldirmatestitarihitextField1.getText();

                try {
                    statement.executeUpdate("INSERT INTO ekipman_bilgileri VALUES ('" + x + "','" + y + "','" + z + "','"+ a +"','"+ b +"','"+ c +"')");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        });
        silbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String x = cihaztextField1.getText();
                String y = tasiyiciortamtextField1.getText();
                String z = muayenebolgesitextField1.getText();
                String a=akimtipitextField1.getText();
                String b=yuzeytextField1.getText();
                String c=kaldirmatestitarihitextField1.getText();
                try {

                    statement.executeUpdate("DELETE FROM ekipman_bilgileri where cihaz='"+x+"'");

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
        guncellebutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = cihaztextField1.getText();
                String y = tasiyiciortamtextField1.getText();
                String z = muayenebolgesitextField1.getText();
                String a=akimtipitextField1.getText();
                String b=yuzeytextField1.getText();
                String c=kaldirmatestitarihitextField1.getText();
                try{
                    statement.executeUpdate("UPDATE ekipman_bilgileri set tasiyiciortam='"+y+"', muayenebolgesi='"+z+"',akimtipi='"+a+"',yuzey='"+b+"',kaldirmatestitarihi='"+c+"' where cihaz='"+x+"'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });


    }

    public static void main(String[] args) {
        JFrame frame = new ekipman_bilgileri("ekipmanbilgileri");
        frame.setVisible(true);
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //connect = DriverManager.getConnection(url, user, pass);
            Connection connect=database.getConnection();
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from ekipman_bilgileri");
            while (resultSet.next()) {
                String cihaz = resultSet.getString(1);
                String tasiyiciortam = resultSet.getString(2);
                String muayenebolgesi = resultSet.getString(3);
                String akimtipi=resultSet.getString(4);
                String yuzey=resultSet.getString(5);
                String kaldirmatestitarihi=resultSet.getString(6);
                System.out.println(cihaz + " " + tasiyiciortam + " " +muayenebolgesi+" "+ akimtipi+" "+yuzey+" "+kaldirmatestitarihi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //catch (ClassNotFoundException e) {
           // e.printStackTrace();
        //}


    }}



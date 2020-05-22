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
    private JLabel kutupmesafesiLabel;
    private JTextField kutupmesafesitextField1;
    private JLabel miknatislamateknigiLabel;
    private JTextField miknatislamateknigitextField1;
    private JLabel uvisiksideetiLabel;
    private JTextField uvisiksiddetitextField1;
    private JLabel isikmesafesiLabel;
    private JTextField isikmesafesitextField1;
    private JLabel isiksiddetiLabel;
    private JTextField isiksiddetitextField1;
    private JLabel muayeneortamiLabel;
    private JTextField muayeneortamitextField1;
    private JLabel miknatisgiderimiLabel;
    private JTextField miknatisgiderimitextField1;
    private JLabel isilislemLabel;
    private JTextField isilislemtextField1;
    private JLabel yuzeysicakligiLabel;
    private JTextField yuzeysicakligitextField1;
    private JLabel isikcihaztanimiLabel;
    private JTextField isikcihaztanimitextField1;

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
                String d=kutupmesafesitextField1.getText();
                String p=miknatislamateknigitextField1.getText();
                String f=uvisiksiddetitextField1.getText();
                String g=isikmesafesitextField1.getText();
                String h=isiksiddetitextField1.getText();
                String ı=muayeneortamitextField1.getText();
                String i=miknatisgiderimitextField1.getText();
                String j=isilislemtextField1.getText();
                String k=yuzeysicakligitextField1.getText();
                String l=isikcihaztanimitextField1.getText();

                try {
                    statement.executeUpdate("INSERT INTO ekipman_bilgileri VALUES ('" + x + "','" + y + "','" + z + "','"+ a +"','"+ b +"','"+ c +",'"+d+"'p'"+"','"+f+"','"+g+"','"+h+"','"+ı+"','"+i+"','"+j+"','"+k+"','"+l+"')");
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
                String d=kutupmesafesitextField1.getText();
                String p=miknatislamateknigitextField1.getText();
                String f=uvisiksiddetitextField1.getText();
                String g=isikmesafesitextField1.getText();
                String h=isiksiddetitextField1.getText();
                String ı=muayeneortamitextField1.getText();
                String i=miknatisgiderimitextField1.getText();
                String j=isilislemtextField1.getText();
                String k=yuzeysicakligitextField1.getText();
                String l=isikcihaztanimitextField1.getText();
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
                String d=kutupmesafesitextField1.getText();
                String p=miknatislamateknigitextField1.getText();
                String f=uvisiksiddetitextField1.getText();
                String g=isikmesafesitextField1.getText();
                String h=isiksiddetitextField1.getText();
                String ı=muayeneortamitextField1.getText();
                String i=miknatisgiderimitextField1.getText();
                String j=isilislemtextField1.getText();
                String k=yuzeysicakligitextField1.getText();
                String l=isikcihaztanimitextField1.getText();
                try{
                    statement.executeUpdate("UPDATE ekipman_bilgileri set tasiyiciortam='"+y+"', muayenebolgesi='"+z+"',akimtipi='"+a+"',yuzey='"+b+"',kaldirmatestitarihi='"+c+"',kutupmesafesi='"+d+"',miknatislamateknigi='"+p+"',uvisiksiddeti='"+f+"',isikmesafesi='"+g+"',isiksiddeti='"+h+"',muayeneortami='"+ı+"',miknatisgiderimi='"+i+"',isilislem='"+j+"',yuzeysicakligi='"+k+"',isikcihaztanimi='"+l+"' where cihaz='"+x+"'");
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
                String kutupmesafesi=resultSet.getString(7);
                String miknatislamateknigi=resultSet.getString(8);
                String uvisiksiddeti=resultSet.getString(9);
                String isikmesafesi=resultSet.getString(10);
                String isiksiddeti=resultSet.getString(11);
                String muayeneortami=resultSet.getString(12);
                String miknatisgiderimi=resultSet.getString(13);
                String isilislem=resultSet.getString(14);
                String yuzeysicakligi=resultSet.getString(15);
                String isikcihaztanimi=resultSet.getString(16);
                System.out.println(cihaz + " " + tasiyiciortam + " " +muayenebolgesi+" "+ akimtipi+" "+yuzey+" "+kaldirmatestitarihi+" "+kutupmesafesi+" "+miknatislamateknigi+" "+uvisiksiddeti+" "+isikmesafesi+" "+isiksiddeti+" "+muayeneortami+" "+miknatisgiderimi+" "+isilislem+" "+yuzeysicakligi+" "+isikcihaztanimi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //catch (ClassNotFoundException e) {
           // e.printStackTrace();
        //}


    }}



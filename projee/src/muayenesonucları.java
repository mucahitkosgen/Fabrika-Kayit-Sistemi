import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class muayenesonucları extends JFrame{
    private JPanel muayenesonucları;
    private JLabel serinoLabel;
    private JTextField serinotextField1;
    private JLabel kaynaknoLabel;
    private JTextField kaynaknotextField1;
    private JLabel kontroluzunluguLabel;
    private JTextField kontroluzunlugutextField1;
    private JLabel kaynakyonLabel;
    private JButton okbutton1;
    private JButton silbutton1;
    private JFormattedTextField kaynakyonTextField1;
    private JButton guncellebutton1;
    private JLabel kalinlikLabel;
    private JTextField kalinliktextField1;
    private JLabel capLabel;
    private JTextField captextField1;
    private JLabel hatatipiLabel;
    private JTextField hatatipitextField1;
    private JLabel hataninyeriLabel;
    private JTextField hataninyeritextField1;
    private JLabel sonucLabel;
    private JTextField sonuctextField1;

    public static Connection connect=null;
    public static Statement statement=null;
    public static ResultSet resultSet=null;
    public static String url="jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public  static String user="root",pass="Kule1845";

    public muayenesonucları(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(muayenesonucları);
        silbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String x = serinotextField1.getText();
                String y = kaynaknotextField1.getText();
                String z = kontroluzunlugutextField1.getText();
                String a= kaynakyonTextField1.getText();
                String b=kalinliktextField1.getText();
                String c=captextField1.getText();
                String d=hatatipitextField1.getText();
                String f=hataninyeritextField1.getText();
                String g=sonuctextField1.getText();

                try {

                    statement.executeUpdate("DELETE FROM muayenesonucları where serino='"+x+"'");

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
        okbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = serinotextField1.getText();
                String y = kaynaknotextField1.getText();
                String z = kontroluzunlugutextField1.getText();
                String a= kaynakyonTextField1.getText();
                String b=kalinliktextField1.getText();
                String c=captextField1.getText();
                String d=hatatipitextField1.getText();
                String f=hataninyeritextField1.getText();
                String g=sonuctextField1.getText();

                try {
                    statement.executeUpdate("INSERT INTO muayenesonucları VALUES ('" + x + "','" + y + "','" + z + "','"+ a +"','"+b+"','"+c+"','"+d+"','"+f+"','"+g+"')");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        guncellebutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = serinotextField1.getText();
                String y = kaynaknotextField1.getText();
                String z = kontroluzunlugutextField1.getText();
                String a= kaynakyonTextField1.getText();
                String b=kalinliktextField1.getText();
                String c=captextField1.getText();
                String d=hatatipitextField1.getText();
                String f=hataninyeritextField1.getText();
                String g=sonuctextField1.getText();
                try{
                    statement.executeUpdate("UPDATE muayenesonucları set kaynakno='"+y+"',kontroluzunlugu='"+z+"',kaynakyon='"+a+"',kalinlik='"+b+"',cap='"+c+"',hatatipi='"+d+"',hataninyeri='"+f+"',sonuc='"+g+"'where serino='"+x+"'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
    }
    public static void main(String[] args) {
        JFrame frame=new muayenesonucları("Muayene Sonuçları");
        frame.setVisible(true);
        try{
           // Class.forName("com.mysql.cj.jdbc.Driver");
            //connect = DriverManager.getConnection(url, user, pass);
            Connection connect=database.getConnection();
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from muayenesonucları");
            while (resultSet.next()) {
                String serino = resultSet.getString(1);
                String kaynakno = resultSet.getString(2);
                String kontroluzunlugu = resultSet.getString(3);
                String kalinlik=resultSet.getString(4);
                String cap=resultSet.getString(5);
                String hatatipi=resultSet.getString(6);
                String hataninyeri=resultSet.getString(7);
                String sonuc=resultSet.getString(8);
                System.out.println(serino + " " +kaynakno  + " "+kontroluzunlugu+" "+kalinlik+" "+cap+" "+hatatipi+" "+hataninyeri+" "+sonuc);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }//catch (ClassNotFoundException e){
           // e.printStackTrace();
        //}


    }





}

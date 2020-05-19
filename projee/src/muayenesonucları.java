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
    private JLabel kaynakyonLabel;
    private JTextField kaynakyontextField1;
    private JLabel sonucLabel;
    private JButton okbutton1;
    private JButton silbutton1;
    private JFormattedTextField sonucTextField1;
    private JButton guncellebutton1;

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
                String z = kaynakyontextField1.getText();
                String a=sonucTextField1.getText();

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
                String z = kaynakyontextField1.getText();
                String a=sonucTextField1.getText();

                try {
                    statement.executeUpdate("INSERT INTO muayenesonucları VALUES ('" + x + "','" + y + "','" + z + "','"+ a +"')");
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
                String z = kaynakyontextField1.getText();
                String a=sonucTextField1.getText();
                try{
                    statement.executeUpdate("UPDATE muayenesonucları set kaynakno='"+y+"',kaynakyon='"+z+"',sonuc='"+a+"'where serino='"+x+"'");
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
                String kaynakyon = resultSet.getString(3);
                String sonuc=resultSet.getString(4);
                System.out.println(serino + " " +kaynakno  + " "+kaynakyon+" "+sonuc);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }//catch (ClassNotFoundException e){
           // e.printStackTrace();
        //}


    }





}

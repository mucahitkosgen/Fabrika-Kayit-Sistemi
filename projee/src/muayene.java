import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class muayene extends JFrame{
    private JPanel muayene;
    private JLabel muayenestandardiLabel;
    private JTextField muayenestandarditextField1;
    private JLabel degerlendirmestandardiLabel;
    private JTextField degerlendirmestandarditextField1;
    private JLabel muayeneproseduruLabel;
    private JTextField muayeneprosedurutextField1;
    private JLabel yuzeydurumuLabel;
    private JTextField yuzeydurumutextField1;
    private JLabel muayeneasamasiLabel;
    private JTextField muayeneasamasitextField1;
    private JLabel raportarihiLabel;
    private JTextField raportarihitextField1;
    private JButton okbutton1;
    private JButton silbutton1;
    public static Connection connect=null;
    public static Statement statement=null;
    public static ResultSet resultSet=null;
    public static String url="jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public  static String user="root",pass="Kule1845";

    public muayene(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(muayene);
        silbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String x = muayenestandarditextField1.getText();
                String y = degerlendirmestandarditextField1.getText();
                String z = muayeneprosedurutextField1.getText();
                String a=yuzeydurumutextField1.getText();
                String b=muayeneasamasitextField1.getText();
                String c=raportarihitextField1.getText();
                try {

                    statement.executeUpdate("DELETE FROM muayene where muayenestandardi='"+x+"'");

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
        okbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = muayenestandarditextField1.getText();
                String y = degerlendirmestandarditextField1.getText();
                String z = muayeneprosedurutextField1.getText();
                String a=yuzeydurumutextField1.getText();
                String b=muayeneasamasitextField1.getText();
                String c=raportarihitextField1.getText();
                try {
                    statement.executeUpdate("INSERT INTO muayene VALUES ('" + x + "','" + y + "','" + z + "','"+ a +"','"+ b +"','"+ c +"')");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

}
    public static void main(String[] args) {
        JFrame frame=new muayene("Muayene");
        frame.setVisible(true);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, pass);
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from muayene");
            while (resultSet.next()) {
                String muayenestandardi = resultSet.getString(1);
                String degerlendirmestandardi = resultSet.getString(2);
                String muayeneproseduru = resultSet.getString(3);
                String yuzeydurumu=resultSet.getString(4);
                String muayeneasamasi=resultSet.getString(5);
                String raportarihi=resultSet.getString(6);
                System.out.println(muayenestandardi + " " +degerlendirmestandardi  + " " +muayeneproseduru+" "+yuzeydurumu+" "+muayeneasamasi+" "+raportarihi);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


    }




}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class muayene extends JFrame {
    private JPanel muayene;
    private JLabel muayenestandardiLabel;
    private JTextField muayenestandarditextField1;
    private JLabel degerlendirmestandardiLabel;
    private JTextField degerlendirmestandarditextField1;
    private JLabel muayeneproseduruLabel;
    private JTextField muayeneprosedurutextField1;
    private JLabel muayenekapsamiLabel;
    private JTextField muayenekapsamitextField1;
    private JLabel resimnoLabel;
    private JTextField resimnotextField1;
    private JLabel yuzeydurumuLabel;
    private JTextField yuzeydurumutextField1;
    private JLabel muayeneasamasiLabel;
    private JTextField muayeneasamasitextField1;
    private JLabel sayfanoLabel;
    private JTextField sayfanotextField1;
    private JLabel rapornoLabel;
    private JTextField rapornotextField1;
    private JLabel raportarihiLabel;
    private JTextField raportarihitextField1;
    private JLabel isemrinoLabel;
    private JTextField isemrinotextField1;
    private JLabel teklifnoLabel;
    private JTextField teklifnotextField1;
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
        okbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x=muayenestandarditextField1.getText();
                String y=degerlendirmestandarditextField1.getText();
                String z=muayeneprosedurutextField1.getText();
                int a= Integer.parseInt(String.valueOf(muayenekapsamitextField1));
                int b= Integer.parseInt(String.valueOf(resimnotextField1));
                String c=yuzeydurumutextField1.getText();
                String d=muayeneasamasitextField1.getText();
                int k= Integer.parseInt(String.valueOf(sayfanotextField1));
                int f= Integer.parseInt(String.valueOf(rapornotextField1));
                String g=raportarihitextField1.getText();
                int h= Integer.parseInt(String.valueOf(isemrinotextField1));
                int ı= Integer.parseInt(String.valueOf(teklifnotextField1));
                try {
                    statement.executeUpdate("INSERT INTO muayene VALUES ('" + x + "','" + y + "','" + z + "','"+a+"','"+b+"','"+c+"','"+d+"','"+k+"','"+f+"','"+g+"','"+h+"','"+ı+"')");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        });
        silbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x=muayenestandarditextField1.getText();
                String y=degerlendirmestandarditextField1.getText();
                String z=muayeneprosedurutextField1.getText();
                int a= Integer.parseInt(String.valueOf(muayenekapsamitextField1));
                int b= Integer.parseInt(String.valueOf(resimnotextField1));
                String c=yuzeydurumutextField1.getText();
                String d=muayeneasamasitextField1.getText();
                int k= Integer.parseInt(String.valueOf(sayfanotextField1));
                int f= Integer.parseInt(String.valueOf(rapornotextField1));
                String g=raportarihitextField1.getText();
                int h= Integer.parseInt(String.valueOf(isemrinotextField1));
                int ı= Integer.parseInt(String.valueOf(teklifnotextField1));
                try {

                    statement.executeUpdate("DELETE FROM muayene where muayenestandardi='"+x+"'");

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });


}
    public static void main(String[] args) {
        JFrame frame=new muayene("muayene");
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
                int muayenekapsami=resultSet.getInt(4);
                int resimno=resultSet.getInt(5);
                String yuzeydurumu=resultSet.getString(6);
                String muayeneasamasi=resultSet.getString(7);
                int sayfano=resultSet.getInt(8);
                int raporno=resultSet.getInt(9);
                String raportarihi=resultSet.getString(10);
                int isemrino=resultSet.getInt(11);
                int teklifno=resultSet.getInt(12);

                System.out.println(muayenestandardi + " " + degerlendirmestandardi + " " + muayeneproseduru+""+muayenekapsami+""+resimno+""+yuzeydurumu+""+muayeneasamasi+""+sayfano+""+raporno+""+raportarihi+""+isemrino+""+teklifno);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


    }

}

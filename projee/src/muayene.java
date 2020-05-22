import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class muayene extends JFrame{
    private JPanel muayene;
    private JLabel musteriLabel;
    private JTextField musteritextField1;
    private JLabel projeadiLabel;
    private JTextField projeaditextField1;
    private JLabel testyeriLabel;
    private JTextField testyeritextField1;
    private JLabel muayenestandardiLabel;
    private JTextField muayenestandarditextField1;
    private JLabel degerlendirmestandardiLabel;
    private JTextField degerlendirmestandarditextField1;
    private JLabel muayeneproseduruLabel;
    private JTextField muayeneprosedurutextField1;
    private JButton okbutton1;
    private JButton silbutton1;
    private JButton guncellebutton1;
    private JLabel muayenekapsamiLabel;
    private JTextField muayenekapsamitextField1;
    private JLabel resimnoLabel;
    private JTextField resimnotextField1;
    private JLabel yuzeydurumuLabel;
    private JTextField yuzeydurumutextField1;
    private JLabel muayeneasamasi;
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

                String x = musteritextField1.getText();
                String y = projeaditextField1.getText();
                String z = testyeritextField1.getText();
                String a= muayenestandarditextField1.getText();
                String b= degerlendirmestandarditextField1.getText();
                String c= muayeneprosedurutextField1.getText();
                String d=muayenekapsamitextField1.getText();
                String f=resimnotextField1.getText();
                String g=yuzeydurumutextField1.getText();
                String h=muayeneasamasitextField1.getText();
                String ı=sayfanotextField1.getText();
                String i=rapornotextField1.getText();
                String j=raportarihitextField1.getText();
                String k=isemrinotextField1.getText();
                String l=teklifnotextField1.getText();
                try {

                    statement.executeUpdate("DELETE FROM muayene where musteri='"+x+"'");

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
        okbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = musteritextField1.getText();
                String y = projeaditextField1.getText();
                String z = testyeritextField1.getText();
                String a= muayenestandarditextField1.getText();
                String b= degerlendirmestandarditextField1.getText();
                String c= muayeneprosedurutextField1.getText();
                String d=muayenekapsamitextField1.getText();
                String f=resimnotextField1.getText();
                String g=yuzeydurumutextField1.getText();
                String h=muayeneasamasitextField1.getText();
                String ı=sayfanotextField1.getText();
                String i=rapornotextField1.getText();
                String j=raportarihitextField1.getText();
                String k=isemrinotextField1.getText();
                String l=teklifnotextField1.getText();
                try {
                    statement.executeUpdate("INSERT INTO muayene VALUES ('" + x + "','" + y + "','" + z + "','"+ a +"','"+ b +"','"+ c +"','"+d+"','"+f+"','"+g+"','"+h+"','"+ı+"','"+i+"','"+j+"','"+k+"','"+l+"')");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        guncellebutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = musteritextField1.getText();
                String y = projeaditextField1.getText();
                String z = testyeritextField1.getText();
                String a= muayenestandarditextField1.getText();
                String b= degerlendirmestandarditextField1.getText();
                String c= muayeneprosedurutextField1.getText();
                String d=muayenekapsamitextField1.getText();
                String f=resimnotextField1.getText();
                String g=yuzeydurumutextField1.getText();
                String h=muayeneasamasitextField1.getText();
                String ı=sayfanotextField1.getText();
                String i=rapornotextField1.getText();
                String j=raportarihitextField1.getText();
                String k=isemrinotextField1.getText();
                String l=teklifnotextField1.getText();
                try{
                    statement.executeUpdate("UPDATE muayene set projeadi='"+y+"',testyeri='"+z+"',muayenestandardi='"+a+"',degerlendirmestandardi='"+b+"',muayeneproseduru='"+c+"',muayenekapsami='"+d+"',resimno='"+f+"',yuzeydurumu='"+g+"',muayeneasamasi='"+h+"',sayfano='"+ı+"',raporno='"+i+"',raportarihi='"+j+"',isemrino='"+k+"',teklifno='"+l+"'where musteri='"+x+"'");
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
           // Class.forName("com.mysql.cj.jdbc.Driver");
            //connect = DriverManager.getConnection(url, user, pass);
            Connection connect=database.getConnection();
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from muayene");
            while (resultSet.next()) {
                String musteri = resultSet.getString(1);
                String projeadi = resultSet.getString(2);
                String testyeri = resultSet.getString(3);
                String muayenestandardi=resultSet.getString(4);
                String degerlendirmestandardi=resultSet.getString(5);
                String muayeneproseduru=resultSet.getString(6);
                String muayenekapsami=resultSet.getString(7);
                String resimno=resultSet.getString(8);
                String yuzeydurumu=resultSet.getString(9);
                String muayeneasamasi=resultSet.getString(10);
                String sayfano=resultSet.getString(11);
                String raporno=resultSet.getString(12);
                String raportarihi=resultSet.getString(13);
                String isemrino=resultSet.getString(14);
                String teklifno=resultSet.getString(15);
                System.out.println(musteri + " " +projeadi  + " " +testyeri+" "+muayenestandardi+" "+degerlendirmestandardi+" "+muayeneproseduru+" "+muayenekapsami+" "+resimno+" "+yuzeydurumu+" "+muayeneasamasi+" "+sayfano+" "+raporno+" "+raportarihi+" "+isemrino+" "+teklifno);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }//catch (ClassNotFoundException e){
           // e.printStackTrace();
        //}


    }




}

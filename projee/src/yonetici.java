import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class yonetici extends JFrame {
    private JPanel yonetici;
    private JLabel yoneticiisimLabel;
    private JTextField yoneticiisimtextField1;
    private JLabel sıfreLabel;
    private JLabel sıfreLable;
    private JButton girisbutton1;
    private JPasswordField sıfrepasswordField1;
    private JButton okbutton1;
    private JButton silbutton1;
    private JButton guncellebutton1;
    private JButton ExportforExcelbutton1;
    private JButton ExportforPdfbutton1;
    private JButton devambutton1;


    public static Connection connect = null;
    public static Statement statement = null;
    public static ResultSet resultSet = null;
    public static String url = "jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public static String user = "root", pass = "Kule1845";

    public yonetici(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(yonetici);

        JLabel label = new JLabel("yoneticiisim");






        girisbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = yoneticiisimtextField1.getText();
                String y = sıfrepasswordField1.getText();
                if (x.equalsIgnoreCase("Mücahit") && y.equalsIgnoreCase("KURUM")) {
                    sec field = new sec();
                    field.setVisible(true);
                    JFrame frame = new muayene("MUAYENE");
                    frame.setSize(700, 700);
                    frame.setVisible(true);

                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Giriş Başarısız");
                }


            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new yonetici("Yönetici giriş");
        frame.setSize(700, 700);
        frame.setVisible(true);

        operator opr1 = new operator();
        JFrame frame1 = new operator("OPERATOR");
        // frame.setPreferredSize(new Dimension(700, 700));
        //frame.pack();
        frame.setSize(700, 700);


        frame.setVisible(true);
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            //connect = DriverManager.getConnection(url, user, pass);
            Connection connect = database.getConnection();
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from operator");
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
        degerlendiren dr1 = new degerlendiren();
        JFrame frame2 = new degerlendiren("DEGERLENDIREN");
        // frame.setPreferredSize(new Dimension(700, 700));
        //frame.pack();
        frame.setSize(700, 700);


        frame.setVisible(true);
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            //connect = DriverManager.getConnection(url, user, pass);
            Connection connect = database.getConnection();
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from degerlendiren");
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
        ekipman_bilgileri ekp1 = new ekipman_bilgileri();
        JFrame frame3 = new ekipman_bilgileri("ekipmanbilgileri");
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        JComboBox cihazcomboBox = new JComboBox();
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        comboBoxModel.setSelectedItem(cihazcomboBox);
        JComboBox tasiyiciortamcomboBox = new JComboBox();
        comboBoxModel.setSelectedItem(tasiyiciortamcomboBox);
        JComboBox akimtipicomboBox = new JComboBox();
        comboBoxModel.setSelectedItem(akimtipicomboBox);
        JComboBox kutupmesafesicomboBox = new JComboBox();
        comboBoxModel.setSelectedItem(kutupmesafesicomboBox);
        JComboBox miknatislamateknigicomboBox = new JComboBox();
        comboBoxModel.setSelectedItem(miknatislamateknigicomboBox);
        JComboBox uvisiksiddeticomboBox = new JComboBox();
        comboBoxModel.setSelectedItem(uvisiksiddeticomboBox);
        JComboBox isikmesafesicomboBox = new JComboBox();
        comboBoxModel.setSelectedItem(isikmesafesicomboBox);
        frame.setVisible(true);
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //connect = DriverManager.getConnection(url, user, pass);
            Connection connect = database.getConnection();
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from ekipman_bilgileri");
            while (resultSet.next()) {
                String cihaz = resultSet.getString(1);
                String tasiyiciortam = resultSet.getString(2);
                String muayenebolgesi = resultSet.getString(3);
                String akimtipi = resultSet.getString(4);
                String yuzey = resultSet.getString(5);
                String kaldirmatestitarihi = resultSet.getString(6);
                String kutupmesafesi = resultSet.getString(7);
                String miknatislamateknigi = resultSet.getString(8);
                String uvisiksiddeti = resultSet.getString(9);
                String isikmesafesi = resultSet.getString(10);
                String isiksiddeti = resultSet.getString(11);
                String muayeneortami = resultSet.getString(12);
                String miknatisgiderimi = resultSet.getString(13);
                String isilislem = resultSet.getString(14);
                String yuzeysicakligi = resultSet.getString(15);
                String isikcihaztanimi = resultSet.getString(16);
                String muayenebolgesialansiddeti = resultSet.getString(17);
                String standartsapmalar = resultSet.getString(18);
                String muayenetarihleri = resultSet.getString(19);
                String aciklamalar = resultSet.getString(20);
                System.out.println(cihaz + " " + tasiyiciortam + " " + muayenebolgesi + " " + akimtipi + " " + yuzey + " " + kaldirmatestitarihi + " " + kutupmesafesi + " " + miknatislamateknigi + " " + uvisiksiddeti + " " + isikmesafesi + " " + isiksiddeti + " " + muayeneortami + " " + miknatisgiderimi + " " + isilislem + " " + yuzeysicakligi + "  " + isikcihaztanimi + " " + muayenebolgesialansiddeti + "+" + standartsapmalar + "+" + muayenetarihleri + "" + aciklamalar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //catch (ClassNotFoundException e) {
        // e.printStackTrace();
        //}
        muayene muayene = new muayene();
        JFrame frame4 = new muayene("Muayene");
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        JComboBox mustericomboBox = new JComboBox();
       // DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        comboBoxModel.setSelectedItem(mustericomboBox);
        JComboBox yuzeydurumucomboBox = new JComboBox();
        comboBoxModel.setSelectedItem(yuzeydurumucomboBox);
        JComboBox muayeneasamasicomboBox = new JComboBox();
        comboBoxModel.setSelectedItem(muayeneasamasicomboBox);
        JComboBox isemrinocomboBox = new JComboBox();
        comboBoxModel.setSelectedItem(isemrinocomboBox);
        JComboBox teklifnocomboBox = new JComboBox();
        comboBoxModel.setSelectedItem(teklifnocomboBox);



        frame.setVisible(true);



        try

        {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            //connect = DriverManager.getConnection(url, user, pass);
            Connection connect = database.getConnection();
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from muayene");
            while (resultSet.next()) {
                String musteri = resultSet.getString(1);
                String projeadi = resultSet.getString(2);
                String testyeri = resultSet.getString(3);
                String muayenestandardi = resultSet.getString(4);
                String degerlendirmestandardi = resultSet.getString(5);
                String muayeneproseduru = resultSet.getString(6);
                String muayenekapsami = resultSet.getString(7);
                String resimno = resultSet.getString(8);
                String yuzeydurumu = resultSet.getString(9);
                String muayeneasamasi = resultSet.getString(10);
                String sayfano = resultSet.getString(11);
                String raporno = resultSet.getString(12);
                String raportarihi = resultSet.getString(13);
                String isemrino = resultSet.getString(14);
                String teklifno = resultSet.getString(15);
                System.out.println(musteri + " " + projeadi + " " + testyeri + " " + muayenestandardi + " " + degerlendirmestandardi + " " + muayeneproseduru + " " + muayenekapsami + " " + resimno + " " + yuzeydurumu + " " + muayeneasamasi + " " + sayfano + " " + raporno + " " + raportarihi + " " + isemrino + " " + teklifno);
            }
        }
        catch(SQLException e){


            e.printStackTrace();
        }//catch (ClassNotFoundException e){
        // e.printStackTrace();
        //}
        muayenesonucları m1=new muayenesonucları();
        JFrame frame5=new muayenesonucları("Muayene Sonuçları");
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        JComboBox sonuccomboBox=new JComboBox();
        //DefaultComboBoxModel comboBoxModel=new DefaultComboBoxModel();
        comboBoxModel.setSelectedItem(sonuccomboBox);
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
        musteri musteri=new musteri();
        JFrame frame6 = new musteri("MUSTERİ");
        // frame.setPreferredSize(new Dimension(700, 700));
        //frame.pack();
        frame.setSize(700,700);


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
        onay o1=new onay();
        JFrame frame7 = new onay("ONAY");
        // frame.setPreferredSize(new Dimension(700, 700));
        //frame.pack();
        frame.setSize(700,700);


        frame.setVisible(true);
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            //connect = DriverManager.getConnection(url, user, pass);
            Connection connect = database.getConnection();
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from onay");
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
        sec sc=new sec();
        JFrame frame8 = new sec("Alan Seçim Yeri");
        // frame.setPreferredSize(new Dimension(700, 700));
        //frame.pack();
        frame.setSize(700, 700);
        // frame.setLocationRelativeTo(null);
        //frame.getContentPane().setSize(500,500);
        //frame.pack();
        //frame.setLocationRelativeTo(null);

        frame.setVisible(true);


    }



    }






















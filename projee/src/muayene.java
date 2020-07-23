import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    private JComboBox mustericomboBox1;
    private JComboBox yuzeydurumucomboBox1;
    private JComboBox muayeneasamasicomboBox1;
    private JComboBox isemrinocomboBox1;
    private JComboBox teklifnocomboBox1;
    private JButton ExportforExcelbutton1;
    private JButton ExportforPdfbutton1;
    private JButton devambutton1;


    public static Connection connect=null;
    public static Statement statement=null;
    public static ResultSet resultSet=null;
    public static String url="jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public  static String user="root",pass="Kule1845";

    public muayene(String title){
        super(title);
        connect = database.getConnection();
        try {
            statement = connect.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(muayene);


        silbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x=mustericomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,x);
                String y = projeaditextField1.getText();
                String z = testyeritextField1.getText();
                String a= muayenestandarditextField1.getText();
                String b= degerlendirmestandarditextField1.getText();
                String c= muayeneprosedurutextField1.getText();
                String d=muayenekapsamitextField1.getText();
                String f=resimnotextField1.getText();
                String g=yuzeydurumucomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,g);
                String h=muayeneasamasicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,h);
                String ı=sayfanotextField1.getText();
                String i=rapornotextField1.getText();
                String j=raportarihitextField1.getText();
                String k=isemrinocomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,k);
                String l=teklifnocomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,l);
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

                String x = mustericomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,x);
                String y = projeaditextField1.getText();
                String z = testyeritextField1.getText();
                String a= muayenestandarditextField1.getText();
                String b= degerlendirmestandarditextField1.getText();
                String c= muayeneprosedurutextField1.getText();
                String d=muayenekapsamitextField1.getText();
                String f=resimnotextField1.getText();
                String g=yuzeydurumucomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,g);
                String h=muayeneasamasicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,h);
                String ı=sayfanotextField1.getText();
                String i=rapornotextField1.getText();
                String j=raportarihitextField1.getText();
                String k=isemrinocomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,k);
                String l=teklifnocomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,l);
                 if ("".equals(x)) {
                    JOptionPane.showMessageDialog(null, "Müşteri alanını seçmeden geçemezsin");
                    return;
                } else if ("".equals(y)) {
                    JOptionPane.showMessageDialog(null, "Proje adını boş geçemezsiniz");
                    return;
                } else if ("".equals(z)) {
                    JOptionPane.showMessageDialog(null, "Test yerini boş geçemezsiniz");
                    return;
                }
                 else if("".equals(a)){
                     JOptionPane.showMessageDialog(null, "Muayene standardini boş bırakamazsınız");
                     return;
                 }
                 else if("".equals(b)){
                     JOptionPane.showMessageDialog(null, "Değerlendirme standardini boş geçemezsiniz");
                     return;
                 }
                 else if("".equals(c)){
                     JOptionPane.showMessageDialog(null, "Muayene prosedurunu boş geçemezsiniz");
                     return;
                 }
                 else if("".equals(d)){
                     JOptionPane.showMessageDialog(null, "Muayene kapsamını boş geçemezsiniz");
                     return;
                 }
                 else if("".equals(f)){
                     JOptionPane.showMessageDialog(null, "Resim no boş geçemezsin");
                     return;
                 }
                 else if("".equals(g)){
                     JOptionPane.showMessageDialog(null, "Yüzey durumunu seçmeden geçemezsin");
                     return;
                 }
                 else if("".equals(h)){
                     JOptionPane.showMessageDialog(null, "Muayene aşamasını seçmeden geçemezsin");
                     return;
                 }
                 else if("".equals(ı)){
                     JOptionPane.showMessageDialog(null, "Sayfa no boş geçemezsin");
                     return;
                 }
                 else if("".equals(i)){
                     JOptionPane.showMessageDialog(null, "Rapor no boş geçemezsin");
                     return;
                 }
                 else if("".equals(j)){
                     JOptionPane.showMessageDialog(null, "Rapor tarihi boş geçemezsiniz");
                     return;
                 }
                 else if("".equals(k)){
                     JOptionPane.showMessageDialog(null, "İş emrino seçmeden geçemezsin");
                     return;
                 }
                 else if("".equals(l)){
                     JOptionPane.showMessageDialog(null, "Teklif no seçmeden geçemezsin");
                     return;
                 }
                 else if(j.equalsIgnoreCase("21.06.2020")){
                    try {
                     statement.executeUpdate("INSERT INTO muayene VALUES ('" + x + "','" + y + "','" + z + "','"+ a +"','"+ b +"','"+ c +"','"+d+"','"+f+"','"+g+"','"+h+"','"+ı+"','"+i+"','"+j+"','"+k+"','"+l+"')");
                 } catch (SQLException e) {
                        e.printStackTrace();
                 }
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "Rapor tarihi değiştirilemez");
                 }
            }
        });
        guncellebutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = mustericomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,x);
                String y = projeaditextField1.getText();
                String z = testyeritextField1.getText();
                String a= muayenestandarditextField1.getText();
                String b= degerlendirmestandarditextField1.getText();
                String c= muayeneprosedurutextField1.getText();
                String d=muayenekapsamitextField1.getText();
                String f=resimnotextField1.getText();
                String g=yuzeydurumucomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,g);
                String h=muayeneasamasicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,h);
                String ı=sayfanotextField1.getText();
                String i=rapornotextField1.getText();
                String j=raportarihitextField1.getText();
                String k=isemrinocomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,k);
                String l=teklifnocomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,l);
                try{
                    statement.executeUpdate("UPDATE muayene set projeadi='"+y+"',testyeri='"+z+"',muayenestandardi='"+a+"',degerlendirmestandardi='"+b+"',muayeneproseduru='"+c+"',muayenekapsami='"+d+"',resimno='"+f+"',yuzeydurumu='"+g+"',muayeneasamasi='"+h+"',sayfano='"+ı+"',raporno='"+i+"',raportarihi='"+j+"',isemrino='"+k+"',teklifno='"+l+"'where musteri='"+x+"'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        devambutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = mustericomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,x);
                String y = projeaditextField1.getText();
                String z = testyeritextField1.getText();
                String a= muayenestandarditextField1.getText();
                String b= degerlendirmestandarditextField1.getText();
                String c= muayeneprosedurutextField1.getText();
                String d=muayenekapsamitextField1.getText();
                String f=resimnotextField1.getText();
                String g=yuzeydurumucomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,g);
                String h=muayeneasamasicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,h);
                String ı=sayfanotextField1.getText();
                String i=rapornotextField1.getText();
                String j=raportarihitextField1.getText();
                String k=isemrinocomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,k);
                String l=teklifnocomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,l);
                if ("".equals(x)) {
                    JOptionPane.showMessageDialog(null, "Müşteri alanını seçmeden geçemezsin");
                    return;
                } else if ("".equals(y)) {
                    JOptionPane.showMessageDialog(null, "Proje adını boş geçemezsiniz");
                    return;
                } else if ("".equals(z)) {
                    JOptionPane.showMessageDialog(null, "Test yerini boş geçemezsiniz");
                    return;
                }
                else if("".equals(a)){
                    JOptionPane.showMessageDialog(null, "Muayene standardini boş bırakamazsınız");
                    return;
                }
                else if("".equals(b)){
                    JOptionPane.showMessageDialog(null, "Değerlendirme standardini boş geçemezsiniz");
                    return;
                }
                else if("".equals(c)){
                    JOptionPane.showMessageDialog(null, "Muayene prosedurunu boş geçemezsiniz");
                    return;
                }
                else if("".equals(d)){
                    JOptionPane.showMessageDialog(null, "Muayene kapsamını boş geçemezsiniz");
                    return;
                }
                else if("".equals(f)){
                    JOptionPane.showMessageDialog(null, "Resim no boş geçemezsin");
                    return;
                }
                else if("".equals(g)){
                    JOptionPane.showMessageDialog(null, "Yüzey durumunu seçmeden geçemezsin");
                    return;
                }
                else if("".equals(h)){
                    JOptionPane.showMessageDialog(null, "Muayene aşamasını seçmeden geçemezsin");
                    return;
                }
                else if("".equals(ı)){
                    JOptionPane.showMessageDialog(null, "Sayfa no boş geçemezsin");
                    return;
                }
                else if("".equals(i)){
                    JOptionPane.showMessageDialog(null, "Rapor no boş geçemezsin");
                    return;
                }
                else if("".equals(j)){
                    JOptionPane.showMessageDialog(null, "Rapor tarihi boş geçemezsiniz");
                    return;
                }
                else if("".equals(k)){
                    JOptionPane.showMessageDialog(null, "İş emrino seçmeden geçemezsin");
                    return;
                }
                else if("".equals(l)){
                    JOptionPane.showMessageDialog(null, "Teklif no seçmeden geçemezsin");
                    return;
                }
                else if(j.equalsIgnoreCase("21.06.2020")){
                    ekipman_bilgileri field=new ekipman_bilgileri();
                    field.setVisible(true);
                    JFrame frame = new ekipman_bilgileri("Ekipman Bilgileri");
                    frame.setSize(700,700);
                    frame.setVisible(true);

                    setVisible(false);
            }}
        });

}

    public muayene() {

    }






}

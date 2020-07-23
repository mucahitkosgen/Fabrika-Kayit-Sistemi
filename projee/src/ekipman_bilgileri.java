import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    private JLabel isilislemLabel;//
    private JTextField isilislemtextField1;
    private JLabel yuzeysicakligiLabel;
    private JTextField yuzeysicakligitextField1;
    private JLabel isikcihaztanimiLabel;
    private JTextField isikcihaztanimitextField1;
    private JButton okbutton1;
    private JButton silbutton1;
    private JButton guncellebutton1;
    private JComboBox cihazcomboBox1;
    private JComboBox tasiyiciortamcomboBox1;
    private JComboBox akimtipicomboBox1;
    private JComboBox kutupmesafesicomboBox1;
    private JComboBox miknatislamateknigicomboBox1;
    private JComboBox uvisiksiddeticomboBox1;
    private JComboBox isikmesafesicomboBox1;
    private JLabel muayenebolgesialansiddetiLabel;
    private JTextField muayenebolgesialansiddetitextField1;
    private JButton ExportforExcelbutton1;
    private JButton ExportforPdfbutton1;
    private JButton devambutton1;
    private JLabel standartsapmalarLabel;
    private JTextField standartsapmalartextField1;
    private JLabel muayenetarihleriLabel;
    private JTextField muayenetarihleritextField1;
    private JLabel aciklamalarLabel;
    private JTextField aciklamalartextField1;


    public static Connection connect=null;
    public static Statement statement=null;
    public static ResultSet resultSet=null;
    public static String url="jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public  static String user="root",pass="Kule1845";
    public ekipman_bilgileri(String title){
        super(title);
        connect = database.getConnection();
        try {
            statement = connect.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(ekipman_bilgileri);

        devambutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = cihazcomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,x);
                String y =tasiyiciortamcomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,y);
                String z =muayenebolgesitextField1.getText();
                String a=akimtipicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,a);
                String b=yuzeytextField1.getText();
                String c=kaldirmatestitarihitextField1.getText();
                String d=kutupmesafesicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,d);
                String p=miknatislamateknigicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,p);
                String f=uvisiksiddeticomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,f);
                String g=isikmesafesicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,g);
                String h=isiksiddetitextField1.getText();
                String ı=muayeneortamitextField1.getText();
                String i=miknatisgiderimitextField1.getText();
                String j=isilislemtextField1.getText();
                String k=yuzeysicakligitextField1.getText();
                String l=isikcihaztanimitextField1.getText();
                String m=muayenebolgesialansiddetitextField1.getText();
                String n= standartsapmalartextField1.getText();
                String o=muayenetarihleritextField1.getText();
                String r=aciklamalartextField1.getText();

                if ("".equals(x)) {
                    JOptionPane.showMessageDialog(null, "Cihaz alanı boş geçilemez");
                    return;
                } else if ("".equals(y)) {
                    JOptionPane.showMessageDialog(null, "Taşıyıcı alan boş geçilemez");
                    return;
                } else if ("".equals(z)) {
                    JOptionPane.showMessageDialog(null, "Muayene bölgesi boş geçilemez");
                    return;
                }
                else if ("".equals(a)) {
                    JOptionPane.showMessageDialog(null, "Akım tipi seçilmeden geçilemez");
                    return;
                }
                else if ("".equals(b)) {
                    JOptionPane.showMessageDialog(null, "Yüzey boş geçilemez");
                    return;
                }
                else if ("".equals(c)) {
                    JOptionPane.showMessageDialog(null, "Kaldırma testi tarihi boş geçilemez");
                    return;
                }
                else if ("".equals(d)) {
                    JOptionPane.showMessageDialog(null, "Kutup mesafesi boş geçilemez");
                    return;
                }
                else if ("".equals(p)) {
                    JOptionPane.showMessageDialog(null, "Mıknatıslama tekniği seçilmeden geçilemez");
                    return;
                }
                else if ("".equals(f)) {
                    JOptionPane.showMessageDialog(null, "uv ışık siddeti seçilmeden geçilemez");
                    return;
                }
                else if ("".equals(g)) {
                    JOptionPane.showMessageDialog(null, "Işık mesafesi seçilmeden geçilemez");
                    return;
                }
                else if ("".equals(h)) {
                    JOptionPane.showMessageDialog(null, "Işık şiddeti boş geçilemez");
                    return;
                }
                else if ("".equals(k)) {
                    JOptionPane.showMessageDialog(null, "Yüzey sıcaklığı boş geçilemez");
                    return;
                }
                else if ("".equals(l)) {
                    JOptionPane.showMessageDialog(null, "Işık cihaz tanımı boş geçilemez");
                    return;
                }
                else if ("".equals(m)) {
                    JOptionPane.showMessageDialog(null, "Muayene bölgesi alan şiddeti boş geçilemez");
                    return;
                }
                else if("".equals(n)){
                    JOptionPane.showMessageDialog(null, "Standartsapma alanı şiddeti boş geçilemez");
                    return;
                }
                else if("".equals(o)){
                    JOptionPane.showMessageDialog(null, "Muayene tarihleri alan şiddeti boş geçilemez");
                    return;
                }

                else{
                    muayenesonucları field=new muayenesonucları();
                    field.setVisible(true);
                    JFrame frame = new muayenesonucları("Muayene Sonuclari");
                    frame.setSize(700,700);
                    frame.setVisible(true);

                    setVisible(false);
            }}
        });//

        okbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = cihazcomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,x);
                String y =tasiyiciortamcomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,y);
                String z =muayenebolgesitextField1.getText();
                String a=akimtipicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,a);
                String b=yuzeytextField1.getText();
                String c=kaldirmatestitarihitextField1.getText();
                String d=kutupmesafesicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,d);
                String p=miknatislamateknigicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,p);
                String f=uvisiksiddeticomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,f);
                String g=isikmesafesicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,g);
                String h=isiksiddetitextField1.getText();
                String ı=muayeneortamitextField1.getText();
                String i=miknatisgiderimitextField1.getText();
                String j=isilislemtextField1.getText();
                String k=yuzeysicakligitextField1.getText();
                String l=isikcihaztanimitextField1.getText();
                String m=muayenebolgesialansiddetitextField1.getText();
                String n= standartsapmalartextField1.getText();
                String o=muayenetarihleritextField1.getText();
                String r=aciklamalartextField1.getText();

                if ("".equals(x)) {
                    JOptionPane.showMessageDialog(null, "Cihaz alanı boş geçilemez");
                    return;
                } else if ("".equals(y)) {
                    JOptionPane.showMessageDialog(null, "Taşıyıcı alan boş geçilemez");
                    return;
                } else if ("".equals(z)) {
                    JOptionPane.showMessageDialog(null, "Muayene bölgesi boş geçilemez");
                    return;
                }
                else if ("".equals(a)) {
                    JOptionPane.showMessageDialog(null, "Akım tipi seçilmeden geçilemez");
                    return;
                }
                else if ("".equals(b)) {
                    JOptionPane.showMessageDialog(null, "Yüzey boş geçilemez");
                    return;
                }
                else if ("".equals(c)) {
                    JOptionPane.showMessageDialog(null, "Kaldırma testi tarihi boş geçilemez");
                    return;
                }
                else if ("".equals(d)) {
                    JOptionPane.showMessageDialog(null, "Kutup mesafesi boş geçilemez");
                    return;
                }
                else if ("".equals(p)) {
                    JOptionPane.showMessageDialog(null, "Mıknatıslama tekniği seçilmeden geçilemez");
                    return;
                }
                else if ("".equals(f)) {
                    JOptionPane.showMessageDialog(null, "uv ışık siddeti seçilmeden geçilemez");
                    return;
                }
                else if ("".equals(g)) {
                    JOptionPane.showMessageDialog(null, "Işık mesafesi seçilmeden geçilemez");
                    return;
                }
                else if ("".equals(h)) {
                    JOptionPane.showMessageDialog(null, "Işık şiddeti boş geçilemez");
                    return;
                }
                else if ("".equals(k)) {
                    JOptionPane.showMessageDialog(null, "Yüzey sıcaklığı boş geçilemez");
                    return;
                }
                else if ("".equals(l)) {
                    JOptionPane.showMessageDialog(null, "Işık cihaz tanımı boş geçilemez");
                    return;
                }
                else if ("".equals(m)) {
                    JOptionPane.showMessageDialog(null, "Muayene bölgesi alan şiddeti boş geçilemez");
                    return;
                }
                else if("".equals(n)){
                    JOptionPane.showMessageDialog(null, "Standartsapma alanı şiddeti boş geçilemez");
                    return;
                }
                else if("".equals(o)){
                    JOptionPane.showMessageDialog(null, "Muayene tarihleri alan şiddeti boş geçilemez");
                    return;
                }

                else{
                    try {
                        statement.executeUpdate("INSERT INTO ekipman_bilgileri VALUES ('" + x + "','" + y + "','" + z + "','"+ a +"','"+ b +"','"+ c +"','"+d+"','"+p+"','"+f+"','"+g+"','"+h+"','"+ı+"','"+i+"','"+j+"','"+k+"','"+l+"','"+m+"','"+n+"','"+o+"','"+r+"')");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }}
            }

        });
        silbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x=cihazcomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,x);
                String y =tasiyiciortamcomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,y);
                String z =muayenebolgesitextField1.getText();
                String a=akimtipicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,a);
                String b=yuzeytextField1.getText();
                String c=kaldirmatestitarihitextField1.getText();
                String d=kutupmesafesicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,d);
                String p=miknatislamateknigicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,p);
                String f=uvisiksiddeticomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,f);
                String g=isikmesafesicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,g);
                String h=isiksiddetitextField1.getText();
                String ı=muayeneortamitextField1.getText();
                String i=miknatisgiderimitextField1.getText();
                String j=isilislemtextField1.getText();
                String k=yuzeysicakligitextField1.getText();
                String l=isikcihaztanimitextField1.getText();
                String m=muayenebolgesialansiddetitextField1.getText();
                String n= standartsapmalartextField1.getText();
                String o=muayenetarihleritextField1.getText();
                String r=aciklamalartextField1.getText();



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
                String x = cihazcomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,x);
                String y =tasiyiciortamcomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,y);
                String z =muayenebolgesitextField1.getText();
                String a=akimtipicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,a);
                String b=yuzeytextField1.getText();
                String c=kaldirmatestitarihitextField1.getText();
                String d=kutupmesafesicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,d);
                String p=miknatislamateknigicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,p);
                String f=uvisiksiddeticomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,f);
                String g=isikmesafesicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,g);
                String h=isiksiddetitextField1.getText();
                String ı=muayeneortamitextField1.getText();
                String i=miknatisgiderimitextField1.getText();
                String j=isilislemtextField1.getText();
                String k=yuzeysicakligitextField1.getText();
                String l=isikcihaztanimitextField1.getText();
                String m=muayenebolgesialansiddetitextField1.getText();
                String n= standartsapmalartextField1.getText();
                String o=muayenetarihleritextField1.getText();
                String r=aciklamalartextField1.getText();
                try{
                    statement.executeUpdate("UPDATE ekipman_bilgileri set tasiyiciortam='"+y+"', muayenebolgesi='"+z+"',akimtipi='"+a+"',yuzey='"+b+"',kaldirmatestitarihi='"+c+"',kutupmesafesi='"+d+"',miknatislamateknigi='"+p+"',uvisiksiddeti='"+f+"',isikmesafesi='"+g+"',isiksiddeti='"+h+"',muayeneortami='"+ı+"',miknatisgiderimi='"+i+"',isilislem='"+j+"',yuzeysicakligi='"+k+"',isikcihaztanimi='"+l+"',muayenebolgesialansiddeti='"+m+"',standartsapmalar='"+n+"',muayenetarihleri='"+o+"',aciklamalar='"+r+"' where cihaz='"+x+"'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });


    }

    public ekipman_bilgileri() {

    }


}



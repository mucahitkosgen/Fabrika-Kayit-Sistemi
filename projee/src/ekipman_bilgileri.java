import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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


    public static Connection connect=null;
    public static Statement statement=null;
    public static ResultSet resultSet=null;
    public static String url="jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public  static String user="root",pass="Kule1845";
    public ekipman_bilgileri(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(ekipman_bilgileri);
        ExportforExcelbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ExcelExport exporter=new ExcelExport();
                exporter.export("ekipman_bilgileri");
            }
        });
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
                else{
                    muayenesonucları field=new muayenesonucları();
                    field.setVisible(true);
                    JFrame frame = new muayenesonucları("Muayene Sonuclari");
                    frame.setSize(700,700);
                    frame.setVisible(true);

                    setVisible(false);
            }}
        });//
        ExportforPdfbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String url = "jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
                String user = "root";
                String pass = "Kule1845";
                try {
                    Class.forName ("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Connection conn = null;
                try {
                    conn = DriverManager.getConnection(url,user,pass);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Statement stmt = null;
                try {
                    stmt = conn.createStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ResultSet query_set = null;
                try {
                    query_set = stmt.executeQuery("SELECT * FROM ekipman_bilgileri ");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                Document my_pdf_report = new Document();
                try {
                    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("ekipman_bilgileri.pdf"));
                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                my_pdf_report.open();
                PdfPTable my_report_table = new PdfPTable(2);
                PdfPCell table_cell;
                while (true) {
                    try {
                        if (!query_set.next()) break;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    String cihaz = null;
                    try {
                        my_report_table.addCell("CIHAZ");
                        cihaz = query_set.getString("cihaz");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(cihaz));
                    my_report_table.addCell(table_cell);
                    String tasiyiciortam= null;
                    try {
                        my_report_table.addCell("TASIYICIORTAM");
                        tasiyiciortam = query_set.getString("tasiyiciortam");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(tasiyiciortam));
                    my_report_table.addCell(table_cell);
                    String muayenebolgesi= null;
                    try {
                        my_report_table.addCell("MUAYENEBOLGESI");
                        muayenebolgesi = query_set.getString("muayenebolgesi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(muayenebolgesi));
                    my_report_table.addCell(table_cell);
                    String akimtipi = null;
                    try {
                        my_report_table.addCell("AKIMTIPI");
                        akimtipi = query_set.getString("akimtipi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(akimtipi));
                    my_report_table.addCell(table_cell);
                    String yuzey= null;
                    try {
                        my_report_table.addCell("YUZEY");
                        yuzey = query_set.getString("yuzey");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(yuzey));
                    my_report_table.addCell(table_cell);
                    String kaldirmatestitarihi= null;
                    try {
                        my_report_table.addCell("KALDIRMATESTITARIHI");
                        kaldirmatestitarihi = query_set.getString("kaldirmatestitarihi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(kaldirmatestitarihi));
                    my_report_table.addCell(table_cell);
                    String kutupmesafesi = null;
                    try {
                        my_report_table.addCell("KUTUPMESAFESI");
                        kutupmesafesi = query_set.getString("kutupmesafesi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(kutupmesafesi));
                    my_report_table.addCell(table_cell);
                    String miknatislamateknigi= null;
                    try {
                        my_report_table.addCell("MIKNATISLAMATEKNIGI");
                        miknatislamateknigi = query_set.getString("miknatislamateknigi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(miknatislamateknigi));
                    my_report_table.addCell(table_cell);
                    String uvisiksiddeti= null;
                    try {
                        my_report_table.addCell("UVISIKSIDDETI");
                        uvisiksiddeti = query_set.getString("uvisiksiddeti");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(uvisiksiddeti));
                    my_report_table.addCell(table_cell);
                    String isikmesafesi = null;
                    try {
                        my_report_table.addCell("ISIKMESAFESI");
                        isikmesafesi = query_set.getString("isikmesafesi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(isikmesafesi));
                    my_report_table.addCell(table_cell);
                    String isiksiddeti= null;
                    try {
                        my_report_table.addCell("ISIKSIDDETI");
                        isiksiddeti = query_set.getString("isiksiddeti");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(isiksiddeti));
                    my_report_table.addCell(table_cell);
                    String muayeneortami= null;
                    try {
                        my_report_table.addCell("MUAYENEORTAMI");
                        muayeneortami = query_set.getString("muayeneortami");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(muayeneortami));
                    my_report_table.addCell(table_cell);
                    String miknatisgiderimi = null;
                    try {
                        my_report_table.addCell("MIKNATISGIDERIMI");
                        miknatisgiderimi = query_set.getString("miknatisgiderimi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(miknatisgiderimi));
                    my_report_table.addCell(table_cell);
                    String isilislem= null;
                    try {
                        my_report_table.addCell("ISILISLEM");
                        isilislem = query_set.getString("isilislem");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(isilislem));
                    my_report_table.addCell(table_cell);
                    String yuzeysicakligi= null;
                    try {
                        my_report_table.addCell("YUZEYSICAKLIGI");
                        yuzeysicakligi = query_set.getString("yuzeysicakligi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(yuzeysicakligi));
                    my_report_table.addCell(table_cell);
                    String isikcihaztanimi = null;
                    try {
                        my_report_table.addCell("ISIKCIHAZTANIMI");
                        isikcihaztanimi = query_set.getString("isikcihaztanimi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(isikcihaztanimi));
                    my_report_table.addCell(table_cell);
                    String muayenebolgesialansiddeti= null;
                    try {
                        my_report_table.addCell("MUAYENEBOLGESİALANSIDDETI");
                        muayenebolgesialansiddeti = query_set.getString("muayenebolgesialansiddeti");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(muayenebolgesialansiddeti));
                    my_report_table.addCell(table_cell);


                }
                try {
                    my_pdf_report.add(my_report_table);
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
                my_pdf_report.close();


                try {
                    query_set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
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

                else{
                    try {
                        statement.executeUpdate("INSERT INTO ekipman_bilgileri VALUES ('" + x + "','" + y + "','" + z + "','"+ a +"','"+ b +"','"+ c +"','"+d+"','"+p+"','"+f+"','"+g+"','"+h+"','"+ı+"','"+i+"','"+j+"','"+k+"','"+l+"','"+m+"')");
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
                try{
                    statement.executeUpdate("UPDATE ekipman_bilgileri set tasiyiciortam='"+y+"', muayenebolgesi='"+z+"',akimtipi='"+a+"',yuzey='"+b+"',kaldirmatestitarihi='"+c+"',kutupmesafesi='"+d+"',miknatislamateknigi='"+p+"',uvisiksiddeti='"+f+"',isikmesafesi='"+g+"',isiksiddeti='"+h+"',muayeneortami='"+ı+"',miknatisgiderimi='"+i+"',isilislem='"+j+"',yuzeysicakligi='"+k+"',isikcihaztanimi='"+l+"',muayenebolgesialansiddeti='"+m+"' where cihaz='"+x+"'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });


    }

    public ekipman_bilgileri() {

    }

    public static void main(String[] args) {
        JFrame frame = new ekipman_bilgileri("ekipmanbilgileri");
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        JComboBox cihazcomboBox=new JComboBox();
        DefaultComboBoxModel comboBoxModel=new DefaultComboBoxModel();
        comboBoxModel.setSelectedItem(cihazcomboBox);
        JComboBox tasiyiciortamcomboBox=new JComboBox();
        comboBoxModel.setSelectedItem(tasiyiciortamcomboBox);
        JComboBox akimtipicomboBox=new JComboBox();
        comboBoxModel.setSelectedItem(akimtipicomboBox);
        JComboBox kutupmesafesicomboBox=new JComboBox();
        comboBoxModel.setSelectedItem(kutupmesafesicomboBox);
        JComboBox miknatislamateknigicomboBox=new JComboBox();
        comboBoxModel.setSelectedItem(miknatislamateknigicomboBox);
        JComboBox uvisiksiddeticomboBox=new JComboBox();
        comboBoxModel.setSelectedItem(uvisiksiddeticomboBox);
        JComboBox isikmesafesicomboBox=new JComboBox();
        comboBoxModel.setSelectedItem(isikmesafesicomboBox);
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
                String muayenebolgesialansiddeti=resultSet.getString(17);
                System.out.println(cihaz + " " + tasiyiciortam + " " +muayenebolgesi+" "+ akimtipi+" "+yuzey+" "+kaldirmatestitarihi+" "+kutupmesafesi+" "+miknatislamateknigi+" "+uvisiksiddeti+" "+isikmesafesi+" "+isiksiddeti+" "+muayeneortami+" "+miknatisgiderimi+" "+isilislem+" "+yuzeysicakligi+" "+isikcihaztanimi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //catch (ClassNotFoundException e) {
           // e.printStackTrace();
        //}


    }}



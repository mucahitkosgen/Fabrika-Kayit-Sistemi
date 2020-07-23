import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;

public class operator extends JFrame {
    private JLabel adisoyadiLabel;
    private JTextField adisoyaditextField1;
    private JLabel seviyeLabel;
    private JTextField seviyetextField1;
    private JLabel tarihLabel;
    private JTextField tarihtextField1;
    private JButton okbutton1;
    private JButton silbutton1;
    private JButton guncellebutton1;
    private JButton ExportforExcelbutton1;
    private JButton ExportforPdfbutton1;
    private JButton devambutton1;
    private JPanel operator;

    public static Connection connect=null;
    public static Statement statement=null;
    public static ResultSet resultSet=null;
    public static String url="jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public  static String user="root",pass="Kule1845";
    public operator(String title) {
        super(title);
         connect = database.getConnection();
        try {
            statement = connect.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(operator);


        ExportforExcelbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ExcelExport exporter = new ExcelExport();
                exporter.export("table_name");


            }});
        ExportforPdfbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String url = "jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
                String user = "root";
                String pass = "Kule1845";

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Connection connect = null;
                try {
                    connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "Kule1845");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Statement stmt = null;
                try {
                    stmt = connect.createStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ResultSet query_set = null;

                Document my_pdf_report = new Document(PageSize.A3,32,32,32,32);

                try {
                    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("gozetimmuayene.pdf"));
                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


                my_pdf_report.open();
                Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.RED);
                Chunk chunk = new Chunk("GÖZETIM MUAYENE VE EGITIM MERKEZI", font);


                try {
                    my_pdf_report.add(chunk);
                } catch (DocumentException e) {
                    e.printStackTrace();
                }

                PdfPTable my_report_table = new PdfPTable(4);
                PdfPCell table_cell;
                try {
                    query_set = stmt.executeQuery("SELECT * FROM muayene ");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                while (true) {
                    try {
                        if (!query_set.next()) break;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    String musteri = null;

                    try {
                        my_report_table.addCell("Musteri");
                        musteri = query_set.getString("musteri");


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(musteri));
                    my_report_table.addCell(table_cell);
                    String projeadi = null;
                    try {
                        my_report_table.addCell("Projeadi");
                        projeadi = query_set.getString("projeadi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(projeadi));
                    my_report_table.addCell(table_cell);


                    String testyeri = null;

                    try {
                        my_report_table.addCell("Testyeri");
                        testyeri = query_set.getString("testyeri");

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(testyeri));
                    my_report_table.addCell(table_cell);
                    String muayenestandardi = null;

                    try {
                        my_report_table.addCell("Muayenestandardi");
                        muayenestandardi = query_set.getString("muayenestandardi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(muayenestandardi));
                    my_report_table.addCell(table_cell);
                    String degerlendirmestandardi = null;
                    try {
                        my_report_table.addCell("Degerlendirmestandardi");
                        degerlendirmestandardi = query_set.getString("degerlendirmestandardi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(degerlendirmestandardi));
                    my_report_table.addCell(table_cell);
                    String muayeneproseduru = null;
                    try {
                        my_report_table.addCell("Muayeneproseduru");
                        muayeneproseduru = query_set.getString("muayeneproseduru");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(muayeneproseduru));
                    my_report_table.addCell(table_cell);
                    String muayenekapsami = null;
                    try {
                        my_report_table.addCell("Muayenekapsami");
                        muayenekapsami = query_set.getString("muayenekapsami");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(muayenekapsami));
                    my_report_table.addCell(table_cell);
                    String resimno = null;
                    try {
                        my_report_table.addCell("Resimno");
                        resimno = query_set.getString("resimno");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(resimno));
                    my_report_table.addCell(table_cell);
                    String yuzeydurumu = null;
                    try {
                        my_report_table.addCell("Yuzeydurumu");
                        yuzeydurumu = query_set.getString("yuzeydurumu");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(yuzeydurumu));
                    my_report_table.addCell(table_cell);
                    String muayeneasamasi = null;
                    try {
                        my_report_table.addCell("Muayeneasamasi");
                        muayeneasamasi = query_set.getString("muayeneasamasi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(muayeneasamasi));
                    my_report_table.addCell(table_cell);
                    String sayfano = null;
                    try {
                        my_report_table.addCell("Sayfano");
                        sayfano = query_set.getString("sayfano");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(sayfano));
                    my_report_table.addCell(table_cell);
                    String raporno = null;
                    try {
                        my_report_table.addCell("Raporno");
                        raporno = query_set.getString("raporno");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(raporno));
                    my_report_table.addCell(table_cell);
                    String raportarihi = null;
                    try {
                        my_report_table.addCell("Raportarihi");
                        raportarihi = query_set.getString("raportarihi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(raportarihi));
                    my_report_table.addCell(table_cell);
                    String isemrino = null;
                    try {
                        my_report_table.addCell("Isemrino");
                        isemrino = query_set.getString("isemrino");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(isemrino));
                    my_report_table.addCell(table_cell);
                    String teklifno = null;
                    try {
                        my_report_table.addCell("Teklifno");
                        teklifno = query_set.getString("teklifno");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(teklifno));
                    my_report_table.addCell(table_cell);

                }



                try {
                    query_set = stmt.executeQuery("SELECT * FROM ekipman_bilgileri ");

                } catch (SQLException e) {
                    e.printStackTrace();
                }


                while (true) {
                    try {
                        if (!query_set.next()) break;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }



                    String cihaz = null;
                    try {
                        my_report_table.addCell("Cihaz");
                        cihaz = query_set.getString("cihaz");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(cihaz));
                    my_report_table.addCell(table_cell);
                    String tasiyiciortam= null;
                    try {
                        my_report_table.addCell("Tasiyiciortam");
                        tasiyiciortam = query_set.getString("tasiyiciortam");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(tasiyiciortam));
                    my_report_table.addCell(table_cell);

                    String muayenebolgesi= null;
                    try {
                        my_report_table.addCell("Muayenebolgesi");
                        muayenebolgesi = query_set.getString("muayenebolgesi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(muayenebolgesi));
                    my_report_table.addCell(table_cell);
                    String akimtipi = null;
                    try {
                        my_report_table.addCell("Akımtipi");
                        akimtipi = query_set.getString("akimtipi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(akimtipi));
                    my_report_table.addCell(table_cell);
                    String yuzey= null;
                    try {
                        my_report_table.addCell("Yuzey");
                        yuzey = query_set.getString("yuzey");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(yuzey));
                    my_report_table.addCell(table_cell);
                    String kaldirmatestitarihi= null;
                    try {
                        my_report_table.addCell("Kaldirmatestitarihi");
                        kaldirmatestitarihi = query_set.getString("kaldirmatestitarihi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(kaldirmatestitarihi));
                    my_report_table.addCell(table_cell);
                    String kutupmesafesi = null;
                    try {
                        my_report_table.addCell("Kutupmesafesi");
                        kutupmesafesi = query_set.getString("kutupmesafesi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(kutupmesafesi));
                    my_report_table.addCell(table_cell);
                    String miknatislamateknigi= null;
                    try {
                        my_report_table.addCell("Miknatislamateknigi");
                        miknatislamateknigi = query_set.getString("miknatislamateknigi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(miknatislamateknigi));
                    my_report_table.addCell(table_cell);
                    String uvisiksiddeti= null;
                    try {
                        my_report_table.addCell("Uvisiksiddeti");
                        uvisiksiddeti = query_set.getString("uvisiksiddeti");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(uvisiksiddeti));
                    my_report_table.addCell(table_cell);
                    String isikmesafesi = null;
                    try {
                        my_report_table.addCell("Isikmesafesi");
                        isikmesafesi = query_set.getString("isikmesafesi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(isikmesafesi));
                    my_report_table.addCell(table_cell);
                    String isiksiddeti= null;
                    try {
                        my_report_table.addCell("Isiksiddeti");
                        isiksiddeti = query_set.getString("isiksiddeti");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(isiksiddeti));
                    my_report_table.addCell(table_cell);
                    String muayeneortami= null;
                    try {
                        my_report_table.addCell("Muayeneortami");
                        muayeneortami = query_set.getString("muayeneortami");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(muayeneortami));
                    my_report_table.addCell(table_cell);
                    String miknatisgiderimi = null;
                    try {
                        my_report_table.addCell("Miknatisgiderimi");
                        miknatisgiderimi = query_set.getString("miknatisgiderimi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(miknatisgiderimi));
                    my_report_table.addCell(table_cell);
                    String isilislem= null;
                    try {
                        my_report_table.addCell("Isilislem");
                        isilislem = query_set.getString("isilislem");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(isilislem));
                    my_report_table.addCell(table_cell);
                    String yuzeysicakligi= null;
                    try {
                        my_report_table.addCell("Yuzeysicakligi");
                        yuzeysicakligi = query_set.getString("yuzeysicakligi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(yuzeysicakligi));
                    my_report_table.addCell(table_cell);
                    String isikcihaztanimi = null;
                    try {
                        my_report_table.addCell("Isikcihaztanimi");
                        isikcihaztanimi = query_set.getString("isikcihaztanimi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(isikcihaztanimi));
                    my_report_table.addCell(table_cell);
                    String muayenebolgesialansiddeti= null;
                    try {
                        my_report_table.addCell("Muayenebolgesialansiddeti");
                        muayenebolgesialansiddeti = query_set.getString("muayenebolgesialansiddeti");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(muayenebolgesialansiddeti));
                    my_report_table.addCell(table_cell);
                    String standartsapmalar= null;
                    try {
                        my_report_table.addCell("Standartsapma");
                        standartsapmalar = query_set.getString("standartsapmalar");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(standartsapmalar));
                    my_report_table.addCell(table_cell);
                    String muayenetarihleri= null;
                    try {
                        my_report_table.addCell("Muayenetarihleri");
                        muayenetarihleri = query_set.getString("muayenetarihleri");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(muayenetarihleri));
                    my_report_table.addCell(table_cell);
                    String aciklamalar= null;
                    try {
                        my_report_table.addCell("Aciklamalar");
                        aciklamalar = query_set.getString("aciklamalar");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(aciklamalar));
                    my_report_table.addCell(table_cell);


                }
                try {
                    query_set = stmt.executeQuery("SELECT * FROM muayenesonucları ");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                while (true) {
                    try {
                        if (!query_set.next()) break;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    String serino = null;
                    try {
                        my_report_table.addCell("Serino");
                        serino = query_set.getString("serino");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(serino));
                    my_report_table.addCell(table_cell);
                    String kaynakno = null;
                    try {
                        my_report_table.addCell("Kaynakno");
                        kaynakno = query_set.getString("kaynakno");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(kaynakno));
                    my_report_table.addCell(table_cell);
                    String kontroluzunlugu = null;
                    try {
                        my_report_table.addCell("Kontroluzunlugu");
                        kontroluzunlugu = query_set.getString("kontroluzunlugu");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(kontroluzunlugu));
                    my_report_table.addCell(table_cell);
                    String kaynakyon = null;
                    try {
                        my_report_table.addCell("Kaynakyon");
                        kaynakyon = query_set.getString("kaynakyon");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(kaynakyon));
                    my_report_table.addCell(table_cell);
                    String kalinlik = null;
                    try {
                        my_report_table.addCell("Kalinlik");
                        kalinlik = query_set.getString("kalinlik");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(kalinlik));
                    my_report_table.addCell(table_cell);
                    String cap = null;
                    try {
                        my_report_table.addCell("Cap");
                        cap = query_set.getString("cap");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(cap));
                    my_report_table.addCell(table_cell);
                    String hatatipi = null;
                    try {
                        my_report_table.addCell("Hatatipi");
                        hatatipi = query_set.getString("hatatipi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(hatatipi));
                    my_report_table.addCell(table_cell);
                    String hataninyeri = null;
                    try {
                        my_report_table.addCell("Hataninyeri");
                        hataninyeri = query_set.getString("hataninyeri");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(hataninyeri));
                    my_report_table.addCell(table_cell);
                    String sonuc = null;
                    try {
                        my_report_table.addCell("Sonuc");
                        sonuc = query_set.getString("sonuc");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(sonuc));
                    my_report_table.addCell(table_cell);

                }
                try {
                    assert stmt != null;
                    query_set = stmt.executeQuery("SELECT * FROM degerlendiren");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                while (true) {
                    try {
                        if (!query_set.next()) break;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    String adisoyadi = null;
                    try {
                        my_report_table.addCell("Adi-soyadi");
                        adisoyadi = query_set.getString("ADISOYADI");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(adisoyadi));
                    my_report_table.addCell(table_cell);
                    String seviye= null;
                    try {
                        my_report_table.addCell("Seviye");
                        seviye = query_set.getString("SEVİYE");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(seviye));
                    my_report_table.addCell(table_cell);
                    String tarih= null;
                    try {
                        my_report_table.addCell("Tarih");
                        tarih = query_set.getString("TARİH");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(tarih));
                    my_report_table.addCell(table_cell);
                }
                try {
                    query_set = stmt.executeQuery("SELECT adisoyadi,seviye,tarih FROM musteri");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                while (true) {
                    try {//
                        if (!query_set.next()) break;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    String adisoyadi = null;
                    try {
                        my_report_table.addCell("Adi-soyadi");
                        adisoyadi = query_set.getString("ADISOYADI");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(adisoyadi));
                    my_report_table.addCell(table_cell);
                    String seviye= null;
                    try {
                        my_report_table.addCell("Seviye");
                        seviye = query_set.getString("SEVİYE");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(seviye));
                    my_report_table.addCell(table_cell);
                    String tarih= null;
                    try {
                        my_report_table.addCell("Tarih");
                        tarih = query_set.getString("TARİH");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(tarih));
                    my_report_table.addCell(table_cell);

                }
                try {
                    query_set = stmt.executeQuery("SELECT adisoyadi,seviye,tarih FROM onay");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                while (true) {
                    try {
                        if (!query_set.next()) break;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    String adisoyadi = null;
                    try {
                        my_report_table.addCell("Adi-soyadi");
                        adisoyadi = query_set.getString("ADISOYADI");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(adisoyadi));
                    my_report_table.addCell(table_cell);
                    String seviye= null;
                    try {
                        my_report_table.addCell("Seviye");
                        seviye = query_set.getString("SEVİYE");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(seviye));
                    my_report_table.addCell(table_cell);
                    String tarih= null;
                    try {
                        my_report_table.addCell("Tarih");
                        tarih = query_set.getString("TARİH");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(tarih));
                    my_report_table.addCell(table_cell);

                }

                try {
                    query_set = stmt.executeQuery("SELECT adisoyadi,seviye,tarih FROM operator");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                while (true) {
                    try {
                        if (!query_set.next()) break;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    String adisoyadi = null;
                    try {
                        my_report_table.addCell("Adi-Soyadi");
                        adisoyadi = query_set.getString("ADISOYADI");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(adisoyadi));
                    my_report_table.addCell(table_cell);
                    String seviye= null;
                    try {
                        my_report_table.addCell("Seviye");
                        seviye = query_set.getString("SEVİYE");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(seviye));
                    my_report_table.addCell(table_cell);
                    String tarih= null;
                    try {
                        my_report_table.addCell("Tarih");
                        tarih = query_set.getString("TARİH");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(tarih));
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
                    connect.close();
                } catch (SQLException e) {
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
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });



        silbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String x = adisoyaditextField1.getText();
                String y = seviyetextField1.getText();
                String z = tarihtextField1.getText();
                try {

                    statement.executeUpdate("DELETE FROM operator where adisoyadi='" + x + "'");

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
        okbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = adisoyaditextField1.getText();
                String y = seviyetextField1.getText();
                String z = tarihtextField1.getText();

                if ("".equals(x) && "".equals(y) && "".equals(z)) {
                    JOptionPane.showMessageDialog(null, "Adı-soyadı,seviye ve tarihi boş geçemezsiniz");
                    return;
                } else if ("".equals(x) && "".equals(y)) {
                    JOptionPane.showMessageDialog(null, "Adı-soyadı ve tarihi boş geçemezsiniz.");
                    return;
                } else if ("".equals(x) && "".equals(z)) {
                    JOptionPane.showMessageDialog(null, "Adı-soyadı ve tarihi boş geçemezsiniz");
                    return;
                } else if ("".equals(y) && "".equals(z)) {
                    JOptionPane.showMessageDialog(null, "Seviye ve tarihi boş geçemezsiniz");
                    return;
                } else if ("".equals(x)) {
                    JOptionPane.showMessageDialog(null, "Adı-soyadı boş geçemezsiniz");
                    return;
                } else if ("".equals(y)) {
                    JOptionPane.showMessageDialog(null, "Seviyeyi boş geçemezsiniz");
                    return;
                } else if ("".equals(z)) {
                    JOptionPane.showMessageDialog(null, "Tarihi boş geçemezsiniz");
                    return;
                }
                else  {
                    try {

                        if(statement==null){

                        }
                        statement.executeUpdate("INSERT INTO operator VALUES ('" + x + "','" + y + "','" + z + "')");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }


        });
        guncellebutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = adisoyaditextField1.getText();
                String y = seviyetextField1.getText();
                String z = tarihtextField1.getText();

                try {
                    statement.executeUpdate("UPDATE operator set seviye='" + y + "',tarih='" + z + "'where adisoyadi='" + x + "'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public operator(){

    }

}



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
    private JComboBox sonuccomboBox1;
    private JButton ExportforExcelbutton1;
    private JButton ExportforPdfbutton1;
    private JButton ExportforAllExcelbutton1;
    private JButton devambutton1;
    private JTextField sonuctextField1;

    public static Connection connect=null;
    public static Statement statement=null;
    public static ResultSet resultSet=null;
    public static String url="jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public  static String user="root",pass="Kule1845";

    public muayenesonucları(String title) {
        super(title);
        connect = database.getConnection();
        try {
            statement = connect.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(muayenesonucları);
        ExportforExcelbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ExcelExport exporter = new ExcelExport();
                exporter.export("muayenesonucları");

            }
        });
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
                Connection conn = null;
                try {
                    conn = DriverManager.getConnection(url, user, pass);
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
                    query_set = stmt.executeQuery("SELECT * FROM muayenesonucları ");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                Document my_pdf_report = new Document();

                try {
                    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("muayenesonucları.pdf"));
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
                    String serino = null;
                    try {
                        my_report_table.addCell("SERINO");
                        serino = query_set.getString("serino");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(serino));
                    my_report_table.addCell(table_cell);
                    String kaynakno = null;
                    try {
                        my_report_table.addCell("KAYNAKNO");
                        kaynakno = query_set.getString("kaynakno");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(kaynakno));
                    my_report_table.addCell(table_cell);
                    String kontroluzunlugu = null;
                    try {
                        my_report_table.addCell("KONTROLUZUNLUGU");
                        kontroluzunlugu = query_set.getString("kontroluzunlugu");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(kontroluzunlugu));
                    my_report_table.addCell(table_cell);
                    String kaynakyon = null;
                    try {
                        my_report_table.addCell("KAYNAKYON");
                        kaynakyon = query_set.getString("kaynakyon");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(kaynakyon));
                    my_report_table.addCell(table_cell);
                    String kalinlik = null;
                    try {
                        my_report_table.addCell("KALINLIK");
                        kalinlik = query_set.getString("kalinlik");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(kalinlik));
                    my_report_table.addCell(table_cell);
                    String cap = null;
                    try {
                        my_report_table.addCell("CAP");
                        cap = query_set.getString("cap");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(cap));
                    my_report_table.addCell(table_cell);
                    String hatatipi = null;
                    try {
                        my_report_table.addCell("HATATIPI");
                        hatatipi = query_set.getString("hatatipi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(hatatipi));
                    my_report_table.addCell(table_cell);
                    String hataninyeri = null;
                    try {
                        my_report_table.addCell("HATANINYERI");
                        hataninyeri = query_set.getString("hataninyeri");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(hataninyeri));
                    my_report_table.addCell(table_cell);
                    String sonuc = null;
                    try {
                        my_report_table.addCell("SONUC");
                        sonuc = query_set.getString("sonuc");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell = new PdfPCell(new Phrase(sonuc));
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
        silbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String x = serinotextField1.getText();
                String y = kaynaknotextField1.getText();
                String z = kontroluzunlugutextField1.getText();
                String a = kaynakyonTextField1.getText();
                String b = kalinliktextField1.getText();
                String c = captextField1.getText();
                String d = hatatipitextField1.getText();
                String f = hataninyeritextField1.getText();
                String g = sonuccomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null, g);

                try {

                    statement.executeUpdate("DELETE FROM muayenesonucları where serino='" + x + "'");

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
        ExportforAllExcelbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ExcelExport exporter = new ExcelExport();
                exporter.export("onay,musteri,operator,degerlendiren,muayene,ekipman_bilgileri,muayenesonucları");

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
                String g=sonuccomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,g);

                if ("".equals(x)) {
                    JOptionPane.showMessageDialog(null, "Seri no boş geçilemez");
                    return;
                } else if ("".equals(y)) {
                    JOptionPane.showMessageDialog(null, "Kaynak no boş geçemezsiniz");
                    return;
                } else if ("".equals(z)) {
                    JOptionPane.showMessageDialog(null, "Kontrol uzunluğu boş geçemezsiniz");
                    return;
                }
                else if("".equals(a)){
                    JOptionPane.showMessageDialog(null, "Kaynak yon boş geçemezsin");
                    return;
                }
                else if("".equals(b)){
                    JOptionPane.showMessageDialog(null, "Kalınlık boş geçemezsiniz");
                    return;
                }
                else if (g.equalsIgnoreCase("RED")){
                     if("".equals(d)  ){
                         JOptionPane.showMessageDialog(null, "Sonuç RED ise hata tipini boş geçemezsin");

                        return;
                     }
                     else if( "".equals(f)){
                         JOptionPane.showMessageDialog(null, "Sonuç RED ise hata yerini boş geçemezsin");
                         return;
                     }

                     else{
                         try {
                             statement.executeUpdate("INSERT INTO muayenesonucları VALUES ('" + x + "','" + y + "','" + z + "','"+ a +"','"+b+"','"+c+"','"+d+"','"+f+"','"+g+"')");
                         }    catch (SQLException e) {
                             e.printStackTrace();
                         }

                     }

                }
                else{
                    try {
                        statement.executeUpdate("INSERT INTO muayenesonucları VALUES ('" + x + "','" + y + "','" + z + "','"+ a +"','"+b+"','"+c+"','"+d+"','"+f+"','"+g+"')");
                    }    catch (SQLException e) {
                        e.printStackTrace();
                    }}
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
                String g=sonuccomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,g);
                try{
                    statement.executeUpdate("UPDATE muayenesonucları set kaynakno='"+y+"',kontroluzunlugu='"+z+"',kaynakyon='"+a+"',kalinlik='"+b+"',cap='"+c+"',hatatipi='"+d+"',hataninyeri='"+f+"',sonuc='"+g+"'where serino='"+x+"'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public muayenesonucları() {

    }

    public static void main(String[] args) {
        JFrame frame=new muayenesonucları("Muayene Sonuçları");
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        JComboBox sonuccomboBox=new JComboBox();
        DefaultComboBoxModel comboBoxModel=new DefaultComboBoxModel();
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


    }





}

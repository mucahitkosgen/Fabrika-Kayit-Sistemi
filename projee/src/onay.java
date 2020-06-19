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

public class onay extends JFrame {
    private JPanel onay;
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

    public static Connection connect=null;
    public static Statement statement=null;
    public static ResultSet resultSet=null;
    public static String url="jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public  static String user="root",pass="Kule1845";
    public onay(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(onay);
        devambutton1.addActionListener(new ActionListener() {
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
                else{
                    muayene fieldd=new muayene();
                    fieldd.setVisible(true);
                    JFrame frame = new muayene("Muayene");
                    frame.setSize(700,700);

                    frame.setVisible(true);

                    setVisible(false);
                }}
        });

        ExportforExcelbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ExcelExport exporter = new ExcelExport();
                exporter.export("onay");


            }

        });
        ExportforPdfbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Class.forName ("com.mysql.cj.jdbc.Driver");
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
                try {
                    query_set = stmt.executeQuery("SELECT adisoyadi,seviye,tarih FROM onay");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                Document my_pdf_report = new Document();
                try {
                    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("onay.pdf"));
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
                    String adisoyadi = null;
                    try {
                        my_report_table.addCell("ADISOYADI");
                        adisoyadi = query_set.getString("ADISOYADI");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(adisoyadi));
                    my_report_table.addCell(table_cell);
                    String seviye= null;
                    try {
                        my_report_table.addCell("SEVIYE");
                        seviye = query_set.getString("SEVİYE");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(seviye));
                    my_report_table.addCell(table_cell);
                    String tarih= null;
                    try {
                        my_report_table.addCell("TARIH");
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
            }
        });



            silbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String x = adisoyaditextField1.getText();
                String y = seviyetextField1.getText();
                String z = tarihtextField1.getText();
                try {

                    statement.executeUpdate("DELETE FROM onay where adisoyadi='" + x + "'");

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
                else {
                    try {
                        statement.executeUpdate("INSERT INTO onay VALUES ('" + x + "','" + y + "','" + z + "')");
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
                    statement.executeUpdate("UPDATE onay set seviye='" + y + "',tarih='" + z + "'where adisoyadi='" + x + "'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public onay(){

    }
    public static void main(String[] args) {
        JFrame frame = new onay("ONAY");
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


    }}





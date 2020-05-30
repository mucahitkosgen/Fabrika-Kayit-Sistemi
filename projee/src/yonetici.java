import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class yonetici extends JFrame {
    private JPanel yonetici;
    private JLabel yoneticiisimLabel;
    private JTextField yoneticiisimtextField1;
    private JLabel sıfreLabel;
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





    public yonetici(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(yonetici);

        JLabel label=new JLabel("yoneticiisim");

        devambutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                musterii field=new musterii();
                field.setVisible(true);
                JFrame frame = new musterii("Gözetim Muayene Raporu");
                frame.setSize(700,700);
                frame.setVisible(true);


                setVisible(false);


            }
        });

        okbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x=yoneticiisimtextField1.getText();

                String y = sıfrepasswordField1.getText();

                try {
                    statement.executeUpdate("INSERT INTO yonetici VALUES ('" + x + "','" + y + "')");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        });
        silbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x=yoneticiisimtextField1.getText();
                String y=sıfrepasswordField1.getText();


                try{
                    statement.executeUpdate("DELETE FROM yonetici where yoneticiisim='"+x+"'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        guncellebutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String  x=yoneticiisimtextField1.getText();
                String y=sıfrepasswordField1.getText();

                try{
                    statement.executeUpdate("UPDATE yonetici set sifre='"+y+"' where yoneticiisim='"+x+"'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        ExportforExcelbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AdvancedDb2ExcelExporter exporter=new AdvancedDb2ExcelExporter();
                exporter.export("yonetici");
            }
        });
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
                    query_set = stmt.executeQuery("SELECT * FROM yonetici ");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                Document my_pdf_report = new Document();
                try {
                    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("yonetici.pdf"));
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
                    String yoneticiisim = null;
                    try {
                        yoneticiisim = query_set.getString("yoneticiisim");
                    } catch (SQLException e) {
                        e.printStackTrace();//
                    }
                    table_cell=new PdfPCell(new Phrase(yoneticiisim));
                    my_report_table.addCell(table_cell);
                    String sıfre= null;
                    try {
                        sıfre = query_set.getString("sıfre");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(sıfre));
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



    }





    public static void main(String[] args) {
        JFrame frame = new yonetici("Yönetici giriş");
       // frame.setPreferredSize(new Dimension(700, 700));
        //frame.pack();
        frame.setSize(700,700);
       // frame.setLocationRelativeTo(null);
        //frame.getContentPane().setSize(500,500);
        //frame.pack();
        //frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, pass);
            Connection connect=database.getConnection();
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from yonetici");
            while (resultSet.next()) {
                String yoneticiisim = resultSet.getString(1);
                String sifre = resultSet.getString(2);
                System.out.println( yoneticiisim+" " + sifre + " " );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



}



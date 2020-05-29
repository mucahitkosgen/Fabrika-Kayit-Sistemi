import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.*;
import com.itextpdf.*;
import com.sun.deploy.net.MessageHeader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class pdf  {


    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, DocumentException {
        String url = "jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        String user = "root";
        String pass = "Kule1845";
        Class.forName ("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,user,pass);
        Statement stmt = conn.createStatement();

        ResultSet query_set = stmt.executeQuery("SELECT * FROM musteri ");

        Document my_pdf_report = new Document();
        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("musteri.pdf"));
        my_pdf_report.open();
        PdfPTable my_report_table = new PdfPTable(3);
        PdfPCell table_cell;
        while (query_set.next()) {
            String adisoyadi = query_set.getString("adisoyadi");
            table_cell=new PdfPCell(new Phrase(adisoyadi));
            my_report_table.addCell(table_cell);
            String seviye=query_set.getString("seviye");
            table_cell=new PdfPCell(new Phrase(seviye));
            my_report_table.addCell(table_cell);
            String tarih=query_set.getString("tarih");
            table_cell=new PdfPCell(new Phrase(tarih));
            my_report_table.addCell(table_cell);

        }

        my_pdf_report.add(my_report_table);
        my_pdf_report.close();


        query_set.close();
        stmt.close();
        conn.close();
    }}
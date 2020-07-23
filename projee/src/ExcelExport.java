import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelExport {


    private static Object CellStyle;



    public static void main(String[] args) {
        ExcelExport exporter = new ExcelExport();


        exporter.export("onay");
        exporter.export("degerlendiren");
        exporter.export("operator");
        exporter.export("musteri");
        exporter.export("ekipman_bilgileri");
        exporter.export("muayene");
        exporter.export("muayenesonucları");
        exporter.export("table_name");



    }





    private static String getFileName(String baseName) {
       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String dateTimeInfo = dateFormat.format(new Date());
        return baseName.concat(String.format("proje.xlsx", dateTimeInfo));}

    static void export(String proje) {
        String url = "jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        String user = "root";
        String pass = "Kule1845";
     String excelFilePath = getFileName(proje.concat("_Export"));


          try (Connection connection = DriverManager.getConnection(url,user,pass)) {
            String sql = "SELECT * FROM ".concat(proje);


            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);


            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet = workbook.createSheet(proje);
            for(int i=0;i<47;i++){

              sheet.setColumnWidth(i,6000);
            }

           writeHeaderLine(result, sheet);

            writeDataLines(result, workbook, sheet);




           FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();

            statement.close();

        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }


    private static void writeDataLines(ResultSet result, XSSFWorkbook workbook, XSSFSheet sheet)throws SQLException {
        ResultSetMetaData metaData = result.getMetaData();

        int numberOfColumns = metaData.getColumnCount();


        CellStyle style = workbook.createCellStyle();

        Row row = sheet.createRow(0);
        Cell cell0 = row.createCell(2);
        cell0.setCellValue("GÖZETİM MUAYENE VE EĞİTİM HİZMETLERİ");


        Row row2 = sheet.createRow(1);
        Cell cell1 = row2.createCell(2);
        cell1.setCellValue("MANYETİK PARÇACIK MUAYENE RAPORU");
//
        Row row3 = sheet.createRow(2);
        Cell cell2 = row3.createCell(0);
        cell2.setCellValue("Musteri ");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell2.setCellValue("Musteri");
        cell2.setCellStyle(style);
        Cell cell2_1 = row3.createCell(1);
        cell2_1.setCellValue("TAG GEMI");

        Cell cell3 = row3.createCell(2);
        cell3.setCellValue("Muayene Prosedürü ");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell3.setCellValue("Muayene Proseduru");
        cell3.setCellStyle(style);
        Cell cell3_1 = row3.createCell(3);
        cell3_1.setCellValue("P-101-004");

        Cell cell4 = row3.createCell(4);
        cell4.setCellValue("Sayfa No ");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell4.setCellValue("Sayfa No");
        cell4.setCellStyle(style);
        Cell cell4_1 = row3.createCell(5);
        cell4_1.setCellValue("1");

        Row row4 = sheet.createRow(3);
        Cell cell5 = row4.createCell(0);
        cell5.setCellValue("Proje Adı ");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell5.setCellValue("Proje Adı");
        cell5.setCellStyle(style);
        Cell cell5_1 = row4.createCell(1);
        cell5_1.setCellValue("KAYNAKÇI TESTİ");

        Cell cell6 = row4.createCell(2);
        cell6.setCellValue("Muayene Kapsamı ");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell6.setCellValue("Muayene Kapsamı");
        cell6.setCellStyle(style);
        Cell cell6_1 = row4.createCell(3);
        cell6_1.setCellValue("20%");

        Cell cell7 = row4.createCell(4);
        cell7.setCellValue("Rapor No");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell7.setCellValue("Rapor No");
        cell7.setCellStyle(style);
        Cell cell7_1 = row4.createCell(5);
        cell7_1.setCellValue("2176895");

        Row row5 = sheet.createRow(4);
        Cell cell8 = row5.createCell(0);
        cell8.setCellValue("Test Yeri");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell8.setCellValue("Test Yeri");
        cell8.setCellStyle(style);
        Cell cell8_1 = row5.createCell(1);
        cell8_1.setCellValue("IZMIT");


        Cell cell9 = row5.createCell(2);
        cell9.setCellValue("Resim No ");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell9.setCellValue("Resim No");
        cell9.setCellStyle(style);
        Cell cell9_1 = row5.createCell(3);
        cell9_1.setCellValue("-");


        Cell cell10 = row5.createCell(4);
        cell10.setCellValue("Rapor Tarihi ");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell10.setCellValue("Rapor Tarihi");
        cell10.setCellStyle(style);
        Cell cell10_1 = row5.createCell(5);
        cell10_1.setCellValue("12/12/2018");

        Row row6 = sheet.createRow(5);
        Cell cell11 = row6.createCell(0);
        cell11.setCellValue("Muayene Standardı ");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell11.setCellValue("Muayene Standardı");
        cell11.setCellStyle(style);
        Cell cell11_1 = row6.createCell(1);
        cell11_1.setCellValue("TS EN ISO 17635");


        Cell cell12 = row6.createCell(2);
        cell12.setCellValue("Yüzey Durumu ");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell12.setCellValue("Yüzey Durumu");
        cell12.setCellStyle(style);
        Cell cell12_1 = row6.createCell(3);
        cell12_1.setCellValue("After Welding");


        Cell cell13 = row6.createCell(4);
        cell13.setCellValue("İş Emri No ");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell13.setCellValue("İş EMri No");
        cell13.setCellStyle(style);
        Cell cell13_1 = row6.createCell(5);
        cell13_1.setCellValue("2604");

        Row row7 = sheet.createRow(6);
        Cell cell14 = row7.createCell(0);
        cell14.setCellValue("Değerlendirme Standardı ");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell14.setCellValue("Değerlendirme Standardı");
        cell14.setCellStyle(style);
        Cell cell14_1 = row7.createCell(1);
        cell14_1.setCellValue("TS EN ISO 23278 Class B");


        Cell cell15 = row7.createCell(2);
        cell15.setCellValue("Muayene Aşaması ");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell15.setCellValue("Muayene Aşaması");
        cell15.setCellStyle(style);
        Cell cell15_1 = row7.createCell(3);
        cell15_1.setCellValue("Untreated");


        Cell cell16= row7.createCell(4);
        cell16.setCellValue(" Teklif No");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell16.setCellValue("Teklif No");
        cell16.setCellStyle(style);
        Cell cell16_1 = row7.createCell(5);
        cell16_1.setCellValue("330-2018");

        Row row8 = sheet.createRow(7);
        Cell cell17 = row8.createCell(2);
        cell17.setCellValue("EKİPMAN BİLGİLERİ");

        Row row9 = sheet.createRow(8);
        Cell cell18= row9.createCell(0);
        cell18.setCellValue(" Kutup Mesafesi");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell18.setCellValue("Kutup Mesafesi");
        cell18.setCellStyle(style);
        Cell cell18_1 = row9.createCell(1);
        cell18_1.setCellValue("100 mm");

        Cell cell19= row9.createCell(2);
        cell19.setCellValue("Muayene Bölgesi");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell19.setCellValue("Muayene Bölgesi");
        cell19.setCellStyle(style);
        Cell cell19_1 = row9.createCell(3);
        cell19_1.setCellValue("KAYNAK+HAZ");

        Cell cell20= row9.createCell(4);
        cell20.setCellValue("Yüzey Sıcaklığı");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell20.setCellValue("Yüzey Sıcaklığı");
        cell20.setCellStyle(style);
        Cell cell20_1 = row9.createCell(5);
        cell20_1.setCellValue("15 C");

        Row row10 = sheet.createRow(9);
        Cell cell21= row10.createCell(0);
        cell21.setCellValue("Cihaz");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell21.setCellValue("Cihaz");
        cell21.setCellStyle(style);
        Cell cell21_1 = row10.createCell(1);
        cell21_1.setCellValue("NAWOO Sn:12546");

        Cell cell22= row10.createCell(2);
        cell22.setCellValue("Akım Tipi");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell22.setCellValue("Akım Tipi");
        cell22.setCellStyle(style);
        Cell cell22_1 = row10.createCell(3);
        cell22_1.setCellValue("AC");

        Cell cell23= row10.createCell(4);
        cell23.setCellValue("Muayene Bölgesi Alan Şiddeti");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell23.setCellValue("Muayene Bölgesi Alan Şiddeti");
        cell23.setCellStyle(style);
        Cell cell23_1 = row10.createCell(5);
        cell23_1.setCellValue("3.2kA/m");

        Row row11 = sheet.createRow(10);
        Cell cell24= row11.createCell(0);
        cell24.setCellValue("MP Taşıyıcı Ortam");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell24.setCellValue("MP Taşıyıcı Ortam");
        cell24.setCellStyle(style);
        Cell cell24_1 = row11.createCell(1);
        cell24_1.setCellValue("BT-20 LOT-BO35PO1");

        Cell cell25= row11.createCell(2);
        cell25.setCellValue("Işık Şiddeti");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell25.setCellValue("Işık Şiddeti");
        cell25.setCellStyle(style);
        Cell cell25_1 = row11.createCell(3);
        cell25_1.setCellValue("1200 Lux");

        Row row12 = sheet.createRow(11);
        Cell cell26= row12.createCell(0);
        cell26.setCellValue("Mıknatıslama Tekniği");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell26.setCellValue("Mıknatıslama Tekniği");
        cell26.setCellStyle(style);
        Cell cell26_1 = row12.createCell(1);
        cell26_1.setCellValue("");

        Cell cell27= row12.createCell(2);
        cell27.setCellValue("Muayene Ortamı");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell27.setCellValue("Muayene Ortamı");
        cell27.setCellStyle(style);
        Cell cell27_1 = row12.createCell(3);
        cell27_1.setCellValue("");

        Cell cell28= row12.createCell(4);
        cell28.setCellValue("Yüzey");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell28.setCellValue("Yüzey");
        cell28.setCellStyle(style);
        Cell cell28_1 = row12.createCell(5);
        cell28_1.setCellValue("TAŞLANMIŞ/GRINDING");

        Row row13 = sheet.createRow(12);
        Cell cell29= row13.createCell(0);
        cell29.setCellValue("UV Işık Şiddeti");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell29.setCellValue("UV Işık Şiddeti");
        cell29.setCellStyle(style);
        Cell cell29_1 = row13.createCell(1);
        cell29_1.setCellValue("V/m2");

        Cell cell30= row12.createCell(2);
        cell30.setCellValue("Mıknatıs Giderimi");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell30.setCellValue("Mıknatıs Giderimi");
        cell30.setCellStyle(style);
        Cell cell30_1 = row12.createCell(3);
        cell30_1.setCellValue("");

        Cell cell31= row12.createCell(4);
        cell31.setCellValue("Işık Cihaz Tanımı");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell31.setCellValue("Işık Cihaz Tanımı");
        cell30.setCellStyle(style);
        Cell cell31_1 = row12.createCell(5);
        cell31_1.setCellValue("***");

        Row row14 = sheet.createRow(13);
        Cell cell32= row14.createCell(0);
        cell32.setCellValue("Işık Mesafesi");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell32.setCellValue("Işık Mesafesi");
        cell32.setCellStyle(style);
        Cell cell32_1 = row14.createCell(1);
        cell32_1.setCellValue("mm");

        Cell cell33= row14.createCell(2);
        cell33.setCellValue("Isıl İşlem");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell33.setCellValue("Isıl İşlem");
        cell33.setCellStyle(style);
        Cell cell33_1 = row14.createCell(3);
        cell33_1.setCellValue("");

        Cell cell34= row14.createCell(4);
        cell34.setCellValue("Kaldırma Testi Tarihi");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell34.setCellValue("Kaldırma Testi Tarihi");
        cell34.setCellStyle(style);
        Cell cell34_1 = row14.createCell(5);
        cell34_1.setCellValue("10.02.2019/LT95235");

        Row row15 = sheet.createRow(14);
        Cell cell35 = row15.createCell(2);
        cell35.setCellValue("Süreksizliğin Yeri");

        Row row16 = sheet.createRow(15);
        Cell cell36= row16.createCell(3);
        cell36.setCellValue("BM");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell36.setCellValue("BM");
        cell36.setCellStyle(style);
        Cell cell36_1 = row16.createCell(4);
        cell36_1.setCellValue("Ana Metal/Base Metal");

        Row row17 = sheet.createRow(16);
        Cell cell37= row17.createCell(3);
        cell37.setCellValue("HAZ");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell37.setCellValue("HAZ");
        cell37.setCellStyle(style);
        Cell cell37_1 = row16.createCell(4);
        cell37_1.setCellValue("Isıdan etkilene bölge/Host effected zone");

        Row row18 = sheet.createRow(17);
        Cell cell38= row18.createCell(3);
        cell38.setCellValue("W");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell38.setCellValue("W");
        cell38.setCellStyle(style);
        Cell cell38_1 = row18.createCell(4);
        cell38_1.setCellValue("Kaynak/Weld");

        Row row19 = sheet.createRow(18);
        Cell cell39= row19.createCell(3);
        cell39.setCellValue("B");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell39.setCellValue("B");
        cell39.setCellStyle(style);
        Cell cell39_1 = row19.createCell(4);
        cell39_1.setCellValue("Kaynak Ağız/Bewel");

        Row row20 = sheet.createRow(19);
        Cell cell40= row20.createCell(0);
        cell40.setCellValue("Standart Sapmalar");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell40.setCellValue("Standart Sapmalar");
        cell40.setCellStyle(style);
        Cell cell40_1 = row20.createCell(1);
        cell40_1.setCellValue("Standart sapma yoktur");

        Row row21 = sheet.createRow(20);
        Cell cell41= row21.createCell(0);
        cell41.setCellValue("Muayene Tarihleri");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell41.setCellValue("Muayene Tarihleri");
        cell41.setCellStyle(style);
        Cell cell41_1 = row21.createCell(1);
        cell41_1.setCellValue("10/16/2019");

        Row row22 = sheet.createRow(21);
        Cell cell42= row22.createCell(0);
        cell42.setCellValue("Açıklamalar ve Ekler");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell42.setCellValue("Açıklamalar ve Ekler");
        cell42.setCellStyle(style);
        Cell cell42_1 = row22.createCell(1);
        cell42_1.setCellValue("");

        Row row23 = sheet.createRow(22);
        Cell cell43 = row23.createCell(3);
        cell43.setCellValue("MUAYENE SONUÇLARI");

        Row row24 = sheet.createRow(23);
        Cell cell44= row24.createCell(0);
        cell44.setCellValue("Seri No");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell44.setCellValue("Seri No");
        cell44.setCellStyle(style);
        Row row25 = sheet.createRow(24);
        Cell cell44_1 = row25.createCell(0);
        cell44_1.setCellValue("1");

        Cell cell45= row24.createCell(1);
        cell45.setCellValue("Kaynak/Parça No");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell45.setCellValue("Kaynak/Parça No");
        cell45.setCellStyle(style);
        Cell cell45_1 = row25.createCell(1);
        cell45_1.setCellValue("TÜRKER ATAGÜL PC");

        Cell cell46= row24.createCell(2);
        cell46.setCellValue("Kontrol Uzunluğu");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell46.setCellValue("Kontrol Uzunluğu");
        cell46.setCellStyle(style);
        Cell cell46_1 = row25.createCell(2);
        cell46_1.setCellValue("300");

        Cell cell47= row24.createCell(3);
        cell47.setCellValue("Kaynak Yön.");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell47.setCellValue("Kaynak Yön.");
        cell47.setCellStyle(style);
        Cell cell47_1 = row25.createCell(3);
        cell47_1.setCellValue("FCAW(136)");

        Cell cell48= row24.createCell(4);
        cell48.setCellValue("Kalınlık");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell48.setCellValue("Kalınlık");
        cell48.setCellStyle(style);
        Cell cell48_1 = row25.createCell(4);
        cell48_1.setCellValue("12");

        Cell cell49= row24.createCell(5);
        cell49.setCellValue("Çap");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell49.setCellValue("Çap");
        cell49.setCellStyle(style);
        Cell cell49_1 = row25.createCell(5);
        cell49_1.setCellValue("-");

        Cell cell50= row24.createCell(6);
        cell50.setCellValue("Hata Tipi");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell50.setCellValue("Hata Tipi");
        cell50.setCellStyle(style);
        Cell cell50_1 = row25.createCell(6);
        cell50_1.setCellValue("");

        Cell cell51= row24.createCell(7);
        cell51.setCellValue("Hatanın Yeri");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell51.setCellValue("Hatanın Yeri");
        cell51.setCellStyle(style);
        Cell cell51_1 = row25.createCell(7);
        cell51_1.setCellValue("");

        Cell cell52= row24.createCell(8);
        cell52.setCellValue("Sonuç");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell52.setCellValue("Sonuç");
        cell52.setCellStyle(style);
        Cell cell52_1 = row25.createCell(8);
        cell52_1.setCellValue("OK");

        Row row26 = sheet.createRow(25);
        Cell cell53= row26.createCell(0);
        cell53.setCellValue("2");
        Cell cell53_1 = row26.createCell(1);
        cell53_1.setCellValue("TÜRKER ATAGÜL PF");

        Cell cell54= row26.createCell(2);
        cell54.setCellValue("300");
        Cell cell54_1 = row26.createCell(3);
        cell54_1.setCellValue("FCAW(136)");

        Cell cell55= row26.createCell(4);
        cell55.setCellValue("12");
        Cell cell55_1 = row26.createCell(5);
        cell55_1.setCellValue("-");

        Cell cell56= row26.createCell(6);
        cell56.setCellValue("");
        Cell cell56_1 = row26.createCell(7);
        cell56_1.setCellValue("");

        Cell cell57= row26.createCell(8);
        cell57.setCellValue("OK");

        Row row27 = sheet.createRow(26);
        Cell cell58= row27.createCell(0);
        cell58.setCellValue("3");
        Cell cell58_1 = row27.createCell(1);
        cell58_1.setCellValue("TÜRKER ATAGÜL PD");

        Cell cell59= row27.createCell(2);
        cell59.setCellValue("300");
        Cell cell59_1 = row27.createCell(3);
        cell59_1.setCellValue("FCAW(136)");

        Cell cell60= row27.createCell(4);
        cell60.setCellValue("12");
        Cell cell60_1 = row27.createCell(5);
        cell60_1.setCellValue("-");

        Cell cell61= row27.createCell(6);
        cell61.setCellValue("");
        Cell cell61_1 = row27.createCell(7);
        cell61_1.setCellValue("");

        Cell cell62= row27.createCell(8);
        cell62.setCellValue("OK");

        Row row28 = sheet.createRow(27);
        Cell cell63= row28.createCell(0);
        cell63.setCellValue("4");
        Cell cell63_1 = row28.createCell(1);
        cell63_1.setCellValue("TÜRKER ATAGÜL PC");

        Cell cell64= row28.createCell(2);
        cell64.setCellValue("300");
        Cell cell64_1 = row28.createCell(3);
        cell64_1.setCellValue("SMAW(111)");

        Cell cell65= row28.createCell(4);
        cell65.setCellValue("12");
        Cell cell65_1 = row28.createCell(5);
        cell65_1.setCellValue("-");

        Cell cell66= row28.createCell(6);
        cell66.setCellValue("");
        Cell cell66_1 = row28.createCell(7);
        cell66_1.setCellValue("");

        Cell cell67= row28.createCell(8);
        cell67.setCellValue("OK");

        Row row29 = sheet.createRow(28);
        Cell cell68= row29.createCell(0);
        cell68.setCellValue("5");
        Cell cell68_1 = row29.createCell(1);
        cell68_1.setCellValue("TÜRKER ATAGÜL PF");

        Cell cell69= row29.createCell(2);
        cell69.setCellValue("300");
        Cell cell69_1 = row29.createCell(3);
        cell69_1.setCellValue("SMAW(111)");

        Cell cell70= row29.createCell(4);
        cell70.setCellValue("12");
        Cell cell70_1 = row29.createCell(5);
        cell70_1.setCellValue("-");

        Cell cell71= row29.createCell(6);
        cell71.setCellValue("");
        Cell cell71_1 = row29.createCell(7);
        cell71_1.setCellValue("");

        Cell cell72= row29.createCell(8);
        cell72.setCellValue("OK");

        Row row30 = sheet.createRow(29);
        Cell cell73= row30.createCell(0);
        cell73.setCellValue("6");
        Cell cell73_1 = row30.createCell(1);
        cell73_1.setCellValue("TÜRKER ATAGÜL PD");

        Cell cell74= row30.createCell(2);
        cell74.setCellValue("300");
        Cell cell74_1 = row30.createCell(3);
        cell74_1.setCellValue("SMAW(111)");

        Cell cell75= row30.createCell(4);
        cell75.setCellValue("12");
        Cell cell75_1 = row30.createCell(5);
        cell75_1.setCellValue("-");

        Cell cell76= row30.createCell(6);
        cell76.setCellValue("");
        Cell cell76_1 = row30.createCell(7);
        cell76_1.setCellValue("");

        Cell cell77= row30.createCell(8);
        cell77.setCellValue("OK");

        Row row31 = sheet.createRow(30);
        Cell cell78= row31.createCell(0);
        cell78.setCellValue("7");
        Cell cell78_1 = row31.createCell(1);
        cell78_1.setCellValue("TÜRKER ATAGÜL H045");

        Cell cell79= row31.createCell(2);
        cell79.setCellValue("300");
        Cell cell79_1 = row31.createCell(3);
        cell79_1.setCellValue("TIG(141)");

        Cell cell80= row31.createCell(4);
        cell80.setCellValue("4");
        Cell cell80_1 = row31.createCell(5);
        cell80_1.setCellValue("4");

        Cell cell81= row31.createCell(6);
        cell81.setCellValue("");
        Cell cell81_1 = row31.createCell(7);
        cell81_1.setCellValue("");

        Cell cell82_1 = row31.createCell(8);
        cell82_1.setCellValue("OK");

        Row row32 = sheet.createRow(31);
        Cell cell83= row32.createCell(0);
        cell83.setCellValue("8");

        Row row33 = sheet.createRow(32);
        Cell cell84= row33.createCell(0);
        cell84.setCellValue("9");

        Row row34 = sheet.createRow(33);
        Cell cell85= row34.createCell(0);
        cell85.setCellValue("9");

        Row row35 = sheet.createRow(34);
        Cell cell86= row35.createCell(0);
        cell86.setCellValue("10");

        Row row36 = sheet.createRow(35);
        Cell cell87= row36.createCell(0);
        cell87.setCellValue("11");

        Row row37 = sheet.createRow(36);
        Cell cell88= row37.createCell(0);
        cell88.setCellValue("12");

        Row row38 = sheet.createRow(37);
        Cell cell89= row38.createCell(0);
        cell89.setCellValue("13");

        Row row39 = sheet.createRow(38);
        Cell cell90= row39.createCell(0);
        cell90.setCellValue("14");

        Row row40 = sheet.createRow(39);
        Cell cell91= row40.createCell(0);
        cell91.setCellValue("Personal Bilgileri");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell91.setCellValue("Personal Bilgileri");
        cell91.setCellStyle(style);
        Cell cell91_1 = row40.createCell(1);
        cell91_1.setCellValue("Operator");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell91_1.setCellValue("Operator");
        cell91_1.setCellStyle(style);

        Cell cell92= row40.createCell(2);
        cell92.setCellValue("Değerlendiren");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell92.setCellValue("Değerlendiren");
        cell92.setCellStyle(style);
        Cell cell92_1 = row40.createCell(3);
        cell92_1.setCellValue("Onay");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell92_1.setCellValue("Onay");
        cell92_1.setCellStyle(style);
        Cell cell93 = row40.createCell(4);
        cell93.setCellValue("Müşteri");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell93.setCellValue("Müşteri");
        cell93.setCellStyle(style);

        Row row41 = sheet.createRow(40);
        Cell cell94= row41.createCell(0);
        cell94.setCellValue("Adı-Soyadı");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell94.setCellValue("Adı-Soyadı");
        cell94.setCellStyle(style);
        Cell cell94_1 = row41.createCell(1);
        cell94_1.setCellValue("fsdf");

        Cell cell95= row41.createCell(2);
        cell95.setCellValue("fadsfasfssa");
        Cell cell95_1 = row41.createCell(3);
        cell95_1.setCellValue("fasdsdafsa");

        Cell cell96= row41.createCell(4);
        cell96.setCellValue("");

        Row row42 = sheet.createRow(41);
        Cell cell97= row42.createCell(0);
        cell97.setCellValue("Seviye");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell97.setCellValue("Seviye");
        cell97.setCellStyle(style);
        Cell cell97_1 = row42.createCell(1);
        cell97_1.setCellValue("LEVEL2");

        Cell cell98= row42.createCell(2);
        cell98.setCellValue("LEVEL2");
        Cell cell98_1 = row42.createCell(3);
        cell98_1.setCellValue("LEVEL3");



        Row row43 = sheet.createRow(42);
        Cell cell99= row43.createCell(0);
        cell99.setCellValue("Tarih");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell99.setCellValue("Tarih");
        cell99.setCellStyle(style);
        Cell cell99_1 = row43.createCell(1);
        cell99_1.setCellValue("10/16/2019");

        Cell cell100= row43.createCell(2);
        cell100.setCellValue("10/16/2019");
        Cell cell100_1 = row43.createCell(3);
        cell100_1.setCellValue("10/16/2019");

        Row row44 = sheet.createRow(43);
        Cell cell101= row44.createCell(0);
        cell101.setCellValue("İmza");
        style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(FillPatternType.DIAMONDS);
        cell101.setCellValue("İmza");
        cell101.setCellStyle(style);


        int rowCount = 1;

       while (result.next()) {
             row = sheet.createRow(rowCount++);

            for (int i = 1; i <= numberOfColumns; i++) {
                Object valueObject = result.getObject(i);
                Cell cell = row.createCell(i - 1);


                if (valueObject instanceof Boolean)
                    cell.setCellValue((Boolean) valueObject);
                else if (valueObject instanceof Double)
                    cell.setCellValue((double) valueObject);
                else if (valueObject instanceof Float)
                    cell.setCellValue((float) valueObject);
                else if (valueObject instanceof Date) {
                    cell.setCellValue((Date) valueObject);
                    formatDateCell(workbook, cell);
                } else cell.setCellValue((String) valueObject);

            }

        }
    }




    private static void formatDateCell(XSSFWorkbook workbook, Cell cell) {

        CellStyle cellStyle = workbook.createCellStyle();


        CreationHelper creationHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd_HH-mm-ss"));

        cell.setCellStyle(cellStyle);
    }



    static void writeHeaderLine(ResultSet result, XSSFSheet sheet) throws SQLException {
        ResultSetMetaData metaData = result.getMetaData();
        int numberOfColumns = metaData.getColumnCount();

        Row headerRow = sheet.createRow(0);




        for (int i = 1; i <= numberOfColumns; i++)
           {

                    String columnName = metaData.getColumnName(i);
                    Cell headerCell = headerRow.createCell(i - 1);
                    headerCell.setCellValue(columnName);

        }
    }


    
}




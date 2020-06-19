import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
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

        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
           String sql = "SELECT * FROM ".concat(proje);



            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);


            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet = workbook.createSheet(proje);

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

        int rowCount = 1;

        while (result.next()) {
            Row row = sheet.createRow(rowCount++);

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



    private static void writeHeaderLine(ResultSet result, XSSFSheet sheet) throws SQLException {
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




import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.Date;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import javax.swing.*;

public class AdvancedDb2ExcelExporter {
    public static void main(String[] args) {
        AdvancedDb2ExcelExporter exporter = new AdvancedDb2ExcelExporter();
        exporter.export("yonetici");
        exporter.export("muayene");
        exporter.export("musteri");
        exporter.export("ekipman_bilgileri");
        exporter.export("muayenesonucları");
        
        
    }
    private String getFileName(String baseName) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String dateTimeInfo = dateFormat.format(new Date());
        return baseName.concat(String.format("yonetici.xlsx", dateTimeInfo));}

    private void export(String yonetici) {
        String url = "jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        String user = "root";
        String pass = "Kule1845";
        String excelFilePath = getFileName(yonetici.concat("_Export"));
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT * FROM ".concat(yonetici);

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(yonetici);

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

    private void writeDataLines(ResultSet result, XSSFWorkbook workbook, XSSFSheet sheet)throws SQLException {
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

    private void formatDateCell(XSSFWorkbook workbook, Cell cell) {
        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper creationHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
        cell.setCellStyle(cellStyle);
    }



    private void writeHeaderLine(ResultSet result, XSSFSheet sheet) throws SQLException {
        ResultSetMetaData metaData = result.getMetaData();
        int numberOfColumns = metaData.getColumnCount();

        Row headerRow = sheet.createRow(0);


        // exclude the first column which is the ID field
        for (int i = 1; i <= numberOfColumns; i++) {
            String columnName = metaData.getColumnName(i);
            Cell headerCell = headerRow.createCell(i - 1);
            headerCell.setCellValue(columnName);
        }
    }
    }




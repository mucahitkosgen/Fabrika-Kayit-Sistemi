import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public class excel {
    public static void main(String[]args) throws IOException {
        Workbook wb=new HSSFWorkbook();
        FileOutputStream fileOut=new FileOutputStream("workbook.xls");
        wb.write(fileOut);
        fileOut.close();

    }
}

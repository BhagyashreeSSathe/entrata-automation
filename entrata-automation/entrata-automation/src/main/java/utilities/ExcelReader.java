package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    private Workbook workbook;

    public ExcelReader(String filePath) throws IOException {
        FileInputStream inputStream = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(inputStream);
    }

    public String getCellData(String sheetName, int rowNumber, int colNumber) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(colNumber);
        return cell.toString();
    }

    public void close() throws IOException {
        workbook.close();
    }
}

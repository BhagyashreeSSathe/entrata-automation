package Tests;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    private String filePath;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }

    public String[] getData(String sheetName, int rowNum) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        Row row = sheet.getRow(rowNum);
        String[] data = new String[row.getPhysicalNumberOfCells()];

        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            Cell cell = row.getCell(i);
            data[i] = cell.toString();
        }

        workbook.close();
        fis.close();

        return data;
    }
}

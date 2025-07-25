
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;

public class ExcelReader {
    private Sheet sheet;

    public ExcelReader(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fis);
            this.sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCellData(int row, int column) {
        Row r = sheet.getRow(row);
        if (r == null) return "";

        Cell c = r.getCell(column);
        if (c == null) return "";

        switch (c.getCellType()) {
            case STRING:
                return c.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(c)) {
                    return c.getDateCellValue().toString();
                } else {
                    double val = c.getNumericCellValue();
                    if (val == (long) val) {
                        return String.valueOf((long) val);
                    } else {
                        return String.valueOf(val);
                    }
                }
            case BOOLEAN:
                return String.valueOf(c.getBooleanCellValue());
            case FORMULA:
                return c.getCellFormula();
            default:
                return "";
        }
    }
}

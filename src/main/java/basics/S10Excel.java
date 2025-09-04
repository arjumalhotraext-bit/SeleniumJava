package basics;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class S10Excel {
    public static void main(String[] args) throws IOException {
        String[][] data = getUserPassData("C:\\Users\\arjumalhotra.ext\\Downloads\\doc.xlsx");
        for (String[] pair : data) {
            System.out.println("{" + pair[0] + ", " + pair[1] + "}");
        }
    }

    public static String[][] getUserPassData(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("testdata");

        int rowCount = sheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowCount - 1][2];

        Row firstRow = sheet.getRow(0);
        int usernameCol = -1, passwordCol = -1;
        for (int j = 0; j < firstRow.getLastCellNum(); j++) {
            String colName = firstRow.getCell(j).getStringCellValue();
            if (colName.equalsIgnoreCase("Username")) usernameCol = j;
            if (colName.equalsIgnoreCase("Password")) passwordCol = j;
        }

        for (int i = 1; i < rowCount; i++) {
            Row r = sheet.getRow(i);
            data[i - 1][0] = r.getCell(usernameCol).getStringCellValue();
            data[i - 1][1] = r.getCell(passwordCol).getStringCellValue();
        }

        workbook.close();
        return data;
    }

    // Practice not related to above thing
    // List<String> myList = new ArrayList<>();
    // myList.add("S");
}

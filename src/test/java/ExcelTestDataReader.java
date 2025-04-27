import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelTestDataReader {
    public static List<LoginTestData> readLoginTestData(String filePath) throws IOException {
        List<LoginTestData> testDataList = new ArrayList<>();

        Workbook workbook = WorkbookFactory.create(new File(filePath));
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            LoginTestData testData = new LoginTestData(
                    row.getCell(0).toString(),
                    row.getCell(1).toString(),
                    row.getCell(2).toString(),
                    row.getCell(3).toString(),
                    row.getCell(4).toString(),
                    row.getCell(5).toString(),
                    Boolean.parseBoolean(row.getCell(6).toString()),
                    Boolean.parseBoolean(row.getCell(7).toString())
            );

            testDataList.add(testData);
        }

        workbook.close();
        return testDataList;
    }
}

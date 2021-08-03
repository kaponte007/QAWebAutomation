package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    private static Sheet testingData = null;
    private static FileInputStream inputStream;
    private static Workbook myWorkbook;
    private static File file;
    private static int lastRowNumber = -1;

    public static Sheet readExcel(String fileName, String sheetName) throws IOException {
        String filePath = "./src/test/resources";
        Sheet mySheet = null;

        file = new File(filePath + "/" + fileName);
        inputStream = new FileInputStream(file);

        myWorkbook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));


        if (fileExtensionName.equals(".xlsx")) {
            myWorkbook = new XSSFWorkbook(inputStream);
        } else if (fileExtensionName.equals(".xls")) {
            myWorkbook = new HSSFWorkbook(inputStream);
        }

        mySheet = myWorkbook != null ? myWorkbook.getSheet(sheetName) : null;
        return mySheet;
    }

    public static Sheet readExcel(String fileName) throws IOException {
        final String defaultSheet = "Sheet1";
        return readExcel(fileName, defaultSheet);
    }

    /*
    Return a String array where:
     pos 0 = username
     pos 1 = password
     */
    public static String[] getUsernamePassFromExcel() throws IOException {
        final String fileName = "credential.xlsx";
        String[] credentials = new String[2];
        Sheet mySheet = readExcel(fileName);

        System.out.println("Getting credencials from Excel sheet");
        credentials[0] = mySheet.getRow(1).getCell(0).getStringCellValue(); //Username
        credentials[1] = mySheet.getRow(1).getCell(1).getStringCellValue(); //Password
        return credentials;
    }

    public static String getUrlFromExcel() throws IOException {
        final String fileName = "credential.xlsx";
        String url = null;
        Sheet mySheet = readExcel(fileName);

        System.out.println("Getting URL from Excel sheet");
        url = mySheet.getRow(1).getCell(2).getStringCellValue();
        return url;
    }

    public static void loadTestingData(String fileName, String sheetName) throws IOException {
        System.out.println("Loading testing data from: " + fileName + " [Sheet: " + sheetName + "]");
        testingData = readExcel(fileName, sheetName);
    }

    public static String getPropertyFromTestDataFile(String field) throws IOException {
        String fieldValue = "";
        boolean done = false;

        if (testingData == null) {
            loadTestingData("testingDataExcel.xlsx", "MainPageValidation1");
        }

        for (Row row : testingData) {
            DataFormatter formatter = new DataFormatter();
            for (Cell cell : row) {
                if (done) break;
                String text = formatter.formatCellValue(cell);

                if (!text.isEmpty() && field.equals(text)) {
                    fieldValue = formatter.formatCellValue(row.getCell(1));
                    done = true;
                    break;
                }
            }
        }
        return fieldValue;
    }

    public static void writeInExcel(String field, String value) throws Exception {
        boolean done = false;
        if (testingData == null) {
            loadTestingData("testingDataExcel.xlsx", "ErrorValidation");
        }
        for (Row row : testingData) {
            if (done) break;
            DataFormatter formatter = new DataFormatter();
            for (Cell cell : row) {
                String text = formatter.formatCellValue(cell);

                if (!text.isEmpty() && field.equals(text)) {
                    row.getCell(1).setCellValue(value);
                    done = true;
                    saveExcel();
                    break;
                }
            }
        }
    }

    public static void saveExcel() throws Exception {
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        myWorkbook.write(outputStream);
        outputStream.close();
    }

    public static void updateHistory(String scenario, String ro, String claim) throws Exception {
        int rowNumber = getLastRowNumber() < 1 ? 1 : getLastRowNumber() + 1;
        if (claim == null) {
            claim = "";
        }
        Row row = testingData.createRow(rowNumber);
        row.createCell(0).setCellValue(scenario);
        row.createCell(1).setCellValue(ro);
        row.createCell(2).setCellValue(claim);
        lastRowNumber++;
    }


    private static int getLastRowNumber() {
        if (lastRowNumber < 1) {
            lastRowNumber = testingData.getLastRowNum();
        }
        return lastRowNumber;
    }

    public static void WriteLogTimeExcel(String scenario) throws Exception {
        loadTestingData("testingDataExcel.xlsx", "Time_logs");
        GeneralUtils.addEndScenarioLog();
        List<String> list = GeneralUtils.getList();

        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                Row row = testingData.createRow(testingData.getLastRowNum() + 1);
                row.createCell(0).setCellValue(str.substring(0, str.indexOf("/")));
                str = str.substring(str.indexOf("/") + 1);
                row.createCell(1).setCellValue(str.substring(0, str.indexOf("/")));
                str = str.substring(str.indexOf("/") + 1);
                row.createCell(2).setCellValue(str.substring(0, str.indexOf("/")));
                str = str.substring(str.indexOf("/") + 1);
                row.createCell(3).setCellValue(str.substring(0, str.indexOf("/")));
                row.createCell(4).setCellValue(str.substring(str.indexOf("/") + 1));
                row.createCell(5).setCellValue(scenario);
            }
            saveExcel();
        }
        GeneralUtils.clearLogs();
    }

    public static void isExcelFileOpened() throws Exception {
        final String filePath = "./src/test/resources/testingDataExcel.xlsx";
        File file = new File(filePath);

        try {
            FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
        } catch (Exception e) {
            throw new Exception("testingDataExcel.xlsx file is opened. Please close it and re run the test");
        }
    }
}
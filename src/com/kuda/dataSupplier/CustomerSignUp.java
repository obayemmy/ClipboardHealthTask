package com.kuda.dataSupplier;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class CustomerSignUp {
    @DataProvider(name = "Register")
    public static Object[][] customerSignUp() throws Exception {

        FileInputStream file = new FileInputStream("./TestData/LoginData.xlsx");
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet loginSheet = book.getSheet("customerSignUp");
        int numberOfData = loginSheet.getPhysicalNumberOfRows();
        Object[][] testData = new Object[numberOfData][5];

        for (int i = 0; i < numberOfData; i++) {
            XSSFRow row = loginSheet.getRow(i);
            XSSFCell fullName = row.getCell(0);
            XSSFCell phoneNumber = row.getCell(1);
            XSSFCell passwords = row.getCell(2);
            XSSFCell confirmPassword = row.getCell(3);
            XSSFCell Cemail = row.getCell(4);

            testData[i][0] = fullName.getStringCellValue();
            testData[i][1] = phoneNumber.getStringCellValue();
            testData[i][2] = passwords.getStringCellValue();
            testData[i][3] = confirmPassword.getStringCellValue();
            testData[i][4] = Cemail.getStringCellValue();

        }
        return testData;
    }

}

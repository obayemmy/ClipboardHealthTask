package com.kuda.dataSupplier;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class CustomerInfoDetails {
    @DataProvider(name = "customer")
    public static Object[][] customer() throws Exception {

        FileInputStream file = new FileInputStream("./TestData/LoginData.xlsx");
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet customerID = book.getSheet("customerInfo");
        int numberOfData = customerID.getPhysicalNumberOfRows();
        Object[][] testData = new Object[numberOfData][1];

        for (int i = 0; i < numberOfData; i++) {
            XSSFRow row = customerID.getRow(i);
            XSSFCell custID = row.getCell(0);
//			XSSFCell bookeremail = row.getCell(1);
//			XSSFCell pNumber = row.getCell(2);
//			XSSFCell kinName= row.getCell(3);
//			XSSFCell kinPhone = row.getCell(4);

            testData[i][0] = custID.getStringCellValue();
//			testData[i][1] = bookeremail.getStringCellValue();
//			testData[i][2] = pNumber.getStringCellValue();
//			testData[i][3] = kinName.getStringCellValue();
//			testData[i][4] = kinPhone.getStringCellValue();

        }
        return testData;
    }

}

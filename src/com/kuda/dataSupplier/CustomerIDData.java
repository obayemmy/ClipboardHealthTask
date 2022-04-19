package com.kuda.dataSupplier;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CustomerIDData {
    public static void writeDataToExcel(String custIdentifier) throws IOException {
        String path = "./TestData/LoginData.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("customerInfo");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue(custIdentifier);
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        fos.close();
    }
}

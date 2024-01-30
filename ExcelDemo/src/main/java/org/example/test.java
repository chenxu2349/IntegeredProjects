package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xuchen22
 */
public class test {
    public static void main(String[] args) {

        String path = "D:\\EXCEL工具类\\test.xlsx";

        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet0 = workbook.getSheetAt(0);

            // 初始化项目维度表头
            sheet0.shiftRows(2, sheet0.getLastRowNum(), 1, true, true);
//            Row row0 = sheet0.createRow(0);
//            row0.createCell(0).setCellValue("这是插入的一行。。。");

            FileOutputStream fos = new FileOutputStream(path);
            workbook.write(fos);
            System.out.println("插入成功");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

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
public class Init {
    public static void main(String[] args) {

        String path = "D:\\EXCEL工具类\\out.xlsx";

        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet0 = workbook.getSheetAt(0);
            Sheet sheet1 = workbook.getSheetAt(1);
            Sheet sheet2 = workbook.getSheetAt(2);

            // 初始化项目维度表头
            Row row0 = sheet0.createRow(0);
            row0.createCell(0).setCellValue("项目名称 - 工时挂靠的项目");
            row0.createCell(1).setCellValue("共计（人月）");
            row0.createCell(2).setCellValue("占比");
            row0.createCell(3).setCellValue("Q1/人月");
            row0.createCell(4).setCellValue("Q2/人月");
            row0.createCell(5).setCellValue("Q3/人月");
            row0.createCell(6).setCellValue("Q4/人月");

            // 初始化需求维度表头
            Row row1 = sheet1.createRow(0);
            row1.createCell(0).setCellValue("需求名称");
            row1.createCell(1).setCellValue("共计（人月）");
            row1.createCell(2).setCellValue("项目名称 - 工时挂靠的项目");

            // 初始化人员维度表头
            Row row2 = sheet2.createRow(0);
            row2.createCell(0).setCellValue("姓名");
            row2.createCell(1).setCellValue("共计（人月）");
            row2.createCell(2).setCellValue("占比");
            row2.createCell(3).setCellValue("项目名称 - 工时挂靠的项目");

            FileOutputStream fos = new FileOutputStream(path);
            workbook.write(fos);
            System.out.println("初始化成功");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

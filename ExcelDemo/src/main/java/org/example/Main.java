package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFDialogsheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        /**
         * 说明：代码使用字符串做键存储数据，请确保同一个项目的字符串是一模一样的，不能出现多一个空格、标点之类的
         * **/

        String configPath = args[0];
        AppConfig.loadConfig(configPath);
        // 月度导出结果文件夹
        String sourceFolder = AppConfig.getProperty("sourceFolder");
        // 汇总表文件地址
        String targetExcelFilePath = AppConfig.getProperty("targetExcelFilePath");

        File folder = new File(sourceFolder);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));

        for (File file : files) {
            fun1(file, targetExcelFilePath);
        }

        Thread.sleep(500);

        for (File file : files) {
            fun2(file, targetExcelFilePath);
        }

        Thread.sleep(500);

        for (File file : files) {
            fun3(file, targetExcelFilePath);
        }

    }

    // 项目维度分析（sheet1）
    private static void fun1(File sourceFile, String targetPath) {

        try (FileInputStream fis1 = new FileInputStream(sourceFile);
             Workbook sourceWorkbook = new XSSFWorkbook(fis1);
             FileInputStream fis2 = new FileInputStream(targetPath);
             Workbook targetWorkbook = new XSSFWorkbook(fis2)) {

            Sheet sheet0 = sourceWorkbook.getSheetAt(1);
            Sheet sheet1 = targetWorkbook.getSheetAt(0);
            String startTime = getCellValue(sheet0.getRow(2).getCell(3));
            String endTime = getCellValue(sheet0.getRow(2).getCell(4));

            // 1.填写工作量（人月）所处列的时间段信息，并且每多一个文件就多添加一列
            int colNumber = sheet1.getRow(0).getPhysicalNumberOfCells();
            Cell newCell0 = sheet1.getRow(0).createCell(colNumber);
            newCell0.setCellValue("工作量（人月）" + "\n" + startTime + "~" + endTime);

            // 2.遍历源文件每一行，计算不同项目的总人月数量（Map存储）
            Map<String, Double> projectWorkload = new HashMap<>();
            for (int i = 1; i < sheet0.getPhysicalNumberOfRows(); i++) {
                // 项目名称
                String projectName = getCellValue(sheet0.getRow(i).getCell(22));
                // 工作量（人月）
                Cell cell = sheet0.getRow(i).getCell(27);
                if (cell == null) {
                    continue;
                }
                double workload = cell.getNumericCellValue();
                // 累加该项目的人月数
                projectWorkload.put(projectName, projectWorkload.getOrDefault(projectName, 0.00) + workload);
            }

            // 3.回填excel表格
            // 3.1统计已有的项目所在的行数
            Map<String, Integer> existProjects = new HashMap<>();
            for (int i = 1; i < sheet1.getPhysicalNumberOfRows(); i++) {
                String cellValue = getCellValue(sheet1.getRow(i).getCell(0));
                if (cellValue.length() == 0 || cellValue == null) {
                    continue;
                } else {
                    existProjects.put(cellValue, i);
                }
            }

            // 3.2将源表统计的项目人月信息合并到目标表中
            for (String projectName : projectWorkload.keySet()) {
                if (existProjects.keySet().contains(projectName)) {
                    int row = existProjects.get(projectName);
                    Cell cell = sheet1.getRow(row).createCell(colNumber);
                    cell.setCellValue(projectWorkload.get(projectName));
                } else {
                    int rowCount = sheet1.getPhysicalNumberOfRows();
                    Row row = sheet1.createRow(rowCount);
                    Cell cell0 = row.createCell(0);
                    cell0.setCellValue(projectName);
                    Cell cell1 = row.createCell(colNumber );
                    cell1.setCellValue(projectWorkload.get(projectName));
                }
            }

            // 写回到文件
            saveChanges(targetWorkbook, targetPath);
            System.out.println("写入成功！");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 需求维度分析（sheet2）
    private static void fun2(File sourceFile, String targetPath) {

        try (FileInputStream fis1 = new FileInputStream(sourceFile);
             Workbook sourceWorkbook = new XSSFWorkbook(fis1);
             FileInputStream fis2 = new FileInputStream(targetPath);
             Workbook targetWorkbook = new XSSFWorkbook(fis2)) {

            Sheet sheet0 = sourceWorkbook.getSheetAt(1);
            Sheet sheet1 = targetWorkbook.getSheetAt(1);
            String startTime = getCellValue(sheet0.getRow(2).getCell(3));
            String endTime = getCellValue(sheet0.getRow(2).getCell(4));

            // 1.填写工作量（人月）所处列的时间段信息，并且每多一个文件就多添加一列
            int colNumber = sheet1.getRow(0).getPhysicalNumberOfCells();
            Cell newCell0 = sheet1.getRow(0).createCell(colNumber);
            newCell0.setCellValue("工作量（人月）" + "\n" + startTime + "~" + endTime);

            // 2.遍历源文件每一行，计算不同需求的总人月数量（Map存储）
            Map<String, Double> demandWorkload = new HashMap<>();
            Map<String, String> demandOfProject = new HashMap<>();
            for (int i = 1; i < sheet0.getPhysicalNumberOfRows(); i++) {
                // 需求名称
                String demandName = getCellValue(sheet0.getRow(i).getCell(19));
                // 记录需求所对应的项目
                if (demandOfProject.get(demandName) == null) {
                    String projectName = getCellValue(sheet0.getRow(i).getCell(22));
                    demandOfProject.put(demandName, projectName);
                }
                // 工作量（人月）
                Cell cell = sheet0.getRow(i).getCell(27);
                if (cell == null) {
                    continue;
                }
                double workload = cell.getNumericCellValue();
                // 累加该需求的人月数
                demandWorkload.put(demandName, demandWorkload.getOrDefault(demandName, 0.00) + workload);
            }

            // 3.回填excel表格
            // 3.1统计已有的项目所在的行数
            Map<String, Integer> existDemands = new HashMap<>();
            for (int i = 1; i < sheet1.getPhysicalNumberOfRows(); i++) {
                String cellValue = getCellValue(sheet1.getRow(i).getCell(0));
                if (cellValue.length() == 0 || cellValue == null) {
                    continue;
                } else {
                    existDemands.put(cellValue, i);
                }
            }

            // 3.2将源表统计的项目人月信息合并到目标表中
            for (String demandName : demandWorkload.keySet()) {
                if (existDemands.keySet().contains(demandName)) {
                    int row = existDemands.get(demandName);
                    Cell cell = sheet1.getRow(row).createCell(colNumber);
                    cell.setCellValue(demandWorkload.get(demandName));
                } else {
                    int rowCount = sheet1.getPhysicalNumberOfRows();
                    Row row = sheet1.createRow(rowCount);
                    Cell cell0 = row.createCell(0);
                    cell0.setCellValue(demandName);
                    Cell cell1 = row.createCell(2);
                    cell1.setCellValue(demandOfProject.get(demandName));
                    Cell cell2 = row.createCell(colNumber );
                    cell2.setCellValue(demandWorkload.get(demandName));
                }
            }

            // 写回到文件
            saveChanges(targetWorkbook, targetPath);
            System.out.println("写入成功！");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 人员维度分析（sheet3）
    private static void fun3(File sourceFile, String targetPath) {

        try (FileInputStream fis1 = new FileInputStream(sourceFile);
             Workbook sourceWorkbook = new XSSFWorkbook(fis1);
             FileInputStream fis2 = new FileInputStream(targetPath);
             Workbook targetWorkbook = new XSSFWorkbook(fis2)) {

            Sheet sheet0 = sourceWorkbook.getSheetAt(1);
            Sheet sheet1 = targetWorkbook.getSheetAt(2);
            String startTime = getCellValue(sheet0.getRow(2).getCell(3));
            String endTime = getCellValue(sheet0.getRow(2).getCell(4));

            // 1.填写工作量（人月）所处列的时间段信息，并且每多一个文件就多添加一列
            int colNumber = sheet1.getRow(0).getPhysicalNumberOfCells();
            Cell newCell0 = sheet1.getRow(0).createCell(colNumber);
            newCell0.setCellValue("工作量（人月）" + "\n" + startTime + "~" + endTime);

            // 2.遍历源文件每一行，计算不同项目的总人月数量（Map存储）
            Map<String, Map<String, Double>> peopleOfProjects = new HashMap<>();
            for (int i = 1; i < sheet0.getPhysicalNumberOfRows(); i++) {
                // 姓名
                String personName = getCellValue(sheet0.getRow(i).getCell(5));
                // 项目名称
                String projectName = getCellValue(sheet0.getRow(i).getCell(22));
                // 工作量（人月）
                Cell cell = sheet0.getRow(i).getCell(27);
                if (cell == null) {
                    continue;
                }
                double workload = cell.getNumericCellValue();

                if (peopleOfProjects.get(personName) == null) {
                    Map<String, Double> projectWorkload = new HashMap<>();
                    projectWorkload.put(projectName, workload);
                    peopleOfProjects.put(personName, projectWorkload);
                } else {
                    Map<String, Double> projectWorkload = peopleOfProjects.get(personName);
                    projectWorkload.put(projectName, projectWorkload.getOrDefault(projectName, 0.00) + workload);
                    peopleOfProjects.put(personName, projectWorkload);
                }

            }

            // 3.回填excel表格
            // 3.1统计已有的项目所在的行数
            Map<String, Map<String, Integer>> existPersons = new HashMap<>();
            for (int i = 1; i < sheet1.getPhysicalNumberOfRows(); i++) {
                String name = getCellValue(sheet1.getRow(i).getCell(0));
                if (name.length() == 0 || name == null) {
                    continue;
                } else {
                    String projectName = getCellValue(sheet1.getRow(i).getCell(3));
                    if (existPersons.keySet().contains(name)) {
                        Map<String, Integer> projectIndex = existPersons.get(name);
                        if (!projectIndex.keySet().contains(projectName)) {
                            projectIndex.put(projectName, i);
                            existPersons.put(name, projectIndex);
                        }
                    } else {
                        Map<String, Integer> projectIndex = new HashMap<>();
                        projectIndex.put(projectName, i);
                        existPersons.put(name, projectIndex);
                    }
                }
            }

            // 3.2将源表统计的项目人月信息合并到目标表中
            for (String personName : peopleOfProjects.keySet()) {
                if (existPersons.keySet().contains(personName)) {
                    Map<String, Integer> projectIndex = existPersons.get(personName);
                    Map<String, Double> projectWorkload = peopleOfProjects.get(personName);
                    for (String projectName : projectWorkload.keySet()) {
                        if (projectIndex.keySet().contains(projectName)) {
                            // 已有这个人和这个项目，则直接在最右边新增一个单元格记录人月信息
                            Cell cell = sheet1.getRow(projectIndex.get(projectName)).createCell(colNumber);
                            cell.setCellValue(projectWorkload.get(projectName));
                        } else {
                            // 有这个人但是没有这个项目，向下挪动插入一行记录新的项目信息
                            int personMaxIndex = getPersonMaxIndex(existPersons, personName);
                            sheet1.shiftRows(personMaxIndex + 1, sheet1.getLastRowNum(), 1, true, true);
                            Row row = sheet1.createRow(personMaxIndex + 1);
                            Cell cell0 = row.createCell(0);
                            cell0.setCellValue(personName);
                            Cell cell1 = row.createCell(colNumber);
                            cell1.setCellValue(projectWorkload.get(projectName));
                            Cell cell2 = row.createCell(3);
                            cell2.setCellValue(projectName);
                        }
                    }
                } else {
                    // 新出现的人，遍历ta的所有项目，每个项目新增一行
                    Map<String, Double> projectWorkload = peopleOfProjects.get(personName);
                    for (String projectName : projectWorkload.keySet()) {
                        int rowCount = sheet1.getPhysicalNumberOfRows();
                        Row row = sheet1.createRow(rowCount);
                        Cell cell0 = row.createCell(0);
                        cell0.setCellValue(personName);
                        Cell cell1 = row.createCell(colNumber);
                        cell1.setCellValue(projectWorkload.get(projectName));
                        Cell cell2 = row.createCell(3);
                        cell2.setCellValue(projectName);
                    }
                }
            }

            // 写回到文件
            saveChanges(targetWorkbook, targetPath);
//            targetWorkbook.write(fos);
            System.out.println("写入成功！");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveChanges(Workbook workbook, String excelFilePath) {
        try (FileOutputStream fos = new FileOutputStream(excelFilePath)) {
            workbook.write(fos);
            System.out.println("修改已保存到Excel文件：" + excelFilePath);

            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }

    private static int getPersonMaxIndex(Map<String, Map<String, Integer>> map, String name) {
        if (map.size() == 0) {
            return 0;
        }
        Map<String, Integer> projectIndex = map.get(name);
        int max = 0;
        for (String projectName : projectIndex.keySet()) {
            max = Math.max(max, projectIndex.get(projectName));
        }

        return max;
    }

}

package com.pgy.poi;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
    public static void main(String[] args) {
        File file22 = new File("/tmp/diff/6.22/dns1.xlsx");
        File file28 = new File("/tmp/diff/6.28/dns2.xlsx");

        List<Sheet> sheetList = getSheetList(file22);

        List<Row> list22 = new ArrayList<Row>();
        for (Sheet sheet : sheetList) {
            list22.addAll(getRowList(sheet));
        }
        List<Row> list28 = new ArrayList<Row>();
        for (Sheet sheet : getSheetList(file28)) {
            list28.addAll(getRowList(sheet));
        }

        int sum = 0;
        for (Row row22 : list22) {
            for (Row row28 : list28) {
                System.out.println(row22.getCell(2));
                System.out.println(row28.getCell(3));
            }
        }

    }

    public static void readExcelFile() {

    }

    public static Workbook getWorkBook(File file) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);

            if ("xlsx".equals(FilenameUtils.getExtension(file.getName()))) {
                return new XSSFWorkbook(fis);
            }

            if ("xls".equals(FilenameUtils.getExtension(file.getName()))) {
                return new HSSFWorkbook(fis);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Sheet> getSheetList(File file) {
        Workbook wb = getWorkBook(file);

        List<Sheet> sheetList = new ArrayList<Sheet>();

        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            sheetList.add(wb.getSheetAt(i));
        }
        return sheetList;
    }

    public static List<Row> getRowList(Sheet sheet) {
        List<Row> rowList = new ArrayList<Row>();
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            rowList.add(sheet.getRow(i));
        }
        return rowList;
    }

    public static List<Cell> getCellList(Row row) {
        List<Cell> cellList = new ArrayList<Cell>();

        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            cellList.add(row.getCell(i));
        }
        return cellList;
    }
}

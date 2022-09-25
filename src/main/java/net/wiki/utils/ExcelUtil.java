package net.wiki.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelUtil {

    public static ArrayList<String> readExcelData(String excelPath) throws Exception {

        InputStream is = ExcelUtil.class.getClassLoader().getResourceAsStream(excelPath);

        if (is != null) {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();//Moving to the 1st row to read data as the 0th row contains the header.
            DataFormatter formatter = new DataFormatter();
            ArrayList<String> arraylist = new ArrayList<>();
            while (rowIterator.hasNext()) {
                String ColumnValue = formatter.formatCellValue(rowIterator.next().getCell(0));
                arraylist.add(ColumnValue);
            }
            return arraylist;
        }
        throw new Exception("Cannot read from excel " + excelPath);
    }
}

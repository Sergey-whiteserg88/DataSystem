package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExelData {


    private ReadExelData() {
    }

    // метод получения студентов из файла
    public static List<Student> readStudent() {
        List<Student> studentList = new ArrayList<>();
        try {
            File file = new File("src/main/resources/universityInfo.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            Row row = null;
            while (iterator.hasNext()) {
                row = iterator.next();
                studentList.add(new Student(row.getCell(1).getStringCellValue(), row.getCell(0).getStringCellValue(),
                        (int) row.getCell(2).getNumericCellValue(), (float) row.getCell(3).getNumericCellValue()));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    // метод получения университетов из файла
    public static List<University> readUniversity() {
        List<University> universityList = new ArrayList<>();
        try {
            File file = new File("src/main/resources/universityInfo.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(1);
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            Row row = null;
            while (iterator.hasNext()) {
                row = iterator.next();
                universityList.add(new University(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(), (int) row.getCell(3).getNumericCellValue(),
                        StudyProfile.valueOf(row.getCell(4).getStringCellValue()), StudyProfile.valueOf(row.getCell(4).getStringCellValue())));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return universityList;
    }
}

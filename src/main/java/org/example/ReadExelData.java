package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class ReadExelData {

    private static final Logger log = Logger.getLogger(ReadExelData.class.getName());

    private ReadExelData() {
    }

    // метод получения студентов из файла
    public static List<Student> readStudent() {
        List<Student> studentList = new ArrayList<>();
        try {
            File file = new File("src/main/resources/universityInfo.xlsx");
            log.info("Файл доступен для чтения");
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
            log.info("Получили список студентов из файла. Размер - " + studentList.size());

        } catch (IOException e) {
            log.severe("Ошибка чтения. Файл не найден. Список студентов пуст");
            e.printStackTrace();
        }
        return studentList;
    }

    // метод получения университетов из файла
    public static List<University> readUniversity() {
        List<University> universityList = new ArrayList<>();
        try {
            File file = new File("src/main/resources/universityInfo.xlsx");
            log.info("Файл доступен для чтения");
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
            log.info("Получили список университетов из файла. Размер - " + universityList.size());
        } catch (IOException e) {
            log.severe("Ошибка чтения. Файл не найден. Список университетов пуст");
            e.printStackTrace();
        }
        return universityList;
    }
}

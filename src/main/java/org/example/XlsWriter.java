package org.example;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.List;

public class XlsWriter {
    private XlsWriter() {
    }

    public static void createAndWriteTable(List<Statistics> statisticsList, String pathname) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Statistic");
        // Шрифт заголовка
        Font titleFont = workbook.createFont();
        titleFont.setBold(true);
        titleFont.setFontHeight((short) (12 * 20));
        // Стиль ячейки заголовка
        CellStyle titleCellStyle = workbook.createCellStyle();
        titleCellStyle.setFont(titleFont);
        // строка заголовка
        Row row = sheet.createRow(0);
        // Ячейки заголовков
        Cell rowCount = row.createCell(0);
        rowCount.setCellStyle(titleCellStyle);
        Cell studyProfileCell = row.createCell(1);
        studyProfileCell.setCellStyle(titleCellStyle);
        Cell avgExamScoreCell = row.createCell(2);
        avgExamScoreCell.setCellStyle(titleCellStyle);
        Cell studentCountByProfileCell = row.createCell(3);
        studentCountByProfileCell.setCellStyle(titleCellStyle);
        Cell universityCountByProfileCell = row.createCell(4);
        universityCountByProfileCell.setCellStyle(titleCellStyle);
        Cell universityName = row.createCell(5);
        universityName.setCellStyle(titleCellStyle);
        // Названия заголовков
        rowCount.setCellValue("№п/п");
        studyProfileCell.setCellValue("Профиль студентов");
        avgExamScoreCell.setCellValue("Средний балл");
        studentCountByProfileCell.setCellValue("Количество студентов по профилю");
        universityCountByProfileCell.setCellValue("Количество университетов по профилю");
        universityName.setCellValue("Название университетов");

        // создание строк из списка коллекций
        for (int i = 0; i < statisticsList.size(); i++) {
            Row newRow = sheet.createRow(i + 1);
            Cell newRowCountCell = newRow.createCell(0);
            Cell newStudyProfileCell = newRow.createCell(1);
            Cell newAvgExamScoreCell = newRow.createCell(2);
            Cell newStudentCountByProfileCell = newRow.createCell(3);
            Cell newUniversityCountByProfileCell = newRow.createCell(4);
            Cell newUniversityName = newRow.createCell(5);
            newRowCountCell.setCellValue(i + 1);
            newStudyProfileCell.setCellValue(statisticsList.get(i).getStudyProfile());
            newAvgExamScoreCell.setCellValue(Float.parseFloat(String.valueOf(statisticsList.get(i).getAvgExamScore())));
            newStudentCountByProfileCell.setCellValue(statisticsList.get(i).getStudentCountByProfile());
            newUniversityCountByProfileCell.setCellValue(statisticsList.get(i).getUniversityCountByProfile());
            String universityNames = String.join(",", statisticsList.get(i).getUniversityName());
            newUniversityName.setCellValue(universityNames);
        }
        // запись в файл
        File file = new File(pathname);
        FileOutputStream fileInputStream = null;
        try {
            fileInputStream = new FileOutputStream(file);
            workbook.write(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

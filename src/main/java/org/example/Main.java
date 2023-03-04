package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    // Коллекция студентов
    private static List<Student> studentList = new ArrayList<>();
    // Коллекция университетов
    private static List<University> universityList = new ArrayList<>();
    // Коллекция сортировок студентов
    private static final List<Comparator<Student>> comparatorStudentList = new ArrayList<>();
    // Коллекция сортировок университетов
    private static final List<Comparator<University>> comparatorUniversityList = new ArrayList<>();

    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        log.info("Начало работы программы");
        // Добавление сортировок студентов в коллекцию
        comparatorStudentList.add(ReturnComparator.getMyStudentComparator(StudentEnumComparator.fullNameComparator));
        comparatorStudentList.add(ReturnComparator.getMyStudentComparator(StudentEnumComparator.UniversityIdComparator));
        comparatorStudentList.add(ReturnComparator.getMyStudentComparator(StudentEnumComparator.CurrentCourseNumberComparator));
        comparatorStudentList.add(ReturnComparator.getMyStudentComparator(StudentEnumComparator.AvgExamScoreComparator));
        Comparator<Student> studentFullNameComparator = comparatorStudentList.get(0);
        Comparator<Student> studentUniversityIdComparator = comparatorStudentList.get(1);
        Comparator<Student> studentCurrentCourseNumberComparator = comparatorStudentList.get(2);
        Comparator<Student> studentAvgExamScoreComparator = comparatorStudentList.get(3);

        // Добавление сортировок университетов в коллекцию
        comparatorUniversityList.add(ReturnComparator.getMyUniversityComparator(UniversityEnumComparator.IdUniversityComparator));
        comparatorUniversityList.add(ReturnComparator.getMyUniversityComparator(UniversityEnumComparator.FullNameUniversityComparator));
        comparatorUniversityList.add(ReturnComparator.getMyUniversityComparator(UniversityEnumComparator.ShortNameUniversityComparator));
        comparatorUniversityList.add(ReturnComparator.getMyUniversityComparator(UniversityEnumComparator.YearOfFoundationUniversityComparator));
        comparatorUniversityList.add(ReturnComparator.getMyUniversityComparator(UniversityEnumComparator.StudentProfileComparator));
        Comparator<University> universityIdComparator = comparatorUniversityList.get(0);
        Comparator<University> universityFullNameComparator = comparatorUniversityList.get(1);
        Comparator<University> universityShortNameComparator = comparatorUniversityList.get(2);
        Comparator<University> universityYearOfFoundationComparator = comparatorUniversityList.get(3);
        Comparator<University> universityStudentProfileComparator = comparatorUniversityList.get(4);


        // получение списка студентов
        log.info("получение списка студентов");
        studentList = ReadExelData.readStudent();
        // сортировка списка студентов
        studentList.sort(studentAvgExamScoreComparator);
        // созданите экземпляра класса списка студентов
        Students students = new Students(studentList);

        // получение списка университетов
        log.info("получение списка университетов");
        universityList = ReadExelData.readUniversity();
        // сортировка списка университетов
        universityList.sort(universityYearOfFoundationComparator);
        // созданите экземпляра класса списка университетов
        Universities universities = new Universities(universityList);

        // Получение статистики из утилитного класса
        log.info("генерирование статистики");
        List<Statistics> statisticsList = GenerateStatistic.statisticsList(studentList, universityList);
        // Запись и создание файла статистики
        log.info("создание файла статистики");
        XlsWriter.createAndWriteTable(statisticsList, "src/main/resources/statistic.xlsx");

        // Создание экземпляра класса с данными для создания XML и JSON файлов
        DataForXmlJsonFile dataForXmlJsonFile = new DataForXmlJsonFile(students, universities, statisticsList, LocalDateTime.now().toString());
        // Создание XML файла
        log.info("генерирование XML файла");
        XmlWriter.createXmlFiles(dataForXmlJsonFile);
        // Создание JSON файлов
        log.info("генерирование JSON файлов");
        JsonWriter.createJsonFiles(dataForXmlJsonFile);
        log.info("Конец работы программы");
    }
}
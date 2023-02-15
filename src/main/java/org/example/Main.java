package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    //  оллекци€ студентов
    private static List<Student> studentList = new ArrayList<>();
    //  оллекци€ университетов
    private static List<University> universityList = new ArrayList<>();
    //  оллекци€ сортировок студентов
    private static final List<Comparator<Student>> comparatorStudentList = new ArrayList<>();
    //  оллекци€ сортировок университетов
    private static final List<Comparator<University>> comparatorUniversityList = new ArrayList<>();

    public static void main(String[] args) {
        // ƒобавление сортировок студентов в коллекцию
        comparatorStudentList.add(ReturnComparator.getMyStudentComparator(StudentEnumComparator.fullNameComparator));
        comparatorStudentList.add(ReturnComparator.getMyStudentComparator(StudentEnumComparator.UniversityIdComparator));
        comparatorStudentList.add(ReturnComparator.getMyStudentComparator(StudentEnumComparator.CurrentCourseNumberComparator));
        comparatorStudentList.add(ReturnComparator.getMyStudentComparator(StudentEnumComparator.AvgExamScoreComparator));
        Comparator<Student> studentFullNameComparator = comparatorStudentList.get(0);
        Comparator<Student> studentUniversityIdComparator = comparatorStudentList.get(1);
        Comparator<Student> studentCurrentCourseNumberComparator = comparatorStudentList.get(2);
        Comparator<Student> studentAvgExamScoreComparator = comparatorStudentList.get(3);

        // ƒобавление сортировок университетов в коллекцию
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

        // сериализаци€ студентов
        System.out.println("--сериализаци€ студентов--");
        studentList = ReadExelData.readStudent();
        String studentListInJson = JsonUtil.serializedStudentList(studentList);
        System.out.println(studentListInJson);
        System.out.println();
        // десериализаци€ студентов
        System.out.println("--десериализаци€ студентов--");
        // сохран€ем новую коллекцию студентов
        List<Student> students = JsonUtil.deserializedStudentList(studentListInJson);
        students.forEach(System.out::println);
        System.out.println();
        // сериализаци€ университетов
        System.out.println("--сериализаци€ университетов--");
        universityList = ReadExelData.readUniversity();
        String universityListInJson = JsonUtil.serializedUniversityList(universityList);
        System.out.println(universityListInJson);
        System.out.println();
        // десериализаци€ университетов
        System.out.println("--десериализаци€ университетов--");
        // сохран€ем новую коллекцию университетов
        List<University> universities = JsonUtil.deserializedUniversityList(universityListInJson);
        universities.forEach(System.out::println);
        System.out.println();
        // сериализаци€/десериализаци€ отдельных студентов в стриме (по среднему баллу) с сортировкой и вывод на печать
        System.out.println("--сериализаци€/десериализаци€ отдельных студентов в стриме (по среднему баллу) с сортировкой и вывод на печать--");
        studentList.stream().filter(student -> student.getAvgExamScore()>4.0f).sorted(studentAvgExamScoreComparator).
                forEach(student -> {
                    String studentList = JsonUtil.serializedStudent(student);
                    System.out.println(studentList);
                    Student deserialisedStudent = JsonUtil.deserializedStudent(studentList);
                    System.out.println(deserialisedStudent);
                });
        System.out.println();
        // сериализаци€/десериализаци€ отдельных университетов в стриме (по году основани€) с сортировкой и вывод на печать
        System.out.println("--сериализаци€/десериализаци€ отдельных университетов в стриме (по году основани€) с сортировкой и вывод на печать--");
        universityList.stream().filter(university -> university.getYearOfFoundation()>1950).sorted(universityYearOfFoundationComparator).
                forEach(university -> {
                    String universityList = JsonUtil.serializedUniversity(university);
                    System.out.println(universityList);
                    University deserialisedUniversity = JsonUtil.deserializedUniversity(universityList);
                    System.out.println(deserialisedUniversity);
                });

        // ѕолучение списка коллекций из утилитного класса
        List<Statistics> statisticsList = GenerateStatistic.statisticsList(studentList, universityList);
        // «апись и создание файла
        XlsWriter.createAndWriteTable(statisticsList, "src/main/resources/statistic.xlsx");
    }
}
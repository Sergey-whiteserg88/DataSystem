package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    // ��������� ���������
    private static List<Student> studentList = new ArrayList<>();
    // ��������� �������������
    private static List<University> universityList = new ArrayList<>();
    // ��������� ���������� ���������
    private static final List<Comparator<Student>> comparatorStudentList = new ArrayList<>();
    // ��������� ���������� �������������
    private static final List<Comparator<University>> comparatorUniversityList = new ArrayList<>();

    public static void main(String[] args) {
        // ���������� ���������� ��������� � ���������
        comparatorStudentList.add(ReturnComparator.getMyStudentComparator(StudentEnumComparator.fullNameComparator));
        comparatorStudentList.add(ReturnComparator.getMyStudentComparator(StudentEnumComparator.UniversityIdComparator));
        comparatorStudentList.add(ReturnComparator.getMyStudentComparator(StudentEnumComparator.CurrentCourseNumberComparator));
        comparatorStudentList.add(ReturnComparator.getMyStudentComparator(StudentEnumComparator.AvgExamScoreComparator));
        Comparator<Student> studentFullNameComparator = comparatorStudentList.get(0);
        Comparator<Student> studentUniversityIdComparator = comparatorStudentList.get(1);
        Comparator<Student> studentCurrentCourseNumberComparator = comparatorStudentList.get(2);
        Comparator<Student> studentAvgExamScoreComparator = comparatorStudentList.get(3);

        // ���������� ���������� ������������� � ���������
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

        // ������������ ���������
        System.out.println("--������������ ���������--");
        studentList = ReadExelData.readStudent();
        String studentListInJson = JsonUtil.serializedStudentList(studentList);
        System.out.println(studentListInJson);
        System.out.println();
        // �������������� ���������
        System.out.println("--�������������� ���������--");
        // ��������� ����� ��������� ���������
        List<Student> students = JsonUtil.deserializedStudentList(studentListInJson);
        students.forEach(System.out::println);
        System.out.println();
        // ������������ �������������
        System.out.println("--������������ �������������--");
        universityList = ReadExelData.readUniversity();
        String universityListInJson = JsonUtil.serializedUniversityList(universityList);
        System.out.println(universityListInJson);
        System.out.println();
        // �������������� �������������
        System.out.println("--�������������� �������������--");
        // ��������� ����� ��������� �������������
        List<University> universities = JsonUtil.deserializedUniversityList(universityListInJson);
        universities.forEach(System.out::println);
        System.out.println();
        // ������������/�������������� ��������� ��������� � ������ (�� �������� �����) � ����������� � ����� �� ������
        System.out.println("--������������/�������������� ��������� ��������� � ������ (�� �������� �����) � ����������� � ����� �� ������--");
        studentList.stream().filter(student -> student.getAvgExamScore()>4.0f).sorted(studentAvgExamScoreComparator).
                forEach(student -> {
                    String studentList = JsonUtil.serializedStudent(student);
                    System.out.println(studentList);
                    Student deserialisedStudent = JsonUtil.deserializedStudent(studentList);
                    System.out.println(deserialisedStudent);
                });
        System.out.println();
        // ������������/�������������� ��������� ������������� � ������ (�� ���� ���������) � ����������� � ����� �� ������
        System.out.println("--������������/�������������� ��������� ������������� � ������ (�� ���� ���������) � ����������� � ����� �� ������--");
        universityList.stream().filter(university -> university.getYearOfFoundation()>1950).sorted(universityYearOfFoundationComparator).
                forEach(university -> {
                    String universityList = JsonUtil.serializedUniversity(university);
                    System.out.println(universityList);
                    University deserialisedUniversity = JsonUtil.deserializedUniversity(universityList);
                    System.out.println(deserialisedUniversity);
                });

        // ��������� ������ ��������� �� ���������� ������
        List<Statistics> statisticsList = GenerateStatistic.statisticsList(studentList, universityList);
        // ������ � �������� �����
        XlsWriter.createAndWriteTable(statisticsList, "src/main/resources/statistic.xlsx");
    }
}
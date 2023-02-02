package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    // ��������� ���������
    private static final List<Student> studentList = new ArrayList<>();
    // ��������� �������������
    private static final List<University> universityList = new ArrayList<>();
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
        // ���������� � ����� ���������
        System.out.println("--���������� � ����� ��������� �� �����--");
        ReadExelData.readStudent().stream().sorted(studentFullNameComparator).forEach(System.out::println);
        System.out.println("--���������� � ����� ��������� �� �������������� �����������--");
        ReadExelData.readStudent().stream().sorted(studentUniversityIdComparator).forEach(System.out::println);
        System.out.println("--���������� � ����� ��������� �� ������ �����--");
        ReadExelData.readStudent().stream().sorted(studentCurrentCourseNumberComparator).forEach(System.out::println);
        System.out.println("--���������� � ����� ��������� �� �������� ����� �� �������� � ��������--");
        ReadExelData.readStudent().stream().sorted(studentAvgExamScoreComparator).forEach(System.out::println);
        // ���������� � ����� �������������
        System.out.println("--���������� � ����� ������������� �� ��������--");
        ReadExelData.readUniversity().stream().sorted(universityFullNameComparator).forEach(System.out::println);
        System.out.println("--���������� � ����� ������������� �� ��������������--");
        ReadExelData.readUniversity().stream().sorted(universityIdComparator).forEach(System.out::println);
        System.out.println("--���������� � ����� ������������� �� ������������ �����--");
        ReadExelData.readUniversity().stream().sorted(universityShortNameComparator).forEach(System.out::println);
        System.out.println("--���������� � ����� ������������� �� ���� ���������--");
        ReadExelData.readUniversity().stream().sorted(universityYearOfFoundationComparator).forEach(System.out::println);
        System.out.println("--���������� � ����� ������������� �� ������� ����������--");
        ReadExelData.readUniversity().stream().sorted(universityStudentProfileComparator).forEach(System.out::println);


    }
}
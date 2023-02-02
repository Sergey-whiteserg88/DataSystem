package org.example;

import java.util.Comparator;

public class ReturnComparator {
    private ReturnComparator() {
    }

    public static Comparator<Student> getMyStudentComparator(StudentEnumComparator studentEnumComparator) {
        switch (studentEnumComparator) {
            case fullNameComparator:
                return new Student.FullNameStudentCompare();
            case UniversityIdComparator:
                return new Student.UniversityIdStudentCompare();
            case CurrentCourseNumberComparator:
                return new Student.CurrentCourseNumberStudentCompare();
            case AvgExamScoreComparator:
                return new Student.AvgExamScoreStudentCompare();
            default:
                return null;
        }
    }

    public static Comparator<University> getMyUniversityComparator(UniversityEnumComparator universityEnumComparator) {
        switch (universityEnumComparator) {
            case IdUniversityComparator:
                return new University.IdUniversityCompare();
            case FullNameUniversityComparator:
                return new University.FullNameUniversityCompare();
            case ShortNameUniversityComparator:
                return new University.ShortNameUniversityCompare();
            case YearOfFoundationUniversityComparator:
                return new University.YearOfFoundationUniversityCompare();
            case StudentProfileComparator:
                return new University.StudentProfileCompare();
            default:
                return null;
        }
    }
}

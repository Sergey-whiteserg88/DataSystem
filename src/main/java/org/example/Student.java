package org.example;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.StringUtils;

public class Student {
    @SerializedName("������ ���")
    private String fullName;
    @SerializedName("������������� ������������")
    private String universityId;
    @SerializedName("����")
    private int currentCourseNumber;
    @SerializedName("������� ����")
    private float avgExamScore;

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }

    // ���������� ��������� �� �����
    public static class FullNameStudentCompare implements StudentInterface {
        @Override
        public int compare(Student o1, Student o2) {
            return StringUtils.compare(o1.getFullName(), o2.getFullName());
        }
    }

    // ���������� ��������� �� �������������� ������������
    public static class UniversityIdStudentCompare implements StudentInterface {
        @Override
        public int compare(Student o1, Student o2) {
            return StringUtils.compare(o1.getUniversityId(), o2.getUniversityId());
        }
    }

    // ���������� ��������� �� ������ �����
    public static class CurrentCourseNumberStudentCompare implements StudentInterface {
        @Override
        public int compare(Student o1, Student o2) {
            return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
        }
    }

    // ���������� ��������� �� �������� ����� � �������� �������
    public static class AvgExamScoreStudentCompare implements StudentInterface {
        @Override
        public int compare(Student o1, Student o2) {
            return Float.compare(o2.getAvgExamScore(), o1.getAvgExamScore());
        }
    }
}

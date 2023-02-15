package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GenerateStatistic {

    private GenerateStatistic() {
    }

    public static List<Statistics> statisticsList(List<Student> studentList, List<University> universityList){
        List<Statistics> statisticsList = new ArrayList<>();
        // ������� ��������
        for(StudyProfile studyProfile : StudyProfile.values()){
            // ����� �������������
            List<String> universityNames = new ArrayList<>();
            // ��������� ������� ������
            List<Float> avgScore = new ArrayList<>();
            // ���������� �������������
            AtomicInteger universityCount = new AtomicInteger();
            // ���������� ���������
            AtomicInteger studentCount = new AtomicInteger();
            // ������� ������������� �� �������
            universityList.stream().filter(university -> university.getMainProfile().equals(studyProfile)).
                    forEach(university -> {
                        universityNames.add(university.getShortName());
                        universityCount.getAndIncrement();
                        // ������� ��������� �� id ������������
                        studentList.stream().filter(student -> student.getUniversityId().equals(university.getId())).
                                forEach(student -> {
                                        studentCount.getAndIncrement();
                                        avgScore.add(student.getAvgExamScore());
                                });
                    });
            // �������������� ��������� ������� ������ � ������
            double[] arr = avgScore.stream().mapToDouble(Float::doubleValue).toArray();
            // ��������� �������� �������� �� ������� ������� ������
            OptionalDouble optionalAvgScore = OptionalDouble.of(Arrays.stream(arr).average().orElse(0));
            // ���������� �� 2-� ������
            BigDecimal avg = BigDecimal.valueOf(optionalAvgScore.getAsDouble()).setScale(2, RoundingMode.HALF_UP);
            // ���������� � ���������
            statisticsList.add(new Statistics(studyProfile.getProfileName(), avg, studentCount.get(), universityCount.get(), universityNames));
        }
        return statisticsList;
    }



}

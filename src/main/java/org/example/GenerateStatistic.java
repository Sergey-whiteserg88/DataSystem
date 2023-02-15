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
        // Перебор профилей
        for(StudyProfile studyProfile : StudyProfile.values()){
            // Имена университетов
            List<String> universityNames = new ArrayList<>();
            // Коллекция средних оценов
            List<Float> avgScore = new ArrayList<>();
            // Количество университетов
            AtomicInteger universityCount = new AtomicInteger();
            // Количество студентов
            AtomicInteger studentCount = new AtomicInteger();
            // Перебор университетов по профилю
            universityList.stream().filter(university -> university.getMainProfile().equals(studyProfile)).
                    forEach(university -> {
                        universityNames.add(university.getShortName());
                        universityCount.getAndIncrement();
                        // Перебор студентов по id университета
                        studentList.stream().filter(student -> student.getUniversityId().equals(university.getId())).
                                forEach(student -> {
                                        studentCount.getAndIncrement();
                                        avgScore.add(student.getAvgExamScore());
                                });
                    });
            // Преобразование коллекции средних оценок в массив
            double[] arr = avgScore.stream().mapToDouble(Float::doubleValue).toArray();
            // получение среднего значения из массива средних оценок
            OptionalDouble optionalAvgScore = OptionalDouble.of(Arrays.stream(arr).average().orElse(0));
            // округление до 2-х знаков
            BigDecimal avg = BigDecimal.valueOf(optionalAvgScore.getAsDouble()).setScale(2, RoundingMode.HALF_UP);
            // добавление в коллекцию
            statisticsList.add(new Statistics(studyProfile.getProfileName(), avg, studentCount.get(), universityCount.get(), universityNames));
        }
        return statisticsList;
    }



}

package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.logging.Logger;

public class JsonWriter {
    private static final Logger log = Logger.getLogger(JsonWriter.class.getName());
    private static final String ROOT_JSON_STUDENT = "src/main/jsonReqs/req_student_" + LocalDate.now() + "_.json";
    private static final String ROOT_JSON_UNIVERSITY = "src/main/jsonReqs/req_university_" + LocalDate.now() + "_.json";
    private static final String ROOT_JSON_STATISTIC = "src/main/jsonReqs/req_statistic_" + LocalDate.now() + "_.json";

    private JsonWriter() {
    }

    public static void createJsonFiles(DataForXmlJsonFile dataForXmlJsonFile) {
        File dir = new File("src/main/jsonReqs");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String studentListInJson = JsonUtil.serializedData(Arrays.asList(dataForXmlJsonFile.getStudents().getStudentList().toArray()));
        String universityListInJson = JsonUtil.serializedData(Arrays.asList(dataForXmlJsonFile.getUniversitets().getUniversityList().toArray()));
        String statisticListInJson = JsonUtil.serializedData(Arrays.asList(dataForXmlJsonFile.getStatistics().toArray()));

        try {
            FileWriter fileStudent = new FileWriter(ROOT_JSON_STUDENT);
            fileStudent.write(studentListInJson);
            fileStudent.close();
            log.info("JSON файл студентов успешно создан");
            FileWriter fileUniversity = new FileWriter(ROOT_JSON_UNIVERSITY);
            fileUniversity.write(universityListInJson);
            fileUniversity.close();
            log.info("JSON файл университетов успешно создан");
            FileWriter fileStatistic = new FileWriter(ROOT_JSON_STATISTIC);
            fileStatistic.write(statisticListInJson);
            fileStatistic.close();
            log.info("JSON файл статистики успешно создан");
        } catch (IOException e) {
            e.printStackTrace();
            log.severe("Ошибка создания JSON файла");
        }
    }
}

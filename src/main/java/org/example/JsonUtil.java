package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {

    private JsonUtil() {
    }

    // сериализация студента
    public static String serializedStudent(Student student) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(student);
    }

    // сериализация университета
    public static String serializedUniversity(University university) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(university);
    }

    // сериализация списка студентов
    public static String serializedStudentList(List<Student> studentList) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(studentList);
    }

    // сериализация списка университетов
    public static String serializedUniversityList(List<University> universityList) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(universityList);
    }

    // десериализация студента
    public static Student deserializedStudent(String jsonStudent) {
        return new Gson().fromJson(jsonStudent, Student.class);
    }

    // десериализация списка студентов
    public static List<Student> deserializedStudentList(String jsonStudentList) {
        return new Gson().fromJson(jsonStudentList, new TypeToken<List<Student>>(){}.getType());
    }

    // десериализация университета
    public static University deserializedUniversity(String jsonUniversity) {
        return new Gson().fromJson(jsonUniversity, University.class);
    }

    // десериализация списка университетов
    public static List<University> deserializedUniversityList(String jsonUniversityList) {
        return new Gson().fromJson(jsonUniversityList, new TypeToken<List<University>>(){}.getType());
    }
}

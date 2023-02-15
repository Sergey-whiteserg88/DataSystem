package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {

    private JsonUtil() {
    }

    // ������������ ��������
    public static String serializedStudent(Student student) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(student);
    }

    // ������������ ������������
    public static String serializedUniversity(University university) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(university);
    }

    // ������������ ������ ���������
    public static String serializedStudentList(List<Student> studentList) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(studentList);
    }

    // ������������ ������ �������������
    public static String serializedUniversityList(List<University> universityList) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(universityList);
    }

    // �������������� ��������
    public static Student deserializedStudent(String jsonStudent) {
        return new Gson().fromJson(jsonStudent, Student.class);
    }

    // �������������� ������ ���������
    public static List<Student> deserializedStudentList(String jsonStudentList) {
        return new Gson().fromJson(jsonStudentList, new TypeToken<List<Student>>(){}.getType());
    }

    // �������������� ������������
    public static University deserializedUniversity(String jsonUniversity) {
        return new Gson().fromJson(jsonUniversity, University.class);
    }

    // �������������� ������ �������������
    public static List<University> deserializedUniversityList(String jsonUniversityList) {
        return new Gson().fromJson(jsonUniversityList, new TypeToken<List<University>>(){}.getType());
    }
}

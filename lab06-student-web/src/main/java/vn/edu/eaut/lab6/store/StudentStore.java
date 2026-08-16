package vn.edu.eaut.lab6.store;

import vn.edu.eaut.lab6.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentStore {

    private static final List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(
                "SV001",
                "Nguyen Van An",
                "DCCNTT12",
                "an@example.com"
        ));

        students.add(new Student(
                "SV002",
                "Tran Thi Binh",
                "DCCNTT12",
                "binh@example.com"
        ));
    }

    // Lấy toàn bộ danh sách
    public static List<Student> findAll() {
        return students;
    }

    // Thêm sinh viên
    public static void add(Student student) {
        students.add(student);
    }

    // Bài 6: tìm theo họ tên
    public static List<Student> searchByName(String keyword) {

        List<Student> result = new ArrayList<>();

        if (keyword == null || keyword.trim().isEmpty()) {
            return findAll();
        }

        keyword = keyword.trim().toLowerCase();

        for (Student student : students) {

            if (student.getName().toLowerCase().contains(keyword)) {
                result.add(student);
            }
        }

        return result;
    }

    // Bài 7: xóa
    public static void delete(String id) {

        students.removeIf(student ->
                student.getId().equals(id)
        );
    }

    // Bài 8: tìm theo mã
    public static Student findById(String id) {

        for (Student student : students) {

            if (student.getId().equals(id)) {
                return student;
            }
        }

        return null;
    }

    // Bài 8: cập nhật
    public static void update(Student newStudent) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId().equals(newStudent.getId())) {

                students.set(i, newStudent);

                return;
            }
        }
    }

    // Bài 12
    public static boolean exists(String id) {

        for (Student student : students) {

            if (student.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }
}
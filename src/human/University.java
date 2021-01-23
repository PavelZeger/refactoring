package human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Pavel Zeger
 */
public class University {

    private String name;
    private int age;
    private List<Student> students;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        this.students = new ArrayList<Student>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        return getStudents()
                .stream()
                .filter(student -> student.getAverageGrade() == averageGrade)
                .findFirst()
                .get();

    }

    public Student getStudentWithMaxAverageGrade() {
        List<Double> averages = new ArrayList<Double>();
        getStudents()
                .stream()
                .forEach(student -> averages.add(student.getAverageGrade()));
        Double maxAverageGrade = Collections.max(averages);
        return getStudents()
                .stream()
                .filter(student -> student.getAverageGrade() == maxAverageGrade)
                .findFirst()
                .get();
    }

    public Student getStudentWithMinAverageGrade() {
        List<Double> averages = new ArrayList<Double>();
        getStudents()
                .stream()
                .forEach(student -> averages.add(student.getAverageGrade()));
        Double maxAverageGrade = Collections.min(averages);
        return getStudents()
                .stream()
                .filter(student -> student.getAverageGrade() == maxAverageGrade)
                .findFirst()
                .get();
    }

    public void expel(Student student) {
        students.remove(student);
    }
}
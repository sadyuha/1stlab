import java.util.ArrayList;

public class Student {
    String name;
    String group;
    int course;
    ArrayList<Integer> grades;

    public Student(String name, String group, int course, ArrayList<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public void printInfo() {
        System.out.println("Имя: " + name + ", Группа: " + group + ", Курс: " + course);
    }
}

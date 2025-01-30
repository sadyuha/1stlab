import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Сколько студентов добавить? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Введите данные студента " + (i + 1) + ":");

            System.out.print("Имя: ");
            String name = scanner.nextLine();

            System.out.print("Группа: ");
            String group = scanner.nextLine();

            System.out.print("Курс: ");
            int course = scanner.nextInt();

            System.out.print("Сколько оценок? ");
            int n = scanner.nextInt();

            ArrayList<Integer> grades = new ArrayList<>();
            System.out.println("Введите оценки (через пробел):");
            for (int j = 0; j < n; j++) {
                grades.add(scanner.nextInt());
            }
            scanner.nextLine();

            students.add(new Student(name, group, course, grades));
        }

        processStudents(students);

        System.out.print("Введите номер курса, чтобы посмотреть, какие студенты на него переведены по результатам сессии: ");
        int neededCourse = scanner.nextInt();

        printStudents(students, neededCourse);

        scanner.close();
    }

    public static void processStudents(ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getAverageGrade() < 3) {
                students.remove(i);
                i--;
            } else {
                s.course++;
            }
        }
    }

    public static void printStudents(ArrayList<Student> students, int course) {
        System.out.println("Студенты на " + course + " курсе:");
        boolean hasStudents = false;
        for (Student s : students) {
            if (s.course == course) {
                System.out.println(s.name + " (группа: " + s.group + ")");
                hasStudents = true;
            }
        }
        if (!hasStudents) {
            System.out.println("Таких студентов нет.");
        }
    }
}

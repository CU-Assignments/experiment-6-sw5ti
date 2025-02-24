import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentFiltering {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("David", 82),
            new Student("Eve", 74),
            new Student("Frank", 90),
            new Student("Grace", 78)
        );

        List<String> topStudents = students.stream()
            .filter(s -> s.marks > 75)
            .sorted(Comparator.comparingDouble(s -> s.marks))
            .map(s -> s.name)
            .collect(Collectors.toList());

        System.out.println("Students scoring above 75%: " + topStudents);
    }
}

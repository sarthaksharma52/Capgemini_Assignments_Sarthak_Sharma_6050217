import java.util.*;

class NewStudents {
    String name;
    int[] marks;
    int rollNo;
    int age;

    NewStudents(String name, int[] marks, int rollNo, int age) {
        this.name = name;
        this.marks = marks;
        this.rollNo = rollNo;
        this.age = age;
    }
}

public class ArrayObjectArraySortingSelection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Students");
        int n = sc.nextInt();

        NewStudents[] arr = new NewStudents[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the Student name");
            String name = sc.next();
            sc.nextLine();

            System.out.println("Enter the number of Subjects");
            int mn = sc.nextInt();
            int[] marks = new int[mn];

            for (int j = 0; j < mn; j++) {
                System.out.println("Enter number of marks of subject " + (j + 1));
                marks[j] = sc.nextInt();
            }

            System.out.println("Enter the Roll Number of Student");
            int rollNo = sc.nextInt();

            System.out.println("Enter the age of Student");
            int age = sc.nextInt();

            arr[i] = new NewStudents(name, marks, rollNo, age);
        }

        // Selection Sort
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (compareStudents(arr[j], arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                NewStudents temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].name + " " +
                    Arrays.toString(arr[i].marks) + " " +
                    arr[i].rollNo + " " +
                    arr[i].age);
        }
    }

    static int compareStudents(NewStudents s1, NewStudents s2) {
        int min = Math.min(s1.marks.length, s2.marks.length);

        for (int i = 0; i < min; i++) {
            if (s1.marks[i] != s2.marks[i]) {
                return s1.marks[i] - s2.marks[i];
            }
        }

        return s1.rollNo - s2.rollNo;
    }
}

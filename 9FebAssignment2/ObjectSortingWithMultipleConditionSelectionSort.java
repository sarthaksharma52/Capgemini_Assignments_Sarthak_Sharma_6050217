import java.util.Scanner;

class Students {
    String name;
    int fullStackMarks;
    int c;
    int java;

    Students(String name, int fullStackMarks, int c, int java) {
        this.name = name;
        this.fullStackMarks = fullStackMarks;
        this.c = c;
        this.java = java;
    }
}

public class ObjectSortingWithMultipleConditionSelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students");
        int n = sc.nextInt();

        Students[] arr = new Students[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the student name");
            String name = sc.next();

            System.out.println("Enter the fullStack marks");
            int fullStackMarks = sc.nextInt();

            System.out.println("Enter the c marks");
            int c = sc.nextInt();

            System.out.println("Enter the java marks");
            int java = sc.nextInt();

            arr[i] = new Students(name, fullStackMarks, c, java);
        }

        // Selection Sort
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (compare(arr[j], arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            Students temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].name + " " +
                    arr[i].fullStackMarks + " " +
                    arr[i].c + " " +
                    arr[i].java);
        }
    }

    static int compare(Students s1, Students s2) {
        if (s1.fullStackMarks != s2.fullStackMarks) {
            return s1.fullStackMarks - s2.fullStackMarks;
        }
        if (s1.c != s2.c) {
            return s1.c - s2.c;
        }
        return s1.java - s2.java;
    }
}

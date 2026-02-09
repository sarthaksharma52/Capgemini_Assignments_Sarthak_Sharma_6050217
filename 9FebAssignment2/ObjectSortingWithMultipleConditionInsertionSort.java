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

public class ObjectSortingWithMultipleConditionInsertionSort {
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

        // Insertion Sort
        for (int i = 1; i < n; i++) {
            Students key = arr[i];
            int j = i - 1;

            while (j >= 0 && compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("\nSorted Students:");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].name + " " +
                    arr[i].fullStackMarks + " " +
                    arr[i].c + " " +
                    arr[i].java);
        }

        sc.close();
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

import java.util.*;

class Student {
    String name;
    int rollNo;
    int donation;

    Student(String name, int rollNo, int donation) {
        this.name = name;
        this.rollNo = rollNo;
        this.donation = donation;
    }
}

public class ObjectSortingWithInsertionSort {
    public static void main(String[] args) {

        Student s1 = new Student("Sarthak", 149, 1000);
        Student s2 = new Student("Riya", 140, 5000);
        Student s3 = new Student("Ashu", 18, 2000);
        Student s4 = new Student("Ishita", 77, 1500);

        Student[] arr = {s1, s2, s3, s4};

        for (int i = 1; i < arr.length; i++) {
            Student key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].donation < key.donation) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].name + " " +
                               arr[i].rollNo + " " +
                               arr[i].donation);
        }
    }
}
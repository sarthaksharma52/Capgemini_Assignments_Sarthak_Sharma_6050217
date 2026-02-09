package Sorting;

import java.util.Scanner;

class Students{
    String name;
    int fullStackMarks;
    int c;
    int java;

    Students(String name,int fullStackMarks,int c,int java){
        this.name = name;
        this.fullStackMarks = fullStackMarks;
        this.c = c;
        this.java = java;
    }

}

public class ObjectSortingWithMultipleCondition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students");
        int n = sc.nextInt();

        Students[] arr = new Students[n];

        for(int i=0;i<n;i++){
            System.out.println("Enter the student name");
            String name = sc.next();
            sc.nextLine();
            System.out.println("Enter the fullStack marks");
            int fullStackMarks = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the c marks");
            int c = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the java marks");
            int java = sc.nextInt();
            sc.nextLine();

            arr[i] = new Students(name,fullStackMarks,c,java);
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j].fullStackMarks>arr[j+1].fullStackMarks){
                    Students temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                else if(arr[j].fullStackMarks == arr[j+1].fullStackMarks && arr[j].c > arr[j+1].c){
                    Students temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                else{
                    Students temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }


        for(int i = 0;i<n;i++){
            System.out.println(arr[i].name + " " + arr[i].fullStackMarks + " " + arr[i].c + " " + arr[i].java);
        }


    }
}

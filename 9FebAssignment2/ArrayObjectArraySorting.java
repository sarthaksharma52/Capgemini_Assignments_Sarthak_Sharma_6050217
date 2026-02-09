import java.util.*;

class NewStudents{
    String name;
    int[] marks;
    int rollNo;
    int age;

    NewStudents(String name, int[] marks,int rollNo,int age){
        this.name = name;
        this.marks = marks;
        this.rollNo = rollNo;
        this.age = age;
    }
}

public class ArrayObjectArraySorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Students");
        int n = sc.nextInt();

        NewStudents[] arr = new NewStudents[n];

        for(int i=0;i<n;i++){
            System.out.println("Enter the Student name");
            String name = sc.next();
            sc.nextLine();
            System.out.println("Enter the number of Subjects");
            int mn = sc.nextInt();
            int[] marks = new int[mn];
            for(int j=0;j<mn;j++){
                System.out.println("Enter number of marks of subject " + (j+1));
                marks[j] = sc.nextInt();
            }
            System.out.println("Enter the Roll Number of Student");
            int rollNo = sc.nextInt();
            System.out.println("Enter the age of Student");
            int age = sc.nextInt();

            arr[i] = new NewStudents(name,marks,rollNo,age);
        }

        boolean swap = false;
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                int min = Math.min(arr[j].marks.length,arr[j+1].marks.length);
                for(int k=0;k<min;k++){
                    if(arr[j].marks[k] > arr[j+1].marks[k] ){
                        NewStudents temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        swap = true;
                        break;
                    }
                }
                if(!swap){
                    if (arr[j].rollNo > arr[j+1].rollNo){
                        NewStudents temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        swap = true;
                    }
                }

            }
            swap = false;
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i].name + " " + Arrays.toString(arr[i].marks) + " " + arr[i].rollNo + " " + arr[i].age);
        }
    }
}
package Sorting;

class Student{
    String name;
    int rollNo;
    int donation;

    Student(String name,int rollNo,int donation){
        this.name = name;
        this.rollNo = rollNo;
        this.donation = donation;
    }
}

public class ObjectSortingWithBubbleSort {
    public static void main(String[] args) {
        Student s1 = new Student("Sarthak",149,1000);
        Student s2 = new Student("Riya",140,5000);
        Student s3 = new Student("Ashu",18,2000);
        Student s4 = new Student("Ishita",077,1500);

        Student[] arr = {s1,s2,s3,s4};

        for(int i=0;i< arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if(arr[j].donation < arr[j+1].donation){
                    Student temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }

            }
        }

        for (int i=0;i< arr.length;i++){
            System.out.println(arr[i].name + " " + arr[i].rollNo + " " + arr[i].donation);
        }

    }
}

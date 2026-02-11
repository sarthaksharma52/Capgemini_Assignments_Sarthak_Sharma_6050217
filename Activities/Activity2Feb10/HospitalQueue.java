package Activities.Activity2Feb10;

import java.util.LinkedList;

public class HospitalQueue {
    public static void main(String[] args) {

        LinkedList<String> queue = new LinkedList<>();

        queue.add("Patient A");
        queue.add("Patient B");
        queue.add("Patient C");
        queue.add("Patient D");
        queue.add("Patient E");

        queue.addFirst("Emergency Patient");

        queue.removeFirst();
        queue.removeFirst();

        System.out.println("Current Queue: " + queue);
    }
}

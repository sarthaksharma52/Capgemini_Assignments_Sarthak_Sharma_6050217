import java.util.*;

public class LabActivity {
    public static void main(String[] args) {

        BST tree = new BST();

        int[] elements = {50, 30, 70, 20, 40, 60, 80};

        for (int e : elements) {
            tree.root = tree.insert(tree.root, e);
        }

        System.out.print("Inorder: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Preorder: ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Postorder: ");
        tree.postorder(tree.root);
        System.out.println();

        System.out.println("Search 40: " + tree.search(tree.root, 40));
        System.out.println("Search 100: " + tree.search(tree.root, 100));


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        Random rand = new Random();

        System.out.print("Inserted numbers: ");
        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(100);
            System.out.print(num + " ");
            minHeap.add(num);
        }

        System.out.println("\nSorted order (Min Heap): ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }
}

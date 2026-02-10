package Activity1Feb10;

// ticket booking queue
// Add 5 customers
// Remove 2 customers
// print queue.

class LinkedListII {
    int[] data;
    int size;

    LinkedListII() {
        this.data = new int[4];
        this.size = 0;
    }

    private void resize() {
        int[] temp = new int[data.length * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public void add(int val) {
        if (size == data.length) {
            resize();
        }
        data[size++] = val;
    }

    public int remove() {
        int val = data[0];
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return val;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}

class LinkedListAsQueue {
    public static void main(String[] args) {
        LinkedListII queue = new LinkedListII();

        queue.add(101);
        queue.add(102);
        queue.add(103);
        queue.add(104);
        queue.add(105);

        queue.print();

        queue.remove();
        queue.remove();

        queue.print();
    }
}
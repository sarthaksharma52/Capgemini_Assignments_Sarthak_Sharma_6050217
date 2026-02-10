package Activity1Feb10;

class NewArrayList{
    int[] data;
    int size;

    public NewArrayList(){
        data = new int[4];
        size = 0;
    }

    public void add(int val){
        if(size == data.length){
            resize();
        }
        data[size++] = val;
    }

    private void resize(){
        int[] newData = new int[data.length*2];
        for(int i=0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    public void display(){
        for(int i=0;i<size;i++){
            System.out.print(data[i] + " ");
        }
    }

    public void insert(int index,int val){
        for(int i=size;i>=index;i--){
            data[i] = data[i-1];
        }
        data[index] = val;
        size++;
    }

    public void findSmallest(){
        if(size == 0){
            throw new RuntimeException("List is empty");
        }

        int min = data[0];

        for(int i = 1; i < size; i++){
            int current = data[i];
            if(current < min){
                min = current;
            }
        }
        System.out.println(min);
    }

}

public class ArrayListTaskA {
    public static void main(String[] args) {
    NewArrayList list = new NewArrayList();
        list.add(40);
        list.add(20);
        list.add(99);
        list.add(65);
        list.add(10);

        list.insert(2, 55);
        list.findSmallest();
        list.display();

    }
}

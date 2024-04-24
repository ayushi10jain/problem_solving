package heap;

public class MinHeap {
    static int capacity = 5;
    static int size =-1;
    static int [] a = new int[capacity];
    public static void printArray(){
        for(int i =0; i<=size/2; i++){
           System.out.println("parent" + a[i]);
            System.out.println("left" + a[getLeftChild(i)]);
            System.out.println("right" + a[getRightChild(i)]);
        }
    }


    public static void main(String[] args) {


//       addElement( 1);
//        addElement( 2);
//        addElement( 3);
//        printArray();
//       removeElement( );
//        printArray();
//        int parent = getParent();
//        int left = getLeftChild();
//        int right = getRightChild();
//        boolean isLeaf = leaf();
System.out.println("*******MAXHEAP Starting **********");
        addElementMax(1);
        addElementMax(2);
        addElementMax(3);
        printArray();
        removeElement();
        printArray();
    }

    public static boolean leaf(int i) {
        if(i>size/2){
            return true;
        }
        return false;
    }

    public static int getParent(int i) {
       return (i-1)/2;
    }

    public static int getRightChild(int i) {
       return 2*i+2;
    }

    public static int getLeftChild(int i) {
        return 2*i+1;
    }

    public static void addElement(int x){
        if(size<capacity) {
            size = size+1;
            a[size] = x;
        }
        int i = size;
        while(i>-1 && getLeftChild(i) <capacity && getRightChild(i) < capacity
                && (a[getLeftChild(i)] > a[i] || a[getRightChild(i)] > a[i])){
            if(a[getLeftChild(i)] > a[i]){
                swap(getLeftChild(i), i);
            }
            if(a[getRightChild(i)] > a[i]){
                swap(getRightChild(i), i);
            }
            i--;
        }
    }

    public static void swap(int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;

    }

    public static int removeElement(){
        int temp = a[0];
        a[0] = a[size];
        a[size] = 0;
        size--;
        //minHeapify(0);
        maxHeapify(0);
        return temp;
    }

    private static void minHeapify(final int i) {
        if (!leaf(i)) {
            int left = getLeftChild(i);
            int right = getRightChild(i);
            int smallest = 0;
            if(left<size && a[left] < a[i]) {
                smallest = left;
            }
            if(right<size && smallest > a[right]){
                smallest = right;
            }
            if(smallest !=i){
                swap(i, smallest);
                minHeapify(smallest);
            }
        }
    }

    public static void addElementMax(int x){

        if(size<capacity) {
            size = size + 1;
            a[size] = x;

            int i = size;
            int j = getParent(i);
            while (i>-1 && a[i] > a[j]) {
                swap(i,j);
                i = getParent(i);
            }
        }
        }


    private static void maxHeapify(final int i) {
        if (!leaf(i)) {
            int left = getLeftChild(i);
            int right = getRightChild(i);
            int largest = 0;
            if(left<size && a[left] > a[i]) {
                largest = left;
            }
            if(right<size && largest > a[right]){
                largest = right;
            }
            if(largest !=i){
                swap(i, largest);
                maxHeapify(largest);
            }
        }
    }
}



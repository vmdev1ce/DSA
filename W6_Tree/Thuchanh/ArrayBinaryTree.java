public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T>{

    private E[] array;
    private int n = 0;
    private int defaulsize = 100;

    public ArrayBinaryTree(){
        array = (E[]) new Object[defaulsize];
    }

    public void setRoot(E element){
        array[0] = element;
        n++;
    }

    public void setLeft(int p, E element){
        int index_left = 2 * p + 1;
        array[index_left] = element;
        n++;
    }

    public void setRight(int p, E element){
        int index_right = 2 * p + 2;
        array[index_right] = element;
        n++;
    }

    public E getElement(int index) {
        return array[index];
    }

    @Override
    public T root() {
        return (T) array[0];
    }

    @Override
    public int size() {
        return n;
    }
    @Override
    public boolean isEmpty() {
       return n==0;
    }

    @Override
    public int numChildren(T p) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (array[i] == p) {
                index = i; 
                break; 
            }
        }
        
        if (index == -1) {
            return 0; 
        }
    
        int index_left = 2 * index + 1;
        int index_right = 2 * index + 2;
    
        int num = 0;
        if (index_left < n && array[index_left] != null) {
            num++; 
        }
    
        if (index_right < n && array[index_right] != null) {
            num++; 
        }
    
        return num;
    }
    

    @Override
    public T parent(T p) {
        int index = 0;
        for (int i =0 ; i < n; i++){
            if (array[i] == p){
                index = i;
            }
        }
        if (index % 2 ==0){
            return (T) array[index/ 2+1];
        }
        return (T) array[index/ 2] ;
    }

    @Override
    public T left(T p) {
        int index = 0;
        for (int i =0 ; i < n; i++){
            if (array[i] == p){
                index = i;
            }
        }

        return (T) array[2 * index + 1];
    }

    @Override
    public T right(T p) {
        int index = 0;
        for (int i =0 ; i < n; i++){
            if (array[i] == p){
                index = i;
            }
        }

        return (T) array[2 * index + 2];
    }

    @Override
    public T sibling(T p) {
        int index = 0;
        for (int i =0 ; i < n; i++){
            if (array[i] == p){
                index = i;
            }
        }
        if (index % 2 == 0){
            return (T) array[index - 1];
        }
        return (T) array[index + 1];
    }
    
}

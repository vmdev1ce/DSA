public interface PriorityQueueInterface<K, E> {
    int size();

    boolean isEmpty();

    void insert(Entry<K, E> entry); // thêm một entry vào PQ

    void insert(K k, E e); // thêm phần tử có khóa key và giá trị element vào PQ

    Entry<K, E> removeMin(); // loại bỏ phần tử có giá trị nhỏ nhất

    Entry<K, E> min(); // trả về phần tử có khóa nhỏ nhất
}

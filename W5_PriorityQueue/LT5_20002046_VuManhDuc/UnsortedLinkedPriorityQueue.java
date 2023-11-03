// 1.3 Xây dựng kiểu dữ liệu UnsortedLinkedPriorityQueue sử dụng danh sách liên kết,
//cài đặt giao diện PriorityQueueInterface đã xây dựng ở trên với lược đồ gợi ý như sau:

public class UnsortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            key = k;
            element = e;
            next = null;
        }

        public K getKey() {
            return key;
        }

        public E getValue() {
            return element;
        }
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    int n = 0;

    public UnsortedLinkedPriorityQueue() {
        head = null;
        tail = null;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Entry<K, E> entry) {
        NodeEntry<K, E> newEntry = new NodeEntry<>(entry.getKey(), entry.getValue());
        if (isEmpty()) {
            head = newEntry;
            tail = newEntry;
        } else {
            tail.next = newEntry;
            tail = newEntry;
        }
        n++;
    }

    public void insert(K key, E element) {
        insert(new NodeEntry<>(key, element));
    }

    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        NodeEntry<K, E> minEntry = findMinEntry();
        NodeEntry<K, E> prev = findPrevNode(minEntry);
        if (prev == null) {
            // minEntry is the head
            head = minEntry.next;
        } else {
            prev.next = minEntry.next;
        }
        n--;
        return minEntry;
    }

    public Entry<K, E> min() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return findMinEntry();
    }

    private NodeEntry<K, E> findMinEntry() {
        NodeEntry<K, E> minEntry = head;
        NodeEntry<K, E> current = head.next;
        while (current != null) {
            if (current.getKey().compareTo(minEntry.getKey()) < 0) {
                minEntry = current;
            }
            current = current.next;
        }
        return minEntry;
    }

    private NodeEntry<K, E> findPrevNode(NodeEntry<K, E> node) {
        NodeEntry<K, E> current = head;
        while (current != null && current.next != node) {
            current = current.next;
        }
        return current;
    }
}
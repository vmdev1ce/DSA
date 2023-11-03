// 1.4 Xây dựng kiểu dữ liệu SortedLinkPriorityQueue sử dụng danh sách liên kết,
//cài đặt giao diện PriorityQueueInterface đã xây dựng ở trên với lược đồ gợi ý như trong bài 1.3:

public class SortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

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
    int n = 0;

    public SortedLinkedPriorityQueue() {
        head = null;
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
        } else if (entry.getKey().compareTo(head.getKey()) < 0) {
            newEntry.next = head;
            head = newEntry;
        } else {
            NodeEntry<K, E> current = head;
            while (current.next != null && entry.getKey().compareTo(current.next.getKey()) >= 0) {
                current = current.next;
            }
            newEntry.next = current.next;
            current.next = newEntry;
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
        NodeEntry<K, E> minEntry = head;
        head = head.next;
        n--;
        return minEntry;
    }

    public Entry<K, E> min() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return head;
    }
}
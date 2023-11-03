import java.util.Random;

public class PriorityQueueTestEx2 {
    public static void main(String[] args) {
        int[] lengths = { 10_000, 100_000, 1_000_000 }; // Độ dài danh sách n

        // Lặp qua từng độ dài danh sách
        for (int length : lengths) {
            System.out.println("Length: " + length);

            // Lập danh sách n đối tượng với giá trị nguyên và sử dụng giá trị làm khóa
            Integer[] elements = generateRandomValues(length);
            Entry<Integer, Integer>[] entries = new Entry[length];
            for (int i = 0; i < length; i++) {
                entries[i] = new ArrayEntry<>(elements[i], elements[i]);
            }

            // Test UnsortedArrayPriorityQueue
            testPriorityQueue(new UnsortedArrayPriorityQueue<>(), "UnsortedArray", entries);

            // Test SortedArrayPriorityQueue
            testPriorityQueue(new SortedArrayPriorityQueue<>(), "SortedArray", entries);

            // Test UnsortedLinkedPriorityQueue
            testPriorityQueue(new UnsortedLinkedPriorityQueue<>(), "UnsortedLinked", entries);

            // Test SortedLinkedPriorityQueue
            testPriorityQueue(new SortedLinkedPriorityQueue<>(), "SortedLinked", entries);

            System.out.println();
        }
    }

    public static void testPriorityQueue(PriorityQueueInterface<Integer, Integer> queue, String queueName,
            Entry<Integer, Integer>[] entries) {
        long startTime, endTime;
        long insertTime, removeMinTime;

        // Thêm phần tử vào danh sách
        startTime = System.currentTimeMillis();
        for (Entry<Integer, Integer> entry : entries) {
            queue.insert(entry);
        }
        endTime = System.currentTimeMillis();
        insertTime = endTime - startTime;

        // Lấy ra phần tử nhỏ nhất
        startTime = System.currentTimeMillis();
        while (!queue.isEmpty()) {
            queue.removeMin();
        }
        endTime = System.currentTimeMillis();
        removeMinTime = endTime - startTime;

        // In ra kết quả
        System.out
                .println(queueName + " - Insert time: " + insertTime + "ms - RemoveMin time: " + removeMinTime + "ms");
    }

    public static Integer[] generateRandomValues(int length) {
        Random random = new Random();
        Integer[] values = new Integer[length];
        for (int i = 0; i < length; i++) {
            values[i] = random.nextInt();
        }
        return values;
    }

    static class ArrayEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;

        public ArrayEntry(K key, E element) {
            this.key = key;
            this.element = element;
        }

        public K getKey() {
            return key;
        }

        public E getValue() {
            return element;
        }
    }
}
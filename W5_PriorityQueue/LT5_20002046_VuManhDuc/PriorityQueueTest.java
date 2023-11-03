//1.5 Viết hàm test các kiểu dữ liệu PriorityQueue đã triển khai với:
//- Danh sách các số nguyên, giá trị phần tử dùng làm khóa.
//- Danh sách các đối tượng có khóa và giá trị khác nhau. Ví dụ: đối tượng
//hàng hóa bao gồm tên hàng hóa (giá trị), giá tiền (khóa).

public class PriorityQueueTest {
    public static void main(String[] args) {
        // Test PriorityQueue với danh sách các số nguyên, giá trị phần tử dùng làm khóa
        testIntegerPriorityQueue();

        // Test PriorityQueue với danh sách các đối tượng có khóa và giá trị khác nhau
        testProductPriorityQueue();
    }

    public static void testIntegerPriorityQueue() {
        // Tạo một PriorityQueue với kiểu dữ liệu Integer
        UnsortedArrayPriorityQueue<Integer, Integer> integerQueue = new UnsortedArrayPriorityQueue<>();

        // Thêm các số nguyên vào hàng đợi ưu tiên
        integerQueue.insert(3, 300);
        integerQueue.insert(1, 100);
        integerQueue.insert(2, 200);

        // Lấy số nguyên nhỏ nhất
        Entry<Integer, Integer> minInteger = integerQueue.min();
        System.out.println("Min integer: " + minInteger.getValue());

        // Xóa số nguyên nhỏ nhất
        Entry<Integer, Integer> removedInteger = integerQueue.removeMin();
        System.out.println("Removed integer: " + removedInteger.getValue());

        // Lấy số nguyên nhỏ nhất sau khi xóa
        Entry<Integer, Integer> newMinInteger = integerQueue.min();
        System.out.println("New min integer: " + newMinInteger.getValue());
    }

    public static void testProductPriorityQueue() {
        // Tạo một PriorityQueue với kiểu dữ liệu Product
        UnsortedArrayPriorityQueue<Double, Product> productQueue = new UnsortedArrayPriorityQueue<>();

        // Tạo các đối tượng hàng hóa
        Product product1 = new Product("Laptop", 1500);
        Product product2 = new Product("Smartphone", 1000);
        Product product3 = new Product("Headphones", 200);

        // Thêm các đối tượng vào hàng đợi ưu tiên
        productQueue.insert(product1.getPrice(), product1);
        productQueue.insert(product2.getPrice(), product2);
        productQueue.insert(product3.getPrice(), product3);

        // Lấy đối tượng hàng hóa có giá trị nhỏ nhất
        Entry<Double, Product> minProduct = productQueue.min();
        System.out.println("Min product: " + minProduct.getValue().getName() + " - Price: $" + minProduct.getKey());

        // Xóa đối tượng hàng hóa có giá trị nhỏ nhất
        Entry<Double, Product> removedProduct = productQueue.removeMin();
        System.out.println(
                "Removed product: " + removedProduct.getValue().getName() + " - Price: $" + removedProduct.getKey());

        // Lấy đối tượng hàng hóa có giá trị nhỏ nhất sau khi xóa
        Entry<Double, Product> newMinProduct = productQueue.min();
        System.out.println(
                "New min product: " + newMinProduct.getValue().getName() + " - Price: $" + newMinProduct.getKey());
    }

    // Định nghĩa lớp Product
    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}
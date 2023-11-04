import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DisplayTreeArray {
    public static void main(String[] args) {
        ArrayBinaryTree<Integer, Integer> b1 = new ArrayBinaryTree<>();
        b1.setRoot(1);
        b1.setLeft(0, 3);
        b1.setRight(0, 5);
        b1.setLeft(1, 2);
        b1.setRight(1, 7);
        b1.setLeft(2, 6);
        b1.setRight(2, 8);

        int[] value_tree = value(b1);
        int[] level = level(b1);

        List<List<Integer>> columns = groupElementsByBIndex(value_tree, level);
        int maxColumnHeight = calculateMaxColumnHeight(columns);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Thuchanh/output.txt"))) {
            writer.write("Array Binary Tree\n");
            printColumns(columns, maxColumnHeight, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] level(ArrayBinaryTree<Integer, Integer> tree) {
        int[] level = new int[tree.size()];
        for (int index = 0; index < tree.size(); index++) {
            level[index] = (int) (Math.log(index + 1) / Math.log(2));
        }
        return level;
    }

    public static int[] value(ArrayBinaryTree<Integer, Integer> tree) {
        int[] value_tree = new int[tree.size()];
        for (int index = 0; index < tree.size(); index++) {
            value_tree[index] = tree.getElement(index);
        }
        return value_tree;
    }

    public static List<List<Integer>> groupElementsByBIndex(int[] A, int[] B) {
        int maxIndex = -1;
        for (int index : B) {
            maxIndex = Math.max(maxIndex, index);
        }

        List<List<Integer>> columns = new ArrayList<>();
        for (int i = 0; i <= maxIndex; i++) {
            columns.add(new ArrayList<>());
        }

        for (int i = 0; i < A.length; i++) {
            columns.get(B[i]).add(A[i]);
        }

        return columns;
    }

    public static int calculateMaxColumnHeight(List<List<Integer>> columns) {
        int maxColumnHeight = 0;
        for (List<Integer> column : columns) {
            maxColumnHeight = Math.max(maxColumnHeight, column.size());
        }
        return maxColumnHeight;
    }

    public static void printColumns(List<List<Integer>> columns, int maxColumnHeight, BufferedWriter writer)
            throws IOException {
        int numColumns = columns.size();

        for (int i = 0; i < maxColumnHeight; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (i >= columns.get(j).size()) {
                    writer.write("\t");
                } else {
                    writer.write(columns.get(j).get(i) + "\t");
                }
            }
            writer.write("\n");
        }
    }

}

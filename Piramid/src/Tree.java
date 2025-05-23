import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Tree {
    private String name;
    private Tree left;
    private Tree right;

    public Tree(String name) {
        this.name = name;
    }

    public boolean contains(String query) {
        if (query.compareTo(name) < 0) {
            return left != null && left.contains(query);
        } else if (query.compareTo(name) > 0) {
            return right != null && right.contains(query);
        } else {
            return name.equals(query);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    // Реализация метода isNamePyramid
    public boolean isNamePyramid() {
        // Проверяем левого потомка
        if (left != null) {
            if (name.length() > left.getName().length()) {
                return false; // Нарушение свойства пирамидальности
            }
            if (!left.isNamePyramid()) {
                return false; // Левое поддерево не является пирамидой
            }
        }

        // Проверяем правого потомка
        if (right != null) {
            if (name.length() > right.getName().length()) {
                return false; // Нарушение свойства пирамидальности
            }
            if (!right.isNamePyramid()) {
                return false; // Правое поддерево не является пирамидой
            }
        }

        // Если все проверки пройдены, то текущее дерево является пирамидой
        return true;
    }

    @Override
    public String toString() {
        String[] leftLines = (left != null ? left.toString() : "").split("\n");
        String[] rightLines = (right != null ? right.toString() : "").split("\n");

        int maxLeftSize = Arrays.stream(leftLines)
                .map(String::length)
                .max(Comparator.naturalOrder())
                .orElse(0);

        List<String> lines = new ArrayList<>();
        lines.add(" ".repeat(maxLeftSize + 1) + name);
        for (int i = 0; i < Math.max(leftLines.length, rightLines.length); i++) {
            String prefix = i < leftLines.length ? leftLines[i] : "";
            lines.add(
                    prefix +
                            " ".repeat(maxLeftSize + name.length() + 1 * 2 - prefix.length()) +
                            (i < rightLines.length ? rightLines[i] : "")
            );
        }

        return lines.stream().collect(Collectors.joining("\n"));
    }
}
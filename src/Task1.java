import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    private List<Integer> sortedDistinctArrayList = new ArrayList<>();
    private int noDistinctCount;

    public Task1(List<Integer> sortedDistinctArrayList) {
        this.noDistinctCount = sortedDistinctArrayList.size();
        this.sortedDistinctArrayList = sortedDistinctArrayList.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private int getCount() {
        return sortedDistinctArrayList.size();
    }

    private int getNoDistinctCount() {
        return noDistinctCount;
    }

    private int getMin() {
        return sortedDistinctArrayList.get(0);
    }

    private int getMax() {
        return sortedDistinctArrayList.get(sortedDistinctArrayList.size()-1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number: sortedDistinctArrayList) {
            stringBuilder.append(number);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("\n");
        stringBuilder.append("count: ");
        stringBuilder.append(getNoDistinctCount());
        stringBuilder.append("\n");
        stringBuilder.append("distinct: ");
        stringBuilder.append(getCount());
        stringBuilder.append("\n");
        stringBuilder.append("min: ");
        stringBuilder.append(getMin());
        stringBuilder.append("\n");
        stringBuilder.append("max: ");
        stringBuilder.append(getMax());
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}

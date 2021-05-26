import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    private List<Integer> sortedArrayList = new ArrayList<>();

    public Task2(List<Integer> sortedDistinctArrayList) {
        this.sortedArrayList = sortedDistinctArrayList.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void printPairs() {
        int PAIR_SUM = 13;

        // Store counts of all elements in hashMap
        Map<Integer, Integer> hashMap = new HashMap<>();
        // Map for store all pairs
        Map<Integer, Integer> resultMap = new TreeMap<>();

        // Go through all elements
        for (Integer element : sortedArrayList) {
            // Search if a pair can be summed with i-element
            int remainder = PAIR_SUM - element;
            if (hashMap.containsKey(remainder)) {
                    resultMap.put(remainder, element);
            }
            if (hashMap.containsKey(element)) {
                hashMap.put(element, hashMap.get(element) + 1);
            } else {
                hashMap.put(element, 1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        //Print pairs
        for (Map.Entry<Integer, Integer> entry: resultMap.entrySet()) {
            int count = hashMap.get(entry.getKey());

            for (int j = 0; j < count; j++) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append(" ");
                stringBuilder.append(entry.getValue());
                stringBuilder.append("\n");
            }
        }
        System.out.println(stringBuilder.toString());
    }

}

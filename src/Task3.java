import java.util.*;

public class Task3 {

    private HashSet<Integer> nodes = new HashSet<>();
    private Map<Integer, HashSet<Integer>> adjMap;
    Map<Integer, Boolean> visited;
    private int size = 0;

    public Task3(int[][] arr) {

        HashSet<Integer> nodeMap = new HashSet<>();
        for (int[] ints : arr) {
            nodeMap.add(ints[0]);
            nodeMap.add(ints[1]);
        }
        this.nodes = nodeMap;
        adjMap = new HashMap<Integer, HashSet<Integer>>();
        visited = new HashMap<>();

        for (int[] ints : arr) {
            addEdge(ints[0], ints[1]);
        }
    }

    // Adds an edge to an undirected graph
    private void addEdge(int src, int dest)
    {
        adjMap.putIfAbsent(src, new HashSet<Integer>());
        adjMap.putIfAbsent(dest, new HashSet<Integer>());
        adjMap.get(src).add(dest);
        adjMap.get(src).add(src);
        adjMap.get(dest).add(src);
        adjMap.get(dest).add(dest);
        visited.put(src, false);
        visited.put(dest, false);
    }


    private void findDFS(int v)
    {
        // Mark the current node as visited and print it
        visited.put(v, true);
        // Recur for all the vertices
        // adjacent to this vertex
        for (int x : adjMap.get(v)) {
            if (!visited.get(x))
                findDFS(x);
        }
    }

    private int countConnectedComponents() {
        int count = 0;

        for (Map.Entry<Integer, Boolean> entry : visited.entrySet()) {
            if (!entry.getValue()) {
                findDFS(entry.getKey());
                count++;
            }
        }
        return count;
    }


    @Override
    public String toString() {
        return String.valueOf(countConnectedComponents());
    }
}

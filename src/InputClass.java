import java.util.*;

public class InputClass {

    public static void main(String[] args) {
        int choosenTask = -1;
        while (choosenTask != 0) {
            choosenTask = chooseTask();
            if (choosenTask == 1) {
                Task1 task = new Task1(inputForTask1and2());
                System.out.println(task);
            }
            if (choosenTask == 2) {
                Task2 task = new Task2(inputForTask1and2());
                task.printPairs();
            }
            if (choosenTask == 3) {
                Task3 task = new Task3(inputForTask3());
                System.out.println(task);
            }
        }
        System.out.println("Thank you! Bye!");
    }

    private static int chooseTask() {
        System.out.println("Enter the number of the task you want to check?");
        System.out.println("1 - Task 1 : distinct sorted list and basic measurement information");
        System.out.println("2 - Task 2 : all the pairs that sum up to 13");
        System.out.println("3 - Task 3 : How many separated graphs are in the input");
        System.out.println("0 - Exit");
        System.out.print("Input: ");
        boolean isError = true;
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (isError) {
            input = scanner.nextLine();

            if (input.equals("0") || input.equals("1") || input.equals("2") || input.equals("3")) {
                isError = false;
                continue;
            }
            System.out.println();
            System.out.println("Wrong input!");
            System.out.println("Enter the number of the task you want to check?");
            System.out.println("1 - Task 1 : distinct sorted list and basic measurement information");
            System.out.println("2 - Task 2 : all the pairs that sum up to 13");
            System.out.println("3 - Task 3 : How many separated graphs are in the input");
            System.out.println("0 - Exit");
            System.out.print("Input: ");
        }
        return Integer.parseInt(input);
    }

    private static List<Integer> inputForTask1and2() {
        System.out.println();
        System.out.println("Enter list of integers separated by a space");
        System.out.println("For example: 1 10 20 20 2 5");
        System.out.print("Input: ");
        boolean isError = true;
        Scanner scanner = new Scanner(System.in);
        List<Integer> arrayList = new ArrayList<>();
        String input = "";
        while (isError) {
            try {
                input = scanner.nextLine();
                String[] numbers = input.split(" ");
                List<String> numbersList = new ArrayList<String>();
                numbersList = Arrays.asList(numbers);
                for (String s : numbersList) {
                    arrayList.add(Integer.parseInt(s));
                }
                isError = false;
                continue;
            }
            catch (NumberFormatException ignored) {
            }
            System.out.println();
            System.out.println("Wrong input!");
            System.out.println("Enter list of integers separated by a space");
            System.out.println("For example: 1 10 20 20 2 5");
            System.out.print("Input: ");
        }
        return arrayList;
    }

    private static int[][] inputForTask3() {
        System.out.println();
        System.out.println("Enter Data. The first line of input contains a positive number n, next n lines contains pairs of positive integers, where each pair identifies a connection between two vertices in a graph");
        System.out.println("For example:");
        System.out.println("3");
        System.out.println("1 2");
        System.out.println("2 3");
        System.out.println("5 6");
        System.out.print("Input: ");
        boolean isError = true;
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> arrayList = new ArrayList<>();
        String input = "";
        int lineCount = 0;
        int[][] arr = new int[0][];
        while (isError) {
            try {
                input = scanner.nextLine();
                lineCount = Integer.parseInt(input);
                arr = new int[lineCount][2];
                int i = 0;
                while (lineCount > 0) {
                    String line = scanner.nextLine();
                    String[] lineArray = line.split(" ");
                    arr[i][0] = Integer.parseInt(lineArray[0]);
                    arr[i][1] = Integer.parseInt(lineArray[1]);
                    i++;
                    lineCount--;
                }

                isError = false;
                continue;
            }
            catch (NumberFormatException | InputMismatchException ignored) {
            }
            System.out.println();
            System.out.println("Enter Data. The first line of input contains a positive number n, next n lines contains pairs of positive integers, where each pair identifies a connection between two vertices in a graph");
            System.out.println("For example:");
            System.out.println("3");
            System.out.println("1 2");
            System.out.println("2 3");
            System.out.println("5 6");
            System.out.print("Input: ");
        }
        return arr;
    }
}

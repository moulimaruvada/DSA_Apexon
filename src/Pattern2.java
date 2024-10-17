import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pattern2 {
    public static List<String> generateCombinations(String[] input) {
        List<String> combinations = new ArrayList<>();
        generateCombinations(input, 0, "", combinations);
        return combinations;
    }

    private static void generateCombinations(String[] input, int index, String current, List<String> combinations) {
        if (index == input.length) {
            if (!current.isEmpty()) {
                combinations.add(current);
            }
            return;
        }
        // Include the current element
        generateCombinations(input, index + 1, current + input[index], combinations);
        // Exclude the current element
        generateCombinations(input, index + 1, current, combinations);
    }

    public static void main(String[] args) {
        String[] input = {"a", "b", "c"};
        List<String> result = generateCombinations(input);
        System.out.println(result);
    }
}

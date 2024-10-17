import java.util.HashMap;
import java.util.Map;

public class StudentAverage {

    public static void main(String[] args) {
        String[][] stu = new String[][]{{"Charles","84"},{"John","100"},{"Andy","37"},{"John","23"},{"Charles","20"}};
        Map<String, Integer> studentsMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        double highestAverage = Double.MIN_VALUE;
        for (int i = 0; i< stu.length; i++) {
            String name = stu[i][0];
            int mark = Integer.parseInt(stu[i][1]);
            studentsMap.put(name,studentsMap.getOrDefault(name,0)+mark);
            countMap.put(name,countMap.getOrDefault(name,0)+1);
        }

        for (Map.Entry<String, Integer> m: studentsMap.entrySet()) {
            String name = m.getKey();
            int marks = m.getValue();
            int count = countMap.get(name);

            double average = (double) marks /count;

            if (average > highestAverage) {
                highestAverage = average;
            }
        }

        System.out.println(highestAverage);
    }


}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelArraySum {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) throws Exception {
        // Example large array
        int[] array = new int[1_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1; // Fill with values from 1 to 1,000,000
        }

        // Calculate sum using multiple threads
        long startTime = System.nanoTime();
        long sum = parallelSum(array);
        long endTime = System.nanoTime();
        System.out.println("Total Sum: " + sum);
        System.out.println("Execution Time: " + (endTime - startTime) + " nanoseconds");
    }

    public static long parallelSum(int[] array) throws Exception {
        int length = array.length;
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        Future<Long>[] futures = new Future[NUM_THREADS];

        // Divide the array into chunks
        int chunkSize = length / NUM_THREADS;

        for (int i = 0; i < NUM_THREADS; i++) {
            final int start = i * chunkSize;
            final int end = (i == NUM_THREADS - 1) ? length : start + chunkSize;
            futures[i] = executor.submit(() -> {
                long partialSum = 0;
                for (int j = start; j < end; j++) {
                    partialSum += array[j];
                }
                return partialSum;
            });
        }

        long totalSum = 0;
        for (Future<Long> future : futures) {
            totalSum += future.get(); // Collect results from each thread
        }

        executor.shutdown();
        return totalSum;
    }

    public static long parallelSumWithoutMultiThreading(int[] array) throws Exception {
        long startTime = System.nanoTime();
        long totalSum = 0;
        for (int i = 0; i < array.length; i++) {
            totalSum += array[i];
        }

        return totalSum;
    }
}
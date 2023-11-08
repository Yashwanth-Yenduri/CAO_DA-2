import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Main {
    public static void main(String[] args) {
        // Record the start time
        long overallStartTime = System.nanoTime();

        // Create a thread pool with a fixed number of threads (5 in this case)
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Create five tasks to represent cyber threat detection and mitigation
        Runnable task1 = new CyberThreatDetectionTask("Task 1");
        Runnable task2 = new CyberThreatDetectionTask("Task 2");
        Runnable task3 = new CyberThreatMitigationTask("Task 3");
        Runnable task4 = new CyberThreatDetectionTask("Task 4");
        Runnable task5 = new CyberThreatMitigationTask("Task 5");

        // Submit the tasks to the thread pool for parallel execution
        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);
        executor.submit(task4);
        executor.submit(task5);

        // Shutdown the thread pool after all tasks are completed
        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Record the end time
        long overallEndTime = System.nanoTime();

        float overallExecutionTime = (overallEndTime - overallStartTime) / 1_000_000_000.0f; // Convert nanoseconds to floating-point seconds
        System.out.println("Overall execution time: " + overallExecutionTime + " seconds");
    }
}

class CyberThreatDetectionTask implements Runnable {
    private String name;

    public CyberThreatDetectionTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        System.out.println("Detecting cyber threats in " + name);
        // Simulate threat detection - you can implement your detection logic here
        boolean threatDetected = Math.random() < 0.2; // Simulate a 20% chance of detecting a threat
        long endTime = System.nanoTime();
        float executionTime = (endTime - startTime) / 1_000_000_000.0f; // Convert nanoseconds to floating-point seconds

        if (threatDetected) {
            System.out.println("Task " + name + " detected a cyber threat and took " + executionTime + " seconds to execute.");
            sendNotification(name + " detected a cyber threat!");
        } else {
            System.out.println("Task " + name + " did not detect a cyber threat and took " + executionTime + " seconds to execute.");
        }
    }

    private void sendNotification(String message) {
        // Replace this with your actual notification mechanism (e.g., sending an alert, email, SMS)
        System.out.println("Notification: " + message);
    }
}

class CyberThreatMitigationTask implements Runnable {
    private String name;

    public CyberThreatMitigationTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        System.out.println("Mitigating cyber threats in " + name);
        // Implement your cyber threat mitigation logic here
        long endTime = System.nanoTime();
        float executionTime = (endTime - startTime) / 1_000_000_000.0f; // Convert nanoseconds to floating-point seconds
        System.out.println("Task " + name + " took " + executionTime + " seconds to execute.");
    }
}

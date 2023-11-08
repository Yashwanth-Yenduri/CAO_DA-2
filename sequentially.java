class Main {
    public static void main(String[] args) {
        // Record the start time
        long overallStartTime = System.nanoTime();

        // Create five tasks to represent cyber threat detection
        CyberThreatDetectionTask task1 = new CyberThreatDetectionTask("Task 1");
        CyberThreatDetectionTask task2 = new CyberThreatDetectionTask("Task 2");
        CyberThreatDetectionTask task3 = new CyberThreatDetectionTask("Task 3"); // Added Task 3
        CyberThreatDetectionTask task4 = new CyberThreatDetectionTask("Task 4");
        CyberThreatDetectionTask task5 = new CyberThreatDetectionTask("Task 5"); // Added Task 5

        // Execute the tasks sequentially
        task1.run();
        task2.run();
        task3.run();
        task4.run();
        task5.run();

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
        // Implement your cyber threat detection logic here
        // For simplicity, I'm just adding a delay to simulate the detection process
        try {
            Thread.sleep(1000); // Simulate detection taking 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        float executionTime = (endTime - startTime) / 1_000_000_000.0f; // Convert nanoseconds to floating-point seconds
        System.out.println("Task " + name + " took " + executionTime + " seconds to execute");
    }
}

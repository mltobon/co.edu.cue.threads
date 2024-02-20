package org.example;

public class Race {
    public static void main(String[] args) throws InterruptedException {
        HydrationStation station = new HydrationStation();
        EnhancedRunner runner1 = new EnhancedRunner("Runner 1", station);
        EnhancedRunner runner2 = new EnhancedRunner("Runner 2", station);

        runner1.start();
        runner2.start();

        // Wait and then interrupt the runners as an example of how to handle interruptions and synchronization in a multi-threaded environment.
        // You can add your own logic to determine when to interrupt the runners based on your specific scenario.

        // Simulate race being canceled after a short period
       Thread.sleep(1000); // Wait for 2 seconds before canceling the race

        // Interrupting all runners due to race cancellation
        System.out.println("Race has been canceled. Interrupting all runners.");
        runner1.interrupt();
        runner2.interrupt();

        // Wait for all runners to finish processing their interruption
        runner1.join();
        runner2.join();

        System.out.println("Race ended due to cancellation.");
    }
}

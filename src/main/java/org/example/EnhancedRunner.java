package org.example;

public class EnhancedRunner extends Thread{
    private final HydrationStation station;
    private final int totalDistance = 100;
    private int distanceCovered = 0;

    public EnhancedRunner(String name, HydrationStation station) {
        super(name);
        this.station = station;
    }

    @Override
    public void run() {
        while (!isInterrupted() && distanceCovered < totalDistance) {
            // Runner advances
            distanceCovered += (int) (Math.random() * 10) + 1;
            System.out.println(getName() + " has advanced to " + distanceCovered + " meters.");

            // Use the hydration station in a synchronized manner
            if (distanceCovered >= 50) { // For example, a station halfway through
                station.use(getName());
                // Check for interruption after using the station
                if (isInterrupted()) {
                    System.out.println(getName() + " has been interrupted after using the hydration station.");
                    break; // Exit the loop and end the thread
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted while resting.");
                interrupt(); // Preserve the interrupt status after catching InterruptedException
                break; // Exit the loop and end the thread
            }
        }
        if (!isInterrupted()) {
            System.out.println(getName() + " has completed the race!");
        } else {
            System.out.println(getName() + " is stopping the race due to interruption.");
        }
    }
}

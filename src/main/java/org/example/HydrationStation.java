package org.example;

class HydrationStation {
    public synchronized void use(String name) {
        System.out.println(name + " is using the hydration station.");
        try {
            Thread.sleep(1000); // Simulates the time of use
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted while using the station.");
            Thread.currentThread().interrupt(); // Re-interrupt to preserve the interrupt status
        }
    }
}

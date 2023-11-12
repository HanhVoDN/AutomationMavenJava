public class SharedResource {
    boolean isDataReady = false;

    synchronized void produceData() {
        // Producing data...
        System.out.println("Producing data...");
        isDataReady = true;
        notify(); // Notify a waiting thread
    }

    synchronized void consumeData() {
        while (!isDataReady) {
            try {
                wait(); // Wait until data is ready
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        // Consuming data...
        System.out.println("Consuming data...");
        isDataReady = false;
    }
}



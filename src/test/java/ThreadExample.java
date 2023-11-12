public class ThreadExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(() -> {
            sharedResource.produceData();
        });

        Thread consumerThread = new Thread(() -> {
            sharedResource.consumeData();
        });

        producerThread.start();
        consumerThread.start();
    }
}

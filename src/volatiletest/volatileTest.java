package volatiletest;

public class volatileTest {

    static boolean running = true;
    static volatile boolean runningVolatile = true;

    public static void main(String[] args) throws InterruptedException {

//        withoutVolatile();

        withVolatile();
    }

    private static void withoutVolatile() throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (running) {
                // Busy-wait loop
            }
            System.out.println("Stopped!");
        });

        thread.start();

        Thread.sleep(1000); // Let thread run for 1 second
        running = false;    // This change may NOT be visible to the thread!
    }

    private static void withVolatile() throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (runningVolatile) {
                // Busy-wait loop
            }
            System.out.println("Stopped!");
        });

        thread.start();

        Thread.sleep(1000); // Let thread run for 1 second
        runningVolatile = false;    // This change may NOT be visible to the thread!
    }



}


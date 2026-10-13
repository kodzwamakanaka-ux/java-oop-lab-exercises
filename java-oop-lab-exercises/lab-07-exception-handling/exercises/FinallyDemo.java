// Assignment 7 (Lab 7) - Exercise 5 (Challenge)
public class FinallyDemo {
    static int test() {
        try {
            System.out.println("in try");
            return 1;                       // value 1 is prepared as the return value...
        } finally {
            System.out.println("in finally"); // ...but finally STILL runs before the method exits
        }
    }

    public static void main(String[] args) {
        // PREDICTION: prints "in try", then "in finally", then "result = 1"
        int result = test();
        System.out.println("result = " + result);

        /* EXPLANATION: finally exists for cleanup (closing files, releasing locks), so Java guarantees it
           runs however the try block ends: normal completion, return, break, or an exception. The return
           value is evaluated first, then finally runs, then the method returns. (Only System.exit() or a
           JVM crash can skip it. Avoid return inside finally: it would override the try's return value.) */
    }
}

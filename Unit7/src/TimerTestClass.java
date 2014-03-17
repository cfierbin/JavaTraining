import java.util.Timer;
import java.util.TimerTask;


public class TimerTestClass {
    private long myLong = 5000;//delay value in milliseconds
    private final java.util.Random randomInstance = new java.util.Random();

    public static void main(String[] args) {
        final TimerTestClass test = new TimerTestClass();

        Timer timer = new Timer();
        //Schedules the specified task for repeated fixed-delay execution, beginning at the specified time
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                test.doStuff();
            }
        }, 0, test.myLong);
    }

    private void doStuff(){
        System.out.println(myLong/1000 + " seconds");
    }
}
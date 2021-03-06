package in.co.madhur.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CalculationTaskD implements Callable<Integer> {
    private int a;
    private int b;
    private long sleepTime;


    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

    public CalculationTaskD(int a, int b, long sleepTime) {
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "CalcTaskD-" + instanceNumber;
    }

    @Override
    public Integer call() throws Exception {

        Date startTime = new Date();

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("###[" + currentThreadName + "] <" + taskId + "> STARTED at ###" + dateFormatter.format(startTime) + " ####");
        //System.out.println("[" + currentThreadName + "] <" + taskId + "> Sleeping for " + sleepTime + " millis");

        TimeUnit.MILLISECONDS.sleep(sleepTime);

        System.out.println("*** [" + currentThreadName + "] <" + taskId + "> FINISHED AT ***" + dateFormatter.format(new Date()));
        return a  + b;
    }
}

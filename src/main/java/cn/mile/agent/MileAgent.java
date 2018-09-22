package cn.mile.agent;

import java.lang.instrument.Instrumentation;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MileAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("this is an perform monitor agent.");

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            public void run() {
                Metric.printMemoryInfo();
                Metric.printGCInfo();
            }
        }, 0, 3000, TimeUnit.MILLISECONDS);
    }
}

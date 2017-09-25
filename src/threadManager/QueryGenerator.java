package threadManager;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.StringTokenizer;


/**
 * Created by user on 25.09.2017.
 */


public class QueryGenerator extends Thread {
    private static final int maxSleepTime = 500;
    private static final int maxWorkerSleepTime = 2000;
    private Writer writer;
    private Manager manager;
    private int resourceMax;

    public QueryGenerator(Writer writer, Manager manager, int resourceMax){
        this.manager = manager;
        this.resourceMax = resourceMax;
        this.writer = writer;
    }

    @Override
    public void run(){
        super.run();
        Random random = new Random();
        int i = 0;
        while(manager.isAlive()){
            GetQuery getQuery = new GetQuery(i);
            getQuery.start();
            ++i;
            try {
                sleep(random.nextInt(maxSleepTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread.getAllStackTraces()
                .keySet()
                .stream()
                .filter(t ->
                        t.getName().startsWith("worker") && t.isAlive())
                .forEach(t -> {
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
    private class GetQuery extends Thread{
        private String name;
        public GetQuery(int number){
            this.name = "worker number " +number;

        }

        @Override
        public void run(){
            super.run();
            writer.writeInLog(new Object[] {name, "started"});
            Random random = new Random();
            int concreteResourses= random.nextInt(resourceMax+4);
            try {
                manager.getResourses(concreteResourses);
                manager.returnResourses(concreteResourses);
                writer.writeInLog(new Object[] {name, "- returned resourses"});
            }catch (NoSuchElementException e){
                writer.writeInLog(new Object[] {e});
            }


        }
    }
}

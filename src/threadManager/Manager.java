package threadManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by user on 25.09.2017.
 */

//fixed using AtomicInteger
public class Manager extends Thread {
    private static  AtomicInteger resourse;
    private static int workingTime;
    private Writer writer;

    public Manager(Writer writer, int maxResourse, int workingTime){
        this.resourse.set(maxResourse);
        this.workingTime = workingTime;
        this.writer = writer;
        this.start();
    }



    private boolean enoughResourses(int number){
        if (number <= resourse.get()){
            writer.writeInLog(new Object[] {"server give", number});
            return true;
        }else{
            writer.writeInLog(new Object[] {"server can't give", number});
            return false;
        }
    }

    public synchronized void getResourses(int number){
        if(enoughResourses(number)){
            resourse.getAndAdd(-number);
        }else{
            throw new NoSuchElementException("not enough resourses");
        }
        return;
    }

    public void returnResourses(int number){
        resourse.getAndAdd(number);
        writer.writeInLog(new Object[] {"server get", number, "back"});
    }

    @Override
    public void run(){
        super.run();
        writer.writeInLog(new Object[] {"server started with", resourse, "resourses"});
        try {
            sleep(workingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        writer.writeInLog(new Object[] {"server stoped with", resourse, "resourses"});
    }

}

package threadManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;


/**
 * Created by user on 25.09.2017.
 */


public class Manager extends Thread {
    private static int resourse;
    private static int workingTime;
    private Writer writer;

    public Manager(Writer writer, int maxResourse, int workingTime){
        this.resourse = maxResourse;
        this.workingTime = workingTime;
        this.writer = writer;
    }



    private boolean enoughResourses(int number){
        if (number <= resourse){
            writer.writeInLog(new Object[] {"server give", number});
            return true;
        }else{
            writer.writeInLog(new Object[] {"server can't give", number});
            return false;
        }
    }

    public synchronized void getResourses(int number){
        if(enoughResourses(number)){
            resourse -= number;
        }else{
            throw new NoSuchElementException("not enough resourses");
        }
        return;
    }

    public synchronized void returnResourses(int number){
        resourse += number;
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

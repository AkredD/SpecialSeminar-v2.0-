package threadManager;

import java.io.*;
import java.util.Properties;
import java.util.StringTokenizer;


/**
 * Created by user on 25.09.2017.
 */


public class mainThreadTest {
    public static void main(String[] args) throws Exception {


        Properties properties = new Properties();
        try {
            properties.load(mainThreadTest.class.getResourceAsStream("managing.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        int maxResourse = Integer.parseInt(properties.getProperty("maxResourse"));
        int workingTime = Integer.parseInt(properties.getProperty("working_time"));
        String logFile = properties.getProperty("logfile_name");
        Writer writer = new Writer(logFile);
        Manager manager = new Manager(writer, maxResourse, workingTime);
        QueryGenerator queryGenerator = new QueryGenerator(writer, manager, maxResourse);
        //QueryGenerator queryGenerator2 = new QueryGenerator(writer, manager, maxResourse);
        queryGenerator.start();
        //queryGenerator2.start();
        try {
            queryGenerator.join();
            //queryGenerator2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        writer.stopWrite();
    }

    private static class Scanner {
        private BufferedReader br;
        private StringTokenizer t;

        public Scanner(File file) throws Exception {
            br = new BufferedReader(new FileReader(file));
            t = new StringTokenizer("");
        }

        public boolean hasNext() throws Exception {
            while (!t.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null)
                    return false;
                t = new StringTokenizer(line);
            }
            return true;
        }


        public String next() throws Exception {
            if (hasNext()) {
                return t.nextToken();
            }
            return null;
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws Exception {
            return Double.parseDouble(next());
        }

        public void close() throws Exception {
            br.close();
        }
    }
}

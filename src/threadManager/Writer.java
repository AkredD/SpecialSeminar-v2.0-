package threadManager;

import java.io.*;
import java.util.StringTokenizer;


/**
 * Created by user on 25.09.2017.
 */


public class Writer{
    private static PrintWriter out;
    public Writer(String logFile) {
        try {
            this.out = new PrintWriter(new File(logFile));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public synchronized void writeInLog(Object[] a) {
        for (int i = 0; i < a.length; ++i) {
            out.print(a[i].toString());
            out.print(" ");
        }
        out.println();
    }
    public void stopWrite(){
        out.close();
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

import employees.mainParseTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


/**
 * Created by user on 25.09.2017.
 */


public class main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("input.txt"));
        //Scanner sc = new Scanner(new File("mainTreeTest.in"));
        PrintWriter out = new PrintWriter(new File("logs.txt"));
        //PrintWriter out = new PrintWriter(new File("mainTreeTest.out"));
        //mainThreadTest threadTest = new mainThreadTest();
        //threadTest.main(new String[]{});
        //mainTreeTest treeTest = new mainTreeTest();
        //mainTreeTest.main(new String[]{});
        mainParseTest parseTest = new mainParseTest();
        parseTest.main(new String[]{});

        /*File file = new File("input.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        out.print(Arrays.stream(reader.readLine().split(" ")).sorted().reduce((x,y) -> x + " " + y).get());*/

        sc.close();
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

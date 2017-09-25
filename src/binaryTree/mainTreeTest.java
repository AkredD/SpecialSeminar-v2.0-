package binaryTree;

import binaryTree.operationWithTree.Evaluate;
import binaryTree.operationWithTree.InverseTree;
import binaryTree.operationWithTree.ToString;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Created by user on 25.09.2017.
 */


public class mainTreeTest {
    public static void main(String[] args) throws Exception {
        //Scanner sc = new Scanner(new File("input.txt"));
        //Scanner sc = new Scanner(new File("mainTreeTest.in"));
        PrintWriter out = new PrintWriter(new File("logs.txt"));
        //PrintWriter out = new PrintWriter(new File("mainTreeTest.out"));
        BiNode<Integer, Character> tree = new BiNode<>(
                '+',
                new BiNode<>(
                        '*',
                        new Leaf<>(10),
                        new Leaf<>(-6)
                ),
                new BiNode<>(
                        '+',
                        new Leaf<>(5),
                        new BiNode<>(
                                '-',
                                new Leaf<>(99),
                                new Leaf<>(33)
                        )
                )
        );
        Process<Integer> evaluate1 = new Evaluate(tree);
        out.println((evaluate1.makeAction()));

        Process<String> evaluate2 = new ToString(tree);
        out.println(evaluate2.makeAction());

        Process<BiNode<Integer, Character>> evaluate3 = new InverseTree(tree);
        tree = evaluate3.makeAction();
        out.println((new ToString(tree).makeAction()));

        evaluate1 = new Evaluate(tree);
        out.println((evaluate1.makeAction()));
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

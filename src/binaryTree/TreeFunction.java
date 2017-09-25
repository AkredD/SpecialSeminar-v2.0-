package binaryTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Created by user on 25.09.2017.
 */


@FunctionalInterface
public interface TreeFunction<T,R> {
    R apply(T arg1, R agr2, R arg3);
}


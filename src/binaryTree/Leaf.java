package binaryTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.function.Function;


/**
 * Created by user on 25.09.2017.
 */


public class Leaf<V, T> implements Node<V, T> {
    private V leafInfo;
    public Leaf(V leaf) { leafInfo = leaf; }
    public <R> R process(Function<V,R> leafProcessor,
                         TreeFunction<T,R> biNodeProcessor) {
        return leafProcessor.apply(leafInfo);
    }
}


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


public class BiNode<V, T> implements Node<V, T> {
    private T binInfo;
    private Node<V, T> left, right;

    public BiNode(T info, Node<V, T> left, Node<V, T> right) {
        binInfo = info;
        this.left = left;
        this.right = right;
    }

    public <R> R process(Function<V,R> leafProcessor,
                         TreeFunction<T,R> biNodeProcessor) {
        R res1 = left.process(leafProcessor, biNodeProcessor);
        R res2 = right.process(leafProcessor, biNodeProcessor);
        return biNodeProcessor.apply(binInfo, res1, res2);
    }
}


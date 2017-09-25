package binaryTree.operationWithTree;

import java.util.function.BinaryOperator;




import binaryTree.BiNode;
import binaryTree.Node;
import binaryTree.Process;
import binaryTree.TreeFunction;
import java.util.function.Function;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.BinaryOperator;


/**
 * Created by user on 25.09.2017.
 */


public class Evaluate implements Process {

    private final Map<Character, BinaryOperator<Integer>> operatorMap =
            new HashMap<Character, BinaryOperator<Integer>>() {{
                put('-', (x, y) -> x - y);
                put('*', (x, y) -> x * y);
                put('+', (x, y) -> x + y);
            }};

    protected BiNode<Integer, Character> tree;

    public Evaluate(BiNode<Integer, Character> a){
        this.tree = a;
    }


    public static <Integer, Operation> Integer evaluate(Map <Operation, BinaryOperator<Integer>> operatorMap, Node <Integer, Operation> tree) {
        return tree.process(
                t -> t,
                (operator, arg1, arg2) -> operatorMap.get(operator).apply(arg1, arg2));
    }

    @Override
    public Integer makeAction(){
        return evaluate(operatorMap, tree);
    }

}

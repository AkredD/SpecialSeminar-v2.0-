package binaryTree.operationWithTree;

import binaryTree.*;
import binaryTree.Process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.function.UnaryOperator;


/**
 * Created by user on 25.09.2017.
 */


public class InverseTree implements Process {
    protected Node<Integer, Character> tree;

    public InverseTree(Node<Integer, Character> a){
        this.tree = a;
    }

    private static Node<Integer, Character> inverseTree(Node<Integer, Character> tree, UnaryOperator<Integer> negate){
        return tree.process(
                e -> new Leaf<>(negate.apply(e)),
                (TreeFunction<Character, Node<Integer, Character>>) BiNode::new);

    }



    @Override
    public Node<Integer, Character> makeAction(){
        UnaryOperator<Integer> negate = e -> -e;
        return inverseTree(tree, negate);
    }

}

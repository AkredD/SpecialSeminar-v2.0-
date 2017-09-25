package binaryTree.operationWithTree;

import binaryTree.BiNode;
import binaryTree.Node;
import binaryTree.Process;
import com.sun.corba.se.spi.orb.Operation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.BinaryOperator;


/**
 * Created by user on 25.09.2017.
 */


public class ToString implements Process {
    protected BiNode<Integer, Character> tree;

    public ToString(BiNode<Integer, Character> a){
        this.tree = a;
    }


    @Override
    public String makeAction(){
        return tree.process(
                t -> t.toString(),
                (Character operator,String arg1,String arg2) -> "(" + arg1 + " " + operator + " " + arg2 + ")");
    }
}

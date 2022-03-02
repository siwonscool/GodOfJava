package StackImplement;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        GenericTenStack<String> a = new GenericTenStack<>();
        //System.out.println(a.peek());

        Stack<String> s = new Stack<>();
        IntegerTenStack in = new IntegerTenStack();
        GenericDoubleStack<Integer> is = new GenericDoubleStack<>();
        in.push(1);
        is.push(33);
        is.pop();
        //System.out.println(is.size());
        //System.out.println(in.size());

        int[] aa = {1,2,3};
        int[] bb = Arrays.copyOfRange(aa,0,2);
        for (int i : bb){
            System.out.println(i);
        }

    }
}

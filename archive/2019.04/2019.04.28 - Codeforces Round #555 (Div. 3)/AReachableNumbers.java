package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.HashSet;

public class AReachableNumbers {


    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        HashSet<Integer> hash = new HashSet<>();
        while (!hash.contains(n)) {
            hash.add(n);
            n = n + 1;
            while (n % 10 == 0) n /= 10;
        }
        out.printLine(hash.size());
    }
}

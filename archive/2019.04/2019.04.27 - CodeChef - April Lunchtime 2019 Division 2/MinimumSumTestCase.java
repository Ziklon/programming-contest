package com.darkbit.problems;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;

import java.util.*;

public class MinimumSumTestCase {
    @TestCase
    public Collection<Test> createTests() {


        int test = 40;

        List<Test> tests = new ArrayList<>();

        Random r = new Random();
        for (int i = 0; i < test; ++i) {

            int n = r.nextInt(10) + 1;

            int[] seq = new int[n];

            StringBuilder sb = new StringBuilder();
            sb.append(1 + "\n");
            sb.append(n + "\n");
            for (int j = 0; j < n; ++j) {

                seq[j] = r.nextInt(30) + 1;
                sb.append(seq[j]);
                sb.append(i + 1 == n ? "\n" : " ");
            }
            tests.add(new Test(sb.toString(), slow(seq) + ""));
        }

        return tests;
    }

    int slow(int[] seq) {

        int ans = 1 << 20;
        for (int x = 0; x <= 200; x++) {

            int sum = 0;
            for (int e : seq) sum += (x ^ e);

            ans = Math.min(ans, sum);
        }
        return ans;
    }

}

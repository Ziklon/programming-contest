package com.darkbit.problems;

import net.egork.generated.collections.list.IntArrayList;
import net.egork.generated.collections.list.IntList;

public class ChristmasCrackers {
    public int[] crack(int N, int K) {


        IntArrayList list = new IntArrayList();

        int[] need = new int[N];


        for (int i = 0; i < N; ++i) {
            if (need[i] >= K) continue;

            for (; need[i] < K; ) {
                int remaind = -K;
                int at = 0;

                for (int j = 0; j < N; ++j) {
                    if (i != j) {
                        if (K - need[j] >= remaind) {
                            at = j;
                            remaind = K - need[j];
                        }
                    }
                }
                list.add(i);
                list.add(at);
                need[i]++;
                need[at]++;
            }
        }

        return list.toArray();

    }
}

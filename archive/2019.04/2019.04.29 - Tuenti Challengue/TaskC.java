package com.darkbit.problems;

import net.egork.generated.collections.pair.LongLongPair;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long w = in.readInt(), h = in.readInt();
        int F = in.readInt(), P = in.readInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < F; ++i) sb.append(in.readCharacter());

        List<LongLongPair> points = new ArrayList<>();
        for (int i = 0; i < P; ++i) points.add(LongLongPair.makePair(in.readInt(), in.readInt()));


        char[] moves = sb.toString().toCharArray();


        for (char c : moves) {

            List<LongLongPair> tmp = new ArrayList<>();

            if (c == 'B') {

                tmp.addAll(points);
                for (LongLongPair p : points) {
                    long x = p.first;
                    long y = (2 * h) - p.second - 1;
                    tmp.add(LongLongPair.makePair(x, y));
                }
                h *= 2;
            } else if (c == 'T') {
                for (LongLongPair p : points) {
                    long x = p.first;
                    long y = h + p.second;
                    tmp.add(LongLongPair.makePair(x, y));
                }
                for (LongLongPair p : points) {
                    long x = p.first;
                    long y = h - p.second - 1;
                    tmp.add(LongLongPair.makePair(x, y));
                }
                h *= 2;
            } else if (c == 'R') {
                tmp.addAll(points);
                for (LongLongPair p : points) {
                    long x = (w * 2) - p.first - 1;
                    long y = p.second;
                    tmp.add(LongLongPair.makePair(x, y));
                }
                w *= 2;
            } else if (c == 'L') {
                for (LongLongPair p : points) {
                    long x = w + p.first;
                    long y = p.second;
                    tmp.add(LongLongPair.makePair(x, y));
                }
                for (LongLongPair p : points) {
                    long x = w - p.first - 1;
                    long y = p.second;
                    tmp.add(LongLongPair.makePair(x, y));
                }
                w *= 2;
            }
            points = tmp;
        }

        out.printLine(String.format("Case #%d:", testNumber));

        Collections.sort(points);

        for (LongLongPair point : points) {
            out.printLine(point.first, point.second);
        }


    }
}

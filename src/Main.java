import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author @Ziklon
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    OutputWriter out = new OutputWriter(outputStream);
    CDivisionAndUnion solver = new CDivisionAndUnion();
    solver.solve(1, in, out);
    out.close();
  }

  static class CDivisionAndUnion {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
      int t = in.readInt();

      for (int i = 0; i < t; ++i) {
        int n = in.readInt();

        List<Pair<Integer, Pair<Integer, Integer>>> list = new ArrayList<>();
        for (int j = 0; j < n; ++j) {
          int a = in.readInt(), b = in.readInt();
          list.add(Pair.makePair(j, Pair.makePair(a, b)));
        }
        Collections.sort(list, Comparator.comparing(a -> a.second.first));

        boolean found = false;
        int[] seq = new int[n];
        int last = -1;
        for (int j = 0; j + 1 < n && !found; ++j) {
          Pair<Integer, Integer> p = list.get(j).second;
          Pair<Integer, Integer> q = list.get(j + 1).second;
          if (p.second.intValue() < q.first.intValue() && last < q.first) {
            found = true;
            for (int k = 0; k <= j; ++k) seq[list.get(k).first] = 1;
            for (int k = j + 1; k < n; ++k) seq[list.get(k).first] = 2;
          }
          last = Math.max(last, Math.max(p.second, q.second));
        }
        if (!found) out.printLine(-1);
        else {
          out.printLine(seq);
        }
      }
    }
  }

  static class Pair<U, V> implements Comparable<Pair<U, V>> {
    public final U first;
    public final V second;

    public static <U, V> Pair<U, V> makePair(U first, V second) {
      return new Pair<U, V>(first, second);
    }

    private Pair(U first, V second) {
      this.first = first;
      this.second = second;
    }

    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Pair pair = (Pair) o;

      return !(first != null ? !first.equals(pair.first) : pair.first != null)
          && !(second != null ? !second.equals(pair.second) : pair.second != null);
    }

    public int hashCode() {
      int result = first != null ? first.hashCode() : 0;
      result = 31 * result + (second != null ? second.hashCode() : 0);
      return result;
    }

    public String toString() {
      return "(" + first + "," + second + ")";
    }

    public int compareTo(Pair<U, V> o) {
      int value = ((Comparable<U>) first).compareTo(o.first);
      if (value != 0) {
        return value;
      }
      return ((Comparable<V>) second).compareTo(o.second);
    }
  }

  static class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
      writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
      this.writer = new PrintWriter(writer);
    }

    public void print(int[] array) {
      for (int i = 0; i < array.length; i++) {
        if (i != 0) {
          writer.print(' ');
        }
        writer.print(array[i]);
      }
    }

    public void printLine(int[] array) {
      print(array);
      writer.println();
    }

    public void close() {
      writer.close();
    }

    public void printLine(int i) {
      writer.println(i);
    }
  }

  static class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private InputReader.SpaceCharFilter filter;

    public InputReader(InputStream stream) {
      this.stream = stream;
    }

    public int read() {
      if (numChars == -1) {
        throw new InputMismatchException();
      }
      if (curChar >= numChars) {
        curChar = 0;
        try {
          numChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (numChars <= 0) {
          return -1;
        }
      }
      return buf[curChar++];
    }

    public int readInt() {
      int c = read();
      while (isSpaceChar(c)) {
        c = read();
      }
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      int res = 0;
      do {
        if (c < '0' || c > '9') {
          throw new InputMismatchException();
        }
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public boolean isSpaceChar(int c) {
      if (filter != null) {
        return filter.isSpaceChar(c);
      }
      return isWhitespace(c);
    }

    public static boolean isWhitespace(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {
      public boolean isSpaceChar(int ch);
    }
  }
}

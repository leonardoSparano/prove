// NOTA: si raccomanda di usare questo template anche se non lo si capisce completamente.

import java.util.*;
import java.io.*;

public class calcolatrice {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Locale.setDefault(Locale.US);
        InputStream fin = System.in;
        OutputStream fout = System.out;
        // decommenta le due righe seguenti se vuoi leggere/scrivere da file
        fin = new FileInputStream("oop/input.txt");
        fout = new FileOutputStream("oop/output.txt");

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fout));
        reader = new BufferedReader(new InputStreamReader(fin));
        scn = new StringTokenizer(reader.readLine());

        int T = Integer.parseInt(next());
        for (int test = 1; test <= T; ++test) {
            long N = Long.parseLong(next());

            int operazioni = 0;

            if (N == 1 && N == 2) {
                operazioni = 1;
            } else {
                operazioni = 1;
                long tmp = N;
                while (tmp != 2) {
                    if (tmp % 2 != 0) {
                        tmp = tmp/2 + 1;
                        operazioni += 2;
                    } else {
                        tmp = tmp/2;
                        operazioni++;
                    }
                }
            }

            writer.write("Case #");
            writer.write(String.valueOf(test));
            writer.write(": ");
            writer.write(String.valueOf(operazioni));
            writer.write('\n');
        }

        writer.flush();
    }

    static String next() throws IOException {
        while (!scn.hasMoreTokens())
            scn = new StringTokenizer(reader.readLine());
        return scn.nextToken();
    }

    static BufferedReader reader;
    static StringTokenizer scn;
}
// NOTA: si raccomanda di usare questo template anche se non lo si capisce completamente.

import java.util.*;
import java.io.*;
import java.lang.*;

public class cioccolato {

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
            long M = Long.parseLong(next());
            long K = Long.parseLong(next());

            long risposta = 0;

            // INSERISCI IL TUO CODICE QUI
            for (int i = 0; i < K; i++) {
                if (N > M) {
                    long tmp = N - M;
                    if (tmp < K - i) {
                        N -= tmp;
                        i += tmp - 1;
                    } else {
                        N -= K - i;
                        break;
                    }
                } else if (M > N) {
                    long tmp = M - N;
                    if (tmp < K - i) {
                        M -= tmp;
                        i += tmp - 1;
                    } else {
                        M -= K - i;
                        break;
                    }
                } else {
                    long tmp = K - i;
                    if (tmp % 2 == 0) {
                        N -= tmp / 2;
                        M -= tmp / 2;
                    } else {
                        N -= tmp / 2;
                        M -= tmp / 2 + 1;
                    }
                    break;
                }
            }
            risposta = N * M;

            writer.write("Case #");
            writer.write(String.valueOf(test));
            writer.write(": ");
            writer.write(String.valueOf(risposta));
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
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
        fin = new FileInputStream("input.txt");
        fout = new FileOutputStream("output.txt");

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
                    N--;
                } else {
                    M--;
                }
            }

            risposta = N*M;


            writer.write("Case #");
            writer.write(String.valueOf(test));
            writer.write(": ");
            writer.write(String.valueOf(risposta));
            writer.write('\n');
        }

        writer.flush();
    }

    static String next() throws IOException {
        while (!scn.hasMoreTokens()) scn = new StringTokenizer(reader.readLine());
        return scn.nextToken();
    }

    static BufferedReader reader;
    static StringTokenizer scn;
}
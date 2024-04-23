// NOTA: si raccomanda di usare questo template anche se non lo si capisce completamente.

import java.util.*;
import java.io.*;
import java.lang.*;

public class superluigi {

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
            int N = Integer.parseInt(next());
            int M = Integer.parseInt(next());

            int[] H = new int[N];
            for (int i = 0; i < N; ++i)
                H[i] = Integer.parseInt(next());

            int[] D = new int[N];
            for (int i = 0; i < N; ++i)
                D[i] = Integer.parseInt(next());

            int tempo = 0;

            int height = H[0];
            tempo += H[0];

            for (int i = 1; i < N; i++) {
                if (H[i] > height) {
                    tempo += H[i] - height;
                    height = H[i];
                } else if (H[i] < height) {
                    if (H[i] + D[i] > height) {
                        tempo += H[i] + D[i] - height;
                        height = H[i] + D[i];
                    } else if(height > H[i] + M*D[i]) {
                        tempo += height - H[i] - M*D[i];
                        height = H[i] + M*D[i];
                    } else if (H[i] + D[i] < height) {
                        int maxD = D[i];
                        int rec = 0;
                        for (int j = 2; j < height+D[i] && j < M; j++) {
                            if(Math.abs(height - H[i] + j*D[i]) < maxD) {
                                maxD = Math.abs(height - H[i] + j*D[i]);
                                rec = j;
                            }
                            if(Math.abs(height - H[i] + (j-1)*D[i]) < maxD) {
                                maxD = Math.abs(height - H[i] + j*D[i]);
                                rec = j-1;
                            }
                        }
                        tempo += maxD;
                        height = H[i] + rec*D[i];
                    }
                }
            }

            writer.write("Case #");
            writer.write(String.valueOf(test));
            writer.write(": ");
            writer.write(String.valueOf(tempo));
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
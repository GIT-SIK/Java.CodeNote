import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] al = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for(int i =0; i < al.length; i++) {
            str = str.replaceAll(al[i], "?");
        }
        System.out.print(str.chars().count());
    }
}
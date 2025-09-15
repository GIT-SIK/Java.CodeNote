import java.io.*;
import java.util.*;
public class Main {

    static int ai = 0;
    static class User {
        int seq;
        int age;
        String name;

        User(int age, String name) {
            this.seq = ai++;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<User> users = new ArrayList<>();

        br.lines().skip(1).map(l -> l.split(" ")).forEach(s -> {
            User user = new User(Integer.parseInt(s[0]), s[1]);
            users.add(user);
        });

        Collections.sort(users, Comparator.comparingInt((User u) -> u.age).thenComparing(u -> u.seq));
        
        for(User u : users){
            bw.write(u.toString());
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}

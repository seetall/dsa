package question2;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class b {
    private int k;
    private Set<Integer> blacklist;
    private Random random;

    public b(int k, int[] blacklisted_ports) {
        this.k = k;
        this.blacklist = new HashSet<>();
        for (int port : blacklisted_ports) {
            blacklist.add(port);
        }
        this.random = new Random();
    }

    public int get() {
        int port;
        do {
            port = random.nextInt(k);
        } while (blacklist.contains(port));

        return port;
    }

    public static void main(String[] args) {
        int k = 7;
        int[] blacklisted_ports = {2, 3, 5};
        b portPicker = new b(k, blacklisted_ports);

        System.out.println(portPicker.get());// Should return a whitelisted random port (0, 1, 4, or6)
        System.out.println(portPicker.get()); // Should return another whitelisted random port
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class HomeWork2 {

    public static void main(String[] args) throws IOException {

        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);

        ArrayList<String> list = new ArrayList<String>();
        list.add(reader.readLine());
        String s = list.get(0);
        int longS = s.length();
        int nextLongS;

        for (int i = 1; i < 10; i++) {
            list.add(reader.readLine());
            s = list.get(i);
            nextLongS = s.length();

            if (nextLongS > longS) {
                longS = nextLongS;
            }
            else {
                System.out.println(i);
                break;
            }
        }

    }

}

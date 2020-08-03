
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader2 = null;
        StringBuilder strbild = new StringBuilder();
        try {
            String userInput = reader1.readLine();
            String[] str = userInput.split("[\\\\/]");
            File inFile = new File(str[str.length - 1]);
            reader2 = new BufferedReader(new FileReader(inFile));
            while (reader2.ready()) {
                strbild.append(reader2.readLine()).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader1.close();
                assert reader2 != null;
                reader2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String[] words = strbild.toString().replaceAll("\\p{Punct}", " ").split("\\s+");
        ArrayList<String> arrList = new ArrayList<>(Arrays.asList(words));
        Collections.sort(arrList);
        arrList.forEach(System.out::println);
        TreeMap<String, Integer> tm = new TreeMap<>();
        for (String s : arrList) {
            tm.put(s, tm.getOrDefault(s, 0) + 1);

        }
        int count = 0;
        for (Map.Entry<String, Integer> pair : tm.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
            if (count < pair.getValue()) count = pair.getValue();
        }
        for (Map.Entry<String, Integer> pair : tm.entrySet()) {
            if (pair.getValue() == count) System.out.println(pair.getKey() + " - " + count);
        }
    }
}
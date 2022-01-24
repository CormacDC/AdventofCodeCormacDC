/*
count the number of times a depth measurement increases from the previous measurement
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DayOne{

    static int prev;
    static int count;
    static String fileName;

    public static void main(String[] args){

        prev = -1;
        count = 0;
        fileName = "depths.txt";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach((depth) -> {
                int curr = Integer.parseInt(depth);
                if (prev != -1 && curr > prev){
                    count++;
                }
                prev = curr;
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}
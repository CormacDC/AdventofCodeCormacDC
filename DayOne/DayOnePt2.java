/*
199  A      
200  A B    
208  A B C  
210    B C D
200      C D E
207        D E F
240          E F G
269            F G H
260              G H
263                H
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DayOnePt2 {
    static int prev2;
    static int prev;
    static int curr;
    static int prev2Total;
    static int prevTotal;
    static int currTotal;
    static int count;
    static int increaseCount;
    static String fileName;

    public static void main(String[] args){
        prev2 = 0;
        prev = 0;
        curr = 0;
        count = 0;
        currTotal = 0;
        increaseCount = 0;
        fileName = "depths.txt";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach((depth) -> {
                prev2 = prev;
                prev = curr;
                curr = Integer.parseInt(depth);
                if (count < 3){
                    currTotal += curr;
                }
                else{
                    prevTotal = currTotal;
                    currTotal = prev2 + prev + curr;
                    if (currTotal > prevTotal)
                        increaseCount++;
                }
                count++;
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(increaseCount);
    }
}

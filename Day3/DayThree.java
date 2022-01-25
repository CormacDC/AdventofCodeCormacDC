import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DayThree {

    static int count;
    
    public static void main(String[] args){

        final int NUMLENGTH = 12;
        String fileName = "binarylist.txt";
        int[] oneTotals = {0,0,0,0,0,0,0,0,0,0,0,0};
        int gamma = 0;
        int epsilon = 0;
        count = 0;

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach((bin) -> {

                int binInt = Integer.parseInt(bin,2);
                int posFromEnd = 0;

                while (binInt > 0){
                    oneTotals[NUMLENGTH - 1 - posFromEnd] += binInt % 2;
                    binInt /= 2;
                    posFromEnd++;
                }

                count++;
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < NUMLENGTH; i++){
            if (oneTotals[NUMLENGTH - 1 - i] > count / 2){
                gamma += (int)Math.pow(2.0,(double)i);
            }
        }

        epsilon = gamma ^ (int)(Math.pow(2.0,(double)NUMLENGTH) - 1);

        System.out.println("Gamma: " + gamma + "\nEpsilon: " + epsilon + "\nGamma * Epsilon: " + (gamma * epsilon));

    }
}

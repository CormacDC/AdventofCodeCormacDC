import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

// very inefficient, > n^2 time complexity

public class DayThreePt2 {

    private static final int BINUMLENGTH = 12;
    private static final String FILENAME = "binarylist.txt";
    
    public static void main(String[] args){
        int O2GenRating;
        int CO2ScrubRating;

        ArrayList<String> binsO2GenRating = populateArrayList();
        ArrayList<String> binsCO2ScrubRating = populateArrayList();

        // oxygen generator rating
        for (int i = 0; i < BINUMLENGTH; i++){

            int freq = frequencyOfBinaryPlace(binsO2GenRating, i);
            
            if (freq >= 0)
                removeNonmatchingNums(binsO2GenRating, '0', i);
            else
                removeNonmatchingNums(binsO2GenRating, '1', i);

            if (binsO2GenRating.size() == 1)
                break;

        }
        O2GenRating = Integer.parseInt(binsO2GenRating.get(0),2);        

        // co2 scrubber rating
        for (int i = 0; i < BINUMLENGTH; i++){

            int freq = frequencyOfBinaryPlace(binsCO2ScrubRating, i);
            
            if (freq >= 0)
                removeNonmatchingNums(binsCO2ScrubRating, '1', i);
            else
                removeNonmatchingNums(binsCO2ScrubRating, '0', i);

            if (binsCO2ScrubRating.size() == 1)
                break;
                
        }
        CO2ScrubRating = Integer.parseInt(binsCO2ScrubRating.get(0),2);      

        System.out.println("Oxygen Generator Rating: " + O2GenRating);
        System.out.println("CO2 Scrubber Rating: " + CO2ScrubRating);
        System.out.println("Life Support Rating: " + O2GenRating * CO2ScrubRating);
    } 

    public static ArrayList<String> populateArrayList(){
        ArrayList<String> bins = new ArrayList<String>();

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(FILENAME))) {

            stream.forEach((bin) -> {

                bins.add(bin);

            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bins;
    }

    public static int frequencyOfBinaryPlace(ArrayList<String> arr, int digitPlace){
        int numOnes = 0;

        for (String str : arr){

            if (str.charAt(digitPlace) == '1'){
                numOnes++;
            }
            else 
                numOnes--;
        }

        return numOnes;
    }

    public static void removeNonmatchingNums(ArrayList<String> arr, char disqualifyingValue, int digitPlace){

        arr.removeIf(str -> str.charAt(digitPlace) == disqualifyingValue);

    }

}

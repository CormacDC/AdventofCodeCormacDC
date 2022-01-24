import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DayTwo {

    public static void main(String[] args){
        String fileName = "vectors.txt";
        Submarine2 sub = new Submarine2();

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach((vector) -> {
                String[] vectorSplit = vector.split(" ");
                String direction = vectorSplit[0];
                int magnitude = Integer.parseInt(vectorSplit[1]);

                switch(direction){
                    case "forward": sub.forward(magnitude);
                                    break;
                    case "up":      sub.up(magnitude);
                                    break;
                    case "down":    sub.down(magnitude);
                                    break;
                    default:        System.err.println("Invalid vector direction");
                                    break;
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sub.toString());
        System.out.println("Multiplication of depth and horizontal positions: " + sub.multiplicationResult());
    }

}

/*
Implementation of a submarine
*/

public class Submarine {
    
    private int horizontal;
    private int depth;

    Submarine(){
        horizontal = 0;
        depth = 0;
    }

    public int getHorizontal(){
        return horizontal;
    }

    public int getDepth(){
        return depth;
    }

    public void forward(int val){
        horizontal += val;
    }

    public void up(int val){
        depth -= val;
    }

    public void down(int val){
        depth += val;
    }

    @Override
    public String toString(){
        return "===================\nSubmarine Stats:\nHorizontal: " + horizontal + "\nDepth: " + depth + "\n===================\n";
    }

    public int multiplicationResult(){
        return horizontal * depth;
    }

}

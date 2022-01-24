public class Submarine2 {
    
    private int horizontal;
    private int depth;
    private int aim;

    Submarine2(){
        horizontal = 0;
        depth = 0;
        aim = 0;
    }

    public int getHorizontal(){
        return horizontal;
    }

    public int getDepth(){
        return depth;
    }

    public int getAim(){
        return aim;
    }

    public void forward(int val){
        horizontal += val;
        depth += aim * val;
    }

    public void up(int val){
        aim -= val;
    }

    public void down(int val){
        aim += val;
    }

    @Override
    public String toString(){
        return "===================\nSubmarine Stats:\nHorizontal: " + horizontal + "\nDepth: " + depth + "\nAim: " + aim + "\n===================\n";
    }

    public int multiplicationResult(){
        return horizontal * depth;
    }

}

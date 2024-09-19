import java.util.Random;

public class Dado {
    public static int girarDado(){
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}

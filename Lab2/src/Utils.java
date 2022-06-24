import java.awt.*;

public class Utils {
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static final Color[] colors = new Color[]{
            Color.cyan, Color.yellow, Color.green,
            Color.pink, Color.red, Color.orange,
            Color.magenta, Color.blue, Color.lightGray
    };

    public static Color getColor(int i){
        return colors[i];
    }
}

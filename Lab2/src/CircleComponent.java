import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CircleComponent extends JPanel {
    private final ArrayList<Circle> circles = new ArrayList<>();
    /*
     *Добавить окружность к компоненту.
     *@param b Добавляемая окружность
     */
    public void add(Circle b){
        circles.add(b);
    }

    public void paintComponent (Graphics g){
        super.paintComponent(g);// очистка фона
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke((float) 2));

        for (Circle c1: circles) {
            for (Circle c2: circles) {
                if(c1 != c2){
                    double distance = Math.sqrt( Math.pow(c2.getX() - c1.getX(), 2) + Math.pow(c2.getY() - c1.getY(), 2) );
                    if(distance < c1.getR())
                        c1.turn(c2.getX(), c2.getY());
                }
            }
        }

        for (Circle b : circles){
            g.setColor(b.getColor());
            g2.draw(b.getShape());
        }
    }
}

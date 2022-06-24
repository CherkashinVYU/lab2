import java.awt.*;


public class CircleRunnable implements Runnable {

    private final Circle circle;
    private final Component component;
    public static final int STEPS = 10000;
    public static final int DELAY = 2;

    public CircleRunnable (Circle aCircle, Component aComponent) throws InterruptedException {
        circle = aCircle;
        component = aComponent;
    }

    public void run(){
        try{
            for (int i = 1; ; i++){
                circle.move(component.getBounds());
                component.repaint();
                Thread.sleep(DELAY);
            }
        }
        catch (InterruptedException e){
            System.out.println("Исключение");

        }
    }
}
 
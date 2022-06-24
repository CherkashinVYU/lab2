import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BounceFrame extends JFrame {

    private final CircleComponent comp;
    public static final int DEFAULT_WIDTH = 450;
    public static final int DEFAULT_HEIGHT = 350;

    private boolean run = false;

    private ControlledCircle circle;

    public BounceFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("BounceThread");
        comp = new CircleComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();

        addButton(buttonPanel, "Начать", new ActionListener(){
            public void actionPerformed(ActionEvent event){
                try {
                    if(run) return;
                    addCircle(10, 10, 0.3, Utils.getRandomNumber(0, 8));
                    addCircle(10, 150, 0.5, Utils.getRandomNumber(0, 8));
                    addCircle(10, 350, 0.6, Utils.getRandomNumber(0, 8));
                    circle = addControlledCircle(200, 250, 1.0, Utils.getRandomNumber(0, 8));
                    run = true;
                    requestFocus();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        addButton(buttonPanel, "Выйти", new ActionListener() {
            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
        });
        add(buttonPanel, BorderLayout.SOUTH);

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if(circle != null)
                    circle.setPos(e.getX(), e.getY());
            }
        });

        setFocusable(true);

        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    if(circle != null)
                        circle.setButtonPos(circle.getX(), circle.getY() - 5);
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    if(circle != null)
                        circle.setButtonPos(circle.getX(), circle.getY() + 5);
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    if(circle != null)
                        circle.setButtonPos(circle.getX() - 5, circle.getY());
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    if(circle != null)
                        circle.setButtonPos(circle.getX() + 5, circle.getY());
                }
            }

            public void keyReleased(KeyEvent e) {  }

            public void keyTyped(KeyEvent e) {  }
        });
    }

    public void addButton (Container c, String title, ActionListener listener){
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addCircle(int x, int y, double d, int c) throws InterruptedException {
        Circle b = new Circle (x, y, d, c);
        comp.add(b);
        Runnable r = new CircleRunnable(b, comp);
        Thread t = new Thread(r) ;
        t.start ();
    }

    public ControlledCircle addControlledCircle(int x, int y, double d, int c) throws InterruptedException {
        ControlledCircle b = new ControlledCircle (x, y, d, c);
        comp.add(b);
        Runnable r = new CircleRunnable(b, comp);
        Thread t = new Thread(r) ;
        t.start ();
        return b;
    }
}

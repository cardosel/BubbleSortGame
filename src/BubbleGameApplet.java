import java.awt.Container;
import javax.swing.JApplet;

public class BubbleGameApplet
  extends JApplet
{
  public void init()
  {
    getContentPane().add(new BubbleGamePanel());
  }
  
  public void destroy() {}
  
  public void start() {}
  
  public void stop() {}
}

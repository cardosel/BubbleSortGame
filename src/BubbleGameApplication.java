import java.awt.Container;
import javax.swing.JFrame;

public class BubbleGameApplication
{
  public static void main(String[] args)
  {
    BubbleGamePanel bubbleGamePanel = new BubbleGamePanel();
    JFrame BubbleGameFrame = new JFrame("Bubble game");
    BubbleGameFrame.getContentPane().add(bubbleGamePanel);
    BubbleGameFrame.setSize(700, 300);
    BubbleGameFrame.setDefaultCloseOperation(3);
    BubbleGameFrame.setVisible(true);
  }
}

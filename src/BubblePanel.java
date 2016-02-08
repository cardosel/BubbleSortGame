import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class BubblePanel
  extends JComponent
{
  public static final int MARGIN = 10;
  public static final int TRIANGLE_WIDTH = 8;
  public static final int TRIANGLE_HEIGHT = 5;
  public static final int DEFAULT_BUBBLE_DIAMETER = 65;
  public BubbleGame bubbleGame;
  
  public BubblePanel(BubbleGame bg)
  {
    this.bubbleGame = bg;
    setBackground(Color.white);
    setOpaque(true);
  }
  
  public void setGame(BubbleGame bg)
  {
    this.bubbleGame = bg;
  }
  
  public void paintComponent(Graphics g)
  {
    g.setColor(getBackground());
    g.fillRect(0, 0, getWidth(), getHeight());
    if (!this.bubbleGame.isGameOver())
    {
      int bubbleDiameter = 
        Math.min(65, 
        (getWidth() - 20) / this.bubbleGame.numberOfBubbles());
      LinkedListNode current = this.bubbleGame.getBubbles().getFirstNode();
      int index = 0;
      while (current != null)
      {
        int x = 10 + index * bubbleDiameter;
        int y = 10;
        g.setColor(((Bubble)current.getData()).getColor());
        g.fillOval(x, y, bubbleDiameter, bubbleDiameter);
        if (current == this.bubbleGame.getCurrentNode()) {
          paintArrow(g, x, y, bubbleDiameter);
        }
        index++;
        current = current.getNext();
      }
    }
    else
    {
      g.setColor(Color.cyan);
      g.drawString("Congratulations, you won!", 10, 10);
    }
  }
  
  public void paintArrow(Graphics g, int x, int y, int bubbleDiameter)
  {
    int[] xCoords = new int[3];
    int[] yCoords = new int[3];
    xCoords[0] = (x + bubbleDiameter / 2 - 4);
    xCoords[1] = (x + bubbleDiameter / 2);
    xCoords[2] = (x + bubbleDiameter / 2 + 4);
    yCoords[0] = (y + bubbleDiameter + 10 + 5);
    yCoords[1] = (y + bubbleDiameter + 10);
    yCoords[2] = (y + bubbleDiameter + 10 + 5);
    
    g.setColor(Color.black);
    g.fillPolygon(xCoords, yCoords, 3);
    
    g.drawLine(xCoords[1], yCoords[2], 
      xCoords[1], yCoords[2] + 10);
    
    g.setColor(this.bubbleGame.getPlayBubble().getColor());
    
    int playBubbleDiam = 2 * bubbleDiameter / 3;
    g.fillOval(
      xCoords[1] - playBubbleDiam / 2, 
      yCoords[2] + 10, 
      playBubbleDiam, 
      playBubbleDiam);
  }
}

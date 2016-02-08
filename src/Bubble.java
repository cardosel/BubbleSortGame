import java.awt.Color;

public class Bubble
{
  public static Color[] DEFAULT_COLORS = { Color.red, Color.blue, Color.green, Color.yellow };
  public Color color;
  
  public Bubble(Color c)
  {
    this.color = c;
  }
  
  public Bubble()
  {
    this.color = DEFAULT_COLORS[((int)(Math.random() * DEFAULT_COLORS.length))];
  }
  
  public Color getColor()
  {
    return this.color;
  }
}

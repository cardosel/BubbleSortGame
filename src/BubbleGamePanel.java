import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BubbleGamePanel
  extends JPanel
{
  public static final int DEFAULT_BUBBLES = 10;
  public BubbleGame bubbleGame;
  public BubblePanel bubblePanel;
  public boolean stopInsert;
  public JLabel scoreLabel;
  
  public BubbleGamePanel()
  {
    this.bubbleGame = new BubbleGame(10);
    this.stopInsert = false;
    initLayout();
  }
  
  public BubbleGamePanel(int n)
  {
    this.bubbleGame = new BubbleGame(n);
    this.stopInsert = false;
    initLayout();
  }
  
  public void initLayout()
  {
    setLayout(new BorderLayout());
    this.bubblePanel = new BubblePanel(this.bubbleGame);
    add(this.bubblePanel, "Center");
    add(createButtonPanel(), "South");
    add(createScorePanel(), "North");
  }
  
  public JPanel createButtonPanel()
  {
    JPanel p = new JPanel(new FlowLayout(1));
    
    JButton newButton = new JButton("New game");
    
    newButton.addActionListener(
    
      new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          BubbleGamePanel.this.bubbleGame = new BubbleGame(10);
          BubbleGamePanel.this.bubblePanel.setGame(BubbleGamePanel.this.bubbleGame);
          BubbleGamePanel.this.repaint();
        }
      });
    p.add(newButton);
    
    JButton resetButton = new JButton("Reset");
    
    resetButton.addActionListener(
    
      new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          BubbleGamePanel.this.bubbleGame.gotoFirst();
          BubbleGamePanel.this.repaint();
        }
      });
    p.add(resetButton);
    
    JButton nextButton = new JButton("Next");
    
    nextButton.addActionListener(
    
      new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          BubbleGamePanel.this.bubbleGame.gotoNext();
          BubbleGamePanel.this.repaint();
        }
      });
    p.add(nextButton);
    
    JButton insertHeadButton = new JButton("Insert as head");
    
    insertHeadButton.addActionListener(
    
      new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          BubbleGamePanel.this.insertHeadBubble();
        }
      });
    p.add(insertHeadButton);
    
    JButton insertButton = new JButton("Insert");
    
    insertButton.addActionListener(
    
      new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          BubbleGamePanel.this.insertBubble();
        }
      });
    p.add(insertButton);
    
    return p;
  }
  
  public JPanel createScorePanel()
  {
    JPanel sp = new JPanel(new FlowLayout(1));
    sp.add(new JLabel("Score: "));
    this.scoreLabel = new JLabel(Integer.toString(this.bubbleGame.getScore()));
    sp.add(this.scoreLabel);
    return sp;
  }
  
  public void updateScore()
  {
    this.scoreLabel.setText(Integer.toString(this.bubbleGame.getScore()));
  }
  
  public void insertHeadBubble()
  {
    if (!this.stopInsert)
    {
      this.stopInsert = true;
      this.bubbleGame.insertPlayBubbleAtHead();
      repaint();
      
      animateChain();
    }
  }
  
  public void insertBubble()
  {
    if (!this.stopInsert)
    {
      this.stopInsert = true;
      this.bubbleGame.insertPlayBubble();
      repaint();
      
      animateChain();
    }
  }
  
  public void animateChain()
  {
    Timer timer = new Timer();
    timer.schedule(
      new TimerTask()
      {
        public void run()
        {
          if ((!BubbleGamePanel.this.bubbleGame.isGameOver()) && (BubbleGamePanel.this.bubbleGame.checkForChain()))
          {
            BubbleGamePanel.this.animateChain();
            BubbleGamePanel.this.updateScore();
            BubbleGamePanel.this.repaint();
          }
          else
          {
            BubbleGamePanel.this.stopInsert = false;
            
            BubbleGamePanel.this.bubbleGame.generatePlayBubble();
            BubbleGamePanel.this.bubbleGame.gotoFirst();
            BubbleGamePanel.this.repaint();
          }
        }
      }, 400L);
  }
}

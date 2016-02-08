import java.awt.Color;

public class BubbleGame
{
  public LinkedList bubbles;
  public LinkedListNode currentNode;
  public Bubble playBubble;
  public int score = 0;
  
  public BubbleGame(int n)
  {
    initBubbles(n);
    generatePlayBubble();
  }
  
  public LinkedList getBubbles()
  {
    return this.bubbles;
  }
  
  public int numberOfBubbles()
  {
    return this.bubbles.size();
  }
  
  public LinkedListNode getCurrentNode()
  {
    return this.currentNode;
  }
  
  public Bubble getPlayBubble()
  {
    return this.playBubble;
  }
  
  public boolean isGameOver()
  {
    return this.bubbles.getFirstNode() == null;
  }
  
  public void gotoFirst()
  {
    this.currentNode = this.bubbles.getFirstNode();
  }
  
  public void gotoNext()
  {
    if (this.currentNode.getNext() != null) {
      this.currentNode = this.currentNode.getNext();
    }
  }
  
  public void insertPlayBubbleAtHead()
  {
    this.bubbles.insertFirst(this.playBubble);
  }
  
  public void insertPlayBubble()
  {
    this.bubbles.insertAfter(this.currentNode, this.playBubble);
  }
  
  public void generatePlayBubble()
  {
    if (!isGameOver()) {
      this.playBubble = new Bubble();
    }
  }
  
  public int getScore()
  {
    return this.score;
  }
  
  public void initBubbles(int n)
  {
    this.bubbles = new LinkedList();
    for (int i = 0; i < n; i++) {
      this.bubbles.insertFirst(new Bubble());
    }
    this.currentNode = this.bubbles.getFirstNode();
  }
  
  public boolean checkForChain()
  {
    LinkedListNode chainStart = null;
    LinkedListNode previous = null;
    LinkedListNode current = this.bubbles.getFirstNode();
    Color c = ((Bubble)current.getData()).color;
    int count = 0;
    while (current != null)
    {
      if (c.equals(((Bubble)current.getData()).getColor()))
      {
        count++;
      }
      else
      {
        if (count >= 3) {
          break;
        }
        chainStart = previous;
        count = 1;
        c = ((Bubble)current.getData()).getColor();
      }
      previous = current;
      current = current.getNext();
    }
    if (count >= 3)
    {
      if (chainStart == null) {
        for (int i = 0; i < count; i++) {
          this.bubbles.deleteFirst();
        }
      } else {
        chainStart.setNext(current);
      }
      updateScore(count);
      
      return true;
    }
    return false;
  }
  
  public void updateScore(int n)
  {
    this.score += 3;
    for (int i = 2; i < n - 1; i++) {
      this.score += i;
    }
  }
}

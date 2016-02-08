import java.io.PrintStream;

public class BasicLinkedList
{
  public LinkedListNode head;
  
  public Object getFirst()
  {
    return getFirstNode().getData();
  }
  
  public void insertFirst(Object data)
  {
    insertFirstNode(new LinkedListNode(data));
  }
  
  public String toString()
  {
    String result = "{ ";
    LinkedListNode current = getFirstNode();
    while (current != null)
    {
      result = result + current.getData().toString() + " ";
      
      current = current.getNext();
    }
    result = result + "}";
    
    return result;
  }
  
  public void print()
  {
    System.out.println(toString());
  }
  
  public LinkedListNode getFirstNode()
  {
    return this.head;
  }
  
  public void insertFirstNode(LinkedListNode node)
  {
    node.setNext(this.head);
    
    this.head = node;
  }
}

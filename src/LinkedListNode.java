public class LinkedListNode
{
  public Object data;
  public LinkedListNode next;
  
  public LinkedListNode(Object data)
  {
    this.data = data;
  }
  
  public Object getData()
  {
    return this.data;
  }
  
  public LinkedListNode getNext()
  {
    return this.next;
  }
  
  public void setNext(LinkedListNode node)
  {
    this.next = node;
  }
}

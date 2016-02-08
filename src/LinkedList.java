public class LinkedList
  extends BasicLinkedList
{
  public void deleteFirst()
  {
    if (this.head != null) {
      this.head = this.head.getNext();
    }
  }
  
  public void insertAfter(LinkedListNode currentNode, Object data)
  {
    insertNodeAfter(currentNode, new LinkedListNode(data));
  }
  
  public void deleteNext(LinkedListNode currentNode)
  {
    if (currentNode.getNext() != null) {
      currentNode.setNext(currentNode.getNext().getNext());
    }
  }
  
  public void insertNodeAfter(LinkedListNode currentNode, LinkedListNode node)
  {
    node.setNext(currentNode.getNext());
    
    currentNode.setNext(node);
  }
  
  public int size()
  {
    int size = 0;
    LinkedListNode current = getFirstNode();
    while (current != null)
    {
      size++;
      current = current.getNext();
    }
    return size;
  }
}

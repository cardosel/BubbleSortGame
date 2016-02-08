public class LinkedListTesterApplication
{
  public static void main(String[] args)
  {
    LinkedList list = new LinkedList();
    
    list.insertFirst("a");
    list.print();
    list.insertFirst("v");
    list.print();
    list.insertFirst("a");
    list.print();
    list.insertFirst("l");
    list.print();
    list.insertFirst("o");
    list.print();
    list.insertFirst("i");
    list.print();
    list.insertAfter(list.getFirstNode().getNext(), "j");
    list.print();
    list.insertAfter(list.getFirstNode().getNext(), "e");
    list.print();
    list.insertAfter(list.getFirstNode().getNext(), "v");
    list.print();
    list.insertAfter(list.getFirstNode(), "l");
    list.print();
    list.deleteNext(list.getFirstNode().getNext().getNext().getNext().getNext());
    list.print();
  }
}

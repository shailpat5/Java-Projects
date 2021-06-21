public class MyTestClass{
  public static void main(String[] args){
    SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
    SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
    
    list1.addAthead(1);
    list1.addAthead(2);
    list1.addAthead(3);
    list1.toString();
    list1.size();
    list1.toString();
    list1.get(0);
    list1.toString();
    list1.indexOf(2);
    list1.toString();
    list1.add(2, 4);
    list1.toString();
    list1.remove(2);
    list1.toString();
    list1.min();
    list1.max();
    list1.empty();
    list2.addatEnd(1);
    list2.toString();
    list2.replace(1,2);
    list2.toString();
    list1.duplicate(2);
    list1.toString();
    list1.reverse();
    list1.toString();
    list1.countGreaterThan(1);
    list1.equals(list2);
    list1.inorder();
    list1.toString();
    list1.removeEven();
    list1.toString();
  }
}
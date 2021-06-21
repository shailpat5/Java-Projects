

public abstract class SinglyLinkedList<T extends Comparable<T>> implements List<T>{
  
  //Node class
  private static class Node<T>{
    private T value;  
    private Node<T> next;
    
    private Node(){
      this.value = null;
      this.next = null;
    }
    
    private Node(T value, Node<T> next){
      this.value = value;
      this.next = next;
    }
  }
  
  private Node<T> head;
  private int size;
  
  public SinglyLinkedList(T value, Node<T> next){
    head = new Node<T>(value, next);
    head.next = head;
    size = 0;
  }
  
  //returns size of list
  public int size(){
    return size;
  }
  
  public T get(int i){
    if(i<0 || i>size){
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }    
    Node<T> p = head.next;
    for(int n=0; n<i ; n++){
      p = p.next;
    }
    return p.value;
  }
  
  //returns index of item in list
  public int indexOf(Object item){
    int result = -1;
    Node<T> p = head;
    for(int i=0; i<size; i++){
      if(((Comparable<T>) item).compareTo(p.value)==0){
        result = i;
      }
    }
    return result;
  }
  
  //adds item at index i
  public void add(int i, T item){
    if (item == null){
      throw new IllegalArgumentException( "null" );
    }
    
    Node<T> newNode = new Node<T>(item, null);
    size++;
    
    Node<T> p = this.head;
    
	for(int n=0; n<i;n++){
		p = p.next;
    }
    
    Node<T> temp = p.next;
    p.next = newNode;
    newNode.next = temp;    
  }
  
  //removes item at index i
  public T remove(int i){
    Node<T> p= head.next;
    Node<T> q= head;
    for(int n=0; n<i;n++){
      p=p.next;
      q=q.next;
    }
    q=p.next;
    return p.value;
  }
  
  //returns minimum value in list
  public T min(){
    Node<T> min = head;
    Node<T> p = head.next;
    for(int i = 0; i<size;i++){
      if(((min.value).compareTo(p.value)) < 0){
        min =  p;
      }
      p=p.next;
    }
    return min.value;
  }
  
  //returns maximum value in list
  public T max(){
    Node<T> max = head;
    Node<T> p = head.next;
    for(int i = 0; i<size;i++){
      if(((max.value).compareTo(p.value)) > 0){
        max =  p;
      }
      p=p.next;
    }
    return max.value;
  }
  
  //returns true if list is empty
  public boolean empty(){
    boolean result=false;
    if(size == 0){
      result = true;
    }
    return result;
  }
  
  //adds item to top of list
  public void addAthead(T item){
    Node<T> temp = new Node();
    temp.value= item;
    temp.next = head;
    head = temp;
  }
  
  //adds item at end of list
  public void addatEnd(T item){
    Node<T> temp = head;
    Node<T> newNode = new Node<T>(item, null);
    while(temp != null){
      temp=temp.next;
    }
    temp = newNode;
    head = temp;
  }
  
  //replaces first with second in list
  public void replace(T first, T second){
    Node<T> p = head;
    for(int i=0; i<size;i++){
      if(p.value.compareTo(first)==0){
        p.value= second;
      }
      p=p.next;
    }
  }
  
  //duplicates item, i.e. next value in list is equal to item - recursive
  public List<T> duplicate(T item){
    Node<T> p = this.head;
    SinglyLinkedList<T> result = this;
    if(p.next == null){
      result = this;
    }else{
      if(p.value.compareTo(item)==0){
        p.next.value = item;
        duplicate(p.next.value);
        result = this;
      }
    }
      return result;
  }
  
    //reverses the order of the list, recursive
  public void reverse(){
	  this.reverseHelper(this.head);
  }
  
  public void reverseHelper(Node<T> next) {
	  Node<T> p = this.head;
	    if (p == null)
	      return;
	    else {
	      reverseHelper(p.next);
	      System.out.println(p.value);
	    };
  }
  //prints string of list
  public String toString(){
    String result = "";
    Node<T> p = this.head;
    while(p.next != null){
      result = result + p.value + ", ";
      p = p.next;
    }
    return result;
  }
  
  //A recursive method that returns a list containing all the elements in the original list that are larger than threshold
  public List<T> countGreaterThan(T threshold){
    Node<T> p = head;
    T val = null;
    SinglyLinkedList<T> x = this;
    SinglyLinkedList<T> result = null;
	if(p == null){
      result = x;
    }else if(p.value.compareTo(threshold)>0){
      x.addatEnd(p.value);
      p = p.next;
      countGreaterThan(threshold);
    }
    return result;
    
  }
  
  //checks if other list is equal to this list
  public boolean equals(Object other){
    boolean result;
    Node<T> p = head;
    result = true;    
    
    if(!(p.value.compareTo((T) other)==0)){
      return false;
    }
    p = p.next;
    result = equals(other);
    return result;
  }
  
  //returns list with elements in ascending order
  public List<T> inorder(){
    Node<T> p = head;
    Node<T> q = head.next;
    for(int i =0;i<size;i++){
      for(int j=0; j<size-1;j++){
        if(p.value.compareTo(q.value) > 0){
          Node<T> temp = p;
          p = q;
          q = temp;
        }
        q = q.next;
      }
      p=p.next;
    }
    SinglyLinkedList<T> x = this;
    return x;
  }
  
  //removes even index elements
  public void removeEven(){
    Node<T> p = head;
    for(int i=0; i<size; i=i+2){
      remove(i);
    }                   
  }
   
}
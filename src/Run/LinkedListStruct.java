package Run;

public class LinkedListStruct
{
   LinkedList first;
   LinkedList last;
   LinkedList previous;
   int size;
   private boolean isDoubly;
   public LinkedListStruct(boolean isDoubly)
   {
    first = null;
    last = null;
    this.isDoubly = isDoubly;
   }

   public void add(int value)
   {
    if(isDoubly)
    {
      if(first == null)
      {
        first = new LinkedList(value);
        size++;
      }
      else if(first.next==null)
      {
        last = new LinkedList(value);
        last.next = first;
        first.next = last;
        previous = last; 
        size++;
      }
      else
      {
        last = new LinkedList(value);
        last.next = first;
        last.previous = previous;
        previous.next = last;
        previous = last;
        size++;
      }
    }
    else{
      if(first == null)
      {
        first = new LinkedList(value);
        size++;
      }
      else if(first.next==null)
      {
        last = new LinkedList(value);
        last.next = first;
        first.next = last;
        previous = last; 
        size++;
      }
      else
      {
        last = new LinkedList(value);
        last.next = first;
        previous.next = last;
        previous = last;
        size++;
      }
    }
   }
   
   public int get(int index)
   {
    LinkedList current = first;
    for(int i = 0;i<size;i++)
    {
      if(i == index)
      {
        return current.value;
      }
      else
      {
        current = current.next;
      }
    }
    return -1;
   }

   public int size()
   {
     return size;
   }

   public int pop()
   { 
    int value = -1;
    if(first == null)
    {
      throw new IndexOutOfBoundsException();
    }
    LinkedList current = first;
    if(first.next == null)
    {
      value = first.value;
      first = null;
      last = null;
      return value;
    }
    for(int i = 0;i<size;i++)
    {
      if(i == size-2)
      {
        current.next = null;
        size--;
        value  = last.value;
        last = current;
      }
      else
      {
        current = current.next;
      }
    }
    return value;
   }
  
   public String toString()
   {
    String s = "";
    if(first == null)
    {
      return "No values";
    }
    LinkedList current = first;
    while(current != last)
    {
      s += current.value +" > ";
      current = current.next;
    }
    s += current.value;
    return s;
   }
}

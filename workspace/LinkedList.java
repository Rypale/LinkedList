/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/
public class LinkedList{

  //instance varialbes go here (think about what you need to keep track of!)
  ListNode head;
  boolean firstNode = false;

  //constructors go here

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line)
  {
    if(firstNode==false){
      head = new ListNode(line, null);
      firstNode = true;
      return head;
    }
    else{
      ListNode newNode;
      if(head.toString().compareTo(line)>0){
        newNode = head;
        head = new ListNode(line, newNode);
        return newNode;
      }
      ListNode prev = null;
      ListNode curr = head;
      while(curr != null){
        if(curr.toString().compareTo(line)>0){
          newNode = new ListNode(line, curr);
          if(prev !=null){
          prev.setNext(newNode);
          }
          
          return newNode;
        }
          else{
          prev = curr;
          curr = curr.getNext();
        }
      }
      newNode = new ListNode(line, null);
      if(prev !=null){
        prev.setNext(newNode);
      }
      
      return newNode;
    }

   
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null

  public ListNode deleteAValue(String line)
  {
    
    ListNode curr = head;
    ListNode prev = null;
    while(curr!=null){
      if(curr.toString().equals(line)){
        if(prev!=null){
          prev.setNext(curr.getNext());
        }
        if(curr == head){
          if(curr.getNext()!=null){
            head = curr.getNext();
          }
          else{
            firstNode = false;

          }
       
        }
        ListNode temp = curr;
        curr = null;
        return temp;
      }
      prev = curr;
      curr = curr.getNext();
    }
    return null;

  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    String allVals = "";
    ListNode curr;
    curr = head;
    while(curr != null){
      allVals = allVals + curr.toString() + " ";
      curr = curr.getNext();
    }
    return allVals;

    
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
    
    head = null;
    firstNode = false;

  
  }
}

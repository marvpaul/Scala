package list

case class Cons (val head:Int, val tail:IntList) extends IntList{
  def isEmpty=false
  
  def nth(index:Int):Int= index match{
    case 0 => head
    case i => tail.nth(i-1)
  }
  
  def contains(elem:Int):Boolean= elem match{
    case y if (y==head) => true
    case _ => tail.contains(elem)
  }

  def insert(X:Int):IntList= new Cons(X,this)
  	
  def insertSorted(elem:Int):IntList=  {
    if(elem > head) Cons(head, tail.insertSorted(elem))
    else Cons(elem, this)
  }

  def delete(elem:Int):IntList= {
    if(tail.head == elem) Cons(head, tail.tail)
    else Cons(head, tail.delete(elem))
  }

  def deleteAll(elem:Int):IntList = {
    if(tail.head == elem) Cons(head, tail.tail.delete(elem))
    else Cons(head, tail.delete(elem))
  }
    
  def insertionSortI:IntList= {
    if(tail.isEmpty) this
    else tail.insertionSortI.insertSorted(head)
  }
}
package list

abstract class IntList {

  def isEmpty:Boolean
  def head:Int
  def tail:IntList
  def nth(index:Int):Int
  def contains(elem:Int):Boolean
  def insert(elem:Int):IntList
  def insertSorted(elem:Int):IntList
  def delete(elem:Int):IntList
  def deleteAll(elem:Int):IntList
	def insertionSortI:IntList
	
  def insertSO(elem:Int):IntList = this match{
    case Cons(head, tail) => if(elem < tail.head) Cons(head, Cons(elem, tail)) else Cons(head, tail.insertSO(elem))
    case Empty => Cons(elem, Empty)
  }
  
  def insertionSort:IntList= {
    if(tail.isEmpty) this
    else tail.insertionSort.insertSorted(head)
  }
  
  def prefix(l:IntList):IntList= {
  }
  
  def flip:IntList= ???
}
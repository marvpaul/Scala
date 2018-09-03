package list

case object Empty extends IntList{
  def isEmpty=true
  def head:Int= throw new Error("head.nil")
  def tail:IntList= throw new Error("tail.nil")
  def contains(elem:Int):Boolean=false
  def nth(index:Int)= throw new Error("IndexOutOfBound")
  def insert(X:Int):IntList= new Cons(X,this)
  def insertSorted(elem:Int):IntList= Cons(elem, this)
  def delete(elem:Int):IntList= this
  def deleteAll(elem:Int):IntList = this
  def insertionSortI:IntList= Empty
  
  /*------------------------------------------------------------------------------*/
  /* 													Exercise 5																					*/
  /*------------------------------------------------------------------------------*/

  def map(mapFun:(Int)=>Int): IntList = ???
  def filter(filterFun:Int=>Boolean):IntList= {
    Empty
  }
  def foldLeft(base:Int)(reduceFun:(Int,Int)=>Int):Int= {
    base
  }
  def foldRight(base:Int)(reduceFun:(Int,Int)=>Int):Int= ???
}
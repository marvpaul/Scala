package list

object Application {
  
  /* Complete the given functions by practicing Higher Order Functions */
  
  /**************************************************************************
   * multiplyAndFilterEven should multiply all elements of the IntList by
   * the factor x and filter all element that are even
   ***************************************************************************/
  
  def multiplyAndFilterEven(l:IntList, x:Int):IntList= {
    l.map(value => value*x).filter(value=>value%2==0)
  }
  
   /**************************************************************************
   * findMin should find the minimum of a list
   ***************************************************************************/
  
  def findMin(l:IntList):Int= {
    l.foldLeft(Int.MaxValue)((smallestVal, curVal)=> if(curVal < smallestVal) curVal else smallestVal)
  }
  
  /**************************************************************************
   * sumOddNumbers should sum up all odd numbers of a list
   ***************************************************************************/
  
  def sumOddNumbers(l:IntList)= {
    l.filter(value => value%2!=0).foldLeft(0)((base, curVal) => base+curVal)
  }
  
  /**************************************************************************
   * countEvenNumbers should count all numbers of a list that are even
   ***************************************************************************/
 
  def countEvenNumbers(l:IntList):Int= {
    l.filter(value => value%2==0).foldLeft(0)((base, curVal) => base+1)
  }

}
package uebung1

class Rational (numerator:Int, denominator:Int){
  

  def this (denom:Int) = this(1,denom)  
  override def toString:String = numerator + "/" + denominator
  
  require (denominator!=0,"Denominator mmuss != 0 sein")  // wirft IllegalArgumentException
  println("Eine Rationale Zahl wurde erzeugt....")  // ist Teil des Konstruktors

  def num:Int=numerator  // damit numerator von aussen zugaenglich ist
  def denom:Int=denominator // damit denominator von aussen zugaenglich ist
  def value:Double = (num.toDouble / denom) // Konvertierung in eine Fliesskommazahl
  
  def  max(x:Rational): Rational = {
    
    if (numerator/denominator<x.num/x.denom) this else x
  }
}

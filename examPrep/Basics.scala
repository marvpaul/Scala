object Basics {
	def main(args: Array[String]): Unit ={
		println(sumNTimes(100))

		//Using the lazy keyword to prevent code from directly execution

		lazyVarExample()

		val v1 = new Vector(1, 2)
		val v2 = new Vector(2, 3)
		println(v1+v2)

	}

	def lazyVarExample(): Unit = {
		//Using some lazy vars
		def myInt(x: Int): Int = {
			println("Oh no, I was executed :=O")
			x
		}

		lazy val lazyVar = myInt(10)
	}

	def sumNTimes(n: Int): Int = {
		if (n > 0) 1 + sumNTimes(n-1)
		else 0
	}

	//Constructors
	class privateValues(myPrivateVal: Int)

	class publicValues(val myPublicVal: Int)

	class publicVariables(var myPublicVar: Int)



	//Infix operator
	//Note: We have to use var to make this variables public
	class Vector(var x: Int, var y: Int){
		def +(other: Vector): Vector = {
			new Vector(this.x + other.x, this.y + other.y)
		}


		override def toString = s"Vector($x, $y)"
	}

}

object Recursion {
	def main(args: Array[String]): Unit = {

	}

	/**
	  * This function is not tail recursive, which means the stack increases each time a rec. call is performed
	  * This is because we always add a +1 to the rec. call
	  * @param n
	  * @return
	  */
	def notTailRec(n: Int): Int = {
		if(n == 0) 0
		else notTailRec(n-1) + 1
	}

	/**
	  * Note: We have a recursive method call where we set a new variable for sum / Accumulator
	  * So the stack does not increase
	  * A tail recursive method is converted to while loop at compilation
	  * @param n
	  * @param sum
	  * @return
	  */
	def tailRec(n: Int, sum: Int): Int = {
		if (n==0) 0
		else tailRec(n-1, sum+1)
	}
}

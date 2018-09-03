object Streams {

	def main(args: Array[String]): Unit = {
		println(simpleSquredStream(10))
		var piStream = primStream(10)
		print(piStream)
	}

	def simpleSquredStream(nThSquareNumber: Int): List[Int] = {
		def endlessStream(n: Int): Stream[Int] = {
			Stream.cons(n*n, endlessStream(n+1))
		}
		endlessStream(1).take(nThSquareNumber).toList
	}

	def primStream(nPrimNumbers: Int): List[Int] = {
		def getNextPrim(i: Int): Int = {
			if(i == 2 || (2 to i-1).filter(x=>i%x==0).length == 0 ) i
			else getNextPrim(i+1)
		}

		def endlessPiStream(lastNumber: Int): Stream[Int] = {
			Stream.cons(getNextPrim(lastNumber), endlessPiStream(getNextPrim(lastNumber)+1))
		}
		endlessPiStream(2).take(nPrimNumbers).toList
	}
}

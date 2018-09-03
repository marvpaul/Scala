object Excersis3 {
	def main(args: Array[String]): Unit = {
		println(quersumme(123))
		println(getSumOfAllPrimsUnder(200000))
	}

	def quersumme(zahl: Int): Int = {
		def getStream(zahl: Int): Stream[Int] = {
			if(zahl > 10) Stream.cons(zahl%10, getStream(zahl/10))
			else Stream.cons(zahl, Stream.empty)
		}
		getStream(zahl).toList.sum
	}

	def getSumOfAllPrimsUnder(limit: Int): Int = {
		def isPrim(x: Int): Boolean = {
			(2 to x/2).filter(y => x % y== 0).length == 0
		}
		(2 to limit).filter(y=>isPrim(y)).sum
	}
}

object HOF {
	def main(args: Array[String]): Unit = {
		mapExample()
		flattenExample()
		flatMapExample()
		filterExample()
		reduceExample()
		foldExample()
		groupByExample()
	}

	def mapExample(): Unit = {
		val list = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		println("Map")
		println("Before: " + list.mkString(", "))
		println("After: " + list.map(x=>x-1).mkString(", "))
	}

	def flattenExample(): Unit = {
		val listWithLists = Array(Array(1, 2, 3), Array(4, 5), Array(6, 7, 8, 9, 10))
		println("Flatten")
		println("Before: " + listWithLists.map(x=>"List(" + x.mkString(", ") + ")").mkString(", "))
		println("After: " + listWithLists.flatten.mkString(", "))
	}

	/**
	  * This function does map first and then flatten
	  */
	def flatMapExample(): Unit = {
		val listWithLists = Array(Array(1, 2, 3), Array(4, 5), Array(6, 7, 8, 9, 10))
		println("FlatMap")
		println("Before: " + listWithLists.map(x=>"List(" + x.mkString(", ") + ")").mkString(", "))
		println("After: " + listWithLists.flatMap(x=>x :+ 0).mkString(", "))
	}


	/**
	  * This example filters by boolean
	  */
	def filterExample(): Unit = {
		val listWithZeros = Array(0, 1, 2, 3, 0, 4, 5, 6, 7, 8, 9, 0, 10)
		println("Filter")
		println("Before: " + listWithZeros.mkString(", "))
		println("After: " + listWithZeros.filter(x=>x!=0).mkString(", "))
	}

	/**
	  * This comobines all elements without a base elem
	  */
	def reduceExample(): Unit = {
		val list = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		println("Reduce")
		println("Before: " + list.mkString(", "))
		println("After: " + list.reduce((x, y) => {
			x+y
		}))
	}

	/**
	  * Combines all elems with a base elem
	  */
	def foldExample(): Unit = {
		val list = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		println("FoldRight")
		println("Before: " + list.mkString(", "))
		println("After: " + list.foldRight(Array[Int]())((x, reverseList) => {
			reverseList :+ x
		}).mkString(", "))
	}

	def groupByExample(): Unit = {
		val list = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		println("GroupBy")
		println("Before: " + list.mkString(", "))
		println("After: " + list.groupBy(x=>x%2).map(x=>"(" + x._1.toString + "=> " + x._2.mkString(", ") + ")"))
	}
}

object DataStructs {
	def main(args: Array[String]): Unit = {
		mapUpdate()
		differencesListAndArray()
		listOperations()
		someAndNone()
	}

	def mapExample(): Unit = {
		var myMap = Map(1->"Eins", 2->"zwei", 3->"drei")
		println(myMap.foldLeft(List[String]())((list, obj)=> {
			list :+ obj._2
		}))
	}

	def mapUpdate(): Unit = {
		var myMap = Map[String, Int]("hello" -> 1, "was" -> 1)
		var myWord = Array("hello", "hello", "new", "was")
		var updatedWordCount = myWord.foldRight(myMap)((word, myMap) => {
			myMap.updated(word, myMap.getOrElse(word, 0)+1)
		})
		println(updatedWordCount.mkString(", "))
	}

	def differencesListAndArray(): Unit = {
		//Lists are by default immutable, array mutable
		var myList = List("hello", "sth")
		//Note: This is not allowed!
		//myList(1) = "nothing"

		var myArray = Array("hello", "sth")
		//This is legit ...
		myArray(1) = "Nothing"
		println(myArray)
	}

	def listOperations(): Unit = {
		var myList = List("hello", "sth")
		var mySecondList = List("nothing")

		//Concat two lists
		myList ++ mySecondList

		//Add a value at the end
		myList :+ "nothing"

		//Add a value to beginning
		"nothing" :: myList

		//Distinct
		("hello" :: myList).distinct
	}

	def someAndNone(): Unit = {
		var myMap = Map[String, Int]("hello" -> 1, "was" -> 1)
		var myWord = Array("hello", "hello", "new", "was")
		var updatedMap = myWord.foldRight(myMap)((word, map) => map.get(word) match{
			//Word is in list
			case Some(elem) => map.updated(word, map.get(word).head+1)
			//Word is not in map
			case None => Map(word->1) ++ map
		})
		println(updatedMap.mkString(","))
	}

	def forEach(): Unit = {
		val list = List("hello", "sth")
		list.foreach(println)
	}

}

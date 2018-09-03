object Generators {
	def main(args: Array[String]): Unit = {
		getDalmatinerGenerator()
		getDalmatinerMapFilter()
	}

	def getDalmatinerGenerator(): Unit ={
		val dogs = Array(("Marv", "Dalmatiner"), ("Peter", "Tschiwauwa"), ("Heinz", "Dalmatiner"))
		println((for(dog <- dogs if dog._2.equals("Dalmatiner")) yield dog._1).mkString(", "))
	}

	def getDalmatinerMapFilter(): Unit = {
		val dogs = Array(("Marv", "Dalmatiner"), ("Peter", "Tschiwauwa"), ("Heinz", "Dalmatiner"))
		println(dogs.filter(x => x._2 == "Dalmatiner").map(x => x._1).mkString(", "))
	}
}

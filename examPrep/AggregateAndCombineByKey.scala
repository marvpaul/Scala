object AggregateAndCombineByKey {
	def main(args: Array[String]): Unit = {
		aggregateExample()
	}

	def aggregateExample(): Unit = {
		val myDogs: Array[String] = Array("Celly", "Kim", "Leo")
		print(myDogs.aggregate(0)((acc, obj)=> acc + obj.length, _+_))
	}
}

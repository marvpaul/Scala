object GenericStuff {

	def main(args: Array[String]): Unit = {

	}

	def myGenricArrayInverter[T](list: List[T]): List[T] = {
		list.foldRight(List[T]())((list, elem) => {
			list +: elem
		})
	}

}

object PatternMatching {
	def main(args: Array[String]): Unit = {

	}

	//We can use case classes to allow pattern matching with these classes
	//Case classes -> TODO: What else is cool about case classes
	sealed abstract class Shape
	case class Circle(r: Int) extends Shape
	case class Rectangle(h: Int, w: Int) extends Shape

	def area(form: Shape): Double = form match{
		case Circle(r) => 3.14 * r * r
		case Rectangle(h, w) => h * w
	}

	//Here goes code for pattern matching with vars and constant

	/**
	  * Note: Here we check if E is equals the constant PI
	  */
	import Math.{PI, E}
	E match {
		case PI => "PI is equals E. Strange!"
		case _ => "My understanding of math seems to be okay ..."
	}

	var pi = PI
	E match {
		case pi => "We dont check for equivalence, just assigning a a variable"
		case _ => "This code is never executed"
	}
}

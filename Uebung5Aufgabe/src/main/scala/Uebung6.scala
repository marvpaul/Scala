object Uebung6 {
	def main(args: Array[String]): Unit = {
		print(reverse[Int](List(1, 2, 3)).mkString(", "))

		val Paradigmen=List(("erlang", "funktional"), ("erlang", "logisch"), ("prolog", "logisch"), ("scala", "funktional"), ("scala", "objektorientiert"), ("scapla", "logisch"), ("java","objektorientiert"))
		println(countParadigma(Paradigmen))
		println(countParadigma(Paradigmen).map(x=>(x._1, x._2.toFloat/Paradigmen.length.toFloat)))

		println(partial[Int, Int, Int](1, (a,b)=>a+b)(10))

		println(mapReduce[Int, Int, Int](x=>{
			def helper(i: Int): Int = {
				if((2 until i).filter(y=>i%y==0).length==0 && x%2==0) i
				else helper(i+1)
			}
			helper(2)

		}, (sum, value) => sum + value, 0, List(10, 12, 20)))
	}

	def reverse[T](l:List[T]):List[T] = {
		l.foldRight(List[T]())((newVal, list) => List.concat(list, List(newVal)))
	}

	def countParadigma(paradigms: List[(String, String)]): Map[String, Int] = {
		paradigms.foldLeft(Map[String, Int]())((map, curLang) => {
			map.updated(curLang._2, map.getOrElse(curLang._2, 0)+1)
		})
	}

	def partial[A,B,C]( a:A,f:(A,B)=>C):B=>C = {
		def fnt(b: B): C = {
			f(a, b)
		}
		fnt
	}

	def mapReduce[S,B,R](mapFun:(S=>B), redFun:(R,B)=>R, base:R, l:List[S]):R = l.map(mapFun).foldLeft[R](base)(redFun)

}

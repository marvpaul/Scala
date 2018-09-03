package uebung7

object Uebung07 {
	def main(args: Array[String]): Unit = {
		val Paradigmen=List(("erlang", "funktional"), ("erlang", "logisch"), ("prolog", "logisch"), ("scala", "funktional"), ("scala", "objektorientiert"), ("scala", "logisch"), ("java","objektorientiert"))
		println(getOOPForGenerator(Paradigmen))
		println(getOOPViaFilter(Paradigmen))

		println(getParadigmaFilter(Paradigmen, List("erlang", "java")))
		println(getParadigmaGenerator(Paradigmen, List("erlang", "java")))

		println(getMoreThanOneParadigma(Paradigmen))
		println(getMoreThanOneParadigmaGenerator(Paradigmen))

		println(getListOfParadigmaFilterMap(Paradigmen))
	}

	//Get all languages which are objektorientiert
	def getOOPViaFilter(list: List[(String, String)]): List[String] = {
		list.filter(x=>x._2.equals("objektorientiert")).map(x=>x._1)
	}

	def getOOPForGenerator(list: List[(String, String)]): List[String] = {
		for(lang <- list if lang._2.equals("objektorientiert")) yield lang._1
	}

	//Get paradigmen for Erlang || Java
	def getParadigmaFilter(list: List[(String, String)], keywords: List[String]): List[String] = {
		list.filter(x=>keywords.contains(x._1)).map(x=>x._2)
	}

	def getParadigmaGenerator(list: List[(String, String)], keywords: List[String]): List[String] = {
		for(lang <- list if keywords.contains(lang._1)) yield lang._2
	}

	def getMoreThanOneParadigma(list: List[(String, String)]): List[String] = {
		list.filter(x=>list.map(y=>{
			if(y._1.equals(x._1) && !x._2.equals(y._2)) x._1
			else "false"
		}).filter(x=> !x.equals("false")).length != 0).map(x=>x._1)
	}

	def getMoreThanOneParadigmaGenerator(list: List[(String, String)]): List[String] = {
		(for(lang <- list) yield for(lang2 <- list if lang._1.equals(lang2._1) && !lang._2.equals(lang2._2)) yield lang._1).flatten
	}

	def getListOfParadigmaFilterMap(list: List[(String, String)]): List[(String, List[String])] = {
		list.flatMap(lang=>list.map(lang2=>{
			if(lang._1.equals(lang2._1) && !lang._2.equals(lang2._2)) (lang._1, List(lang._2, lang2._2))
			else null
		})).filter(x=>x!=null)
	}
}

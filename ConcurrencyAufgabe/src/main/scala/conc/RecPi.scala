package conc

import java.util.concurrent.RecursiveTask

import conc.PiCalculation.calculateHits

class RecPi(var tries: Int, var nrOfDepth: Int) extends RecursiveTask[Double] {
	override def compute(): Double = {
		if (nrOfDepth == 0) computeValue
		else {
			val t1= new RecPi(tries/2, nrOfDepth-1)
			val t2= new RecPi(tries/2, nrOfDepth-1)
			common.pool.execute(t1)
			common.pool.execute(t2)
			(t1.join+t2.join)
		}

	}

	def computeValue: Double = {
		calculateHits(tries,0).toDouble / tries.toDouble
	}
}

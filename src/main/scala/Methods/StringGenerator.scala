package Methods

import Map.Map

import scala.collection.mutable

class StringGenerator(private val map: Map, private var weights: List[Int]) {

  private val weightedList: mutable.Map[String, Int] = ()

  for (i <- (0, map.size))
    weightedList += ((map.elements(i), weights(i)))

  private def GenerateString(source: List[String], length: Int): String = {

    assert(source.nonEmpty)

    var answer: String = ""
    var iterator: Int = 0

    while(answer.length < length) {

      if (source.size <= iterator)
        iterator = 0

      answer = answer + source(iterator)
      iterator += 1

    }

    while(answer.length > length)
      answer.drop(0)

    answer

  }

  private def AnyWeight(length: Int) : String = {

    val aux = weightedList.collect{case x if weightedList(x._1) != 0 => x}
    var list : List[String] = ()

    for (elem <- aux)
      list = elem._1 :: list

    GenerateString(list, length)

  }

  private def NotWeighted(length: Int) : String = {

    val aux = weightedList.collect{case x if weightedList(x._1) == 0 => x}
    var list : List[String] = ()

    for (elem <- aux)
      list = elem._1 :: list

    GenerateString(list, length)

  }

}

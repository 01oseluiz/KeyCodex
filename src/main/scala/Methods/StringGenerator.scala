package Methods

import Map.Map

import scala.collection.mutable

class StringGenerator(private val map: Map, private var weights: List[Int]) {

  private val weightedList: mutable.Map[String, Int] = ()

  for (i <- (0, map.size))
    weightedList += ((map.elements(i), weights(i)))

  private def AnyWeight(length: Int) : String = {

    val aux = weightedList.collect{case x if weightedList(x._1) != 0 => x}
    var list : List[String] = ()
    var answer: String = ""

    for (elem <- aux)
      list = elem._1 :: list

    for (i <- (0, math.ceil(length/map.groupSize)))
      answer += list(i)

    while (answer.length > length)
      answer.drop(0)

    answer

  }

  private def NotWeighted(length: Int) : String = {

    val aux = weightedList.collect{case x if weightedList(x._1) == 0 => x}
    var list : List[String] = ()
    var answer: String = ""

    for (elem <- aux)
      list = elem._1 :: list

    for (i <- (0, math.ceil(length/map.groupSize)))
      answer += list(i)

    while (answer.length > length)
      answer.drop(0)

    answer

  }

}

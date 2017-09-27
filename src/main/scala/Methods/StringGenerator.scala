package Methods

import Map.{Group, Map}

class StringGenerator(private val current_map: Map, private var password: String, private var length: Int) {

  assert(length > 0)

  private val weightedList: List[Group] = current_map.getWeightedMap(password)

  private def FilterList(condition: (Group) => Boolean): List[String] = {

    val aux = weightedList.filter(x => condition(x))
    var list : List[String] = ()

    for (elem <- aux)
      list = elem.characters :: list

    list

  }

  private def SortList(condition: (Group, Group) => Boolean): List[String] = {

    val aux = weightedList.sortWith((x, y) => condition(x, y))
    var list : List[String] = ()

    for (elem <- aux)
      list = elem.characters :: list

    list

  }

  private def BuildString(source: List[String]): String = {

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
      answer.drop(answer.length()-1)

    answer

  }

  private def AnyWeight(length: Int): String = BuildString(FilterList(x => x.weight != 0))
  private def LeastWeighted(length: Int): String = BuildString(SortList((x, y) => x.weight < y.weight))
  private def MostWeighted(length: Int): String = BuildString(SortList((x, y) => x.weight > y.weight))
  private def NoFilter(lenght: Int): String = BuildString(FilterList(x => true))
  private def NotWeighted(length: Int): String = BuildString(FilterList(x => x.weight == 0))
  private def ReverseOrder(length: Int): String = BuildString(FilterList(x => true).reverse)

}

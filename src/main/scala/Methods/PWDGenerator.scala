package Methods

import Map.{Group, Map}

/*TODO list:

    TODO Most marked spaces method.
    TODO Most weighted spaces method.
    TODO Integrate this class with Security Class.

 */

/*
 * A classe PWDGenerator é construída para gerar as senhas do progama a partir de em um Map fornecido.
 */

class PWDGenerator(current_map: Map) {

  private val availableMethods: List[List[Group] => String] = List(AnyWeight, LeastWeighted, MostWeighted,
    NoFilter, NotWeighted, ReverseOrder)

  private def FilterGroupList(groups: List[Group], condition: (Group) => Boolean): List[String] =
    groups.filter(x => condition(x)).map(x => x.characters)

  private def SortGroupList(groups: List[Group], condition: (Group, Group) => Boolean): List[String] =
    groups.sortWith((x, y) => condition(x, y)).map(x => x.characters)

  // Método para construir uma senha a partir de uma lista de strings e do tamanho especificado.

  private def TruncatePWD(original: String, desired_length: Int): String = {

    assert(original.length > 0)

    var answer: String = ""
    var iterator: Int = 0

    while(answer.length < desired_length) {

      if (original.lengthCompare(iterator) <= 0)
        iterator = 0

      answer = answer + original(iterator)
      iterator += 1

    }

    answer

  }

  // Métodos de geração de senha.

  private def AnyWeight(groups: List[Group]) : String = FilterGroupList(groups, x => x.weight != 0).mkString("")
  private def LeastWeighted(groups: List[Group]): String = SortGroupList(groups, (x, y) => x.weight < y.weight)
    .mkString("")
  private def MostWeighted(groups: List[Group]): String = SortGroupList(groups, (x, y) => x.weight > y.weight)
    .mkString("")
  private def NoFilter(groups: List[Group]): String = FilterGroupList(groups, x => true).mkString("")
  private def NotWeighted(groups: List[Group]): String = FilterGroupList(groups, x => x.weight == 0).mkString("")
  private def ReverseOrder(groups: List[Group]): String = groups.map(x => x.characters).reverse.mkString("")

  def Generate(initial_input: String, length: Int): List[String] = {

    // O tamanho do input inicial e da senha desejada devem ser maiores que 0.

    assert(initial_input.length > 0)
    assert(length > 0)

    // Obtém-se a lista de grupos utilizando-se o input inicial e o mapa da classe PWDGen.

    val groups: List[Group] = current_map.getWeightedMap(initial_input)

    /*
     * Primeiro, a lista de grupos obtidas com o input inicial_input fornecido é mapeada como argumento de todos os
     * métodos existentes de geração de senha.
     *
     * Depois, mapeia-se a cada senha obtida pelos métodos de geração de senha como argumento do método TruncatePWD
     * junto com o input lenght, para se obter uma lista com senhas do tamanho length, chamada possiblePWDs.
     *
     */

    val possiblePWDs = availableMethods.map(x => x(groups)).map(y => TruncatePWD(y, length))

    possiblePWDs

  }

}

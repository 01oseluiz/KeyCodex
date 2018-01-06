package Methods

import Map.{Group, Map}

/*TODO list:

    TODO Most marked spaces method.
    TODO Most weighted spaces method.
    TODO Integrate this class with Security Class.

 */

/*
 * A classe StringGenerator tem o intuito de receber um mapa de senha, uma senha inicial e um tamanho desejado de
 * senha. Utilizando a senha inicial no mapa de senha fornecido, a classe gera uma lista de possíveis senhas com o
 * tamanho fornecido.
 */

class PWDGen(current_map: Map, initial_input: String) {

  // Atributos.

  // Lista de grupos fornecida pela senha inicial.

  private val weightedList: List[Group] = current_map.getWeightedMap(initial_input)

  // Lista com os métodos de geração de senha disponíveis.

  private val availableMethods: List[() => List[String]] = List(AnyWeight, LeastWeighted, MostWeighted, NoFilter,
                                                           NotWeighted, ReverseOrder)

  // Métodos.

  // Método para filtrar a lista de grupos com uma condição, retornando a lista de strings dos grupos restantes.

  private def FilterList(condition: (Group) => Boolean): List[String] = {

    val aux = weightedList.filter(x => condition(x))
    val list : List[String] = aux.map(x => x.characters)

    list

  }

  // Método para organizar a lista de grupos com uma condição, retornando a lista de strings dos grupos em ordem.

  private def SortList(condition: (Group, Group) => Boolean): List[String] = {

    val aux = weightedList.sortWith((x, y) => condition(x, y))
    val list : List[String] = aux.map(x => x.characters)

    list

  }

  // Método para construir uma senha a partir de uma lista de strings e do tamanho especificado.

  private def SizePWD(source: List[String], length: Int): String = {

    assert(source.nonEmpty)

    var answer: String = ""
    var iterator: Int = 0

    while(answer.length < length) {

      if (source.lengthCompare(iterator) <= 0)
        iterator = 0

      answer = answer + source(iterator)
      iterator += 1

    }

    while(answer.length > length)
      answer.drop(answer.length()-1)

    answer

  }

  // Métodos de geração de senha.

  private def AnyWeight() : List[String] = FilterList(x => x.weight != 0)
  private def LeastWeighted(): List[String] = SortList((x, y) => x.weight < y.weight)
  private def MostWeighted(): List[String] = SortList((x, y) => x.weight > y.weight)
  private def NoFilter(): List[String] = FilterList(x => true)
  private def NotWeighted(): List[String] = FilterList(x => x.weight == 0)
  private def ReverseOrder(): List[String] = weightedList.map(x => x.characters).reverse

  // Método para gerar lista de senhas recomendadas.

  def Generate(length: Int): List[String] = {

    // O tamanho da senha deve ser maior que 0.

    assert(length > 0)

    var aux: List[String] = List()

    for (method <- availableMethods)
      aux = SizePWD(method(), length) :: aux

    aux

  }

}

package Methods

import Map.{Group, Map}
import Methods.PWDGenMethods.availableMethods
import Security.{KeysSecurity, SingleKeySecurity}

/*TODO list:

    TODO Most marked spaces method.
    TODO Most weighted spaces method.
    TODO Integrate this class with Security Class.

 */

/*
 * A classe PWDGenerator é construída para gerar as senhas do progama a partir de em um Map fornecido.
 */

class PWDGenerator(current_map: Map) {

  // Método para truncar uma senha a partir de uma senha original fornecida e um tamanho desejado.

  private def TruncatePWD(original: String, desired_length: Int): String = {

    if (original.length <= 0) return ""

    var answer: String = ""
    var iterator: Int = 0

    while (answer.length < desired_length) {

      if (original.lengthCompare(iterator) <= 0)
        iterator = 0

      answer = answer + original(iterator)
      iterator += 1

    }

    answer

  }

  // Método para gerar uma senha a partir de uma string de input e de um tamanho desejado.

  def Generate(initial_input: String, length: Int): SingleKeySecurity = {

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

    val possiblePWDs = availableMethods.map(x => x(groups))
    var possiblePWDsTruncate: List[String] = List.empty

    possiblePWDs.foreach(y => possiblePWDsTruncate :+= TruncatePWD(y, length))


    // Exibir todas as senhas geradas
    /*println("\n----Senhas Geradas-----")
    possiblePWDsTruncate.foreach(println)
    println("-----------------------\n")
    */


    KeysSecurity.bestKey(possiblePWDsTruncate)
  }

}

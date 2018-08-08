package Methods

import Map.Group

/*
 * Singleton para abrigar os métodos de manipular uma lista de Groups (Filtragem, Ordenação, entre outros...) e
 * retornar uma lista com os caracteres dos Groups restantes após a manipulação.
 */

object GroupsManipulation {

  def FilterGroupList(groups: List[Group], condition: (Group) => Boolean): List[String] =
    groups.filter(x => condition(x)).map(x => x.characters)

  def IntersperseGroupLists(groups1: List[Group], groups2: List[Group]): List[String] = {

    var interspersed_list : List[Group] = List.empty

    var iterator = 0

    /*
     * Enquanto ambas as listas tem elementos a serem iterados, os elementos de cada lista são intercalados
     * e colocados na lista interspersed_list.
     */

    while(iterator < groups1.size && iterator < groups2.size) {

      interspersed_list = interspersed_list ::: List(groups1(iterator), groups2(iterator))

      iterator += 1

    }

    /*
     * Caso alguma das listas ainda tenha elementos a serem iterados, estes são diretamente concatenados à lista
     * interspersed_list.
     */

    if(iterator != groups2.size)
      interspersed_list = interspersed_list ::: groups2.drop(iterator)

    else if(iterator != groups1.size)
      interspersed_list = interspersed_list ::: groups1.drop(iterator)

    interspersed_list.map(x => x.characters)

  }

  def SortGroupList(groups: List[Group], condition: (Group, Group) => Boolean): List[String] =
    groups.sortWith((x, y) => condition(x, y)).map(x => x.characters)

}

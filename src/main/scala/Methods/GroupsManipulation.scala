package Methods

import Map.Group

/*
 * Singleton para abrigar os métodos de manipular uma lista de Groups (Filtragem, Ordenação, entre outros...) e
 * retornar uma lista com os caracteres dos Groups restantes após a manipulação.
 */

object GroupsManipulation {

  def FilterGroupList(groups: List[Group], condition: (Group) => Boolean): List[String] =
    groups.filter(x => condition(x)).map(x => x.characters)

  def SortGroupList(groups: List[Group], condition: (Group, Group) => Boolean): List[String] =
    groups.sortWith((x, y) => condition(x, y)).map(x => x.characters)

}

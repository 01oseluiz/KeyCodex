package Methods

import Map.Group
import Methods.BinaryOps.CountOnes
import Methods.GroupsManipulation.{FilterGroupList, SortGroupList}

/*
 * Singleton para abrigar os métodos de geração de senha a partir de uma lista de Groups.
 */

object PWDGenMethods {

  val availableMethods: List[List[Group] => String] = List(AnyWeight, EvenStrikes, LeastStrikes, LeastWeighted,
    MostStrikes, MostWeighted, NoFilter, NotWeighted, OddStrikes, ReverseOrder)

  def AnyWeight(groups: List[Group]): String = FilterGroupList(groups, x => x.weight != 0).mkString("")
  def EvenStrikes(groups: List[Group]): String = FilterGroupList(groups, x => CountOnes(x.weight) % 2 == 0)
    .mkString("")
  def LeastStrikes(groups: List[Group]): String = SortGroupList(groups,
    (x, y) => CountOnes(x.weight) < CountOnes(y.weight)).mkString("")
  def LeastWeighted(groups: List[Group]): String = SortGroupList(groups, (x, y) => x.weight < y.weight).mkString("")
  def MostStrikes(groups: List[Group]): String = SortGroupList(groups,
    (x, y) => CountOnes(x.weight) > CountOnes(y.weight)).mkString("")
  def MostWeighted(groups: List[Group]): String = SortGroupList(groups, (x, y) => x.weight > y.weight).mkString("")
  def NoFilter(groups: List[Group]): String = FilterGroupList(groups, x => true).mkString("")
  def NotWeighted(groups: List[Group]): String = FilterGroupList(groups, x => x.weight == 0).mkString("")
  def OddStrikes(groups: List[Group]): String = FilterGroupList(groups, x => CountOnes(x.weight) % 2 != 0)
    .mkString("")
  def ReverseOrder(groups: List[Group]): String = groups.map(x => x.characters).reverse.mkString("")

}

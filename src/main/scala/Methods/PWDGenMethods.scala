package Methods

import Map.Group
import Methods.GroupsManipulation.{FilterGroupList, SortGroupList}

/*
 * Singleton para abrigar os métodos de geração de senha a partir de uma lista de Groups.
 */

object PWDGenMethods {

  val availableMethods: List[List[Group] => String] = List(AnyWeight, LeastStrikes, LeastWeighted, MostStrikes,
    MostWeighted, NoFilter, NotWeighted, ReverseOrder)

  def AnyWeight(groups: List[Group]) : String = FilterGroupList(groups, x => x.weight != 0).mkString("")
  def LeastStrikes(groups: List[Group]): String = SortGroupList(groups,
    (x, y) => BinaryOps.CountOnes(x.weight) < BinaryOps.CountOnes(y.weight)).mkString("")
  def LeastWeighted(groups: List[Group]): String = SortGroupList(groups, (x, y) => x.weight < y.weight).mkString("")
  def MostStrikes(groups: List[Group]): String = SortGroupList(groups,
    (x, y) => BinaryOps.CountOnes(x.weight) > BinaryOps.CountOnes(y.weight)).mkString("")
  def MostWeighted(groups: List[Group]): String = SortGroupList(groups, (x, y) => x.weight > y.weight).mkString("")
  def NoFilter(groups: List[Group]): String = FilterGroupList(groups, x => true).mkString("")
  def NotWeighted(groups: List[Group]): String = FilterGroupList(groups, x => x.weight == 0).mkString("")
  def ReverseOrder(groups: List[Group]): String = groups.map(x => x.characters).reverse.mkString("")

}

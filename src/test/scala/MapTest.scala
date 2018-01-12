import org.scalatest.{FunSuite, FlatSpec, Matchers}
import Map.Map

class MapTest extends FunSuite{
  test("Preenchimento") {
    val map = new Map
    map.printMap()
  }

  test("Indexacao") {
    val map = new Map
    val map_list : List[Char] = List.range('A', 'Z') ::: List('Z') ::: List.range('0', '9') ::: List('9')

    var list1 : Option[List[Int]] = Option.empty
    var list2 : Option[List[Int]] = Option.empty
    var list3 : Option[List[Int]] = Option.empty

    var list12 : List[Int] = List.empty
    var list13 : List[Int] = List.empty
    for (i <- 0 until 6) {
      list1 = map.getIndex(map_list(i).toString)
      list2 = map.getIndex(map_list(17 - i).toString)
      list3 = map.getIndex(map_list(29 - i).toString)

      ///Lista a verificar, lado oposto 1, lado oposto 2
      //println(map_list(i).toString, map_list(17 - i).toString, map_list(29 - i).toString)

      list12 = list1.get.intersect(list2.get)
      list13 = list1.get.intersect(list3.get)

      assert(list12.union(list13).diff(list12.intersect(list13)).sorted == list1.get)
    }

    for (i <- 6 until 12) {
      list1 = map.getIndex(map_list(i).toString)
      list2 = map.getIndex(map_list(29 - i).toString)
      list3 = map.getIndex(map_list(41 - i).toString)

      ///Lista a verificar, lado oposto 1, lado oposto 2
      //println(map_list(i).toString, map_list(29 - i).toString, map_list(41 - i).toString)

      list12 = list1.get.intersect(list2.get)
      list13 = list1.get.intersect(list3.get)

      assert(list12.union(list13).diff(list12.intersect(list13)).sorted == list1.get)
    }

    for (i <- 12 until 18) {
      list1 = map.getIndex(map_list(i).toString)
      list2 = map.getIndex(map_list(17 - i).toString)
      list3 = map.getIndex(map_list(41 - i).toString)

      ///Lista a verificar, lado oposto 1, lado oposto 2
      //println(map_list(i).toString, map_list(17 - i).toString, map_list(41 - i).toString)

      list12 = list1.get.intersect(list2.get)
      list13 = list1.get.intersect(list3.get)

      assert(list12.union(list13).diff(list12.intersect(list13)).sorted == list1.get)
    }

    for (i <- 18 until 24) {
      list1 = map.getIndex(map_list(i).toString)
      list2 = map.getIndex(map_list(29 - i).toString)
      list3 = map.getIndex(map_list(53 - i).toString)

      ///Lista a verificar, lado oposto 1, lado oposto 2
      //println(map_list(i).toString, map_list(29 - i).toString, map_list(53 - i).toString)

      list12 = list1.get.intersect(list2.get)
      list13 = list1.get.intersect(list3.get)

      assert(list12.union(list13).diff(list12.intersect(list13)).sorted == list1.get)
    }

    for (i <- 24 until 30) {
      list1 = map.getIndex(map_list(i).toString)
      list2 = map.getIndex(map_list(29 - i).toString)
      list3 = map.getIndex(map_list(41 - i).toString)

      ///Lista a verificar, lado oposto 1, lado oposto 2
      //println(map_list(i).toString, map_list(29 - i).toString, map_list(41 - i).toString)

      list12 = list1.get.intersect(list2.get)
      list13 = list1.get.intersect(list3.get)

      assert(list12.union(list13).diff(list12.intersect(list13)).sorted == list1.get)
    }

    for (i <- 30 until 36) {
      list1 = map.getIndex(map_list(i).toString)
      list2 = map.getIndex(map_list(53 - i).toString)
      list3 = map.getIndex(map_list(41 - i).toString)

      ///Lista a verificar, lado oposto 1, lado oposto 2
      //println(map_list(i).toString, map_list(53 - i).toString, map_list(41 - i).toString)

      list12 = list1.get.intersect(list2.get)
      list13 = list1.get.intersect(list3.get)

      assert(list12.union(list13).diff(list12.intersect(list13)).sorted == list1.get)
    }
  }
}

import Map.Group
import Methods.BinaryOps
import Methods.GroupsManipulation.IntersperseGroupLists
import org.scalatest.{FunSuite, Matchers}

class MiscTest extends FunSuite {

  test("CountOnes method: Normal cases") {

    assert(BinaryOps.CountOnes(0) == 0)
    assert(BinaryOps.CountOnes(1) == 1)
    assert(BinaryOps.CountOnes(3) == 2)
    assert(BinaryOps.CountOnes(6) == 2)
    assert(BinaryOps.CountOnes(7) == 3)
    assert(BinaryOps.CountOnes(24) == 2)
    assert(BinaryOps.CountOnes(59) == 5)
    assert(BinaryOps.CountOnes(567) == 6)
    assert(BinaryOps.CountOnes(4096) == 1)
    assert(BinaryOps.CountOnes(1048576) == 1)
    assert(BinaryOps.CountOnes(1073741824) == 1)

  }

  test("CountOnes method: Invalid cases") {

    try {
      BinaryOps.CountOnes(-1)
    }

    catch {
      case a: AssertionError => succeed
      case _: Throwable => fail()
    }

  }

  test("IntersperseGroupLists: Different sizes 1.") {

    val TestList1 : List[Group] = List(Group("abcd", 0), Group("efgh", 0))
    val TestList2 : List[Group] = List(Group("uvwx", 2), Group("yz01", 0), Group("2345", 3), Group("6789", 1))

    assert(IntersperseGroupLists(TestList1, TestList2) == List("abcd", "uvwx", "efgh", "yz01", "2345", "6789"))

  }

  test("IntersperseGroupLists: Different sizes 2.") {

    val TestList1 : List[Group] = List(Group("abcd", 0), Group("efgh", 0), Group("2345", 3), Group("6789", 1))
    val TestList2 : List[Group] = List(Group("uvwx", 2), Group("yz01", 0))

    assert(IntersperseGroupLists(TestList1, TestList2) == List("abcd", "uvwx", "efgh", "yz01", "2345", "6789"))

  }

  test("IntersperseGroupLists: Equal sizes.") {

    val TestList1 : List[Group] = List(Group("abcd", 0), Group("efgh", 0))
    val TestList2 : List[Group] = List(Group("uvwx", 2), Group("yz01", 0))

    assert(IntersperseGroupLists(TestList1, TestList2) == List("abcd", "uvwx", "efgh", "yz01"))

  }

}

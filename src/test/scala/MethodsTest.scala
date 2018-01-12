import Map.Group
import Methods.PWDGenMethods._
import org.scalatest.FunSuite

class MethodsTest extends FunSuite {

  test("AnyWeight method.") {

    val TestList : List[Group] = List(Group("abcd", 0), Group("efgh", 0), Group("ijkl", 1), Group("mnop", 3),
      Group("qrst", 1), Group("uvwx", 2), Group("yz01", 0), Group("2345", 3), Group("6789", 1))

    assert(AnyWeight(TestList) == "ijklmnopqrstuvwx23456789")

  }

  test("LeastWeighted method.") {

    val TestList : List[Group] = List(Group("abcd", 0), Group("efgh", 0), Group("ijkl", 1), Group("mnop", 3),
      Group("qrst", 1), Group("uvwx", 2), Group("yz01", 0), Group("2345", 3), Group("6789", 1))

    assert(LeastWeighted(TestList) == "abcdefghyz01ijklqrst6789uvwxmnop2345")

  }

  test("MostWeighted method.") {

    val TestList : List[Group] = List(Group("abcd", 0), Group("efgh", 0), Group("ijkl", 1), Group("mnop", 3),
      Group("qrst", 1), Group("uvwx", 2), Group("yz01", 0), Group("2345", 3), Group("6789", 1))

    assert(MostWeighted(TestList) == "mnop2345uvwxijklqrst6789abcdefghyz01")

  }

  test("NoFilter method.") {

    val TestList : List[Group] = List(Group("abcd", 0), Group("efgh", 0), Group("ijkl", 1), Group("mnop", 3),
      Group("qrst", 1), Group("uvwx", 2), Group("yz01", 0), Group("2345", 3), Group("6789", 1))

    assert(NoFilter(TestList) == "abcdefghijklmnopqrstuvwxyz0123456789")

  }

  test("NotWeighted method.") {

    val TestList : List[Group] = List(Group("abcd", 0), Group("efgh", 0), Group("ijkl", 1), Group("mnop", 3),
      Group("qrst", 1), Group("uvwx", 2), Group("yz01", 0), Group("2345", 3), Group("6789", 1))

    assert(NotWeighted(TestList) == "abcdefghyz01")

  }

  test("ReverseOrder method.") {

    val TestList : List[Group] = List(Group("abcd", 0), Group("efgh", 0), Group("ijkl", 1), Group("mnop", 3),
      Group("qrst", 1), Group("uvwx", 2), Group("yz01", 0), Group("2345", 3), Group("6789", 1))

    assert(ReverseOrder(TestList) == "67892345yz01uvwxqrstmnopijklefghabcd")

  }

}

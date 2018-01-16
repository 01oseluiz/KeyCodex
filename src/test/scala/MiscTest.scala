import Methods.BinaryOps
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

}

import org.scalatest.{FlatSpec, Matchers}

class Teste extends FlatSpec with Matchers{

  "estou apenas fazendo uma soma para testar o ScalaTest, e a soma" should "dar 10" in {
    val soma = 5+5
    soma should be (10)
  }

}

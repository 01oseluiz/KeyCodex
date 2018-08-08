import org.scalatest.FunSuite
import Map._
import Methods._
import Security._

import scala.collection.mutable.ListBuffer

class GenerationManyMapsTest extends FunSuite{

  /*
  * OBJETIVO: dado um conjunto de senhas testar
  * qual mapa gera senhas com maior complexidade
  * e maior facilidade de escrita
  */

  val Map = new Map

  // Senhas para teste de mapa
  var inputPasswords:ListBuffer[String] = ListBuffer.empty
  inputPasswords += "teste"
  inputPasswords += "a"
  inputPasswords += "111"
  inputPasswords += "face18"
  inputPasswords += "tteee"
  inputPasswords += "tttee"
  inputPasswords += "azyqkrgb01"

  //----------------- Geração de senhas - tamanho 8 -----------------
  printInputPasswords()

  test("FirstMap.map -> a-z 0-9 'especiais' QWERTZ -> pass.size = 8"){
    Map.fillMapWithLoad("FirstMap.map")
    testPassWithActualMap(8)
    succeed
  }

  test("FirstMap.map -> a-z + QWERTZ alternated 0-9 + 'especiais' -> pass.size = 8"){
    Map.fillMapWithLoad("Alternado.map")
    testPassWithActualMap(8)
    succeed
  }

  test("Combinacoes.map -> [a1, b2, b3 ... C? ... AZ] -> pass.size = 8"){
    Map.fillMapWithLoad("Combinacoes.map")
    testPassWithActualMap(8)
    succeed
  }

  private def testPassWithActualMap(size:Int): Unit ={
    inputPasswords.foreach{inputPass =>
      val bestKey = new PWDGenerator(Map).Generate(inputPass, size)
      print("\t" + bestKey.Password + " -> " + bestKey.getCrackTime + "\t|")
    }
    println("")
  }

  private def printInputPasswords(): Unit ={
    inputPasswords.foreach{inputPass =>
      print("\t\t\t" + inputPass + "\t\t\t|")
    }
    println("")
  }
}

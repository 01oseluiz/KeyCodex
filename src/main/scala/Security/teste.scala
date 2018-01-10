package Security

import scala.io.StdIn.readLine

object teste {

  def main(args: Array[String]): Unit = {
   test_mult_keys()
  }

  def test_mult_keys(): Unit = {
    var entradas: List[String] = List.empty
    var ent:String = readLine("PASSWORD: ")

    while (ent != "0"){
      entradas :+= ent
      ent = readLine("PASSWORD: ")
    }

    println(KeysSecurity.bestKey(entradas).Password)
  }


  def test_single_key(): Unit = {
    var entrada: String = readLine("PASSWORD: ")

    while (entrada != "0") {
      val pass = new SingleKeySecurity(entrada)

      println("Time to crack: " + pass.getCrackTime)
      println(pass.getFeedback)

      entrada = readLine("PASSWORD: ")
    }
  }

}



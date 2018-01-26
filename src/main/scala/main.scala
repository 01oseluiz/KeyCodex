import Map._
import Methods._
import Security._

import scala.io.StdIn.readLine

object main {
  private val Map = new Map

  //println("---------------MAPA-------------------")
  //Map.printMap()
  //println("------------Fim MAPA-------------------")

  def main(args: Array[String]): Unit = {
    renderMenu()
  }

  private def renderMenu(): Unit = {
    var input = ""

    while (input != "0") {
      printMenuOptions()

      input = readLine("-> ")

      input match {
        case "1" => generatePassArea()
        case "2" => testPassArea()
        case _ =>
      }
    }
  }

  private def printMenuOptions(): Unit = {
    println("-------------Menu-----------")
    println("(0) Exit")
    println("(1) Generate Password")
    println("(2) Test Password")
    println("----------------------------")
  }

  private def testPassArea(): Unit = {
    var input = ""

    while (input != "exit") {
      input = readLine("Test -> ")

      if (input != "exit" && input != "") {
        val bestKey = new SingleKeySecurity(input)
        println("Time to Crack: " + bestKey.getCrackTime)
      }
    }
  }

  private def generatePassArea(): Unit = {
    var input = ""

    while (input != "exit") {
      input = readLine("Generate -> ")

      if (input != "exit" && input != "") {
        val bestKey = getGeneratePassword(input, 8)
        println("BestKey: " + bestKey.Password + "\nTime to Crack: " + bestKey.getCrackTime)
      }
    }
  }

  private def createNewMap(): Unit = {

  }

  private def loadMap(): Unit = {

  }

  private def getGeneratePassword(initialPass: String, length: Int): SingleKeySecurity = {
    //val PWDGenerator = new PWDGenerator(Map)
    //val bestKey = PWDGenerator.Generate(initialPass, length)
    //bestKey

    new PWDGenerator(Map).Generate(initialPass, length)
  }

}

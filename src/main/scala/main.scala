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
        case "3" => createNewMap()
        case "4" => loadMap()
        case _ =>
      }
    }
  }

  private def printMenuOptions(): Unit = {
    println("-------------Menu-----------")
    println("(0) Exit")
    println("(1) Generate Password")
    println("(2) Test Password")
    println("(3) Create Map")
    println("(4) Load Map")
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
    var listWords:List[String] = List.empty

    var count = 0

    while (count <= 68){
      val word = readLine("Position " + count + " -> ")

      if (!word.isEmpty && word.length <= 4){
        listWords :+= word
        count += 1
      }
    }

    val nameMap = readLine("name Map: ") + ".map"

    if (Map.createFillMap(listWords, nameMap)){
      println("Map created with success!")
    }else{
      println("Error to create map!")
    }
  }

  private def loadMap(): Unit = {
    val mapName = readLine("Name Map file: ")
    Map.fillMapWithLoad(mapName)

    println("---------------MAPA-------------------")
    Map.printMap()
    println("------------Fim MAPA-------------------")
  }

  private def getGeneratePassword(initialPass: String, length: Int): SingleKeySecurity = {
    //val PWDGenerator = new PWDGenerator(Map)
    //val bestKey = PWDGenerator.Generate(initialPass, length)
    //bestKey

    new PWDGenerator(Map).Generate(initialPass, length)
  }

}

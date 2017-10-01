package Map

import scala.collection.{immutable, mutable}
import scala.collection.mutable._
import scala.io.Source
import scala.io.StdIn._
/**
  TODO Criar lista de pesos seguindo a indexação do mapa
  TODO Criar método getWeights()
 */

case class Cell(characters: List[String])
case class Group(characters: List[String], weight: Int)

class Map (){
   private val elements : List[Group] = List.empty
   private val index : HashMap[String, List[Int]] = setMapIndexes()

  def getGroupSize : Int = {
    elements.head.characters.size
  }

  def getIndex(key: String) : Option[List[Int]] = index.get(key)
  //def getWeightedMap(password : String) : List[Group]

  private def setMapIndexes(): HashMap[String, List[Int]] = {
    val mapIndexes : HashMap[String, List[Int]] = HashMap.empty

    mapIndexes.put("A", List(0, 1, 11, 18, 19, 20, 21, 23, 31, 41, 42, 48, 56, 60, 66, 68, 70, 71))
    mapIndexes.put("B", List(1, 10, 18, 22, 23, 24, 30, 31, 37, 38, 39, 42, 47, 56, 57, 59, 60, 66, 67, 68))
    mapIndexes.put("C", List(1, 2, 9, 10, 17, 23, 24, 30, 37, 40, 41, 43, 46, 47, 53, 57, 58, 59))
    mapIndexes.put("D", List(2, 3, 9, 16, 17, 24, 25, 29, 36, 42, 43, 44, 45, 46, 52, 54, 55, 56))
    mapIndexes.put("E", List(3, 8, 16, 24, 25, 26, 27, 28, 29, 35, 36, 42, 43, 51, 52, 56, 63, 64, 65, 66))
    mapIndexes.put("F", List(3, 4, 5, 6, 7, 8, 15, 25, 35, 43, 51, 57, 62, 63, 64, 66, 71))
    mapIndexes.put("G", List(0, 1, 2, 3, 4, 14, 15, 26, 34, 44, 50, 57, 58, 62, 67, 69, 70))
    mapIndexes.put("H", List(0, 4, 5, 14, 21, 22, 23, 24, 25, 26, 27, 33, 34, 44, 45, 49, 50, 58, 61, 67, 68, 69))
    mapIndexes.put("I", List(5, 6, 13, 21, 22, 26, 27, 33, 41, 42, 43, 44, 45, 49, 59, 60, 61))
    mapIndexes.put("J", List(6, 12, 13, 20, 27, 28, 32, 39, 40, 41, 44, 46, 47, 48, 55, 56, 57))
    mapIndexes.put("K", List(6, 7, 12, 19, 20, 27, 28, 29, 30, 31, 32, 38, 39, 40, 45, 55, 58, 65, 66, 67))
    mapIndexes.put("L", List(7, 8, 9, 10, 11, 19, 28, 38, 45, 46, 53, 54, 58, 59, 65, 67, 70, 71))
    mapIndexes.put("M", List(4, 5, 6, 7, 8, 18, 29, 37, 46, 52, 53, 54, 59, 63, 64, 68, 70))
    mapIndexes.put("N", List(3, 8, 9, 17, 18, 25, 26, 27, 28, 29, 30, 36, 37, 47, 52, 60, 63, 64, 68, 69))
    mapIndexes.put("O", List(2, 3, 9, 17, 25, 29, 30, 36, 43, 44, 45, 46, 47, 48, 51, 60, 61, 62))
    mapIndexes.put("P", List(2, 9, 10, 16, 24, 30, 31, 35, 43, 46, 47, 48, 49, 50, 51, 57, 58, 59))
    mapIndexes.put("Q", List(1, 10, 11, 15, 16, 23, 24, 30, 31, 32, 33, 34, 35, 42, 47, 56, 57, 59, 60, 66, 67, 68))
    mapIndexes.put("R", List(0, 1, 11, 12, 13, 14, 15, 23, 31, 41, 42, 48, 56, 60, 66, 68, 70, 71))
    mapIndexes.put("S", List(0, 7, 8, 9, 10, 11, 12, 22, 32, 41, 48, 49, 55, 61, 65, 69, 70, 71))
    mapIndexes.put("T", List(7, 12, 21, 22, 29, 30, 31, 32, 33, 39, 40, 49, 54, 55, 61, 62, 64, 65, 69))
    mapIndexes.put("U", List(6, 12, 13, 20, 21, 28, 32, 33, 39, 40, 46, 47, 48, 50, 53, 54, 62, 63))
    mapIndexes.put("V", List(5, 6, 13, 14, 20, 27, 33, 34, 38, 45, 49, 50, 51, 52, 53, 59, 60, 61))
    mapIndexes.put("W", List(5, 14, 19, 26, 27, 33, 34, 35, 36, 37, 44, 45, 49, 50, 58, 61, 67, 68, 69))
    mapIndexes.put("X", List(4, 14, 15, 16, 17, 18, 19, 26, 34, 44, 50, 57, 58, 62, 67, 69, 70, 71))
    mapIndexes.put("Y", List(3, 4, 11, 12, 13, 14, 15, 25, 35, 43, 51, 57, 62, 63, 66, 70, 71))
    mapIndexes.put("Z", List(3, 10, 11, 15, 16, 24, 25, 31, 32, 33, 34, 35, 36, 42, 43, 51, 52, 56, 63, 64, 65, 66))
    mapIndexes.put("0", List(2, 10, 16, 17, 24, 31, 35, 36, 42, 48, 49, 50, 51, 52, 54, 55, 56))
    mapIndexes.put("1", List(1, 2, 9, 17, 23, 30, 36, 37, 40, 41, 47, 48, 51, 53, 60, 61, 62))
    mapIndexes.put("2", List(1, 8, 9, 17, 18, 22, 23, 29, 30, 36, 37, 38, 39, 47, 52, 60, 63, 64, 68, 69))
    mapIndexes.put("3", List(0, 8, 18, 19, 20, 21, 29, 37, 46, 52, 53, 54, 59, 63, 64, 68, 70))
    mapIndexes.put("4", List(7, 15, 16, 17, 18, 19, 28, 38, 45, 46, 53, 54, 58, 59, 65, 67, 71))
    mapIndexes.put("5", List(6, 7, 14, 19, 20, 27, 28, 34, 35, 36, 37, 38, 39, 40, 45, 55, 58, 65, 66, 67))
    mapIndexes.put("6", List(6, 13, 14, 20, 27, 34, 38, 39, 40, 41, 44, 50, 51, 52, 53, 55, 56, 57))
    mapIndexes.put("7", List(5, 13, 20, 21, 22, 26, 33, 39, 40, 41, 42, 43, 44, 50, 53, 54, 62, 63))
    mapIndexes.put("8", List(0, 4, 5, 12, 21, 22, 23, 24, 25, 26, 32, 33, 39, 40, 49, 54, 55, 61, 62, 64, 65, 69))
    mapIndexes.put("9", List(0, 1, 2, 3, 4, 11, 12, 22, 32, 41, 48, 49, 55, 61, 65, 69, 70, 71))

    mapIndexes
  }

  protected def fillMap(chars : List[Cell]): Unit = {

  }
}


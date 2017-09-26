package Map

import scala.collection.immutable
import scala.collection.mutable._
import scala.io.Source
import scala.io.StdIn._
/**
  TODO Criar indexação do mapa e assimilar para o HashMap (Rotação a partir do A)
  TODO Criar lista de pesos seguindo a indexação do mapa
  TODO Criar método getWeights()
 */
case class Group(characters: List[Char], weight: Int)

class Map (){
  private val elements : List[Group] = ()
  private var index : HashMap[Char, List[Int]] = HashMap.empty

  def getGroupSize : Int = {
    elements.head.characters.size
  }
  def getWeightedMap(password : String) : List[Group]

  def mapEntries(): Unit = {
    val file = Source.fromFile("MapEntries.txt")
    var currentEntry : List[Int] = List.empty

    for (i <- file.getLines()){
      currentEntry :+= i.toInt
    }

  }

    //file.getLines.foreach{currentEntry += this}
}


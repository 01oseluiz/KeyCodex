package Security
import scala.io.StdIn.readLine

object Random extends App {

  var entrada:String = readLine("PASSWORD: ")
  var pass = new Security

  while(entrada != "0"){
    pass.Password = entrada

    println("Time to crack: " + pass.getCrackTime)
    println(pass.getFeedback)

    entrada = readLine("PASSWORD: ")
  }


  /*def max(bla:List[Int]) : Int = {
  require(bla.nonEmpty)
  var Max:Int = bla.head
  for (i <- bla if i > Max) Max = i
  Max
}
println(this.max(List(1,2,3,1,9,7,10,0,21,2,3,4,7,45)))*/

  /*val mult = (i:Int) => i * 3
 def tes = (i:String) => i + "asdf"
 println("laksjf:" + tes("134"))*/
}



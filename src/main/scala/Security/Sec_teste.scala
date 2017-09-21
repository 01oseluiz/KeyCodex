package Security

import scala.io.Source
import java.io._

object Sec_teste extends  App{

  val writer = new PrintWriter(new File("senhas_out.txt"))
  val pass = new Security

  for (line <- Source.fromFile("senhas.txt").getLines()){
    pass.Password = line

    writer.write(pass.Password + "\t")
    writer.write(pass.getCrackTime + "\t")
    writer.write(pass.getStrength_Double.toString + "\n")
  }
  writer.close()

}

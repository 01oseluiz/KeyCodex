package Security

import scala.collection.immutable.HashMap

object KeysSecurity {

  def bestKey(keys: List[String]): SingleKeySecurity = {

    var keys_strength: HashMap[SingleKeySecurity, Double] = HashMap.empty

    keys.foreach{ key=>
      val aux_key_security = new SingleKeySecurity(key)
      keys_strength +=  aux_key_security -> aux_key_security.getStrength
    }

    keys_strength.toSeq.maxBy(_._2)._1
  }

}

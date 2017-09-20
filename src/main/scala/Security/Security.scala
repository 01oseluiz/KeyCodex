package Security

import com.nulabinc.zxcvbn.{Strength, Zxcvbn}

/* TODO-Frodo: List task
*     Pesquisar Metodos de verificação de segurança
*       EX: testedesenha.com
*           howsecureismypassword.net
* */

class Security {

  var Password:String = ""

  private val zxcvbn = new Zxcvbn
  private val pass_strength:Strength = zxcvbn.measure(Password)

  def getStrength_Int:Double = pass_strength.getCrackTimeSeconds.getOfflineSlowHashing1e4perSecond

  def getCrackTime:String = pass_strength.getCrackTimesDisplay.getOfflineSlowHashing1e4perSecond

  def getFeedback:String = pass_strength.getFeedback.getWarning + ": " + pass_strength.getFeedback.getSuggestions()

  def getStrength_Percent:Double = null

}

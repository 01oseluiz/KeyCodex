package Security

import com.nulabinc.zxcvbn.{Strength, Zxcvbn}

/* TODO-Frodo: List task
*     Pesquisar Metodos de verificação de segurança
*       EX: testedesenha.com
*           howsecureismypassword.net
* */

class Security {

  private val zxcvbn = new Zxcvbn
  private var password:String = ""
  private var pass_strength:Strength = _

  def Password:String = password
  def Password_= (x:String) {password = x; pass_strength = zxcvbn.measure(password)}

  def getStrength_Double:Double = pass_strength.getCrackTimeSeconds.getOnlineNoThrottling10perSecond

  def getCrackTime:String = pass_strength.getCrackTimesDisplay.getOnlineNoThrottling10perSecond

  def getFeedback:String = pass_strength.getFeedback.getWarning + ": " + pass_strength.getFeedback.getSuggestions()

  def getStrength_Percent:Double = 0

}

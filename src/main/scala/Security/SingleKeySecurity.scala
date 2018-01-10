package Security

import com.nulabinc.zxcvbn.{Strength, Zxcvbn}

class SingleKeySecurity(pass:String) {

  private val zxcvbn = new Zxcvbn
  private var password:String = pass
  private var pass_strength:Strength = zxcvbn.measure(password)

  def Password:String = password
  def Password_= (x:String) {password = x; pass_strength = zxcvbn.measure(password)}

  def getStrength:Double = pass_strength.getCrackTimeSeconds.getOnlineNoThrottling10perSecond

  def getCrackTime:String = pass_strength.getCrackTimesDisplay.getOnlineNoThrottling10perSecond

  def getFeedback:String = pass_strength.getFeedback.getWarning + ": " + pass_strength.getFeedback.getSuggestions()
}

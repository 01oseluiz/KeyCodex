package Methods

/*
 * Singleton para abrigar operações realizáveis em números binários.
 */

object BinaryOps {

  /*
   * O método CountOnes só funciona para inteiros positivos. Isso se deve ao fato de que os pesos
   * utilizados no programa serão sempre positivos e ao fato de que existem diversas representações
   * binárias possíveis para números negativos.
   */

  def CountOnes(number : Int) : Int = {

    // O número deve ser positivo, conforme explicado anteriormente.

    assert(number >= 0)

    if(number == 0)
      0

    else if(number % 2 == 1)
      1 + CountOnes(number/2)

    else
      CountOnes(number/2)

  }

}

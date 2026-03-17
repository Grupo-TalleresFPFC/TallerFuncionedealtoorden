package ConjuntosDifusos {

  type ConjDifuso = Int => Double

  def pertenece(elem: Int, s: ConjDifuso): Double = {
    s(elem)
  }

  // 1.1.1 grande
  
  def grande(d: Int, e: Int): ConjDifuso = {
    (n: Int) => {
      val base = ((n * 1.0)/(n + d))
      //Funcion recursiva interna
      def exponente(b: Double, exp: Int): Double = {
        if (exp == 0) 1.0
        else b*exponente(b, exp-1)
      }
      exponente(base,e)
    }
  } 
 
  // 1.1.2 complemento

  def complemento(cd: ConjDifuso): ConjDifuso = {
  (n: Int) => 1.0 - cd(n)
}

  // 1.1.2 union
  def union(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
    def fu(x: Int): Double = math.max(cd1(x), cd2(x))
    fu
  }

  // 1.1.2 interseccion
  def interseccion(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
    def fi(x: Int): Double = math.min(cd1(x), cd2(x))
    fi
  }

  // 1.1.3 inclusion

    def inclusion(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
    def compara(n: Int): Boolean = {
      if(n > 1000) true
      else if (pertenece(n,cd1) > pertenece(n,cd2)) false
      else compara(n+1)
    }
    compara(0)
  }   

  // 1.1.3 igualdad

   def igualdad(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
    inclusion(cd1,cd2) && inclusion(cd2, cd1)
  }


}
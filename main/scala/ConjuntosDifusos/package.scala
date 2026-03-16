package ConjuntosDifusos {

  type ConjDifuso = Int => Double

  def pertenece(elem: Int, s: ConjDifuso): Double = {
    s(elem)
  }

  // 1.1.1 grande
 
  // 1.1.2 complemento

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
 

  // 1.1.3 igualdad


}
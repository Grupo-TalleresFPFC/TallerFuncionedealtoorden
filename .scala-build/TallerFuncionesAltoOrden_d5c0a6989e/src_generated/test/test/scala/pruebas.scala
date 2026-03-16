package test.scala


final class pruebas$_ {
def args = pruebas_sc.args$
def scriptPath = """test/scala/pruebas.sc"""
/*<script>*/
import ConjuntosDifusos.*

val A: ConjDifuso = x => if (x == 1) 0.2 else if (x == 2) 0.7 else 0.0
val B: ConjDifuso = x => if (x == 1) 0.5 else if (x == 2) 0.4 else 0.0

// Prueba de union
val U = union(A, B)

println(U(1))  // debería dar 0.5
println(U(2))  // debería dar 0.7

// Prueba de interseccion
val I = interseccion(A, B)

println(I(1))  // debería dar 0.2
println(I(2))  // debería dar 0.4
/*</script>*/ /*<generated>*//*</generated>*/
}

object pruebas_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new pruebas$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export pruebas_sc.script as `pruebas`


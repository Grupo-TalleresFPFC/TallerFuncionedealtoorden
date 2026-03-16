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
import ConjuntosDifusos.*

val A: ConjDifuso = x => if (x == 1) 0.2 else if (x == 2) 0.7 else 0.0
val B: ConjDifuso = x => if (x == 1) 0.5 else if (x == 2) 0.4 else 0.0
val C: ConjDifuso = x => if (x == 1) 1.0 else if (x == 2) 0.3 else 0.0
val vacio: ConjDifuso = x => 0.0

// Prueba de union   
//================

//caso 1: valores diferentes

val U1 = union(A, B)
assert(U1(1) == 0.5)

//caso 2:otro valor
assert(U1(2) == 0.7)

//caso 3: union con el conjunto vacio
val U2 = union(A, vacio)
assert(U2(1) == 0.2)

//caso 4: union con valores altos
val U3 = union(A, C)
assert(U3(1) == 1.0)

//caso 5: union de conjunto mismo
val U4 = union(A, A)
assert(U4(2) == 0.7)

// Prueba de interseccion
//=======================

//caso 1: valores diferentes
val I1 = interseccion(A, B)
assert(I1(1) == 0.2)

//caso 2:otro valor
assert(I1(2) == 0.4)

//caso 3: interseccion con el conjunto vacio
val I2 = interseccion(A, vacio)
assert(I2(1) == 0.0)

//caso 4: interseccion con valores altos
val I3 = interseccion(A, C)
assert(I3(1) == 0.2)

//caso 5: interseccion de conjunto mismo
val I4 = interseccion(A, A)
assert(I4(2) == 0.7)
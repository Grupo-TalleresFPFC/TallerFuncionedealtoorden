import ConjuntosDifusos.*

val A: ConjDifuso = x => if (x == 1) 0.2 else if (x == 2) 0.7 else 0.0
val B: ConjDifuso = x => if (x == 1) 0.5 else if (x == 2) 0.4 else 0.0
val C: ConjDifuso = x => if (x == 1) 1.0 else if (x == 2) 0.3 else 0.0
val vacio: ConjDifuso = x => 0.0

// Prueba de grande
//================
val g1 = grande(100, 1)
val g2 = grande(100, 5)
val medio = grande(50, 2)
val apr = grande(1, 2)
val cero = grande(1, 100)

//Caso 1: El exponente al ser pequeño, se aproxima mas a 1
g1(100)
//Caso 2: El exponente al incrementar, no se aproxima tanto a 1
g2(100)
//Caso 3: Si n es muy grande se aproxima mucho a 1, pero no lo toca
apr(1000000)
//Caso 4: Si n = d, la base de la potencia siempre sera 0,5 (d/2d)^e
medio(50)
//Caso 5: Si n = 0, entonces la aprox debe ser 0,0
cero(0)

// Prueba de complemento
//======================

val compA = complemento(A)

// caso 1: complemento de valor bajo
assert(compA(1) == 0.8)

// caso 2: complemento de valor alto
assert(compA(2) == 0.3)

// caso 3: complemento de elemento fuera del conjunto
assert(compA(3) == 1.0)

// caso 4: complemento del conjunto vacio
val compVacio = complemento(vacio)
assert(compVacio(1) == 1.0)

// caso 5: complemento del conjunto total
val total: ConjDifuso = x => 1.0
val compTotal = complemento(total)
assert(compTotal(1) == 0.0)

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

// Prueba de inclusion
//================


//Caso 1: true, ya que el exponente de g2 = 5, y de g1 = 1, por lo que g1 sera mas grande
inclusion(g2, g1)

//Caso 2: false, inverso no se cumple
inclusion(g1, g2)

//Caso 3: true, todo conjunto difuso debe estar incluido en si mismo
inclusion(medio, medio)

//Caso 4: true, el conjunto vacio esta incluido en cualquier otro conjunto
inclusion(vacio, g1)

//Caso 5: false, en apr el d = 1, en medio el d = 50, no hay inclusion
igualdad(apr, medio)

// Prueba de igualdad
//===================

val in1 = grande(150, 3)
val in2 = grande(25, 2)
//Caso 1: true, Cualquier conjuntos es igual a el mismo
igualdad(g1, g1)

//Caso 2: false, Misma potencia, pero diferentes valores
igualdad(g1, medio)

//Caso 3: true, Propiedad de la interseccion
igualdad(interseccion(in1, in2), in1)

//Caso 4: false, la union es diferente de interseccion
igualdad(union(in1, in2), interseccion(in1, in2))

//Caso 5:  true, conmutatividad de la union
igualdad(union(in1, in2), union(in2, in1))
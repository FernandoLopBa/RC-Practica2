(ns sockets.pruebas)

'Data 'types
'Number
1 2 3 4 5 ,,,

'Char
\a \b \c ,,,

'Stings
"a" "b" "c" "hola"

'keywords
:a :b :c :hola :mi.namespace/hola :tu.namespace/hola

'Semejante 'a 'null
nil

'Bool
true false

'Funciones
+ - / *  mod
'Colecciones
'Vectores
[] [1 "aasd" :asd] [1 2 ["asd" "Asd"]]

'Conjuntos
#{} #{\a :b} #{"A" #{"X"}}

'Listas
'() '(1 2 3) '(defn hola [] (print "hola"))

'Hash-maps
{1 "uno"
 2 "dos"
 3 "tres"}

{:val    20
 :fn     (fn [],,,)
 :params {:a 1, :b 2}}


'Control 'de 'flujo
'Lazy
for map pmap reduce

'Not 'lazy '( Eager)
mapv doseq while

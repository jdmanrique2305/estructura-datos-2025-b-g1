# Objetivo del taller
Comprender los tipos de datos en Java y su aplicacion.

## Ejercicio1_ISBN13
    Este ejercicio tarta de verificar si un numero es un ISBN-13 valido.
    *Revisar que la cadena tenga exactamente 13 caracteres y todos sean digitos.
    *Aplicar la formula de validacion del ISBN-13
    -Multiplicar cada digito por 1 si esta en posicion par, o por 3 si esa en posicion impar.
    -sumar todos los valores.
    *comprueba si la suma es multipo de 10.
    -si lo es > el ISBN en valido (true)
## Ejercicio2_RLE
    Este ejercicio implemeta una compresion de texto usadon RLE (Run-Length Encoding)
    *Entrada: una cadena ("aaabbccd")
    *Metodo compress:
    -Recorre el texto contando cuantas veces seguidas se repite cada caracter.
    -Construye una nueva cadena con el formato letra + cantidad.
    -Ejemplo: "aaabbccd" > "a3b2c2d1"
    *en main:
    -Muesta el original, el comprimido y el radio de compresion (logitud comprimido / ñongitud original)
## Ejercicio3_Temperaturas
    Este ejercicio procesa un conjunto de temperaturas y calcula estadistcas basicas.
    *Convetir los datos de texto en numero.
    -La cadena "23.5,25.0,22.8,21.4,24.1,26.3,20.0" se separa por comas y se guarda en un arreglo de double.
    *Recorre el arreglo para obtener.
    -Suma total 
    -El valora maximo 
    -El valor minimo
    *Calcula el promedio.
    -promedio = suma / cantidadDeDatos 
    *Calcula la varianza y la desviacion estandar.
    -Varianza= proemdio de la diferencia an cuadrado respecto al promedio.
    -Desviacion estandar= raiz cuadrada de la variaza.
    *Imprime resultados
    -Temparatura originales.
    -Minimo,maximo,promedio.
    -Desviacion estandar.
## Ejercicio4_ConversorBases
    Este ejercicio es un conversor de base numerica.
    *Recibe un numero y su base de origen (binario,decimal,hexadecima)
    *Verifica si el numero es válido en esa base (esValido)
    *Convierte el numero a otras bases (decimal, binario, hexadecimal)
    -Si el numero cabe en un long, usa Long.parseLong.
    -Si es demasiado grande, usa BigInteger para evitar desbordamiento.
    *Imprime las conversiones y muestra si usó BigInteger o no.
## Ejercicio5_tiempos
    Este programa trabaja con tiempos en formato HH:MM:SS y calcula estadísticas.
    *Convierte tiempos a segundos (aSegundos) y de segundos a formato HH:MM:SS (aHHMMSS).
    *Lee un arreglo de tiempos: {"00:05:33", "00:12:17", "00:03:50"}.
    *Convierte cada tiempo a segundos y calcula:
    -Tiempo total (suma de todos).
    -Promedio de duración.
    -Tramo más largo (máximo y su índice).
    *Muestra el porcentaje que representa cada tramo respecto al total.

    


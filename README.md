# Códigos de Hamming
>Implementado en Java

### SOBRE LA IMPLEMENTACIÓN
* Alfabeto fuente: Binario
* Algoritmo de codificación: Hamming (3, 2)

### CODIFICACIÓN
La codificación se lanza ejecutando el fichero java e introduciendo bit a bit una palabra binaria inicial. El programa solo acepta números enteros binarios.

A partir de esta palabra binaria, el programa genera el vector código correspondiente multiplicando la palabra por la matriz generadora.

### INTRODUCIR ERROR
Para introducir un error en el vector código, se pide una posición del vector código a cambiar y se muestra el vector código con el bit cambiado en la posición elegida.

### DESCODIFICACIÓN (REPARACIÓN DEL ERROR + RECUPERACIÓN DEL MENSAJE FUENTE ORIGINAL)
Para detectar el error introducido, el programa calcula el síndrome correspondiente multiplicando el vector código por su matriz de paridad traspuesta. La posición del error se obtiene al convertir el síndrome calculado (binario) a decimal.

Para corregir el error introducido, el programa cambia el valor del vector código correspondiente a la posición del error y muestra el vector código corregido.

<img src="https://github.com/marioperezmon/Descodificador-Hamming/blob/master/img/hamming.png" alt="hamming" height="400"/>
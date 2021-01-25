Proyecto Final -- Análisis de Algoritmos
-------------------------
Integrantes:
-Hayleen Carrillo
-Manuel Loor
-Milen Ortega
-Joffre Ramírez
-------------------------
Consideraciones para ejecutarlo:
Se creo un archivo de prueba llamado test.txt para poder ejecutar el programa con un ejemplo real, es un inicio se pregunta si desea poner la ruta de otro archivo o caso contrario utiliza test.txt por defecto.
El programa está escrito en java y fue creado en Netbeans.

Funcionamiento del proyecto:
-Se generó un archivo .txt con datos de cada cartón (de los 3 colores) con el siguiente formato:
	ColorID, num1, num2, ... numx (la cantidad de números depende del color de la tabla).
-Para almacenar los números de cada cartón, se utilizó un árbol AVL (mejorar tiempo de búsqueda).
-Luego, se crearon 3 HashMap (para cada color), en donde la clave sería el ID de cada cartón, y el valor, el árbol AVL del cartón correspondiente.
-Para cada ronda el usuario debe ingresar números por consola y, este será buscado en cada elemento (valor) del correspondiente mapa (según el color),
 y, en caso de encontrarlo será eliminado del árbol AVL. 
-Para verficar que exista un ganador por ronda, se elige al primer árbol AVL (de acuerdo al color de la ronda) que no tenga elementos.

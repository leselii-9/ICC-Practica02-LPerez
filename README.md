# ICC-Practica02-LPerez

Materia: Introducción a Ciencias de la Computación
Profesor: Salvador López Mendoza
Ayudante: Yanahí Demerio Torres
Ayudante de laboratorio: Rosa Victoria Villa Padilla
Alumna: Lesly Elizabeth Pérez Facio

## Descripción general

En una institución bancaria se requiere hacer cierto manejo de fechas para
determinar, por ejemplo, la fecha final de una inversión de dinero. El
propósito de esta práctica es escribir una clase para crear y manejar fechas
(Fecha) y un programa que la utilice para simular una inversión
(TiempoDeInversion).

El objetivo de la práctica es ejercitar:

- El uso y la aplicación de las instrucciones condicionales dentro de un
  programa (if, else if, else, y el ciclo do-while para repetir la
  simulación).
- La creación y el uso de objetos de clases existentes: en este caso, la
  clase Fecha que se crea en la práctica se usa desde TiempoDeInversion
  para crear objetos y llamar a sus métodos, junto con la clase Scanner de
  Java para leer los datos del usuario.

Para el cálculo del rendimiento se usan los días transcurridos entre las
dos fechas que da el usuario (no un cálculo anual):


rendimiento = monto * 0.12 * días / 365


## Estructura

```
LPerez/
└── practica02/
    └── src/
        └── icc/
            ├── Fecha.java
            └── TiempoDeInversion.java
```

## Contenido de los archivos

### Fecha.java

Clase que representa una fecha (día, mes y año). La fecha predeterminada es
01/enero/2026. Para febrero se usa 29 días si el año es bisiesto y 28 si no.
Incluye los siguientes métodos:

- Constructores: uno sin parámetros (fecha predeterminada), uno con tres
  enteros (día, mes, año) y uno con dos enteros y una cadena (día, año y
  nombre del mes).
- **Asignar campos: asignarFecha, asignarDia, asignarMes y
  asignarAnio. Solo asignan si la fecha es válida.
- Obtener campos: obtenerDia, obtenerMes y obtenerAnio.
- Diferencia en días entre dos fechas: obtenerDiferenciaDias.
- Fecha con una cantidad de días: obtenerFechaConDias suma (o resta, si
  el número es negativo) días a una fecha. 
- Comparar fechas: equals determina si dos fechas son iguales.
- Mes a número y número a mes: obtenerNumeroMes y obtenerNombreMes.
- Días transcurridos en el año: diasTranscurridosEnAnio. 
- Representación en texto: toString devuelve la fecha en el formato
  dd/mes/aaaa.

### TiempoDeInversion.java

Clase con el método main, que es el programa que usa el inversionista. Lee
los datos con Scanner y sigue estos pasos:

1. Da la bienvenida y solicita el nombre del inversionista, y lo recaba.
2. Saluda al inversionista por su nombre y pregunta por el monto a invertir, y
   lo recaba (número con decimales).
3. Pregunta por la **fecha de inicio** de la inversión y la recaba: el día
   (número), el mes (nombre) y el año. Con esos datos crea un objeto Fecha.
4. Pregunta por la fecha de fin de la inversión y la recaba de la misma
   forma, creando otro objeto Fecha.
5. Calcula con obtenerDiferenciaDias cuántos días dura la inversión, y
   muestra al usuario esos días junto con su rendimiento al 12 %.
6. Pregunta si desea hacer otra simulación. Si responde si, vuelve al paso 2
   (saluda y pregunta el monto) sin pedir de nuevo el nombre; en otro caso, se
   despide y termina. Esta repetición se hace con un ciclo do-while.

## Cómo compilar y ejecutar

Desde la carpeta `LPerez/practica02`:

```
javac src/icc/*.java
java -cp src icc.TiempoDeInversion
```

## Cómo usarlo

1. Escribe tu nombre.
2. Escribe el monto a invertir (solo el número, por ejemplo `10000`).
3. Escribe la fecha de inicio: día (número), mes (nombre, por ejemplo `enero`)
   y año (por ejemplo `2026`), cada dato en una línea.
4. Escribe la fecha de fin con el mismo formato.
5. Responde `si` para hacer otra simulación, o cualquier otra cosa para salir.

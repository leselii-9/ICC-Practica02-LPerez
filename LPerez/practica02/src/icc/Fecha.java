package icc;

/**
 * Clase que representa una fecha (día, mes y año) y permite manipularla
 * para calcular, por ejemplo, la fecha final de una inversión de dinero.
 *
 * @author Lesly Elizabeth Pérez Facio
 * @version 1.0
 */
public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    // Inciso (a): constructores

    /**
     * Constructor sin parámetros. Crea la fecha predeterminada: 01/enero/2026.
     */
    public Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.anio = 2026;
    }

    /**
     * Constructor que recibe día, mes (número) y año.
     * Si la fecha no es válida, se queda con la fecha predeterminada.
     */
    public Fecha(int dia, int mes, int anio) {
        this();
        asignarFecha(dia, mes, anio);
    }

    /**
     * Constructor que recibe día, año y el nombre del mes.
     * Si el nombre del mes o la fecha no son válidos, se queda con la
     * fecha predeterminada.
     */
    public Fecha(int dia, int anio, String nombreMes) {
        this();
        asignarFecha(dia, obtenerNumeroMes(nombreMes), anio);
    }

    // Inciso (b): asignar valor a los campos

    /**
     * Asigna una fecha completa. Solo la asigna si es válida; si no lo es,
     * la fecha actual del objeto se queda como estaba.
     * Una fecha es válida si el año es mayor que cero, el mes está entre
     * 1 y 12 y el día existe en ese mes de ese año.
     */
    public void asignarFecha(int dia, int mes, int anio) {
        if (anio > 0 && mes >= 1 && mes <= 12) {
            if (dia >= 1 && dia <= diasDelMes(mes, anio)) {
                this.dia = dia;
                this.mes = mes;
                this.anio = anio;
            }
        }
    }

    /**
     * Asigna el día, conservando el mes y el año actuales.
     * Si el nuevo día no existe en ese mes, no se modifica nada.
     */
    public void asignarDia(int dia) {
        asignarFecha(dia, this.mes, this.anio);
    }

    /**
     * Asigna el mes (en número), conservando el día y el año actuales.
     * Si el día actual no existe en el nuevo mes, no se modifica nada.
     */
    public void asignarMes(int mes) {
        asignarFecha(this.dia, mes, this.anio);
    }

    /**
     * Asigna el año, conservando el día y el mes actuales.
     */
    public void asignarAnio(int anio) {
        asignarFecha(this.dia, this.mes, anio);
    }

    // Inciso (c): obtener los campos

    /**
     * Devuelve el día del mes de la fecha.
     */
    public int obtenerDia() {
        return this.dia;
    }

    /**
     * Devuelve el número del mes de la fecha.
     */
    public int obtenerMes() {
        return this.mes;
    }

    /**
     * Devuelve el año de la fecha.
     */
    public int obtenerAnio() {
        return this.anio;
    }

    // Inciso (d): diferencia en días entre dos fechas

    /**
     * Calcula cuántos días han pasado desde el año 1 hasta esta fecha.
     * Nos ayuda como número de referencia para poder restar dos fechas
     */
    private int diasDesdeOrigen() {
        int anioAnterior = this.anio - 1;
        int diasDeAniosCompletos = anioAnterior * 365
                + anioAnterior / 4
                - anioAnterior / 100
                + anioAnterior / 400;
        return diasDeAniosCompletos + diasTranscurridosEnAnio();
    }

    /**
     * Obtiene la diferencia, en días, entre esta fecha y otra.
     * El resultado es positivo si la otra fecha es posterior a esta,
     * negativo si es anterior y cero si son la misma.
     *
     * @param otra fecha con la que se compara
     * @return diferencia en días (otra - esta)
     */
    public int obtenerDiferenciaDias(Fecha otra) {
        return otra.diasDesdeOrigen() - this.diasDesdeOrigen();
    }


    // Inciso (e): fecha que resulta de sumar o restar días

    /**
     * Obtiene la fecha que resulta de sumarle una cantidad de días a esta
     * fecha. Si la cantidad es negativa, se retrocede en el tiempo.
     */
    public Fecha obtenerFechaConDias(int dias) {
        int anioNuevo = this.anio;
        int total = this.diasTranscurridosEnAnio() + dias;

        // Si nos pasamos del final del año, avanzamos de año.
        if (total > diasDelAnio(anioNuevo)) {
            do {
                total -= diasDelAnio(anioNuevo);
                anioNuevo++;
            } while (total > diasDelAnio(anioNuevo));
        }

        // Si quedamos antes del 1 de enero, retrocedemos de año.
        if (total < 1) {
            do {
                anioNuevo--;
                total += diasDelAnio(anioNuevo);
            } while (total < 1);
        }

        // Convertir el número de día del año en mes y día.
        int mesNuevo = 1;
        if (total > diasDelMes(mesNuevo, anioNuevo)) {
            do {
                total -= diasDelMes(mesNuevo, anioNuevo);
                mesNuevo++;
            } while (total > diasDelMes(mesNuevo, anioNuevo));
        }

        return new Fecha(total, mesNuevo, anioNuevo);
    }

    // Inciso (f): determinar si dos fechas son iguales

    /**
     * Determina si esta fecha es igual a otra, comparando su estado
     */
    public boolean equals(Object otra) {
        Fecha fecha = (Fecha) otra;
        return this.dia == fecha.obtenerDia()
                && this.mes == fecha.obtenerMes()
                && this.anio == fecha.obtenerAnio();
    }

    // Inciso (g): número de un mes a partir de su nombre

    /**
     * Devuelve el número correspondiente a un mes
     */
    public int obtenerNumeroMes(String nombreMes) {
        String nombre = nombreMes.trim().toLowerCase();
        int numero;
        if (nombre.equals("enero")) {
            numero = 1;
        } else if (nombre.equals("febrero")) {
            numero = 2;
        } else if (nombre.equals("marzo")) {
            numero = 3;
        } else if (nombre.equals("abril")) {
            numero = 4;
        } else if (nombre.equals("mayo")) {
            numero = 5;
        } else if (nombre.equals("junio")) {
            numero = 6;
        } else if (nombre.equals("julio")) {
            numero = 7;
        } else if (nombre.equals("agosto")) {
            numero = 8;
        } else if (nombre.equals("septiembre")) {
            numero = 9;
        } else if (nombre.equals("octubre")) {
            numero = 10;
        } else if (nombre.equals("noviembre")) {
            numero = 11;
        } else if (nombre.equals("diciembre")) {
            numero = 12;
        } else {
            numero = 0;
        }
        return numero;
    }

    // Inciso (h): nombre de un mes a partir de su número

    /**
     * Devuelve el nombre de un mes a partir de su número
     */
    public String obtenerNombreMes(int numeroMes) {
        String nombre;
        if (numeroMes == 1) {
            nombre = "enero";
        } else if (numeroMes == 2) {
            nombre = "febrero";
        } else if (numeroMes == 3) {
            nombre = "marzo";
        } else if (numeroMes == 4) {
            nombre = "abril";
        } else if (numeroMes == 5) {
            nombre = "mayo";
        } else if (numeroMes == 6) {
            nombre = "junio";
        } else if (numeroMes == 7) {
            nombre = "julio";
        } else if (numeroMes == 8) {
            nombre = "agosto";
        } else if (numeroMes == 9) {
            nombre = "septiembre";
        } else if (numeroMes == 10) {
            nombre = "octubre";
        } else if (numeroMes == 11) {
            nombre = "noviembre";
        } else if (numeroMes == 12) {
            nombre = "diciembre";
        } else {
            nombre = "invalido";
        }
        return nombre;
    }

    // Inciso (i): días transcurridos en el año

    /**
     * Devuelve los días transcurridos en el año hasta esta fecha
     */
    public int diasTranscurridosEnAnio() {
        int total = this.dia;
        if (this.mes > 1) {
            total += diasDelMes(1, this.anio);
        }
        if (this.mes > 2) {
            total += diasDelMes(2, this.anio);
        }
        if (this.mes > 3) {
            total += diasDelMes(3, this.anio);
        }
        if (this.mes > 4) {
            total += diasDelMes(4, this.anio);
        }
        if (this.mes > 5) {
            total += diasDelMes(5, this.anio);
        }
        if (this.mes > 6) {
            total += diasDelMes(6, this.anio);
        }
        if (this.mes > 7) {
            total += diasDelMes(7, this.anio);
        }
        if (this.mes > 8) {
            total += diasDelMes(8, this.anio);
        }
        if (this.mes > 9) {
            total += diasDelMes(9, this.anio);
        }
        if (this.mes > 10) {
            total += diasDelMes(10, this.anio);
        }
        if (this.mes > 11) {
            total += diasDelMes(11, this.anio);
        }
        return total;
    }

    // Inciso (j): representar la fecha como dd/mes/aaaa

    /**
     * Representa la fecha como cadena en el formato dd/mes/aaaa
     */
    public String toString() {
        String diaTexto = "" + this.dia;
        if (this.dia < 10) {
            diaTexto = "0" + this.dia;
        }

        String anioTexto = "" + this.anio;
        if (this.anio < 10) {
            anioTexto = "000" + this.anio;
        } else if (this.anio < 100) {
            anioTexto = "00" + this.anio;
        } else if (this.anio < 1000) {
            anioTexto = "0" + this.anio;
        }

        return diaTexto + "/" + obtenerNombreMes(this.mes) + "/" + anioTexto;
    }


    /**
     * Indica si un año es bisiesto
     */
    private boolean esBisiesto(int anio) {
        boolean bisiesto;
        if (anio % 400 == 0) {
            bisiesto = true;
        } else if (anio % 100 == 0) {
            bisiesto = false;
        } else if (anio % 4 == 0) {
            bisiesto = true;
        } else {
            bisiesto = false;
        }
        return bisiesto;
    }

    /**
     * Devuelve cuántos días tiene un mes de un año dado
     */
    private int diasDelMes(int mes, int anio) {
        int dias;
        if (mes == 2) {
            if (esBisiesto(anio)) {
                dias = 29;
            } else {
                dias = 28;
            }
        } else if (mes == 4) {
            dias = 30;
        } else if (mes == 6) {
            dias = 30;
        } else if (mes == 9) {
            dias = 30;
        } else if (mes == 11) {
            dias = 30;
        } else {
            dias = 31;
        }
        return dias;
    }

    /**
     * Devuelve cuántos días tiene un año: 366 si es bisiesto, 365 si no.
     */
    private int diasDelAnio(int anio) {
        int dias;
        if (esBisiesto(anio)) {
            dias = 366;
        } else {
            dias = 365;
        }
        return dias;
    }
} 

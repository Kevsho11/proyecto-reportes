package main.java.com.proyectoReporte.builder;

import java.time.LocalDateTime;
/** 
 * Clase que representa un reporte (objeto complejo).
 * Las instancias de esta clase son construidas usando el patrón Builder (ReporteBuilder).
 * [Requerimiento: 2]
 */

public class Reporte {
    //Atributos que son obligatorios
    private final String titulo;
    private final String cuerpoPrincipal;

    //Atributos que son opcionales
    private final String encabezado;
    private final String pieDePagina;
    private final LocalDateTime fecha;
    private final String autor;
    private final Orientacion orientacion;

    //Constructor privado, solo el Builder (ReporteBuilder) puede crear instancias de Reporte
    private Reporte(ReporteBuilder builder) {
        this.titulo = builder.titulo;
        this.cuerpoPrincipal = builder.cuerpoPrincipal;
        this.encabezado = builder.encabezado;
        this.pieDePagina = builder.pieDePagina;
        this.fecha = builder.fecha;
        this.autor = builder.autor;
        this.orientacion = builder.orientacion;
    }

    //Getters para los atributos
    @Override
    public String toString(){
        return "Reporte [\n" +
                "  titulo=" + titulo + ",\n" +
                "  cuerpoPrincipal=" + cuerpoPrincipal + ",\n" +
                "  encabezado=" + encabezado + ",\n" +
                "  pieDePagina=" + pieDePagina + ",\n" +
                "  fecha=" + fecha + ",\n" +
                "  autor=" + autor + ",\n" +
                "  orientacion=" + orientacion + "\n" +
                "]";
    }
}
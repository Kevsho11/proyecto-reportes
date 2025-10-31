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

    // Clase estática interna que implementa el patrón Builder
    public static class ReporteBuilder {
        private final String titulo;
        private final String cuerpoPrincipal;

        private String encabezado;
        private String pieDePagina;
        private java.time.LocalDateTime fecha;
        private String autor;
        private Orientacion orientacion;

        public ReporteBuilder(String titulo, String cuerpoPrincipal) {
            this.titulo = titulo;
            this.cuerpoPrincipal = cuerpoPrincipal;
        }

        //Metodos para agregar atributos opcionales
        public ReporteBuilder agregarEncabezado(String encabezado) {
            this.encabezado = encabezado;
            return this; // Se retorna el mismo builder para permitir encadenamiento
        }

        public ReporteBuilder agregarPieDePagina(String pieDePagina) {
            this.pieDePagina = pieDePagina;
            return this;
        }

        public ReporteBuilder agregarFecha(java.time.LocalDateTime fecha) {
            this.fecha = fecha;
            return this;
        }

        public ReporteBuilder agregarAutor(String autor) {
            this.autor = autor;
            return this;
        }

        //Metodo para construir el objeto Reporte
        public Reporte construir() {
            return new Reporte(this);
        }

    }

}
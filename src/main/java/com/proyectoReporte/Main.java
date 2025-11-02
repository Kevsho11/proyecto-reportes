package com.proyectoReporte;

//Importaciones para el Requerimiento 2
import com.proyectoReporte.builder.Reporte;

import java.time.LocalDateTime;

import com.proyectoReporte.builder.Orientacion;

public class Main {
    public static void main(String[] args){

        //1) Reporte minimo (campos obligatorios)
        Reporte reporteMinimo = new Reporte.ReporteBuilder("Informe ventas 1", "Resumen de ventas")
                .construir();
        System.out.println("=== Reporte Mínimo ===");
        System.out.println(reporteMinimo);
        System.out.println(); //Salto de línea

        //2) Reporte con varios atributos opcionales
        Reporte reporteCompleto = new Reporte.ReporteBuilder("Reporte Financiero Anual", "Cuerpo principal con análisis detallado")
                .agregarEncabezado("Empresa Faramacia S.A.")
                .agregarPieDePagina("Confidencial - No distribuir")
                .agregarFecha(LocalDateTime.of(2025, 10, 31, 14, 0))
                .agregarAutor("Fran Lozano")
                .agregarOrientacion(Orientacion.HORIZONTAL)
                .construir();
        System.out.println("=== Reporte Completo ===");
        System.out.println(reporteCompleto);
        System.out.println();

        //3) Reporte con ALGUNOS atributos opcionales (Acá demostramos flexibilidad))
        Reporte reporteParcial = new Reporte.ReporteBuilder("Reporte de Marketing", "Análisis de campañas publicitarias")
                .agregarAutor("Kevin Luchiano Rodríguez")
                .agregarOrientacion(Orientacion.VERTICAL)
                .construir();
        System.out.println("=== Reporte Parcial ===");
        System.out.println(reporteParcial);
        System.out.println(); 
    }
    
}

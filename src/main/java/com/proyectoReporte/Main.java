package com.proyectoReporte;

import com.proyectoReporte.factory.Renderizador;
import com.proyectoReporte.factory.RenderizadorFactory;
import com.proyectoReporte.builder.Reporte;
import com.proyectoReporte.builder.Orientacion;
import com.proyectoReporte.singleton.GestorConfiguracion;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        
        // Singleton
        GestorConfiguracion config1 = GestorConfiguracion.getInstance();
        System.out.println("URL BD: " + config1.getUrlBd());
        System.out.println("Usuario BD: " + config1.getUserBd());
        System.out.println("Path Reportes: " + config1.getPathReportes());
        
        GestorConfiguracion config2 = GestorConfiguracion.getInstance();
        config2.setPathReportes("/nuevo/path/reportes/");
        System.out.println("Path desde config1: " + config1.getPathReportes());
        System.out.println("Es la misma instancia: " + (config1 == config2));
        System.out.println();

        // Builder
        Reporte reporteMinimo = new Reporte.ReporteBuilder("Informe Ventas Q1", "Resumen de ventas del primer trimestre")
                .construir();
        System.out.println(reporteMinimo);
        System.out.println();

        Reporte reporteCompleto = new Reporte.ReporteBuilder("Reporte Financiero Anual 2024", "Análisis financiero detallado del año completo")
                .agregarEncabezado("Empresa Farmacéutica S.A.")
                .agregarPieDePagina("Confidencial - No distribuir")
                .agregarFecha(LocalDate.of(2024, 12, 31))
                .agregarAutor("Fran Lozano")
                .agregarOrientacion(Orientacion.HORIZONTAL)
                .construir();
        System.out.println(reporteCompleto);
        System.out.println();

        Reporte reporteParcial = new Reporte.ReporteBuilder("Reporte de Marketing Digital", "Análisis de campañas publicitarias online")
                .agregarAutor("Kevin Luchiano Rodríguez")
                .agregarOrientacion(Orientacion.VERTICAL)
                .agregarFecha(LocalDate.now())
                .construir();
        System.out.println(reporteParcial);
        System.out.println();

        // Factory
        Renderizador renderizadorPDF = RenderizadorFactory.crearRenderizador("PDF");
        renderizadorPDF.renderizar(reporteCompleto);
        System.out.println();

        Renderizador renderizadorExcel = RenderizadorFactory.crearRenderizador("EXCEL");
        renderizadorExcel.renderizar(reporteParcial);
        System.out.println();

        Renderizador renderizadorCSV = RenderizadorFactory.crearRenderizador("CSV");
        renderizadorCSV.renderizar(reporteMinimo);
        System.out.println();

        // Integración
        GestorConfiguracion config = GestorConfiguracion.getInstance();
        System.out.println("Path reportes: " + config.getPathReportes());
        
        Reporte reporteIntegrado = new Reporte.ReporteBuilder("Reporte Integrado", "Demostración de integración de patrones")
                .agregarAutor("Sistema de Reportes")
                .agregarFecha(LocalDate.now())
                .agregarOrientacion(Orientacion.VERTICAL)
                .construir();
        
        Renderizador renderizador = RenderizadorFactory.crearRenderizador("PDF");
        renderizador.renderizar(reporteIntegrado);
    }
}

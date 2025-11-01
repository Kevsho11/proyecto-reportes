package com.proyectoReporte.factory;

import com.proyectoReporte.builder.Reporte;

public class RenderizadorExcel implements Renderizador {

    @Override
    public void renderizar(Reporte reporte) {
        // Lógica de renderizado específica para Excel
        System.out.println("--- RENDERIZANDO REPORTE A EXCEL ---");
        System.out.println("Creando hoja de cálculo...");
        System.out.println("Insertando datos en celdas para: " + reporte.getTitulo());
        System.out.println("...lógica compleja de Excel con fórmulas y hojas múltiples...");
        System.out.println("--- REPORTE EXCEL GENERADO ---");
    }
}

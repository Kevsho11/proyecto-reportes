package com.proyectoReporte.factory;

import com.proyectoReporte.builder.Reporte;

public class RenderizadorPDF implements Renderizador {

    @Override
    public void renderizar(Reporte reporte) {
        // Lógica de renderizado específica para PDF
        System.out.println("--- RENDERIZANDO REPORTE A PDF ---");
        System.out.println("Título: " + reporte.getTitulo());
        System.out.println("...lógica compleja de PDF con fuentes, márgenes y gráficos...");
        System.out.println("--- REPORTE PDF GENERADO ---");
    }
}

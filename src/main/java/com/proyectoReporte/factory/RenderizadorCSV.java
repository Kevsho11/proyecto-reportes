package com.proyectoReporte.factory;

import com.proyectoReporte.builder.Reporte;

public class RenderizadorCSV implements Renderizador {

    @Override
    public void renderizar(Reporte reporte) {
        // Lógica de renderizado específica para CSV
        System.out.println("--- RENDERIZANDO REPORTE A CSV ---");
        System.out.println("Formateando datos delimitados por comas...");
        // Asumimos que el Reporte tiene un getter para el cuerpo
        System.out.println(reporte.getTitulo() + "," + reporte.getCuerpoPrincipal()); 
        System.out.println("--- REPORTE CSV GENERADO ---");
    }
}

# Diagrama de Clases UML - Proyecto Reportes

Este documento contiene el diagrama de clases UML del proyecto de reportes que implementa tres patrones creacionales: Factory, Builder y Singleton.

```mermaid
classDiagram
    %% ========================================
    %% FACTORY PATTERN
    %% ========================================
    class Renderizador {
        <<interface>>
        +void renderizar(Reporte reporte)
    }
    
    class RenderizadorFactory {
        +static Renderizador crearRenderizador(String tipo)
    }
    
    class RenderizadorPDF {
        +void renderizar(Reporte reporte)
    }
    
    class RenderizadorExcel {
        +void renderizar(Reporte reporte)
    }
    
    class RenderizadorCSV {
        +void renderizar(Reporte reporte)
    }
    
    Renderizador <|.. RenderizadorPDF : implements
    Renderizador <|.. RenderizadorExcel : implements
    Renderizador <|.. RenderizadorCSV : implements
    RenderizadorFactory ..> Renderizador : creates
    
    %% ========================================
    %% BUILDER PATTERN
    %% ========================================
    class Reporte {
        -String titulo
        -String cuerpoPrincipal
        -String encabezado
        -String pieDePagina
        -LocalDate fecha
        -String autor
        -Orientacion orientacion
        -Reporte(ReporteBuilder builder)
        +String getTitulo()
        +String getCuerpoPrincipal()
        +String getEncabezado()
        +String getPieDePagina()
        +LocalDate getFecha()
        +String getAutor()
        +Orientacion getOrientacion()
        +String toString()
    }
    
    class ReporteBuilder {
        -String titulo
        -String cuerpoPrincipal
        -String encabezado
        -String pieDePagina
        -LocalDate fecha
        -String autor
        -Orientacion orientacion
        +ReporteBuilder(String titulo, String cuerpoPrincipal)
        +ReporteBuilder agregarEncabezado(String encabezado)
        +ReporteBuilder agregarPieDePagina(String pieDePagina)
        +ReporteBuilder agregarFecha(LocalDate fecha)
        +ReporteBuilder agregarAutor(String autor)
        +ReporteBuilder agregarOrientacion(Orientacion orientacion)
        +Reporte construir()
    }
    
    class Orientacion {
        <<enumeration>>
        VERTICAL
        HORIZONTAL
    }
    
    Reporte *-- ReporteBuilder : builds
    Reporte --> Orientacion : uses
    
    %% ========================================
    %% SINGLETON PATTERN
    %% ========================================
    class GestorConfiguracion {
        -static final GestorConfiguracion instancia
        -String urlBd
        -String userBd
        -String pathReportes
        -GestorConfiguracion()
        +static GestorConfiguracion getInstance()
        +String getUrlBd()
        +String getUserBd()
        +String getPathReportes()
        +void setPathReportes(String pathReportes)
    }
    
    %% ========================================
    %% MAIN CLASS
    %% ========================================
    class Main {
        +static void main(String[] args)
    }
    
    %% ========================================
    %% RELACIONES ENTRE PATRONES
    %% ========================================
    Renderizador ..> Reporte : uses
    RenderizadorPDF ..> Reporte : uses
    RenderizadorExcel ..> Reporte : uses
    RenderizadorCSV ..> Reporte : uses
    Main ..> ReporteBuilder : uses
    Main ..> Orientacion : uses
    Main ..> GestorConfiguracion : uses
```

## Descripción de Patrones

### 1. Factory Pattern
- **Interface**: `Renderizador`
- **Factory**: `RenderizadorFactory` - Crea instancias de diferentes tipos de renderizadores
- **Implementaciones**: `RenderizadorPDF`, `RenderizadorExcel`, `RenderizadorCSV`
- **Propósito**: Centralizar la creación de objetos renderizadores según un tipo especificado

### 2. Builder Pattern
- **Product**: `Reporte` - Objeto complejo que necesita construcción paso a paso
- **Builder**: `ReporteBuilder` - Clase estática interna que construye objetos `Reporte`
- **Enum**: `Orientacion` - Define la orientación del reporte
- **Propósito**: Construir objetos `Reporte` de manera flexible con atributos obligatorios y opcionales

### 3. Singleton Pattern
- **Singleton**: `GestorConfiguracion`
- **Características**:
  - Instancia única privada y estática
  - Constructor privado
  - Método estático `getInstance()` para obtener la instancia
- **Propósito**: Garantizar una única instancia global de configuración en toda la aplicación


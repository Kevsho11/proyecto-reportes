# proyecto-reportes
Trabajo Práctico de Patrones Creacionales - POO II".

### 1. Documento de Justificación

A continuación, se detallan las decisiones de diseño tomadas para cada requerimiento.

#### Requerimiento 1: El Motor de Renderizado

* **¿Qué patrón de diseño creacional eligieron?**
    Se eligió el **Patrón Factory** (en su forma de *Simple Factory*).

* **¿Por qué este patrón es la solución adecuada para este problema?**
    Este patrón es la solución ideal porque encapsula la lógica de creación de los diferentes motores de renderizado. El código cliente (ej. el módulo de Finanzas) no necesita conocer los nombres de las clases concretas (`RenderizadorPDF`, `RenderizadorExcel`, etc.)[cite: 19]. Simplemente le pide a la `RenderizadorFactory` que le entregue el objeto adecuado pasándole un tipo, como "PDF"[cite: 20]. Esto centraliza la lógica de instanciación en un solo lugar.

* **¿Qué problema(s) evita (ej. acoplamiento, violación del principio Abierto/Cerrado)?**
    1.  **Evita el Alto Acoplamiento:** El cliente solo conoce la interfaz `Renderizador` y la clase `RenderizadorFactory`. No está acoplado a ninguna implementación concreta, lo que facilita el mantenimiento.
    2.  **Cumple el Principio Abierto/Cerrado:** El sistema está *cerrado a la modificación* (el código cliente no se toca) pero *abierto a la extensión*. [cite_start]Como pide el requerimiento[cite: 21], si en el futuro queremos agregar un `RenderizadorXML`, solo creamos la nueva clase y añadimos un `case` en la Factory. El código cliente existente seguirá funcionando sin ningún cambio.

## Requerimiento 2 - Construcción de Reportes

## Patrón de diseño elegido: Builder

## Justificación de la elección:

El patrón Builder es ideal para construir objetos complejos paso a paso. Permite separar el proceso de construcción del objeto (Builder) de su representación final (Reporte). Esto permite especificar solo los atributos que necesitamos (especialmente los opcionales ), mientras forzamos la inclusión de los atributos obligatorios  a través del constructor del Builder. Esto ayuda a tener un código much más limpio y legible.

## Problemas específicos que resuelve

- Evita el "Constructor Telescopico": No se necesita crear múltiples constructores, solo un Builder que se configura fluidamente.
- Evita que el constructor tenga múltiples parámetros y nulls, es decir, el cliente no tiene que llamar a un constructor como por ejemplo " new Reporte("Mi Título", "Cuerpo...", null, "Mi mano", null, null, null) " . En lugar de eso solo llama a los métodos "setter" de los atributos opcionales que realmente desea configurar.

### Requerimiento 3: El Gestor de Configuración Global
* **¿Qué patrón de diseño creacional eligieron?**
    Se eligió el patrón **Singleton**.

* **¿Por qué este patrón es la solución adecuada para este requerimiento?**
    Este patrón es la solución idónea porque el requerimiento exige explícitamente las dos características principales del Singleton:
    1.  **Instancia Única:** El sistema debe garantizar que "solo exista una y solo una instancia del objeto `GestorConfiguracion`"
    2.  **Punto de Acceso Global:** Se necesita un "único punto de acceso a esta configuración" para todos los módulos de la aplicación (Finanzas, Marketing, RRHH)

    El patrón Singleton resuelve esto directamente, previniendo la ineficiencia y las "inconsistencias en los datos" que ocurrirían si múltiples objetos de configuración (con valores potencialmente diferentes) pudieran coexistir.

* **¿Cómo garantizaron la unicidad de la instancia?**
    La unicidad de la instancia se garantizó implementando los tres pilares fundamentales del patrón Singleton:
    1.  **Constructor Privado:** Se declaró el constructor de la clase como `private GestorConfiguracion()`. Esto impide que cualquier otra clase pueda instanciar el objeto usando la palabra clave `new`.
    2.  **Instancia Estática Privada:** Se creó una única instancia, `private static final`, de la misma clase dentro de ella misma. Esta instancia se inicializa una sola vez cuando la clase es cargada.
    3.  **Método Estático Público:** Se proporciona un método `public static GestorConfiguracion getInstance()` que actúa como el único punto de acceso global y que devuelve siempre la única instancia ya creada.

<img width="2777" height="1556" alt="mermaid-diagram-2025-11-02-093155" src="https://github.com/user-attachments/assets/09b75ef4-342c-4023-b27c-c529cd2be0b6" />

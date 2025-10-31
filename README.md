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

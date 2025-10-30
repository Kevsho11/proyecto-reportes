# proyecto-reportes
Trabajo Práctico de Patrones Creacionales - POO II".


## Requerimiento 2 - Construcción de Reportes

## Patrón de diseño elegido: Builder

## Justificación de la elección:

El patrón Builder es ideal para construir objetos complejos paso a paso. Permite separar el proceso de construcción del objeto (Builder) de su representación final (Reporte). Esto permite especificar solo los atributos que necesitamos (especialmente los opcionales ), mientras forzamos la inclusión de los atributos obligatorios  a través del constructor del Builder. Esto ayuda a tener un código much más limpio y legible.

## Problemas específicos que resuelve

- Evita el "Constructor Telescopico": No se necesita crear múltiples constructores, solo un Builder que se configura fluidamente.
- Evita que el constructor tenga múltiples parámetros y nulls, es decir, el cliente no tiene que llamar a un constructor como por ejemplo " new Reporte("Mi Título", "Cuerpo...", null, "Mi mano", null, null, null) " . En lugar de eso solo llama a los métodos "setter" de los atributos opcionales que realmente desea configurar.
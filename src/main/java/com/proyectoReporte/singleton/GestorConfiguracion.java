package main.java.com.proyectoReporte.singleton;

/**
 * Implementación del Patrón Singleton para el Gestor de Configuración.
 * [Requerimiento 3]
 * Esta clase garantiza una única instancia de configuración global
 * para toda la aplicación.
 */

public class GestorConfiguracion {

    // 1. La instancia única, privada y estática.
    // Se inicializa "tempranamente" cuando la clase es cargada por la JVM.
    // es simple y garantiza la seguridad en entornos multi-hilo.
    private static final GestorConfiguracion instancia = new GestorConfiguracion();

    // 2. Los atributos de configuración
    private String urlBd;
    private String userBd;
    private String pathReportes;

    // 3. El constructor PRIVADO.
    // Evita que cualquier otra clase pueda crear
    // una instancia usando 'new GestorConfiguracion()'.
    private GestorConfiguracion() {
        // Simulación de carga de configuración.
        try {
            //se simula un pequeño retardo, como si leyera un archivo
            Thread.sleep(500); 
            this.urlBd = "jdbc:mysql://localhost:3306/produccion";
            this.userBd = "admin_prod";
            this.pathReportes = "/var/app/reportes/global/";
            
            System.out.println("...[GestorConfiguracion] Instancia única creada.");
            System.out.println("...[GestorConfiguracion] Configuración cargada desde 'archivo'.");

        } catch (InterruptedException e) {
            e.printStackTrace();
            // Manejar error de carga
        }
    }

    // 4. El método de acceso global, público y estático.
    // Este es el único punto de acceso [cite: 40] a la instancia.
    public static GestorConfiguracion getInstance() {
        return instancia;
    }

    //Getters para que el resto de la aplicación lea los valores
    
    public String getUrlBd() {
        return urlBd;
    }

    public String getUserBd() {
        return userBd;
    }

    public String getPathReportes() {
        return pathReportes;
    }

    // (Opcional) Un setter para demostrar en el Main que la instancia es la misma
    public void setPathReportes(String pathReportes) {
        this.pathReportes = pathReportes;
    }
}
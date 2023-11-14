import com.example.controladorprocesos.model.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class NotificacionTest {

    @Test
    public void deberiaEnviarCorreoElectronicoCorrectamente() {
        // Configuración de prueba
        String destinatario = "bryangomez1625@gmail.com";
        String asunto = "Asunto del correo";
        String mensaje = "Cuerpo del correo";

        // Configuración de correo (puedes utilizar una cuenta de prueba para evitar enviar correos reales)
        ConfiguracionCorreo configuracionCorreo = new ConfiguracionCorreo("pruebasgestorprocesos@gmail.com", "funl zkvm ibhx bvfd");

        // Crear una instancia de Notificacion
        Notificacion notificacion = new Notificacion();

        // Intentar enviar el correo electrónico
        try {
            notificacion.enviarCorreoElectronico(destinatario, asunto, mensaje, configuracionCorreo);

            // Si no se lanzó una excepción, la prueba es exitosa
            assertTrue(true);
        } catch (Exception e) {
            // Si se lanza una excepción, la prueba falla
            fail("No debería lanzar una excepción: " + e.getMessage());
        }
    }
}


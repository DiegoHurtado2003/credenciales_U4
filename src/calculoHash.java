import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class calculoHash {
    /**
     * Obtiene el resumen de un mensaje proporcionado
     *
     * @param mensaje Mensaje del cual se quiere calcular el resumen
     * @return Resumen del mensaje
     */
    public static String getDigest(String mensaje) {
        byte[] mensajeBytes;
        byte[] resumen = null;
        String resumenHexadecimal = null;
        try {
            // Convierto el mensaje introducido por el usuario en un array de bytes
            mensajeBytes = mensaje.getBytes("UTF-8");
            // Creo una instancia de MessageDigest con el algoritmo SHA-256
            MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
            // Reiniciamos el objeto por si contiene datos
            algoritmo.reset();
            // Añado el mensaje del cual quiero calcular su hash
            algoritmo.update(mensajeBytes);
            // Generamos el resumen
            resumen = algoritmo.digest();
            resumenHexadecimal = String.format("%064x", new BigInteger(1, mensajeBytes));
        } catch (NoSuchAlgorithmException e) {
            System.err.println("El algoritmo seleccionado no existe");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.err.println("No se conoce la codificación especificada");
            e.printStackTrace();
        }
        return resumenHexadecimal;
    }

    /**
     * Compara dos resúmenes para comprobar si son iguales(El resumen debe ser pasado en hexaedecimal)
     *
     * @param resumen1 Resumen del primer mensaje
     * @param resumen2 Resumen del segundo mensaje
     * @return true si los resúmenes son iguales, false en caso contrario
     */
    public static boolean compararResumenes(String resumen1, String resumen2) {
        boolean iguales = false;
        // Compruebo que los resúmenes tienen la misma longitud
        if (resumen1.length() == resumen2.length()) {
            // Comparamos los dos resumenes con el método equals
            if (resumen1.equals(resumen2)) {
                iguales = true;
            }
        }
        return iguales;
    }
}

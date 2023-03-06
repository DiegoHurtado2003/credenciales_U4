import java.io.*;
import java.util.Scanner;

public class login {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un usuario: ");
        String usuario = sc.nextLine();
        System.out.println("Introduce una contraseña: ");
        String contrasena = sc.nextLine();
        validarUsuario(usuario, calculoHash.getDigest(contrasena));
    }

    /**
     * Valida el usuario y la contraseña
     * @param usuario Usuario a validar
     * @param resumenContrasena Resumen de la contraseña a validar
     */
    private static void validarUsuario(String usuario, String resumenContrasena) {
        File file = new File("credenciales.cre");
        BufferedReader br; //Buffer para leer el fichero
        String line; //Almacena la línea leída del fichero
        boolean encontrado; //Indica si se ha encontrado el usuario para no contiuar buscando
        try {
            br = new BufferedReader(new FileReader(file));
            encontrado = false;
            line = br.readLine();
            while (line != null && !encontrado) {//Mientras no se llegue al final del fichero y no se haya encontrado el usuario se sigue buscando
                if (line.equals(usuario)) {//Si se encuentra el usuario se comprueba la contraseña
                    String resContra = br.readLine();
                    if (calculoHash.compararResumenes(resContra, resumenContrasena)) { //Se compara el resumen de la contraseña almacenado con el resumen de la contraseña introducida
                        System.out.println("Acceso permitido a la aplicación");
                    } else {
                        System.out.println("Contraseña incorrecta");
                    }
                    encontrado = true;
                }
                line = br.readLine();//Se lee la siguiente línea
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.err.println("Ha habido un error al leer el fichero");
        }
    }



}




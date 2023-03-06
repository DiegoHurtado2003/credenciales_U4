import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class registroUsuario {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un usuario: ");
        String usuario = sc.nextLine();
        System.out.println("Introduce una contraseña: ");
        String contrasena = sc.nextLine();

        almacenarUsuario(usuario, calculoHash.getDigest(contrasena));


    }

    //Método que almacena el usuario y el resumen de la contraseña en un fichero
    public static void almacenarUsuario(String usuario, String contrasena) {
        File file = new File("credenciales.cre");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(usuario);
            bw.newLine();
            bw.write(contrasena);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Ha habido un error al escribir en el fichero");
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                System.err.println("Ha habido un error al cerrar el fichero");
            }

        }


    }
}

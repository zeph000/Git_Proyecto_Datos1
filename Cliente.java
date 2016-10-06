package sockets.cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import sockets.conexion.Conexion;

public class Cliente extends Conexion {
	public Cliente() throws IOException{super("cliente");} //Se usa el constructor para cliente de Conexion

    public void startClient() //M�todo para iniciar el cliente
    {
        try
        {            
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(socketcliente.getOutputStream());

            //Se enviar�n dos mensajes
            for (int i = 0; i < 3; i++)
            {
                //Se escribe en el servidor usando su flujo de datos
                salidaServidor.writeUTF("Mostrando datos" + (i+1) + "\n");                
            }           

            socketcliente.close();//Fin de la conexi�n

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
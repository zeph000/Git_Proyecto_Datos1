package sockets.servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import sockets.conexion.Conexion;

public class Servidor extends Conexion //Se hereda de conexi�n para hacer uso de los sockets y dem�s
{
    public Servidor() throws IOException{super("servidor");} //Se usa el constructor para servidor de Conexion

    public void startServer()//M�todo para iniciar el servidor
    {
        try
        {
            System.out.println("Esperando..."); //Esperando conexi�n

            socketcliente = socketservidor.accept(); //Accept comienza el socket y espera una conexi�n desde un cliente

            System.out.println("Cliente en l�nea");

            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            salidaCliente = new DataOutputStream(socketcliente.getOutputStream());

            //Se le env�a un mensaje al cliente usando su flujo de salida
            salidaCliente.writeUTF("Conexi�n establecida");
            
            //Se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketcliente.getInputStream()));
            
            while((mensajeServidor = entrada.readLine()) != null) //Mientras haya mensajes desde el cliente
            {
                //Se muestra por pantalla el mensaje recibido
                System.out.println(mensajeServidor);
            }
            
            System.out.println("Fin de la conexi�n");
            
            socketservidor.close();//Se finaliza la conexi�n con el cliente
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
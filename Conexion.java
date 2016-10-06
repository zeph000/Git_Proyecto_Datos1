package sockets.conexion;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion
{
    private final int PUERTO = 3800; //Puerto para la conexión
    private final String HOST = "localhost"; //Host para la conexión
    private final String IP ="127.0.0.1"; //Dirección de la máquina, en este caso de donde se hizo el servidor.
    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    protected ServerSocket socketservidor; //Socket del servidor
    protected Socket socketcliente; //Socket del cliente
    protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida
    
    public Conexion(String tipo) throws IOException //Constructor
    {
        if(tipo.equalsIgnoreCase("servidor"))
        {
            socketservidor = new ServerSocket(PUERTO);//Se crea el socket para el servidor en puerto 3800
            socketcliente = new Socket(); //Socket para el cliente
        }
        else
        {
        	socketcliente = new Socket(HOST,PUERTO,IP); //Socket para el cliente en localhost en puerto 3800
        }
    }
}
    
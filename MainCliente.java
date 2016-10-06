package sockets.main;
//Se importa los paquetes necesarios
import java.io.*;
import sockets.cliente.Cliente;


//Clase principal que hará uso del cliente
public class MainCliente {
	
    public static void main(String[] args) throws IOException {  
    	Cliente cli = new Cliente(); //Se crea el cliente
        
        System.out.println("Iniciando cliente\n");
        cli.startClient(); //Se inicia el cliente
    }
}

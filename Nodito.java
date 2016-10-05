
import javax.swing.*;


public class Nodito {
	public int num; //variable para elemento entero del nodo
	public Nodo_Mapa Current; //variable para almacenar la posicion del nodo en el mapa
	public Estelita Next; //Puntero que enlaza con otro nodo
	public ImageIcon Icon;

	
	//constructor del nodo
	public Nodito(){
		this.Next = null;
		this.Current = null;
	}
	
	//Este mae de aqui me enlaza los nodos
	public void Enlazar(Estelita n){
		Next = n;
	}
	/*
	//Este bicho me enlaza con un nodo en el mapa
	public void EnlazarConMapa(Nodito Nodo_Mapa){
		Current = Nodo_Mapa;
	}
	*/
}


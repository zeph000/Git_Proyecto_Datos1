import java.awt.Color;

import javax.swing.*;

public class Nodo_Mapa extends JLabel
{
	public int Yaxis;
	public int Xaxis;
	public Nodo_Mapa up;
	public Nodo_Mapa down;
	public Nodo_Mapa left;
	public Nodo_Mapa right;

	
	public Nodo_Mapa(int fila, int columna)
	{
		Yaxis= fila;
		Xaxis= columna;
		setToolTipText(Position());
		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(Color.black);
		
	}
	public String Position(){
		return "Estoy en la fila "+Yaxis+" y enla columna "+Xaxis;
	}
}

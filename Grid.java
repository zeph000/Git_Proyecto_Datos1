import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

// clase de la malla//
public class Grid extends JFrame implements ActionListener
{
	public Container contents;
	public Nodo_Mapa[][] Nodo = new Nodo_Mapa [30][30];
	public ImageIcon MotoAUp = new ImageIcon("/home/daniel/workspace/Grid/src/moto_p1.png");
	public Timer timer;
	public boolean inGame =true;
	public Moto_Lista moto;
	
	// posicion de los items en el mapa
	public Estela_item Estela_on_map;
	public int estela_y;
	public int estela_x;
	
	
	
	// parametros para permitir cambiar direccion de la moto
	public boolean UP =false;
	public boolean DOWN=false;
	public boolean RIGHT=true;
	public boolean LEFT=false;
	
	
	
	//constructor
	public Grid()
	{
		contents = getContentPane();
		contents.setLayout( new GridLayout(30,30));
		addKeyListener(new TAdapter());
		
		
		for (int i=0;i<30;i++)
		{
			for (int j=0;j<30;j++)
			{
				Nodo[i][j]= new Nodo_Mapa(i,j);
				contents.add (Nodo[i][j]);
			}
		}
	    for (int i=0;i<30;i++){
	        for (int j=0;j<30;j++){
	            if (i<29)
	            	Nodo[i][j].down = Nodo[i+1][j];
	            if (i>1)
	            	Nodo[i][j].up = Nodo[i-1][j];
	            if (j<29)
	            	Nodo[i][j].right = Nodo[i][j+1];
	            if (j>1)
	            	Nodo[i][j].left = Nodo[i][j-1];
	        }   
	    }
	       
	    //parametros del grid
	    
		setSize(650,650);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}
// inicia el juegp
	public void Start_Game(){
		moto = new Moto_Lista();
		Place(20,10,moto);
		
		timer = new Timer(200, this);
        timer.start();
	}
	
	//posiciona moto en en el grid
	public void Place(int Y, int X, Moto_Lista Moto){
		Moto.Head.Current=  Nodo[Y][X];
		Nodo[Y][X].setIcon(Moto.Head.Icon);
		Estelita estela = Moto.Head.Next;
		Y+=1;
		for( int i=0; i<(Moto.Size-1); i++){
			estela.Current = Nodo[Y][X];
			Nodo[Y][X].setIcon(estela.Icon);
			Y+=1;
			estela=estela.Next;
		}

	}
	
	@Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {
        	checkCollision();
        	checkItems();

            Move(moto);
        }
    }
	
    private void checkItems() {

        if ((moto.Head.Current.Yaxis == Estela_on_map.current.Yaxis) && (moto.Head.Current.Xaxis== Estela_on_map.current.Xaxis)) {

            
        	moto.Add_Estela();
            
            locateEstela();
        }
    }
	
    private void locateEstela() {
    	
    	int y = (int) (Math.random() * 30);
        int x = (int) (Math.random() * 30);
        
        estela_y = y;
        estela_x = x;
        Estela_on_map=new Estela_item();
        Estela_on_map.current=Nodo[y][x];
        Nodo[y][x].setIcon(Estela_on_map.icon);
    }

	
    
    
	// Adaptor que cambia la direccion de la moto dependiendo de la t   checkCollisionecla
    public class TAdapter extends KeyAdapter {

	    //Override
	    public void keyPressed(KeyEvent e) {
	    	
	    	String dir;
	    	dir="up";
	    	
	        int key = e.getKeyCode();

	        if ((key == KeyEvent.VK_LEFT) && !RIGHT) {
	            dir="left";
	        	UP = false;
	        	DOWN = false;
	        	LEFT = true;
		        moto.Head.direccion=dir;
		        //Move(moto);            
	        }

	        if ((key == KeyEvent.VK_RIGHT) && !LEFT) {
	            dir= "right";
	        	UP = false;
	        	DOWN = false;
	        	RIGHT = true;
		        moto.Head.direccion=dir;
		        //Move(moto);
	        }

	        if ((key == KeyEvent.VK_UP) && !DOWN) {
	            dir="up";
	        	LEFT = false;
	        	RIGHT = false;
	        	UP = true;
		        moto.Head.direccion=dir;
		        //Move(moto);
	        }

	        if ((key == KeyEvent.VK_DOWN) && !UP) {
	            dir="down";
	        	LEFT = false;
	        	RIGHT = false;
	        	DOWN = true;
		        moto.Head.direccion=dir;
		        //Move(moto);
	        }
	        

	    }
	}

    public void checkCollision() {
    	Estelita actual= moto.Head.Next;
    	
    	
    	while(actual!=null){
    		if( moto.Head.Current==actual.Current){
    			inGame=false;
    		}
    		actual=actual.Next;
    	}
    }

	
	//mueve los iconos de los nodos
	
	public void Move(Moto_Lista Moto){
		Nodo_Mapa point = Moto.Head.Current;
		int y= point.Yaxis;
		int x= point.Xaxis;
		Nodo_Mapa tail=Moto.tail.Current;
		if(0<=y & y<30 & 0<=x & x<30){
			Moto.Move2();
			if(tail==null){
			tail=Moto.tail.Current;
			}			
			point.setIcon(Moto.tail.Icon);
			tail.setIcon(null);
			point=Moto.Head.Current;
			point.setIcon(Moto.Head.Icon);
			}		
	}
	

	
	//main
	public static void main(String[] args)
	{

		
		
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run(){
				Grid malla = new Grid();
				malla.locateEstela();
				malla.Start_Game();
				
				
				}
		});
		
		
	}

}
























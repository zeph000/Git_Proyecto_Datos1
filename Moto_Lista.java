


public class Moto_Lista {
	Moto Head;
	int Size;
	Estelita tail;
	
	public Moto_Lista(){
		Head = new Moto(); //empieza en null,es el punto de partida
		Size = 1;
		int num = 0;
		
		while (num<=2){
			this.Add_Estela();
			num++;
		}
		/*Estelita temp= Head.Next;
		while(temp.Next!=null){
			temp=temp.Next;
		}
		tail=temp;*/
		System.out.println(Size);
	}
	
	
	//revisa si esta vacia
	public boolean Vacia(){
		return (Head == null)?true:false;
	}
	
	//Agrega un elemento desde el head.
	public void AddMoto(){
		if (Head == null){
			Head = new Moto();
		}
		/*
		else {
			Nodito Temp = Head;
			Nodito nuevo = new Nodito();
			nuevo.Enlazar(Temp);
			Head = nuevo;
		}*/
		Size++;
	}
	
	
	
	//Agrega un nodo desde el Tail(terminar)
	public void Add_Estela(){
		if (Head == null){
			Head = new Moto();
		}
		else if(Head.Next==null){
			Head.Next= new  Estelita();
			tail=Head.Next;
		}
		else{ 
			Estelita nuevo = new Estelita(); 
			Estelita temp = Head.Next;
			while(temp.Next != null){
				temp = temp.Next;
			}
			temp.Enlazar(nuevo);
			nuevo.Enlazar(null);
			tail=nuevo;
			
		}
		Size++;
		
	}
	//Obtengo el Size de la lista
	public int Size(){
		return Size;
	}
	
	//Mueve los currents de los nodos de la moto un espacio
	public void Move(){
		Estelita temp1= Head.Next;
		Nodo_Mapa temp2=Head.Current;
		Estelita cola=tail;
		System.out.println(Size);
		this.Remove_Tail();
		Head.Next=cola;
		if(Head.direccion=="up"){
			Head.Current=Head.Current.up;
		}
		else if(Head.direccion=="down"){
			Head.Current=Head.Current.down;
		}
		else if(Head.direccion=="right"){
			Head.Current=Head.Current.right;
		}
		else if(Head.direccion=="left"){
			Head.Current=Head.Current.left;
		}
		cola.Current=temp2;
		cola.Next=temp1;
		
		Size++;
		//System.out.println(Size);
		//System.out.println(Head.Next.Next.Next);
		System.out.println(Head.Next.Current.Yaxis);
		System.out.println(Head.Next.Next.Current.Yaxis);
		System.out.println(Head.Next.Next.Next.Current.Yaxis);
	}
	
	public void Move2(){
		
		Estelita Actual= Head.Next;
		Nodo_Mapa temp1= Head.Current;
		Nodo_Mapa temp2;
		if(Head.direccion=="up"){
			Head.Current=Head.Current.up;
		}
		else if(Head.direccion=="down"){
			Head.Current=Head.Current.down;
		}
		else if(Head.direccion=="right"){
			Head.Current=Head.Current.right;
		}
		else if(Head.direccion=="left"){
			Head.Current=Head.Current.left;
		}
		while(Actual.Next!=null){
			temp2=Actual.Current;
			Actual.Current= temp1;
			temp1=temp2;
			Actual=Actual.Next;	
		}
		Actual.Current=temp1;
	
		
		Size++;
	}
		 
	public void Remove_Tail(){
		Estelita t1= Head.Next;
		Estelita t2= Head.Next.Next;
		if (t2.Next!=null){
			while(t2.Next!=null){
				t1=t2;
				t2=t2.Next;
			}
		}
		t1.Next=null;
		Size--;
	}
	
	
	//de que me sirve get dato? , que dato quiero?
	/*
	public int GetDato(int indice){
		int contador = 0;
		Nodito Temporal = Head;
		while (contador < indice){
			Temporal = Temporal.Next;
			contador++;	
		}
		return Temporal.ObtenerValor();
	}
	
	*/
	
	
	
	
	/*
	public void EliminarFirst(){
		Head = Head.Next;
		Size--;
	}
	
	*/
	
	/*
	public void Eliminar(int indice){
		if (indice == 0){
			Head = Head.obtenerSiguiente();
			Size--;
		}
		else{
			int cuenta= 0;
			Nodito temporal = Head;
			while(cuenta < indice-1){
				temporal = temporal.obtenerSiguiente();
				cuenta++;
			temporal.Enlazar(temporal.obtenerSiguiente().obtenerSiguiente());
			}
			Size--;
		}
	}
	
	*/
	
	//Para que quiero unir os listas de motos?
	/*
	public Moto_Lista Unimela(Moto_Lista l1, Moto_Lista l2){
			Moto temp = l1.Head;
			while(temp.Next != null){
				
				Estelita temp = temp.Next;
			}
			temp.Enlazar(l2.Head);
			return l1;
		}*/
	
	
	
	
	/*
	public void mostrar(){
        System.out.println("Contenido de la lista");
        System.out.println("---------------------");
        
        Nodito aux = Head;
        
        while(aux!=null){
            System.out.println(aux.ObtenerValor());//mostramos el dato
            aux = aux.obtenerSiguiente();
        }
	}
	*/
	
	
	
	/*
	public Moto_Lista UnirEstela(Moto_Lista Moto , Estelita estela){
		while(contamela < RandomEstela){
			Moto.Add_Estela(Current, Combustible);
			contamela ++;
			Size ++;
		}
		return Moto;
	}
	public void movete(){
		
	}
	*/
	
	
	

}


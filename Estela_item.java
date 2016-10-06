import javax.swing.ImageIcon;
public class Estela_item extends Poder{
	
	public Estela_item(){
		icon= new ImageIcon("/home/daniel/workspace/Grid/src/item_estela.png");
		current=null;
	}
	@Override
	public void Buff(Moto_Lista moto){
		moto.Add_Estela();
	}

}

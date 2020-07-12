package Usaveis;
import elementosbasicos.GameObject;
import elementosbasicos.Mapa;

public abstract class Magia extends Item{
	
	Magia(String chave) {
		super(chave);
	}

	public abstract void Usar(GameObject gameobject, Mapa mapa);
	
}
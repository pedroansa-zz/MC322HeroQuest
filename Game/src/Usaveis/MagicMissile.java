package Usaveis;

import elementosbasicos.*;
import elementosbasicos.GameObject;
import elementosbasicos.Mapa;
import excecoes.DigitoInvalidoException;

import java.util.Scanner;

import Externos.Direcao;

public class MagicMissile extends Magia {

	private static final String nome = "MagicMissile";

	public MagicMissile() {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	private Objeto getPrimeiroInimigo(int x, int y, Direcao direcao, Mapa mapa) {
		// Essa função vai percorrer o mapa numa direção e devolver um inimigo assim que
		// o vir
		Objeto inimigo = null;
		int nx = x;
		int ny = y;

		while (inimigo == null) {
			
			if (direcao == Direcao.DOWN)
				nx += 1;

			else if (direcao == Direcao.RIGHT)
				ny += 1;

			else if (direcao == Direcao.LEFT)
				ny -= 1;

			else
				nx -= 1;
			
			if(nx > mapa.getAltura() || ny > mapa.getLargura())
				break;
			
			inimigo = mapa.getObjetoMapa(nx, ny);
		
		}
		return inimigo;	
	}

	
	public void Usar(GameObject gameobject, Mapa mapa) throws DigitoInvalidoException {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			int x = gameobject.getX();
			int y = gameobject.getY();

			System.out.println("Digite a direção na qual você atirará");
			Scanner keyboard = new Scanner(System.in);

			String command = keyboard.nextLine().toLowerCase();
			Direcao direcao = null;

			if(command.compareTo("s") == 0)
				direcao = Direcao.DOWN;
			
			else if(command.compareTo("d") == 0)
				direcao = Direcao.RIGHT;
			
			else if(command.compareTo("a") == 0)
				direcao = Direcao.LEFT;
			
			else if(command.compareTo("w") == 0)
				direcao = Direcao.UP;			
			else 
				throw new DigitoInvalidoException();
			

			Objeto alvo = getPrimeiroInimigo(x, y, direcao, mapa);
			if(alvo != null) {
				alvo.receberDano(2);
			}
		}

	}

}

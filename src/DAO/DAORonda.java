package DAO;

import java.util.List;

import Entity.Chaves;
import Entity.Ronda;

public interface DAORonda {
	
	

	void adicionar(Ronda ronda);
	


	List<Ronda> pesquisarPorNome(String string);

	

	
	
}

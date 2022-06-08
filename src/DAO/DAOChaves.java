package DAO;

import java.util.List;

import Entity.Chaves;

public interface DAOChaves {

	
	void adicionar(Chaves chaves);
	
	


	List<Chaves> pesquisarPorNome(String string);




	
}

package DAO;

import java.util.List;

import Entity.Chaves;

public interface DAOChaves {

	
	void adicionar(Chaves chaves);
	
	

	void remover(String chave);

	List<Chaves> pesquisarPorNome(String string);

	List<Chaves> buscarChaves(String chaves);

	
}

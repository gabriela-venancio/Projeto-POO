package DAO;

import java.util.List;

import Entity.Ronda;
import Entity.Visitante;

public interface DAOVisitante {
	
	

	void adicionar (Visitante visitante);
	

	List<Visitante> pesquisarPorNome(String string);

}
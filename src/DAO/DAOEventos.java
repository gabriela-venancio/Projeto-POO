package DAO;

import java.util.List;

import Entity.Eventos;

public interface DAOEventos {

	
	
	void adicionar(Eventos e);

	List<Eventos> pesquisarPorNome(String string);

	
}

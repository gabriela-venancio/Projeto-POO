package DAO;

import java.util.List;

import Entity.AgendarSala;
import Entity.Ronda;

public interface DAOAgendarSala {


	List<AgendarSala> pesquisarPorNome(String string);

	void adicionar(AgendarSala as);
}

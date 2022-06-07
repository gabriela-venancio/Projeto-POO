package DAO;

import java.util.List;

import Entity.Chaves;
import Entity.Funcionario;

public interface DAOFun {


	void adicionar(Funcionario f);
	
	List<Funcionario> pesquisarPorNome(String string);
}

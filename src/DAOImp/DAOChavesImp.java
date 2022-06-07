package DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOChaves;
import Entity.Chaves;
import Entity.Funcionario;

public class DAOChavesImp implements DAOChaves{
	 private static final String URL = "jdbc:mariadb://localhost:3307/portaria";
	    private static final String USER = "root";
	    private static final String PASSWORD = "root";
 @Override
 public void adicionar(Chaves chaves) {
     try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
         String sql = "insert into chaves " +
                 "(chaves, responsavel) " +
                 "values (?, ?)";
         PreparedStatement statement = con.prepareStatement(sql);
         statement.setString(1, chaves.getChave());
         statement.setString(2, chaves.getResponsavel());
       
       
         statement.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

	


	@Override
	public List<Chaves> pesquisarPorNome(String nome) {
		List<Chaves> lista = new ArrayList<>();
        String sql = "SELECT * FROM chaves WHERE chaves LIKE '" + nome + "%'";

        
        try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	Chaves chave = new Chaves();
            	chave.setChave(rs.getString("chaves"));
            	chave.setResponsavel(rs.getString("responsavel"));
               
                lista.add(chave);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;	
	}


	@Override
	public void remover(String chave) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Chaves> buscarChaves(String chaves) {
		// TODO Auto-generated method stub
		return null;
	}

}

package DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOVisitante;
import Entity.Funcionario;
import Entity.Visitante;

public class DAOVisitImp implements DAOVisitante{
	 private static final String URL = "jdbc:mariadb://localhost:3307/portaria";
	    private static final String USER = "root";
	    private static final String PASSWORD = "root";
 @Override
 public void adicionar(Visitante visitante) {
     try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
         String sql = "insert into visitante " +
                 "(nome, cpf , destino) " +
                 "values (?, ?, ?)";
         PreparedStatement statement = con.prepareStatement(sql);
         statement.setString(1, visitante.getNome());
         statement.setString(2, visitante.getCpf());
         statement.setString(3, visitante.getDestino());
       
         statement.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

	
	@Override
	public List<Visitante> pesquisarPorNome(String string) {
		List <Visitante> lista = new ArrayList();
		String  sql = "select * from visitante where cpf like = '%" + string + "%'";
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)){
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Visitante visita = new Visitante();
				visita.setNome(rs.getString("nome"));
				visita.setCpf(rs.getString("cpf"));
				visita.setDestino(rs.getString("destino"));
				
				lista.add(visita);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return lista;
	}

	

	

	

}

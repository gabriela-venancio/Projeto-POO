package DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOEventos;
import Entity.Eventos;

public class DAOEventosImp  implements DAOEventos{
	 private static final String URL = "jdbc:mariadb://localhost:3307/portaria";
	    private static final String USER = "root";
	    private static final String PASSWORD = "root";
 @Override
 public void adicionar(Eventos eventos) {
     try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
         String sql = "insert into evento " +
                 "(proximoEvento, responsavel , assunto) " +
                 "values (?, ?, ?)";
         PreparedStatement statement = con.prepareStatement(sql);
         statement.setString(1, eventos.getProximoEvento());
         statement.setString(2, eventos.getResponsavel());
         statement.setString(3, eventos.getAssunto());
       
         statement.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }


	

	@Override
	public List<Eventos> pesquisarPorNome(String nome) {

			List<Eventos> lista = new ArrayList<>();
	        String sql = "SELECT * FROM evento WHERE responsavel LIKE '%" + nome + "%'";

	        
	        try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
	            PreparedStatement stmt = con.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	            	Eventos ev = new Eventos();
	            	ev.setProximoEvento(rs.getString("proximoEvento"));
	            	ev.setResponsavel(rs.getString("responsavel"));
	            	ev.setAssunto(rs.getString("assunto"));
	                
	               
	                lista.add(ev);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return lista;	
		}



}

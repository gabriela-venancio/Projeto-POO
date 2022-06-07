package DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAORonda;
import Entity.Ronda;

public class DAORondaImp implements DAORonda{
	 private static final String URL = "jdbc:mariadb://localhost:3307/portaria";
	    private static final String USER = "root";
	    private static final String PASSWORD = "root";
 @Override
 public void adicionar(Ronda ronda) {
     try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
         String sql = "insert into ronda " +
                 "(nome, local , turno) " +
                 "values (?, ?, ?)";
         PreparedStatement statement = con.prepareStatement(sql);
         statement.setString(1, ronda.getNome());
         statement.setString(2, ronda.getLocal());
         statement.setString(3, ronda.getTurno());
       
         statement.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

 
 
 
	@Override
	public List<Ronda> pesquisarPorNome(String nome) {
		List<Ronda> lista = new ArrayList<>();
        String sql = "SELECT * FROM ronda WHERE nome LIKE '%" + nome + "%'";

        
        try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	Ronda r = new Ronda();
            	r.setNome(rs.getString("nome"));
            	r.setLocal(rs.getString("local"));
            	r.setTurno(rs.getString("turno"));
                
               
                lista.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;	
	}


	
}

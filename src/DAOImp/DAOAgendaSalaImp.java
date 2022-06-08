package DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOAgendarSala;
import Entity.AgendarSala;
import Entity.Ronda;

public class DAOAgendaSalaImp implements DAOAgendarSala{
	 private static final String URL = "jdbc:mariadb://localhost:3307/portaria";
	    private static final String USER = "root";
	    private static final String PASSWORD = "root";

    public void adicionar(AgendarSala as) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "insert into salavideo " +
                    "(motivo, responsavel , data) " +
                    "values (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, as.getMotivo());
            statement.setString(2, as.getResponsavel());
            statement.setString(3, as.getData());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	

	
	@Override
	public List<AgendarSala> pesquisarPorNome(String string) {
	
		
		List<AgendarSala> lista = new ArrayList<>();
        String sql = "SELECT * FROM salavideo WHERE responsavel LIKE '" + string + "%'";

        
        try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	AgendarSala r = new AgendarSala();
            	r.setMotivo(rs.getString("motivo"));
            	
            	r.setResponsavel(rs.getString("responsavel"));
            	r.setData(rs.getString("data"));
                
               
                lista.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;	
	}



}

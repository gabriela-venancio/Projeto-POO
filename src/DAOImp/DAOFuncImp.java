package DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOFun;
import Entity.Funcionario;

public class DAOFuncImp implements DAOFun{
	 private static final String URL = "jdbc:mariadb://localhost:3307/portaria";
	    private static final String USER = "root";
	    private static final String PASSWORD = "root";
    @Override
    public void adicionar(Funcionario funcionario) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "insert into funcionario " +
                    "(nome, cpf , cargo) " +
                    "values (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getCpf());
            statement.setString(3, funcionario.getCargo());
          
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
    
	@Override
	public List<Funcionario> pesquisarPorNome(String string) {
		 List<Funcionario> lista = new ArrayList<>();
	        String sql = "SELECT * FROM funcionario WHERE nome LIKE '" + string + "%'";

	        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
	            PreparedStatement stmt = con.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	            	Funcionario fun = new Funcionario();
	            	fun.setNome(rs.getString("nome"));
	            	fun.setCpf(rs.getString("cpf"));
	            	fun.setCargo(rs.getString("cargo"));
	                
	                lista.add(fun);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return lista;	
	        
	}

}

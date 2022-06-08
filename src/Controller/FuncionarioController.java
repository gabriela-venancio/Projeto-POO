package Controller;

import java.util.List;

import DAO.DAOFun;
import DAOImp.DAOFuncImp;
import Entity.Chaves;
import Entity.Funcionario;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class FuncionarioController {
//nome cpf cargo
	

  private ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList();
	private TableView<Funcionario> tableFuncionario = new TableView<>();

	  
	private StringProperty nome =  new SimpleStringProperty();
	private StringProperty cpf = new SimpleStringProperty();
	private StringProperty cargo = new SimpleStringProperty();
	
	private DAOFun daofun = new DAOFuncImp();

	
	
	
	public TableView<Funcionario> getTable() {
        return tableFuncionario;
    }
	
	
    public void setEntity(Funcionario f) {
        if (f != null) {
            nome.set(f.getNome());
           cpf.set(f.getCpf());
           cargo.set(f.getCargo());
            
        }
    }
    
    
	public Funcionario getEntityFun() {
		Funcionario c = new Funcionario();
		c.setNome(nome.get().toLowerCase());
		c.setCpf(cpf.get().toLowerCase());
		c.setCargo(cargo.get().toLowerCase());
		
		return c;
	}
		@SuppressWarnings("unchecked")
	   public FuncionarioController() {
	        TableColumn<Funcionario, String> col1 = new TableColumn<>("Nome");
	       col1.setCellValueFactory(new PropertyValueFactory<>("nome"));

	        
	        TableColumn<Funcionario, String> col2 = new TableColumn<>("CPF");
	       col2.setCellValueFactory(new PropertyValueFactory<>("cpf"));

	        
	        TableColumn<Funcionario, String> col3 = new TableColumn<>("Cargo");
	        col3.setCellValueFactory(new PropertyValueFactory<>("cargo"));

	        
	    

	        tableFuncionario.getColumns().addAll( col1, col2, col3);
	           

			col1.setPrefWidth(190);
			col2.setPrefWidth(190);
			

			
			
			tableFuncionario.setItems(funcionarios);
			tableFuncionario.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			
		}
	        
	        
	        

	public void limpar() {
		nome.setValue("");
		cpf.setValue("");
		cargo.setValue("");
		
	}
	
	public String getNome() {
		return nome.get();
	}
	
	public StringProperty NomeProperty() {
		return nome;
	}
	
	public String getCpf() {
		return cpf.get();
	}
	
	public StringProperty cpfProperty() {
		return cpf;
	}
	
	public String getCargo() {
		return cargo.get();
	}
	
	public StringProperty cargoProperty() {
		return cargo;
	}

	public void pesquisarPorNome() {
		 List<Funcionario> funListPesquisa = daofun.pesquisarPorNome(nome.get());
	      
	        funcionarios.clear();
	        funcionarios.addAll(funListPesquisa);
	        limpar();
	    }

	


	public void adicionar() {
		Funcionario f = new Funcionario();
		
		f.setNome(nome.get());
		f.setCpf(cpf.get());
		f.setCargo(cargo.get());
		funcionarios.add(f);
		
		
        daofun.adicionar(f);
		
	}
	
}
	
	
	


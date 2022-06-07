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

	  
	private StringProperty nome =  new SimpleStringProperty("");
	private StringProperty cpf = new SimpleStringProperty("");
	private StringProperty cargo = new SimpleStringProperty("");
	
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
	
	   public void generatedTable() {
	        TableColumn<Funcionario, String> colNome = new TableColumn<>("nome");
	        TableColumn<Funcionario, String> colCpf = new TableColumn<>("cpf");
	        TableColumn<Funcionario, String> colCargo = new TableColumn<>("cargo");
	        
	        
	        Callback<TableColumn<Funcionario, String>, TableCell<Funcionario, String>> cellFactory = col ->
	                new TableCell<Funcionario, String>() {
	                    @Override
	                    public void updateItem(String item, boolean empty) {
	                        super.updateItem(item, empty);
	                        if (empty) {
	                            setGraphic(null);
	                        }
	                    }
	                };
	      
	        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
	        colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
	        colCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
	        

	        tableFuncionario.getColumns().addAll( colNome, colCpf, colCargo);
	        tableFuncionario.getSelectionModel().selectedItemProperty().addListener((obj, antigo, novo) -> {
	            setEntity(antigo);
	            setEntity(novo);
	        });
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

	public boolean pesquisarPorNome() {
		 List<Funcionario> funListPesquisa = daofun.pesquisarPorNome(nome.get());
	        if (funListPesquisa==null){
	            return false;
	        }
	        funcionarios.clear();
	        funcionarios.addAll(funListPesquisa);
	        return true;
	    }

	


	public void adicionar() {
		Funcionario f = getEntityFun();
        daofun.adicionar(f);
		
	}
	
}
	
	
	


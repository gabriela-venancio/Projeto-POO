package Controller;

import java.util.List;

import DAO.DAOVisitante;
import DAOImp.DAOVisitImp;
import Entity.Ronda;
import Entity.Visitante;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class VisitanteController {

	//nome/cpf/destino
	
	private DAOVisitante daovis= new DAOVisitImp();
	private ObservableList<Visitante> v = FXCollections.observableArrayList();
	    private TableView<Visitante> tabelav = new TableView<>();
	
	private StringProperty nome = new SimpleStringProperty();
	private StringProperty cpf = new SimpleStringProperty();
	private StringProperty destino = new SimpleStringProperty();
	
	

	
	
  
 @SuppressWarnings("unchecked")
 public VisitanteController() {
	 
	    TableColumn<Visitante, String> col1 = new TableColumn<>("Nome");
	    col1.setCellValueFactory(new PropertyValueFactory<>("nome"));
	 
	    
	    TableColumn<Visitante, String> col2 = new TableColumn<>("Cpf");
	    col2.setCellValueFactory(new PropertyValueFactory<>("cpf"));
	    
	    TableColumn<Visitante, String> col3 = new TableColumn<>("Destino");
	    col3.setCellValueFactory(new PropertyValueFactory<>("destino"));
	 
	    
	    tabelav.getColumns().addAll(col1, col2, col3);
	    
	    col1.setPrefWidth(19);
	    
		col2.setPrefWidth(19);
		col3.setPrefWidth(19);
			  
        
        
             
        tabelav.setItems(v);
        
    

        tabelav.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    
	
	

   

    public void adicionar(){
        Visitante m = new  Visitante();
        m.setNome(nome.get());
        m.setCpf(cpf.get());
        m.setDestino(destino.get());
        v.add(m);
        daovis.adicionar(m);
        
        limpar();
       
    }

    
    public void pesquisarPorNome(){
        List<Visitante> visListPesquisa = daovis.pesquisarPorNome(cpf.get());
        
        v.clear();
        v.addAll(visListPesquisa);
        limpar();
    }
	
    public TableView<Visitante> getTable() {
    	
        return  tabelav;
        
    }
	
	 
	public void limpar() {
		nome.setValue("");
		cpf.setValue("");
		destino.setValue("");
	}
	
	
	public StringProperty nomeProperty() {
		return nome;
	}
	

	
	public StringProperty cpfProperty() {
		return cpf;
	}

	public StringProperty destinoProperty() {
		return destino;
	}
	
	
}

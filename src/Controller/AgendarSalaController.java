package Controller;

import java.util.List;

import DAO.DAOAgendarSala;
import DAOImp.DAOAgendaSalaImp;
import Entity.AgendarSala;
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

public class AgendarSalaController {

	private DAOAgendarSala daoAgendarSala = new DAOAgendaSalaImp();

	private ObservableList<AgendarSala> agendarSalas = FXCollections.observableArrayList();
	private TableView<AgendarSala> tableAgendarSala = new TableView<>();

	
	private StringProperty motivo = new SimpleStringProperty();
	private StringProperty responsavel = new SimpleStringProperty();
	private StringProperty data = new SimpleStringProperty();
	
	
	public AgendarSala getEntityAgendarSala() {
		AgendarSala a = new AgendarSala();
		
		a.setMotivo(motivo.get().toLowerCase());
		a.setResponsavel(responsavel.get().toLowerCase());
		a.setData(data.get().toLowerCase());
		
		return a;
	}
	
	 public void setEntityAgendarSala(AgendarSala as) {
	        if (as != null) {
	            motivo.set(as.getMotivo());
	           responsavel.set(as.getResponsavel());
	           data.set(as.getData());
	            
	        }
	    }
	
	public void limpar() {
		motivo.setValue("");
		responsavel.setValue("");
		data.setValue("");
	}
	
	public String getMotivo() {
		return motivo.get();
	}
	
	public StringProperty motivoProperty() {
		return motivo;
	}
	
	public String getResponsavel() {
		return responsavel.get();
	}
	public StringProperty responsavelProperty() {
		return responsavel;
	}
	
	public String getData() {
		return data.get();
		
	}
	
	public StringProperty dataProperty() {
		return data;
	}

	
			TableColumn<AgendarSala, String> col1 = new TableColumn<>("motivo");
	        TableColumn<AgendarSala, String> col2 = new TableColumn<>("responsavel");
	        TableColumn<AgendarSala, String> col3 = new TableColumn<>("data");
	        
	        
	 @SuppressWarnings("unchecked")
	public AgendarSalaController() {
	     
		 TableColumn<AgendarSala, String> col1 = new TableColumn<>("Motivo");
		 col1.setCellValueFactory(new PropertyValueFactory<>("motivo"));
		 
		 TableColumn<AgendarSala, String> col2 = new TableColumn<>("Responsavel");
	        col2.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
	        
			 TableColumn<AgendarSala, String> col3 = new TableColumn<>("Data");
	        col3.setCellValueFactory(new PropertyValueFactory<>("data"));
	        
	        tableAgendarSala.getColumns().addAll( col1, col2, col3);
	        
	        col1.setPrefWidth(190);
			col2.setPrefWidth(190);
			col3.setPrefWidth(190);
				
	        
	        tableAgendarSala.setItems(agendarSalas);

	        tableAgendarSala.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	    }
	
	
	

	public void adicionar() {
		AgendarSala as = new AgendarSala();
		
		as.setMotivo(motivo.get());
		as.setResponsavel(responsavel.get());
		as.setData(data.get());
		
		agendarSalas.add(as);
        daoAgendarSala.adicionar(as);
        limpar();
		
	}
	
	public void pesquisarPorNome() {
		 List<AgendarSala> asListPesquisa = daoAgendarSala.pesquisarPorNome(responsavel.get());
	       
	        agendarSalas.clear();
	        agendarSalas.addAll(asListPesquisa);
	       limpar();
	    }
	public TableView<AgendarSala> getTable() {
        return tableAgendarSala;
    }
	
	
}

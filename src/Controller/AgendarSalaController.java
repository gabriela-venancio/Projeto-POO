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


	private ObservableList<AgendarSala> agendarSalas = FXCollections.observableArrayList();
	private TableView<AgendarSala> tableAgendarSala = new TableView<>();

	
	private StringProperty motivo = new SimpleStringProperty("");
	private StringProperty responsavel = new SimpleStringProperty("");
	private StringProperty data = new SimpleStringProperty("");
	
	private DAOAgendarSala daoAgendarSala = new DAOAgendaSalaImp();
	
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
		return motivo.get();
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

	public boolean pesquisarPorNome() {
		 List<AgendarSala> asListPesquisa = daoAgendarSala.pesquisarPorNome(responsavel.get());
	        if (asListPesquisa==null){
	            return false;
	        }
	        agendarSalas.clear();
	        agendarSalas.addAll(asListPesquisa);
	        return true;
	    }


	public void generatedTable() {
	      TableColumn<AgendarSala, String> colMotivo = new TableColumn<>("motivo");
	        TableColumn<AgendarSala, String> colResponsavel = new TableColumn<>("responsavel");
	        TableColumn<AgendarSala, String> colData = new TableColumn<>("data");
	        
	        
	      
	       colMotivo.setCellValueFactory(new PropertyValueFactory<>("motivo"));
	        colResponsavel.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
	        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
	        

	        tableAgendarSala.getColumns().addAll( colMotivo, colResponsavel, colData);
	        tableAgendarSala.getSelectionModel().selectedItemProperty().addListener((obj, antigo, novo) -> {
	            setEntityAgendarSala(novo);
	            setEntityAgendarSala(antigo);
	        });
	        tableAgendarSala.setItems(agendarSalas);

	        tableAgendarSala.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	    }
	
	
	public TableView<AgendarSala> getTable() {
        return tableAgendarSala;
    }

	public void adicionar() {
		AgendarSala as = getEntityAgendarSala();
        daoAgendarSala.adicionar(as);
		
	}
	
	public boolean remover() {
        for (AgendarSala as : agendarSalas) {
            if (as.getResponsavel().toLowerCase().contains(responsavel.get().toLowerCase())) {
            	agendarSalas.remove(as);
                return true;
            }
        }
        return false;
    }
	
	
}

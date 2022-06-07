package Controller;

import java.util.List;

import DAO.DAOEventos;
import DAOImp.DAOEventosImp;
import Entity.Eventos;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EventosController {
//proximoEvento responsavel assunto
	
private DAOEventos daoEventos = new DAOEventosImp();
	 private ObservableList<Eventos> eventos = FXCollections.observableArrayList();
	private TableView<Eventos> tableEventos = new TableView<>();

	
	private StringProperty proximoEvento = new SimpleStringProperty();
	private StringProperty responsavel = new SimpleStringProperty();
	private StringProperty assunto = new SimpleStringProperty();
	
	
	

	
	public Eventos getEntityEventos() {
		Eventos e = new Eventos();
		e.setProximoEvento(proximoEvento.get().toLowerCase());
		e.setResponsavel(responsavel.get().toLowerCase());
		e.setAssunto(assunto.get().toLowerCase());
		
		return e;
					}
	
	
	
	 public void setEntity(Eventos e) {
	        if (e != null) {
	            proximoEvento.set(e.getProximoEvento());
	           responsavel.set(e.getResponsavel());
	           assunto.set(e.getAssunto());
	            
	        }
	    }
	 
	 
	
	public void limpar() {
		proximoEvento.setValue("");
		responsavel.setValue("");
		assunto.setValue("");
	}
	
	public String getProximoEvento() {
		return proximoEvento.get();
	}
	
	public StringProperty proximoEventoProperty() {
		return proximoEvento;
	}
	
	public String getResponsavel() {
		return responsavel.get();
	}
	
	public StringProperty responsavelProperty() {
		return responsavel;
	}
	
	public String getAssunto(){
		return assunto.get();
	}
	
	public StringProperty assuntoProperty() {
		return assunto;
	}

	

	TableColumn<Eventos, String> col1 = new TableColumn<>("proximoEvento");
        TableColumn<Eventos, String> col2 = new TableColumn<>("responsavel");
        TableColumn<Eventos, String> col3 = new TableColumn<>("assunto");
        
	

	
        
    @SuppressWarnings("unchecked")
	public EventosController() {
		
        

    	TableColumn<Eventos, String> col1 = new TableColumn<>("ProximoEvento");
    	col1.setCellValueFactory(new PropertyValueFactory<>("proximoEvento"));
    	
    	TableColumn<Eventos, String> col2 = new TableColumn<>("Responsavel");
    	col2.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
    	
    	TableColumn<Eventos, String> col3 = new TableColumn<>("Assunto");
    	col3.setCellValueFactory(new PropertyValueFactory<>("assunto"));
    	
    	tableEventos.getColumns().addAll( col1, col2, col3);

    	
    	col1.setPrefWidth(190);
    	col2.setPrefWidth(190);
    	col2.setPrefWidth(190);
    	
    	tableEventos.setItems(eventos);

    	
    	

        tableEventos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
	
	public TableView<Eventos> getTable() {
        return tableEventos;
    }
	
	public void adicionar() {
		Eventos v = new Eventos ();
		v.setProximoEvento(proximoEvento.get());
		v.setResponsavel(responsavel.get());
		v.setAssunto(assunto.get());
		
		eventos.add(v);
		daoEventos.adicionar(v);
		
		limpar();
	}
	
	public void pesquisarPorNome() {
		List<Eventos> eveListPesquisa = daoEventos.pesquisarPorNome(responsavel.get());
       
		
        eventos.clear();
        eventos.addAll(eveListPesquisa);
        limpar();
	}
	
	
	
}

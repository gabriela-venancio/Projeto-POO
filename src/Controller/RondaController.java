package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import DAO.DAORonda;
import DAOImp.DAORondaImp;
import Entity.Chaves;
import Entity.Ronda;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RondaController {

	//nome local turno
	private DAORonda daoronda = new DAORondaImp();
	  private ObservableList<Ronda> rondas = FXCollections.observableArrayList();
		private TableView<Ronda> tableRonda = new TableView<>();

	
	private StringProperty nome = new SimpleStringProperty();
	private StringProperty local = new SimpleStringProperty();
	private StringProperty turno = new SimpleStringProperty();
	
	
	
	public Ronda getEntityRonda() {
		Ronda r = new Ronda();
		r.setNome(nome.get().toLowerCase());
		r.setLocal(local.get().toLowerCase());
		r.setTurno(turno.get().toLowerCase());
		return r;
	}
	
	 public void setEntity(Ronda r) {
	        if (r != null) {
	            nome.set(r.getNome());
	           local.set(r.getLocal());
	           turno.set(r.getTurno());
	            
	        }
	    }
	
	public void limpar() {
		nome.setValue("");
		local.setValue("");
		turno.setValue("");
	}
	
	public String getNome() {
		return nome.get();
	}
	 public StringProperty nomeProperty() {
		 return nome;
	 }
	 
	 public String getLocal() {
		 return local.get();
	 }
	 
	 public StringProperty localProperty() {
		 return local;
	 }
	 
	 public String getTurno() {
		 return turno.get();
	 }
	 
	 public StringProperty turnoProperty() {
		 return turno;
	 }

	TableColumn<Ronda, String> colNome = new TableColumn<>("nome");
        TableColumn<Ronda, String> colLocal = new TableColumn<>("local");
        TableColumn<Ronda, String> colTurno = new TableColumn<>("turno");
        
        @SuppressWarnings("unchecked")
        public  RondaController(){
        	
        
        TableColumn<Ronda, String> col1 = new TableColumn<>("Nome");
		col1.setCellValueFactory(new PropertyValueFactory<>("nome"));
			
		TableColumn<Ronda, String> col2 = new TableColumn<>("Local");
		col2.setCellValueFactory(new PropertyValueFactory<>("local"));
			
		TableColumn<Ronda, String> col3 = new TableColumn<>("Turno");
		col3.setCellValueFactory(new PropertyValueFactory<>("turno"));
			
		tableRonda.getColumns().addAll(col2, col1, col3);
			
		col1.setPrefWidth(190);
		col2.setPrefWidth(190);
		col3.setPrefWidth(190);
			
       
       
        tableRonda.setItems(rondas);

        tableRonda.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);		
	}


public void adicionar() {
		Ronda r = new Ronda();
        r.setNome(nome.get());
        r.setLocal(local.get());
        r.setTurno(turno.get());
        rondas.add(r);
        daoronda.adicionar(r);
        

        limpar();
	}
	
	public void pesquisarPorNome() {
		List<Ronda> ronListPesquisa = daoronda.pesquisarPorNome(nome.get());
      
        rondas.clear();
        rondas.addAll(ronListPesquisa);
        limpar();
        
    }


	



    public TableView<Ronda> getTable() {
        return tableRonda;
    }
	
}

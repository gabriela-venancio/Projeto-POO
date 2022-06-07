package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import DAO.DAOChaves;
import DAOImp.DAOChavesImp;
import Entity.Chaves;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ChavesController {
	
	
	 private DAOChaves daoChaves = new DAOChavesImp();
	  private ObservableList<Chaves> chave = FXCollections.observableArrayList();
	    private TableView<Chaves> tableChaves = new TableView<>();

	    
	  
	    private StringProperty chaves = new SimpleStringProperty();
	
	    private StringProperty responsavel = new SimpleStringProperty();
	    
	   



		@SuppressWarnings("unchecked")
		public ChavesController() {
			
			TableColumn<Chaves, String> col1 = new TableColumn<>("Chaves");
			col1.setCellValueFactory(new PropertyValueFactory<>("chave"));
			
			TableColumn<Chaves, String> col2 = new TableColumn<>("Responsavel");
			col2.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
			
			
			tableChaves.getColumns().addAll(col2, col1);
			
			col1.setPrefWidth(190);
			col2.setPrefWidth(190);
			

			
			
			tableChaves.setItems(chave);
			tableChaves.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			//tableChaves.setEditable(true);
			
		}

	    public void adicionar(){
	        Chaves c = new Chaves();
	        c.setChave(chaves.get());
	        c.setResponsavel(responsavel.get());
	        chave.add(c);
	        daoChaves.adicionar(c);
	        	        
	        JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");	

	        limpar();
	    }


	    public void pesquisarPorNome(){
	        List<Chaves> chaveListPesquisa = daoChaves.pesquisarPorNome(chaves.get());
	       
	        chave.clear();
	        chave.addAll(chaveListPesquisa);
	        limpar();
	    }

    public TableView<Chaves> getTable() {
        return tableChaves;
    }
	
	public void limpar() {
		chaves.setValue("");
		responsavel.setValue("");
	}
	
	
	
	
	public StringProperty chavesProperty() {
		return chaves;
	}
	
	
	
	public StringProperty responsavelProperty() {
		return responsavel;
	}
	

}

package Tela;

import java.util.Objects;

import Controller.RondaController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RondaBoundary extends Application {

	public Stage stage;

		//butões da classse Ronda
	    private final TextField ronTxtNome = new TextField();
	    private final TextField ronTxtLocal = new TextField();
	    private final TextField ronTxtTurno = new TextField();

	    private final Button ronBtnCadastrar = new Button("Cadastrar");
	    private final Button ronBtnPesquisar = new Button("Pesquisar");
	    private final Button ronBtnLimpar = new Button("Limpar");
	    private final Button ronBtnInicio = new Button("Inicio");

	    private final Label ronLblnome = new Label("nome:");
	    Label ronTitle = new Label(" ronda");

	    private final RondaController ronControl = new RondaController();
	    
	    

		@Override
		public void start(Stage stage) throws Exception {
		
			
			Bindings.bindBidirectional(ronControl.nomeProperty(), ronTxtNome.textProperty());
		  Bindings.bindBidirectional(ronControl.localProperty(), ronTxtLocal.textProperty());
		  Bindings.bindBidirectional(ronControl.turnoProperty(), ronTxtTurno.textProperty());

		        
		        
	    BorderPane ronPanePrincipal = new BorderPane();
        VBox ronPaneConteudo = new VBox();
        GridPane ronPaneForm = new GridPane();
        FlowPane ronPaneButton = new FlowPane();
	

        ronPanePrincipal.getStylesheets().add(Objects.requireNonNull(tela.class.getResource("style.css")).toExternalForm());
        

        
		ronTitle.getStyleClass().add("tabela de Rondas");

		
        ronPaneForm.add(new Label("Nome:"), 0, 0);
        ronPaneForm.add(new Label("local:"), 0, 1);
        ronPaneForm.add(new Label("turno:"), 0, 2);
        ronPaneForm.add(ronTxtNome, 1, 0);
        ronPaneForm.add(ronTxtLocal, 1, 1);
        ronPaneForm.add(ronTxtTurno, 1, 2);
        
        ronPaneForm.setVgap(10);
        ronPaneForm.setHgap(5);
        ronPaneForm.setAlignment(Pos.CENTER);

        ronPaneButton.getChildren().addAll(ronBtnCadastrar, ronBtnPesquisar, ronBtnLimpar,  ronBtnInicio);
        ronPaneButton.setHgap(50);
        ronPaneButton.setVgap(25);
        ronPaneButton.setAlignment(Pos.CENTER);

        ronPaneConteudo.getChildren().addAll(ronTitle, ronPaneForm, ronPaneButton);
        ronPaneConteudo.setSpacing(15);
        ronPaneConteudo.setAlignment(Pos.CENTER);
        
        ronPanePrincipal.setLeft(ronPaneConteudo);
        ronPanePrincipal.setCenter(ronControl.getTable());
       
        

		ronBtnCadastrar.setOnAction(e ->{
			ronControl.adicionar();
		});
		
		
		ronBtnPesquisar.setOnAction(e->{
			ronControl.pesquisarPorNome();
		});
		
		
		ronBtnInicio.setOnAction(e ->{
			getStage().close();
		});
        
        
		Scene scn = new Scene(ronPanePrincipal, 1400,800);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scn);
		stage.show();
		setStage(stage);
        
        
}



		private void setStage(Stage stage) {
			this.stage = stage;			
		}



		private Stage getStage() {
			return stage;
		}
}
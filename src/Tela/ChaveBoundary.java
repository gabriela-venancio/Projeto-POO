package Tela;

import java.util.Objects;

import Controller.ChavesController;
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

public class ChaveBoundary extends Application{

	
 
	public  Stage stage;


    
    //Botões da classe chaves
    private final TextField chaTxtChaves = new TextField();
    private final TextField chaTxtResponsaval = new TextField();
    private final Button chaBtnCadastrar = new Button("Cadastrar");
    private final Button chaBtnPesquisar = new Button("Pesquisar");
    private final Button chaBtnInicio = new Button("Inicio");

    private final Label chaLblChaves = new Label("");
    private final Label chaLblResponsavel = new Label("");

    Label chaTitle = new Label("Chaves");

    private  ChavesController chaControl = new ChavesController();
    
    

	@Override
	public void start(Stage stage) throws Exception {
		
		

			
			GridPane formularioChaves = new GridPane();
			GridPane formularioResponsavel = new GridPane();
			GridPane formulariopainel = new GridPane();
	        BorderPane chaPanePrincipal = new BorderPane();
	      

		 Bindings.bindBidirectional(chaControl.chavesProperty(), chaTxtChaves.textProperty());
	        Bindings.bindBidirectional(chaControl.responsavelProperty(), chaTxtResponsaval.textProperty());
	        
	        formularioChaves.add(chaTxtChaves, 0, 1);
	      
	        
	        formularioResponsavel.add(chaTxtResponsaval, 2, 0);


	        formulariopainel.add(new Label("Chave:"), 1,0);
	        formulariopainel.add(new Label("Responsavel:"), 3, 0);
	        formulariopainel.add(formularioChaves,1,2);
	        formulariopainel.add(formularioResponsavel,3,2);
	        formulariopainel.add(chaBtnCadastrar, 4, 2);
	        formulariopainel.add(chaBtnInicio, 6, 2);
	        formulariopainel.add(chaBtnPesquisar, 9, 2);
	        chaPanePrincipal.getStylesheets().add(Objects.requireNonNull(tela.class.getResource("style.css")).toExternalForm());

	        
			chaTitle.getStyleClass().add("tabela de chaves");

			chaPanePrincipal.setTop(formulariopainel);
			chaPanePrincipal.setCenter(chaControl.getTable());
			
			

			
			chaBtnCadastrar.setOnAction(e ->{
				chaControl.adicionar();
			});
			
			
			chaBtnPesquisar.setOnAction(e->{
				chaControl.pesquisarPorNome();
			});
			
			
			chaBtnInicio.setOnAction(e ->{
				getStage().close();
			});

			Scene scn = new Scene(chaPanePrincipal, 1400,800);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(scn);
			stage.show();
			setStage(stage);
		}

		
			
	private void setStage(Stage stage2) {
		this.stage = stage2;
		
	}



	private Stage getStage() {
		return stage;
	}
    
    
}

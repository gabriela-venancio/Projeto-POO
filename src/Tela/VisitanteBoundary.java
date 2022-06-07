package Tela;

import java.security.Principal;
import java.util.Objects;

import Controller.VisitanteController;
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

public class VisitanteBoundary extends Application {

	
private Stage stage;
	//butões da classse visitante

private final TextField visTxtNome = new TextField();
private final TextField visTxtCpf = new TextField();
private final TextField visTxtDestino = new TextField();

private final Button visBtnCadastrar = new Button("Cadastrar");
private final Button visBtnPesquisar = new Button("Pesquisar");
private final Button visBtnLimpar = new Button("Limpar");
private final Button visBtnInicio = new Button("Inicio");

private final Label visLblCpf = new Label("cpf:");
Label visTitle = new Label("Visitantes");

private final VisitanteController visControl = new VisitanteController();


@Override
public void start(Stage stage) throws Exception {
	

	 Bindings.bindBidirectional(visControl.nomeProperty(), visTxtNome.textProperty());
       Bindings.bindBidirectional(visControl.cpfProperty(), visTxtCpf.textProperty());
       Bindings.bindBidirectional(visControl.destinoProperty(), visTxtDestino.textProperty());
     
	
	  BorderPane visPanePrincipal = new BorderPane();
      VBox visPaneConteudo = new VBox();
      GridPane visPaneForm = new GridPane();
      FlowPane visPaneButton = new FlowPane();

      visPanePrincipal.getStylesheets().add(Objects.requireNonNull(tela.class.getResource("style.css")).toExternalForm());

	
  	visTitle.getStyleClass().add("tabela de Visitante");

		
		
		

        visPaneForm.add(new Label("nome"), 0, 0);
        visPaneForm.add(new Label("cpf"), 0, 1);
        visPaneForm.add(new Label("destino"), 0, 2);
        visPaneForm.add(visTxtNome, 1, 0);
        visPaneForm.add(visTxtCpf, 1, 1);
        visPaneForm.add(visTxtDestino, 1, 2);
        
        visPaneForm.setVgap(10);
        visPaneForm.setHgap(15);
        visPaneForm.setAlignment(Pos.CENTER);

        visPaneButton.getChildren().addAll(visBtnCadastrar, visBtnPesquisar, visBtnLimpar,  visBtnInicio);
        visPaneButton.setHgap(10);
        visPaneButton.setVgap(15);
        visPaneButton.setAlignment(Pos.CENTER);

        visPaneConteudo.getChildren().addAll(visTitle, visPaneForm, visPaneButton);
        visPaneConteudo.setSpacing(15);
        visPaneConteudo.setAlignment(Pos.CENTER);
        
        visPanePrincipal.setLeft(visPaneConteudo);
        visPanePrincipal.setCenter(visControl.getTable());
        
        
        visBtnCadastrar.setOnAction(e->{
			visControl.adicionar();
		});

		
		visBtnPesquisar.setOnAction(e->{
			visControl.pesquisarPorNome();
		});
		
		visBtnInicio.setOnAction(e ->{
			getStage().close();
		});
				
        Scene scn = new Scene(visPanePrincipal, 1400, 800);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scn);
		stage.show();
		setStage(stage);
		
}
		


private void setStage(Stage stage2) {
	this.stage = stage;	
}


private Stage getStage() {
	return stage;}
	
	
}

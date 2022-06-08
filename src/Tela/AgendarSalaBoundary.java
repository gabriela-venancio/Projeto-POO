package Tela;

import java.util.Objects;

import Controller.AgendarSalaController;
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

public class AgendarSalaBoundary extends Application{

	
	private Stage stage;

	
	//butões da classse AgendarSala
    private final TextField asTxtMotivo = new TextField();
    private final TextField asTxtResponsavel = new TextField();
    private final TextField asTxtData = new TextField();

    private final Button asBtnCadastrar = new Button("Cadastrar");
    private final Button asBtnPesquisar = new Button("Pesquisar");
    private final Button asBtnInicio = new Button("Inicio");


        private final AgendarSalaController asControl = new AgendarSalaController();

    Label asTitle = new Label("Agenda Sala ");

    

	@Override
	public void start(Stage stage) throws Exception {

 Bindings.bindBidirectional(asControl.motivoProperty(), asTxtMotivo.textProperty());
 Bindings.bindBidirectional(asControl.responsavelProperty(), asTxtResponsavel.textProperty());
 Bindings.bindBidirectional(asControl.dataProperty(), asTxtData.textProperty());	
    
 
 BorderPane asPanePrincipal = new BorderPane();
    VBox asPaneConteudo = new VBox();
    GridPane asPaneForm = new GridPane();
    FlowPane asPaneButton = new FlowPane();
    
     asPanePrincipal.getStylesheets().add(Objects.requireNonNull(tela.class.getResource("style.css")).toExternalForm());

		asTitle.getStyleClass().add("tabela de Visitante");

     
     
    asPaneForm.add(new Label("motivo:"), 0, 0);
    asPaneForm.add(new Label("responsavel:"), 0, 1);
    asPaneForm.add(new Label("data:"), 0, 2);
    asPaneForm.add(asTxtMotivo, 1, 0);
    asPaneForm.add(asTxtResponsavel, 1, 1);
    asPaneForm.add(asTxtData, 1, 2);
    
    asPaneForm.setVgap(10);
    asPaneForm.setHgap(5);
    asPaneForm.setAlignment(Pos.CENTER);

    asPaneButton.getChildren().addAll(asBtnCadastrar, asBtnPesquisar, asBtnInicio);
    asPaneButton.setHgap(50);
    asPaneButton.setVgap(25);
    asPaneButton.setAlignment(Pos.CENTER);

    asPaneConteudo.getChildren().addAll(asTitle, asPaneForm, asPaneButton);
    asPaneConteudo.setSpacing(15);
    asPaneConteudo.setAlignment(Pos.CENTER);
	
    asPanePrincipal.setLeft(asPaneConteudo);
    
    asPanePrincipal.setCenter(asControl.getTable());
    
    asBtnCadastrar.setOnAction(e ->{
		asControl.adicionar();
	});
	
	
	asBtnPesquisar.setOnAction(e->{
		asControl.pesquisarPorNome();
	});
	
	
	asBtnInicio.setOnAction(e ->{
		getStage().close();
	});
	
	
	Scene scn = new Scene(asPanePrincipal, 1400,800);
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
	}}

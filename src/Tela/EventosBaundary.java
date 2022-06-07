package Tela;

import java.util.Objects;

import Controller.EventosController;
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

public class EventosBaundary extends Application{
	public  Stage stage;


    //botoes da classe Evento

     private final TextField eveTxtProximoEvento = new TextField();
    private final TextField eveTxtResponsavel = new TextField();
    private final TextField eveTxtAssunto = new TextField();

    private final Button eveBtnCadastrar = new Button("Cadastrar");
    private final Button eveBtnPesquisar = new Button("Pesquisar");
    private final Button eveBtnLimpar = new Button("Limpar");
    private final Button eveBtnInicio = new Button("Inicio");

    private final Label eveLblResponsavel = new Label("responsavel:");
    Label eveTitle = new Label("eventos");

    private final EventosController eveControl = new EventosController();

	@Override
	public void start(Stage stage) throws Exception {
		
 
        Bindings.bindBidirectional(eveControl.proximoEventoProperty(), eveTxtProximoEvento.textProperty());
        Bindings.bindBidirectional(eveControl.responsavelProperty(), eveTxtResponsavel.textProperty());
        Bindings.bindBidirectional(eveControl.assuntoProperty(), eveTxtAssunto.textProperty());
        
        BorderPane evePanePrincipal = new BorderPane();
        VBox evePaneConteudo = new VBox();
        GridPane evePaneForm = new GridPane();
        FlowPane evePaneButton = new FlowPane();

        evePanePrincipal.getStylesheets().add(Objects.requireNonNull(tela.class.getResource("style.css")).toExternalForm());
		eveTitle.getStyleClass().add("tabela de Eventos");

        
        evePaneForm.add(new Label("ProximoEvento:"), 0, 0);
        evePaneForm.add(new Label("Responsavel:"), 0, 1);
        evePaneForm.add(new Label("Assunto:"), 0, 2);
        evePaneForm.add(eveTxtProximoEvento, 1, 0);
        evePaneForm.add(eveTxtResponsavel, 1, 1);
        evePaneForm.add(eveTxtAssunto, 1, 2);
        
        evePaneForm.setVgap(10);
        evePaneForm.setHgap(5);
        evePaneForm.setAlignment(Pos.CENTER);

        evePaneButton.getChildren().addAll(eveBtnCadastrar, eveBtnPesquisar, eveBtnLimpar,  eveBtnInicio);
        evePaneButton.setHgap(10);
        evePaneButton.setVgap(25);
        evePaneButton.setAlignment(Pos.CENTER);

        evePaneConteudo.getChildren().addAll(eveTitle, evePaneForm, evePaneButton);
        evePaneConteudo.setSpacing(15);
        evePaneConteudo.setAlignment(Pos.CENTER);
        
        evePanePrincipal.setLeft(evePaneConteudo);
        evePanePrincipal.setCenter(eveControl.getTable());
		

		eveBtnCadastrar.setOnAction(e ->{
			eveControl.adicionar();
		});
		
		
		eveBtnPesquisar.setOnAction(e->{
			eveControl.pesquisarPorNome();
		});
		
		
		eveBtnInicio.setOnAction(e ->{
			getStage().close();
		});

		Scene scn = new Scene(evePanePrincipal, 1400,800);
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

package Tela;

import java.util.Objects;

import Controller.telaController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class tela extends Application  {
	public  Stage stgStage;


   
    telaController telac = new telaController();

	private Stage stage;
    
    
     Button menuBtnPesquisarVisitante = new Button("Pesquisar Visitante");
        
        Button menuBtnPesquisarFuncionario = new Button("Pesquisar funcionarios");
        
        Button menuBtnPesquisarChaves = new Button("Pesquisar chaves");
        
        Button menuBtnPesquisarEventos = new Button("Pesquisar eventos");
        
        Button menuBtnPesquisarRonda = new Button("Pesquisar ronda");
        
        Button menuBtnPesquisarAgendar = new Button("Pesquisar agendar sala de reunião");
   
    
    
   


    @Override
    public void start(Stage stage) throws Exception{
        stgStage = stage;
		GridPane menuPanePrincipal = new GridPane();

        
        menuPanePrincipal.getStylesheets().add(Objects.requireNonNull(tela.class.getResource("style.css")).toExternalForm());

        Label menuTitle = new Label("Menu portaria EMS");
        menuTitle.getStyleClass().add("titulo");

       
        



		menuBtnPesquisarAgendar.setOnAction(e->{
			telac.acessaAgendaSala();
		});

		
		menuBtnPesquisarChaves.setOnAction(e->{
			telac.acessaChave();
		});
		
		menuBtnPesquisarEventos.setOnAction(e->{
			telac.acessaEventos();
		});
		
		menuBtnPesquisarFuncionario.setOnAction(e->{
			telac.acessaFuncionario();
		});
		
		menuBtnPesquisarRonda.setOnAction(e->{
			telac.acessaRonda();
		});
		
		menuBtnPesquisarVisitante.setOnAction(e->{
			telac.acessaVisitante();
		});
		

		menuPanePrincipal.setHgap(100);
		menuPanePrincipal.setVgap(70);
		menuPanePrincipal.add(menuTitle, 1, 1, 1, 1);
		menuPanePrincipal.add(menuBtnPesquisarAgendar, 2,1);
		menuPanePrincipal.add(menuBtnPesquisarChaves, 2, 2);
		menuPanePrincipal.add(menuBtnPesquisarEventos, 2, 3);
		menuPanePrincipal.add(menuBtnPesquisarFuncionario, 2, 4);
		menuPanePrincipal.add(menuBtnPesquisarRonda, 2, 5);
		menuPanePrincipal.add(menuBtnPesquisarVisitante, 2, 6);
		
		
		
		
		menuTitle.setEffect(new Lighting());
		
		
		Scene scn = new Scene(menuPanePrincipal, 1400, 800);
		stage.initStyle(StageStyle.UNDECORATED);
		
		stage.setScene(scn);
		stage.show();
		setStage(stage);
    }

  

	public static void main(String[] args) {
		Application.launch(tela.class, args);	}

	public  Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}

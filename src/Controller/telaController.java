package Controller;

import Tela.AgendarSalaBoundary;
import Tela.ChaveBoundary;
import Tela.EventosBaundary;
import Tela.FuncionarioBoundary;
import Tela.RondaBoundary;
import Tela.VisitanteBoundary;
import javafx.stage.Stage;

public class telaController {
	AgendarSalaBoundary agendaSala = new AgendarSalaBoundary();
	ChaveBoundary chave = new ChaveBoundary();
	EventosBaundary eventos = new EventosBaundary();
	FuncionarioBoundary funcionario = new FuncionarioBoundary();
	RondaBoundary ronda = new RondaBoundary();
	VisitanteBoundary visitante= new VisitanteBoundary();
	
	
	public void acessaAgendaSala() {
		try {
			agendaSala.start(new Stage());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void acessaChave() {
		try {
			chave.start(new Stage());
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void acessaEventos() {
		try {
			eventos.start(new Stage());
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public void acessaFuncionario() {
		try {
			funcionario.start(new Stage());
		}catch(Exception e3) {
			e3.printStackTrace();
		}
	}
	
	public void acessaRonda() {
		try {
			ronda.start(new Stage());
		}catch(Exception e4){
			e4.printStackTrace();
		}
	}
	
	public void acessaVisitante() {
		try {
			visitante.start(new Stage());
		}catch(Exception e5) {
			e5.printStackTrace();
		}
	}
}

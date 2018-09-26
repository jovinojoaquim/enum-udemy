package Entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Entidades.enums.NivelTrabalho;

public class Trabalhador {
	private String nome;
	private NivelTrabalho nivel;
	private Double salarioBase;
	private Departamento departamento;
	private List<ContratoData> contratosHora = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public NivelTrabalho getNivel() {
		return nivel;
	}
	public void setNivel(NivelTrabalho nivel) {
		this.nivel = nivel;
	}
	public Double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public List<ContratoData> getContratoHora() {
		return contratosHora;
	}
	
	public Trabalhador() {}
	
	public Trabalhador(String nome, NivelTrabalho nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}
	
	public void adicionarContrato(ContratoData contratoHora) {
		contratosHora.add(contratoHora);
	}
	
	public void removeContrato(ContratoData contratoHora) {
		contratosHora.remove(contratoHora);
	}
	
	public Double rendimento(int ano, int mes) {
		double soma = salarioBase;
		Calendar calendario = Calendar.getInstance();
		for(ContratoData contratos : contratosHora) {
			calendario.setTime(contratos.getData());
			int anoCalendario = calendario.get(Calendar.YEAR);
			int mesCalendario = 1+ calendario.get(Calendar.MONTH);
			if(ano == anoCalendario && mes == mesCalendario) {
				soma +=contratos.valorTotal();
			}	
		}
		return soma;
	}
}

package Entidades;

import java.util.Date;

public class ContratoData {
	private Date data;
	private Double valorPorHora;
	private Integer horas;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getValorPorHora() {
		return valorPorHora;
	}
	public void setValorPorHora(double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	public ContratoData() {
	}
	public ContratoData(Date data, double valorPorHora, Integer horas) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.horas = horas;
	}
	
	public Double valorTotal() {
		return this.valorPorHora*this.horas;
	}
}

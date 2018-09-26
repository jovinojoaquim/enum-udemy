package Entidades.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entidades.ContratoData;
import Entidades.Departamento;
import Entidades.Trabalhador;
import Entidades.enums.NivelTrabalho;

public class Aplicacao {
	public static void main(String[] args) throws ParseException {
		Scanner s = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int mes;
		int ano;
		
		
		System.out.print("Entre com o nome do departamento:");
		String departamento = s.nextLine();
		System.out.println("Dados do Trabalhador");
		System.out.print("Nome:");
		String nome = s.nextLine();
		System.out.println("Nível:");
		String nivel = s.nextLine();
		System.out.println("Salário base");
		double salarioBase = s.nextDouble();

		Trabalhador t = new Trabalhador(nome, NivelTrabalho.valueOf(nivel), salarioBase, new Departamento(departamento));
		
		System.out.println("Quantos contratos para esse trabalhador?");
		int quantidadeContratos = s.nextInt();
		
		for(int i = 0; i< quantidadeContratos; i++) {
			System.out.print("Contrato nº: "+ i);
			System.out.print("Data (DD/MM/AAAA): ");
			Date dataContrato = sdf.parse(s.next());
			System.out.print("Valor Por Hora: ");
			double valorPorHora = s.nextDouble();
			System.out.print("Duração(horas): ");
			int horas = s.nextInt();
			
			ContratoData contrato = new ContratoData(dataContrato, valorPorHora, horas);
			t.adicionarContrato(contrato);
		}
		
		System.out.println("Entre com o mês e o ano para calcular o salário");
		String mesEAno = s.next();
		mes = Integer.parseInt(mesEAno.substring(0, 2));
		ano = Integer.parseInt(mesEAno.substring(3));
		
		System.out.print("Nome: "+ t.getNome());
		System.out.print("Departamento" + t.getDepartamento().getNome());
		System.out.print("Ganhou no mes " + mesEAno +" um valor de " + String.format("%2.f",t.rendimento(ano, mes)));
		s.close();
		
	}
}

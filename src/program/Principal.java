package program;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Exceptions.Businessexceptions;
import entities.Emprestimo;
import entities.ItemBiblioteca;
import entities.ItemEmprestimo;
import entities.Livro;
import entities.Revista;
import entities.Usuario;
import entities.enums.EstatusBibi;

public class Principal {

	public static void main(String[] args) {
		
		DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		
		
		Usuario usuario;
		
		boolean valido = false;

		while (!valido) {
		    try {

		        System.out.println("Insira as informações: ");

		        System.out.println("Nome:");
		        String nome = sc.nextLine();

		        System.out.println("Email:");
		        String email = sc.nextLine();

		        System.out.println("Digite a data de nascimento:");
		        LocalDate nascimento = LocalDate.parse(sc.next(), DTF);

		        usuario = new Usuario(nome, email, nascimento);

		        System.out.println("Digite a data da coleta:");
		        LocalDate emprestimoData = LocalDate.parse(sc.next(), DTF);

		        System.out.println("Digite a data da devolução:");
		        LocalDate devolucao = LocalDate.parse(sc.next(), DTF);

		        System.out.println("Status:");
		        String status = sc.next().toUpperCase();

		        System.out.println("Quantos itens neste empréstimo?");
		        int n = sc.nextInt();

		        Emprestimo emprestimo = new Emprestimo(emprestimoData, devolucao, EstatusBibi.valueOf(status), usuario);

		        ItemBiblioteca item;

		        for (int i = 1; i <= n; i++) {

		            System.out.println("Digite os dados do item " + i);
		            System.out.println("Tipo do item (L/R):");

		            char tipo = sc.next().charAt(0);
		            sc.nextLine();

		            if (tipo == 'L') {

		                System.out.println("Titulo:");
		                String titulo = sc.nextLine();

		                System.out.println("Autor:");
		                String autor = sc.nextLine();

		                System.out.println("Ano da publicação:");
		                int publicacao = sc.nextInt();

		                System.out.println("Quantas páginas:");
		                int paginas = sc.nextInt();

		                item = new Livro(titulo, publicacao, autor, paginas);

		            } else {

		                System.out.println("Titulo:");
		                String titulo = sc.nextLine();

		                System.out.println("Edição:");
		                int edicao = sc.nextInt();

		                System.out.println("Ano da publicação:");
		                int publicacao = sc.nextInt();

		                item = new Revista(titulo, publicacao, edicao);
		            }

		            System.out.println("Dias emprestados:");
		            int dias = sc.nextInt();

		            ItemEmprestimo itemEmprestimo = new ItemEmprestimo(item, dias);
		            emprestimo.adicionarItens(itemEmprestimo);
		        }

		        for (ItemEmprestimo ie : emprestimo.getItens()) {
		            System.out.println("- " + ie.getItens().pegarDescricao());
		            System.out.println("  Dias: " + ie.getDiasEmprestado());
		            System.out.printf("  Multa: R$ %.2f%n", ie.calcularMulta());
		        }

		        valido = true;

		   } catch (Businessexceptions e) {
		        System.out.println("Erro de negócio: " + e.getMessage());
		        sc.nextLine();
		   } catch (Exception e) {
		        System.out.println("Erro nos dados digitados. Tente novamente.");
		        sc.nextLine();
		   }
		}
		sc.close();
	}
}

package br.victorpolicarpo.app;

import br.victorpolicarpo.model.Gerenciador;
import br.victorpolicarpo.model.Pessoa;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CRUD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Gerenciador gerenciador = new Gerenciador();
        boolean continua = true;
        while (continua) {
            System.out.println("------ Cadastro de Pessoas ------");
            System.out.println("""
                    [1] - Cadastrar Pessoa
                    [2] - Listar Pessoas
                    [3] - Remover Pessoa
                    [4] - Atualizar Pessoa
                    [5] - Sair
                    """);
            try {
                System.out.print("Digite o numero da funcionalidade que voce deseja usar: ");
                int respostaUsuario = input.nextInt();
                if (respostaUsuario >= 1 && respostaUsuario <= 5) {
                    switch (respostaUsuario) {
                        case 1:
                            cadastrarPessoa(input, gerenciador);
                            break;
                        case 2:
                            listarPessoas(gerenciador);
                            break;
                        case 3:
                            removerPessoas(gerenciador, input);
                            break;
                        case 4:
                            atualizarDadosPessoa(gerenciador, input);
                            break;
                        case 5:
                            System.out.println("Finalizando execucao do programa...");
                            continua = false;
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("O valor informado nao é um numero ou um valor valido.");
            }
        }
    }
    public static void cadastrarPessoa(Scanner input, Gerenciador gerenciador){
        input.nextLine();
        System.out.println("------ Cadastando Pessoas ------");
        try {
            System.out.print("Digite o nome da pessoa: ");
            String nome = input.nextLine();
            System.out.print("\nDigite a idade da pessoa: ");
            int idade = input.nextInt();
            input.nextLine();
            System.out.print("\nDigite o email da pessoa: ");
            String email = input.nextLine();
            if (nome != null && idade > 0 && email != null){
                Pessoa pessoa = new Pessoa(nome, idade, email);
                gerenciador.adicionar(pessoa);
            } else {
                System.out.println("Nenhum dos valores informados podem ser nulo. Tente novamente. ");
            }
        } catch (InputMismatchException | IllegalArgumentException e){
            System.out.println("O valor informado nao é um tipo valido.");
            input.nextLine();
        }

    }
    public static void listarPessoas(Gerenciador gerenciador){
        System.out.println("------ Listando todas pessoas cadastradas ------");
        gerenciador.listar();

    }

    public static void removerPessoas(Gerenciador gerenciador, Scanner input) {
        System.out.println("------ Removendo Pessoas.. ------");
        gerenciador.listar();
        System.out.print("Digite o id da pessoa no qual voce quer remover: ");
        int respostaUsuario = input.nextInt();
        if (respostaUsuario >= 0) {
            gerenciador.remover(respostaUsuario);
        } else {
            System.out.println("O valor informado nao outro tipos de dados alem do numero real. ");
        }
    }
    public static void atualizarDadosPessoa(Gerenciador gerenciador, Scanner input){
        System.out.println("------ Atualizando dados de pessoa ------");
        gerenciador.listar();
        System.out.print("Digite o id da pessoa no qual voce quer atualizar: ");
        int respostaUsuario = input.nextInt();
        if (respostaUsuario >= 0) {
            gerenciador.atualizar(respostaUsuario, input);
        } else {
            System.out.println("O valor informado nao outro tipos de dados alem do numero real. ");
        }

    }

}

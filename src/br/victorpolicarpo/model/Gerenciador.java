package br.victorpolicarpo.model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Gerenciador implements GerenciadorInterface {
    public ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();

    @Override
    public void adicionar(Pessoa pessoa){
        listaPessoas.add(pessoa);
        System.out.printf("Dados de %s foram adicionados com sucesso!\n", pessoa.getNome());
    }
    @Override
    public void listar(){
        if (listaPessoas.isEmpty()){
            System.out.println("A lista de pessoas cadastrada esta vazia.");
            return;
            }
        System.out.println("Lista: ");
        for(int i = 0; i<listaPessoas.size(); i++) {
            System.out.printf("Id: %s | Nome: %s\n", i, listaPessoas.get(i).getNome());


        }}

    @Override
    public void remover(int indice){
        if (listaPessoas.isEmpty()){
            System.out.println("A lista de pessoas cadastradas esta vazia.");
            return;
        }

        if (indice <= listaPessoas.size() && indice >= 0){
            System.out.printf("Removendo %s\n", listaPessoas.get(indice).getNome());
            listaPessoas.remove(indice);
        } else {
            System.out.println("O valor informado nao esta dentro do tamanho da lista.");
        }
    }
    @Override
    public void atualizar(int indice, Scanner input){
        if (listaPessoas.isEmpty()){
            System.out.println("A lista de pessoas cadastradas esta vazia.");
            return;
        }
        System.out.printf("Editando %s\n", listaPessoas.get(indice).getNome());
        boolean continua = true;
        while (continua) {
            boolean valido = true;
            int escolha = 0;
            System.out.println("""
                [1] - alterar nome
                [2] - alterar idade
                [3] - alterar email
                [4] - sair
                """);

            try {
                System.out.print("Digite o numero da funcionalidade que voce deseja usar: ");
                int respostaUsuario = input.nextInt();
                escolha = respostaUsuario;
                input.nextLine();
                if (respostaUsuario > 4 || respostaUsuario < 1){
                    valido = false;
                    throw new IllegalArgumentException();
                }

            } catch (InputMismatchException | IllegalArgumentException e){
                System.out.println("O valor informado nao é um valor valido ou nao esta entre 1 a 4!");
            }
            switch (escolha) {
                case 1:
                    System.out.println("Alterando o nome");
                    System.out.println("Nome atual: "+listaPessoas.get(indice).getNome());
                    System.out.print("Digite o novo nome: ");
                    String nome = input.nextLine();
                    listaPessoas.get(indice).setNome(nome);
                    System.out.printf("Novo nome: %s\n", listaPessoas.get(indice).getNome());
                    break;
                case 2:
                    System.out.println("Alterando a idade");
                    System.out.println("Idade atual: "+listaPessoas.get(indice).getIdade());
                    System.out.print("Digite a nova idade: ");
                    int idade = input.nextInt();
                    input.nextLine();
                    listaPessoas.get(indice).setIdade(idade);
                    System.out.printf("Nova idade: %s\n", listaPessoas.get(indice).getIdade());
                    break;
                case 3:
                    System.out.println("Alterando o email");
                    System.out.println("E-mail atual: "+listaPessoas.get(indice).getEmail());
                    System.out.print("Digite o novo email: ");
                    String email = input.nextLine();
                    listaPessoas.get(indice).setEmail(email);
                    System.out.printf("Novo E-mail: %s\n", listaPessoas.get(indice).getEmail());
                    break;
                case 4:
                    System.out.println("Finalizando alteracoes...");
                    continua = false;
                    break;
            }
        }

    }
}

package br.victorpolicarpo.model;

import java.util.Scanner;

public interface GerenciadorInterface {
    void adicionar(Pessoa pessoa);
    void listar();
    void remover(int indice);
    void atualizar(int indice, Scanner input);
}

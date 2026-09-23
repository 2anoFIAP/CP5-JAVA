// Guilherme de Araujo Moreira RM: 561848
// Joao Vitor Parizotto Rocha RM: 562719
// Leonardo Silva Pinto RM: 564929
// Samuel Enzo RM: 564391
package br.com.fiap.view;

import br.com.fiap.controller.FilmeController;

import javax.swing.*;
import java.util.Scanner;

public class FilmeView {
    static void main() {
        int opcao = 0, codigo;
        String titulo, genero, produtora;
        Scanner scan = new Scanner(System.in);
        FilmeController filmeController = new FilmeController();
        while(opcao != 5){
            try {
                System.out.println("====== MENU PRÍNCIPAL =====");
                System.out.println("Selecione uma das opções de manipulção de filme:" +
                        "\n1.Inserir" +
                        "\n2.Alterar" +
                        "\n3.Excluir" +
                        "\n4.Listar todos" +
                        "\n5.Encerrar programa");
                switch (opcao){
                    case 1:
                        System.out.println("Informe o título do filme");
                        titulo = scan.nextLine();
                        System.out.println("Informe o gênero do filme");
                        genero = scan.nextLine();
                        System.out.println("Informe a produtora do filme");
                        produtora = scan.nextLine();
                        System.out.println(filmeController.inserirFilme(titulo, genero, produtora));
                        break;
                    case 2:
                        System.out.println("Informe o novo código do filme");
                        codigo = scan.nextInt();
                        System.out.println("Informe o novo título do filme");
                        titulo = scan.nextLine();
                        System.out.println("Informe o novo gênero do filme");
                        genero = scan.nextLine();
                        System.out.println("Informe a novo produtora do filme");
                        produtora = scan.nextLine();
                        System.out.println(filmeController.alterarFilme(codigo,titulo,genero,produtora));
                        break;
                    case 3:
                        System.out.println("Informe o código do filme que deseja retirar do cátalogo");
                        codigo = scan.nextInt();
                        System.out.println(filmeController.excluirFilme(codigo));
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, filmeController.listarTodosFilmes());
                        break;
                    case 5:
                        System.out.println("Finalizando programa...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Insira somente valores númericos!");
            } catch (Exception e) {
                System.out.println("Erro! " + e.getMessage());
            }
        }
        System.out.println("Programa finalizado!\nVolte sempre!");

    }
}

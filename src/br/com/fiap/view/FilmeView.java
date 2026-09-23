// Guilherme de Araujo Moreira RM: 561848
// Joao Vitor Parizotto Rocha RM: 562719
// Leonardo Silva Pinto RM: 564929
// Samuel Enzo RM: 564391

package br.com.fiap.view;

import br.com.fiap.controller.FilmeController;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class FilmeView {
    static void main() {
        Scanner scan = new Scanner(System.in);
        FilmeController filmeController = new FilmeController();

        int opcao, codigo;
        String titulo, genero, produtora, continuar = "S";
        while (continuar.equalsIgnoreCase("S")) {
            try {
                System.out.println("====== MENU PRINCIPAL =====");
                System.out.println("Selecione uma das opções:");
                System.out.println("1. Inserir");
                System.out.println("2. Alterar");
                System.out.println("3. Excluir");
                System.out.println("4. Listar todos");

                opcao = scan.nextInt();
                scan.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.println("Informe o título do filme:");
                        titulo = scan.nextLine();

                        System.out.println("Informe o gênero do filme:");
                        genero = scan.nextLine();

                        System.out.println("Informe a produtora do filme:");
                        produtora = scan.nextLine();

                        System.out.println(
                                filmeController.inserirFilme(
                                        titulo,
                                        genero,
                                        produtora
                                )
                        );
                        break;
                    case 2:
                        System.out.println(
                                "Informe o código do filme que deseja alterar:"
                        );
                        codigo = scan.nextInt();
                        scan.nextLine();

                        System.out.println("Informe o novo título do filme:");
                        titulo = scan.nextLine();

                        System.out.println("Informe o novo gênero do filme:");
                        genero = scan.nextLine();

                        System.out.println("Informe a nova produtora do filme:");
                        produtora = scan.nextLine();

                        System.out.println(
                                filmeController.alterarFilme(
                                        codigo,
                                        titulo,
                                        genero,
                                        produtora
                                )
                        );
                        break;
                    case 3:
                        System.out.println(
                                "Informe o código do filme que deseja excluir:"
                        );

                        codigo = scan.nextInt();
                        scan.nextLine();

                        System.out.println(
                                filmeController.excluirFilme(codigo)
                        );

                        break;
                    case 4:
                        JOptionPane.showMessageDialog(
                                null,
                                filmeController.listarTodosFilmes()
                        );
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                System.out.println(
                        "Deseja continuar? (S/N)"
                );
                continuar = scan.nextLine();
            } catch (Exception e) {
                System.out.println(
                        "Erro! " + e.getMessage()
                );
                scan.nextLine();
            }
        }
        System.out.println(
                "Programa finalizado!\nVolte sempre!"
        );
        scan.close();
    }
}
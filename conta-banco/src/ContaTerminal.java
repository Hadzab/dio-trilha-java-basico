import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Olá, seja bem-vindo ao nosso sistema de banco Java! Por favor, insira o número de sua Agência:");
        String agencia = leitura.nextLine();

        //dados do cliente
        System.out.println("Certo, agora por favor, insira o seu nome completo:");
        String nome = leitura.nextLine();

        System.out.println("Perfeito, agora por favor, insira o número de sua conta:");
        String numeroConta = leitura.nextLine();

        //dados da conta
        System.out.println("\nSeja muito bem-vindo(a), " + nome + "! Sua conta foi criada com sucesso.");
        System.out.println("Acompanhe abaixo os dados de sua conta:");
        System.out.println("Agência: " + agencia);
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Nome do Cliente: " + nome);

        double saldo = 50.00;  // Saldo inicial

        boolean continuar = true;

        //menu principal
        while (continuar) {
            System.out.println("\nMenu Principal:");
            System.out.println("1 - Conferir saldo bancário");
            System.out.println("2 - Realizar operação (transferência ou depósito)");
            System.out.println("3 - Sair");

            int opcao = leitura.nextInt();

            if (opcao == 1) {
                System.out.printf("Seu saldo bancário atual é: R$ %.2f%n", saldo);

            } else if (opcao == 2) {
                boolean operando = true;
                while (operando) {
                    System.out.println("\nSelecione a operação:");
                    System.out.println("1 - Transferência");
                    System.out.println("2 - Depósito");
                    System.out.println("3 - Voltar ao menu principal");

                    int escolha = leitura.nextInt();
                    leitura.nextLine();  // Limpa buffer

                    if (escolha == 1) {
                        System.out.println("Certo " + nome + ", insira a quantia que deseja transferir:");
                        double quantia = leitura.nextDouble();
                        leitura.nextLine();

                        if (quantia > saldo) {
                            System.out.println("Saldo insuficiente para realizar a transferência.");
                        } else {
                            saldo -= quantia;
                            System.out.println("Agora, insira o nome completo do destinatário:");
                            String nomeTransferencia = leitura.nextLine();
                            System.out.println("Transferência de R$ " + quantia + " para " + nomeTransferencia + " realizada com sucesso!");
                        }

                    } else if (escolha == 2) {
                        System.out.println("Certo " + nome + ", insira a quantia que deseja depositar:");
                        double quantia = leitura.nextDouble();
                        leitura.nextLine();

                        saldo += quantia;
                        System.out.println("Depósito de R$ " + quantia + " realizado com sucesso!");

                    } else if (escolha == 3) {
                        System.out.println("Voltando ao menu principal...");
                        operando = false;
                    } else {
                        System.out.println("Opção inválida. Por favor, escolha 1, 2 ou 3.");
                    }
                }

            } else if (opcao == 3) {
                System.out.println("Obrigado por utilizar nosso banco. Até logo!");
                continuar = false;

            } else {
                System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }

        leitura.close();
    }
}

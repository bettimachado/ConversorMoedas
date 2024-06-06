import java.io.IOException;
import java.util.Scanner;

public class MenuPrincipal {
    public void exibir() throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        int escolha;
        do {

            String asteriscos = "*".repeat(43);
            System.out.println(asteriscos);

            System.out.println("Bem vindo ao Conversor de Moedas!\n");
            System.out.println("1) Dólar (USD)           ==> Peso argentino (ARS)");
            System.out.println("2) Peso argentino (ARS)  ==> Dólar (USD)");
            System.out.println("3) Dólar (USD)           ==> Real brasileiro (BRL)");
            System.out.println("4) Real brasileiro (BRL) ==> Dólar (USD)");
            System.out.println("5) Dólar (USD)           ==> Euro (EUR)");
            System.out.println("6) Euro (EUR)            ==> Dólar (USD)");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida: ");
            System.out.println(asteriscos);
            escolha = leitura.nextInt();

            switch (escolha) {
                case 1:
                    ConversorDeMoeda.converterMoeda("USD", "ARS", leitura);
                    break;
                case 2:
                    ConversorDeMoeda.converterMoeda("ARS", "USD", leitura);
                    break;

                case 3:
                    ConversorDeMoeda.converterMoeda("USD", "BRL", leitura);
                    break;

                case 4:
                    ConversorDeMoeda.converterMoeda("BRL", "USD", leitura);
                    break;

                case 5:
                    ConversorDeMoeda.converterMoeda("USD", "EUR", leitura);
                    break;

                case 6:
                    ConversorDeMoeda.converterMoeda("EUR", "USD", leitura);
                    break;

                case 7:
                    System.out.println("Saindo do conversor de moedas...");
                    break;
                default:
                    String tracinhos = "-".repeat(33);
                    System.out.println(tracinhos);
                    System.out.println("Opção inválida. Opções de 1 a 7.");
                    System.out.println(tracinhos);
                    break;
                    //return;
            }
            if (escolha != 7) {
                System.out.println("\nPressione Enter para continuar");
                leitura.nextLine();
                leitura.nextLine();
            }
        } while (escolha!=7);
        leitura.close();
    }
}

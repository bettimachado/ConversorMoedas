import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ConversorDeMoeda {
    public static void converterMoeda (String moedaEntrada, String moedaEscolha, Scanner leitura) throws IOException, InterruptedException {
        BuscandoApi buscandoApi = new BuscandoApi();
        double taxaDeCambio = buscandoApi.obterTaxaDeCambio(moedaEntrada, moedaEscolha);
        // acrescentar o throws para o obterTaxaDeCambio, com o add exceptions to method signature

        if (taxaDeCambio < 0) {
            return;

        }
        System.out.println("Digite o valor em " + moedaEntrada + ": ");
        double valor = leitura.nextDouble();
        double valorConvertido = valor * taxaDeCambio;
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String valorFormatadoEntrada = getMoedaFormatada(valor, moedaEntrada);
        String valorFormatadoSaida = getMoedaFormatada(valorConvertido, moedaEscolha);


        System.out.println("-----------------Resultado-----------------");
        System.out.println(valorFormatadoEntrada + " é igual a " + valorFormatadoSaida);
        System.out.println("Taxa de câmbio utilizada: " + moedaEntrada +" " + taxaDeCambio);
        System.out.println("-------------------------------------------");

    }
        private static String getMoedaFormatada(double valor, String moeda){
            DecimalFormat df = new DecimalFormat("#,##0.00");
            switch (moeda){
                case "BRL":
                    return "(BRL) Real R$ " + df.format(valor);
                case "USD":
                    return "(USD) Dolar $ "  + df.format(valor);
                case "ARS":
                        return "(ARS) Peso Argentino $ "  + df.format(valor);
                case "EUR":
                    return "(EUR) Euro € "  + df.format(valor);
                default:
                    return df.format(valor) + "" + moeda;
            }
        }
    }

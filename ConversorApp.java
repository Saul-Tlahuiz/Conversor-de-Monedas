import java.io.IOException;
import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsumoAPI consumo = new ConsumoAPI();
        System.out.println("Escriba el código de la moneda que desea consultar:");

        try{
            var codigoMoneda = lectura.nextLine();
            Monedas moneda = consumo.buscarMoneda(codigoMoneda);
            System.out.println(moneda);
            GeneradorArchivo generador = new GeneradorArchivo();
            generador.guardarJson(moneda);
        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicación...");
        }

    }
}
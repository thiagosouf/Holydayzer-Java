import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Verificar Feriados de 2023");
            System.out.println("================");
            String data = escolherData(sc);
            Feriados feriados = new Feriados();
            if (data.equals("00")) {
                listarFeriados(feriados);
                return;
            }
            String feriado = verificaFeriado(data, feriados);
            if (feriado.length() > 0) {
                System.out.println(feriado);
            } else {
                System.out.println("Não existe feriado nessa data");
            }

        } catch (RuntimeException e) {
            System.out.println("Não existe feriado nessa data");
        }
    }

    private static void listarFeriados(Feriados feriados) {
        for (int i = 0; i < feriados.dataFeriados.length; i++) {
            System.out.println(feriados.dataFeriados[i] + " => " + feriados.nomeFeriados[i]);
        }
    }

    private static String escolherData(Scanner sc) {
        System.out.println("Entre com uma data no formato 'DD/MM/AAAA': ");
        String data = sc.nextLine();
        return data;
    }

    private static String verificaFeriado(String data, Feriados feriados) {
        String feriado = null;
        for (int i = 0; i < feriados.dataFeriados.length; i++) {
            if (data.equals(feriados.dataFeriados[i])) {
                feriado = feriados.nomeFeriados[i];
            }
        }
        return feriado;
    }
}

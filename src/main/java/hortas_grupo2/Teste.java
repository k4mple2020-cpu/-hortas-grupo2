package hortas_grupo2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Diogo Ferrira 51084
 * @author Ricardo Sousa 51364
 */
public class Teste {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    GestorHorta gestor = new GestorHorta();
    int userChoice = 0;

    while (true) {
      System.out.println("Escolha uma opção:");
      System.out.println("1- Registar Horta");
      System.out.println("2- Registar Talhao");
      System.out.println("3- Registar Plantação");
      System.out.println("4- Imprimir Plantação");
      System.out.println("5- Imprimir área de uma horta");
      System.out.println("6- Imprimir maior horta");
      System.out.println("7- Imprimir hortas de um dado tipo");
      System.out.println("8- Fechar o programa");
      try {
        userChoice = input.nextInt();
        input.nextLine();
      } catch (InputMismatchException e) {
        System.out.println("dnsajfasndkf");
        input.nextLine();
        continue;
      }

      switch (userChoice) {
        case 1: {
          System.out.println("Qual é o nome da Horta?");
          String nomeH = input.nextLine();
          System.out.println("Qual é a localização da horta?");
          String localizacaoH = input.nextLine();
          gestor.registarHorta(nomeH, localizacaoH);
          break;
        }

        case 2: {
          System.out.println("Qual é o nome da Horta?");
          String nomeHH = input.nextLine();
          System.out.println("Qual é o número do talhão?");
          int numeroT = input.nextInt();
          input.nextLine();
          System.out.println("Qual é a área do talhão? (em metros quadrados");
          int areaT = input.nextInt();
          input.nextLine();
          gestor.registarTalhao(nomeHH, numeroT, areaT);
          break;
        }

        case 3: {
          System.out.println("Qual é o nome da Horta?");
          String nomeHorta = input.nextLine();
          System.out.println("Qual é o número do talhão?");
          int numeroTT = input.nextInt();
          input.nextLine();
          System.out.println("Qual é a data da sementeira? (introduzir tipo dd/mm/yyyy)");
          String dateString = input.nextLine();
          LocalDate dataS = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
          System.out.println("Qual é o tipo de cultura?");
          String tipoC = input.nextLine();
          gestor.registarPlantacao(nomeHorta, numeroTT, dataS, tipoC);
          break;
        }

        case 4: {
          System.out.println("Qual é a horta? (introduza o nome)");
          String hortaNome = input.nextLine();
          gestor.imprimirPlantacao(hortaNome);
          break;
        }

        case 5: {
          System.out.println("Qual é a horta?");
          String hortaNom = input.nextLine();
          gestor.imprimirAreaHorta(hortaNom);
          break;
        }

        case 6: {
          gestor.imprimirMaiorHorta();
          break;
        }

        case 7: {
          System.out.println("Qual é o tipo de sementeira?");
          String tipoSem = input.nextLine();
          gestor.imprimirHortaHasTipo(tipoSem);
          break;
        }

        case 8: {
          System.exit(0);
        }

        default:
          System.out.println("Por favor escolha um número entre 1 e 8");
          break;
      }
    }

  }

}

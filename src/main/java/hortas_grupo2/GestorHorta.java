package hortas_grupo2;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestorHorta {

  private ArrayList<Horta> hortas;

  public GestorHorta() {
    hortas = new ArrayList<Horta>();
  }

  /**
   * @param nome
   * @param localizacao
   */
  public void registarHorta(String nome, String localizacao) {
    hortas.add(new Horta(nome, localizacao));
  }

  public Horta procurarHorta(String nome) {
    for (Horta horta : hortas) {
      if (horta.getNome().equalsIgnoreCase(nome)) {
        return horta;
      }
    }
    System.out.println("Horta não encontrada");
    return null;
  }

  /**
   * @param nomeH
   * @param numero
   * @param area
   */
  public void registarTalhao(String nomeH, int numero, int area) {
    Horta horta = procurarHorta(nomeH);
    if (horta != null) {
      horta.adicionarTalhao(numero, area);
    }
  }

  /**
   * @param nomeH
   * @param numeroT
   * @param dataSem
   * @param tipo
   */
  public void registarPlantacao(String nomeH, int numeroT, LocalDate dataSem, String tipo) {
    Horta horta = procurarHorta(nomeH);
    if (horta != null) {
      Talhao talhao = horta.procurarTalhao(numeroT);
      if (talhao != null) {
        talhao.adicionarPlantacao(dataSem, tipo);
      }
    }
  }

  /**
   * @param nomeH   nome da horta
   * @param numeroT numero do talhão
   */
  public void imprimirPlantacao(String nomeH) {
    Horta horta = procurarHorta(nomeH);
    if (horta != null) {
      horta.imprimirPlantacoes();
    }
  }

  /**
   * @param nomeH nome da horta
   *              imprime a area da horta
   */
  public void imprimirAreaHorta(String nomeH) {
    Horta horta = procurarHorta(nomeH);
    if (horta != null) {
      horta.imprimirAreaTotal();
    }
  }

  /**
   * imprime o nome e tamanho da maior horta
   */
  public void imprimirMaiorHorta() {
    int biggest = 0;
    String maiorNome = null;
    for (Horta horta : hortas) {
      if (horta.calcularAreaTotal() > biggest) {
        maiorNome = horta.getNome();
        biggest = horta.calcularAreaTotal();
      }
    }
    Horta maiorHorta = procurarHorta(maiorNome);
    if (maiorHorta != null) {
      System.out.println("Nome da maior horta: " + maiorNome + "\n Área: " + biggest);
    }
  }

  /**
   * @param tipo tipo a verificar
   */
  public void imprimirHortaHasTipo(String tipo) {
    for (Horta horta : hortas) {
      if (horta.verificarTipoTalhoes(tipo)) {
        System.out.println(horta.getNome());
      }
    }
  }
}

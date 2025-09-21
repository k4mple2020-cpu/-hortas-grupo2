package hortas_grupo2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Talhao {

  private int numero;
  private int area;
  ArrayList<Plantacao> plantacoes;

  /**
   * @param numero número do talhão
   * @param area   área do talhão em metros quadrados
   */
  public Talhao(int numero, int area) {
    this.numero = numero;
    this.area = area;
    plantacoes = new ArrayList<Plantacao>();
  }

  /**
   * @param data data da plantação
   * @param tipo tipo de cultura
   *             cria e adiciona uma nova plantação ao talhão
   */
  public void adicionarPlantacao(LocalDate data, String tipo) {
    plantacoes.add(new Plantacao(data, tipo));
  }

  /**
   * imprime todas as plantações do talhão
   */
  public void imprimirPlantacoes() {
    for (Plantacao plantacao : plantacoes) {
      System.out.println(plantacao);
    }
  }

  /**
   * @return devolve a area em metros quadrados
   */
  public int getArea() {
    return area;
  }

  /**
   * @return devolve o numero do talhão
   */
  public int getNumero() {
    return numero;
  }

  /**
   * @param tipo Tipo de plantacao a verificar
   * @return true se tiver o tipo de plantacao, false se não tiver
   */
  public boolean hasTipo(String tipo) {
    for (Plantacao plantacao : plantacoes) {
      if (plantacao.getTipoCultura().equalsIgnoreCase(tipo)) {
        return true;
      }
    }
    return false;
  }

}

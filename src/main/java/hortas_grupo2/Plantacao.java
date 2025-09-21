package hortas_grupo2;

import java.time.LocalDate;

public class Plantacao {
  private LocalDate dataSementeira;
  private String tipoCultura;

  public Plantacao(LocalDate dataSementeira, String tipoCultura) {
    this.dataSementeira = dataSementeira;
    this.tipoCultura = tipoCultura;
  }

  public String toString() {
    return "[Data de sementeira: " + dataSementeira + ", Tipo de cultura: " + tipoCultura + "]";
  }

  public String getTipoCultura() {
    return tipoCultura;
  }
}

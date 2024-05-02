import java.util.concurrent.TimeUnit;

/**
 * <h3>Smart TV</h3>
 * 
 * Esta classe cria uma TV Smart
 * 
 * @author José Eduardo
 * @version 1.0.0
 * @since 29/04/2024
 */
public class SmartTv {
  private boolean isOn = false;
  private int channel = 1;
  private int volume = 25;

  private final int WIDTH = 50;
  private final int HEIGHT = 10;
  private final String border = "||";

  /**
   * Este método é utilizado para ligar e desligar a TV. Não há retorno.
   */
  public void toggleOnOff() {
    this.isOn = !this.isOn;

    String state = this.isOn ? "Ligando..." : "Desligando...";

    this.render(17, 5, state);

    if (this.isOn) {
      this.render(36, 2, "Canal " + channel);
    }
  }

  /**
   * Este método é utilizado para aumentar o volume da TV. Não há retorno.
   */
  public void increaseVolume() {
    if (this.isOn && this.volume >= 0 && this.volume <= 100) {
      this.volume++;

      printVolume();
    }
  }

  /**
   * Este método é utilizado para diminuir o volume da TV. Não há retorno.
   */
  public void decreaseVolume() {
    if (this.isOn && this.volume >= 0 && this.volume <= 100) {
      this.volume--;

      printVolume();
    }
  }

  /**
   * Este método é utilizado para mudar o canal de TV através do número do canal.
   * Não há retorno.
   * 
   * @param channel número do canal de TV
   * @return void
   */
  public void changeChannel(int channel) {
    if (this.isOn && this.channel > 0) {
      this.channel = channel;

      this.render(36, 2, "Canal " + channel);
    }
  }

  /**
   * Este método é utilizado para ir para o próximo canal. Não há retorno.
   */
  public void increaseChannel() {
    if (this.isOn) {
      this.channel++;

      this.render(36, 2, "Canal " + channel);
    }
  }

  /**
   * Este método é utilizado para voltar para o canal anterior. Não há retorno.
   */
  public void decreaseChannel() {
    if (this.isOn && (this.channel - 1) > 0) {
      this.channel--;

      this.render(36, 2, "Canal " + channel);
    }
  }

  /**
   * Este método é utilizado para imprimir o quadro da TV vazio. Nâo há retorno.
   */
  public void render() {
    clearConsole();
    printNoContent();
    printPowerButton();
    delay();
  }

  /**
   * Este método é utilizado para imprimir o quadro da TV com conteúdo. Não há
   * retorno.
   * 
   * @param x       posição do conteúdo na horizontal
   * @param y       posição do conteúdo na vertical
   * @param content conteúdo a ser impresso na TV
   * @return void
   */
  public void render(int x, int y, String content) {
    clearConsole();
    printContent(x, y, content);
    printPowerButton();
    delay();
  }

  /**
   * Esté método é utilizado para "limpar" o terminal.
   * <b>Nota:</b> O método apenas imprimi no terminal os caracteres de controle
   * "\r\n" repetidas vezes.
   */
  private void clearConsole() {
    System.out.println("\r\n".repeat(this.HEIGHT));
  }

  /**
   * Este método imprimi apenas a tela da TV sem nenhum conteúdo. Não há retorno.
   */
  private void printNoContent() {
    int screenLength = this.WIDTH - (this.border.length() * 2);

    this.printBorder();

    for (int row = 1; row <= this.HEIGHT; row++) {
      System.out.println(this.border + " ".repeat(screenLength) + this.border);
    }
  }

  /**
   * Este método imprimi apenas a tela da TV com conteúdo informado. Não há
   * retorno.
   * 
   * @param x       posição do conteúdo na horizontal
   * @param y       posição do conteúdo na vertical
   * @param content conteúdo a ser impresso na TV
   * @return void
   */
  private void printContent(int x, int y, String content) {
    int screenLength = this.WIDTH - (this.border.length() * 2);

    this.printBorder();

    for (int row = 1; row < this.HEIGHT; row++) {
      if (row == y) {
        this.printRowContent(x, content, screenLength);
      }

      System.out.println(this.border + " ".repeat(screenLength) + this.border);
    }
  }

  /**
   * Este método imprimi as bordas horizontais da TV.
   */
  private void printBorder() {
    System.out.println("=".repeat(this.WIDTH));
  }

  /**
   * Este método imprimi linha a linha do conteúdo informado. Não há
   * retorno.
   * 
   * @param position     posição do conteúdo na linha
   * @param content      conteúdo a ser impresso na linha
   * @param screenLength comprimento da tela da TV
   * @return void
   */
  private void printRowContent(int position, String content, int screenLength) {
    String positionedContent = " ".repeat(position) + content;

    int rightBorderPosition = screenLength - content.length() - position;
    String rightBorder = " ".repeat(rightBorderPosition) + this.border;

    System.out.println(this.border + positionedContent + rightBorder);
  }

  /**
   * Este método imprimi a borda inferior da TV com o botão de ligar/desligar. Não
   * há retorno.
   */
  private void printPowerButton() {
    int screenLength = this.WIDTH - (this.border.length() * 2);
    String powerButton = this.isOn ? "(O) " : "( ) ";

    this.printBorder();
    this.printRowContent(41, powerButton, screenLength);
    this.printBorder();
  }

  /**
   * Este método gera um atraso de um segundo. Não há retorno.
   */
  private void delay() {
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Este método imprimi a barra de volume na tela da TV. Não há retorno.
   */
  private void printVolume() {
    String dotted = ".".repeat(this.volume / 5);
    String content = "Volume: " + this.volume + ": " + dotted;

    this.render(2, 9, content);
  }
}

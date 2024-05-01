import java.util.concurrent.TimeUnit;

public class SmartTv {
  private boolean isOn = false;
  private int channel = 1;
  private int volume = 25;

  private final int WIDTH = 50;
  private final int HEIGHT = 10;
  private final String border = "||";

  public void toggleOnOff() {
    this.isOn = !this.isOn;

    String state = this.isOn ? "Ligando..." : "Desligando...";

    this.render(17, 5, state);

    if (this.isOn) {
      this.render(36, 2, "Canal " + channel);
    }
  }

  public void increaseVolume() {
    if (this.isOn && this.volume >= 0 && this.volume <= 100) {
      this.volume++;

      printVolume();
    }
  }

  public void decreaseVolume() {
    if (this.isOn && this.volume >= 0 && this.volume <= 100) {
      this.volume--;

      printVolume();
    }
  }

  public void changeChannel(int channel) {
    if (this.isOn && this.channel > 0) {
      this.channel = channel;

      this.render(36, 2, "Canal " + channel);
    }
  }

  public void increaseChannel() {
    if (this.isOn) {
      this.channel++;

      this.render(36, 2, "Canal " + channel);
    }
  }

  public void decreaseChannel() {
    if (this.isOn && (this.channel - 1) > 0) {
      this.channel--;

      this.render(36, 2, "Canal " + channel);
    }
  }

  public void render() {
    clearConsole();
    printNoContent();
    printPowerButton();
    delay();
  }

  public void render(int x, int y, String content) {
    clearConsole();
    printContent(x, y, content);
    printPowerButton();
    delay();
  }

  private void clearConsole() {
    System.out.println("\r\n".repeat(this.HEIGHT));
  }

  private void printNoContent() {
    int screenLength = this.WIDTH - (this.border.length() * 2);

    this.printBorder();

    for (int row = 1; row <= this.HEIGHT; row++) {
      System.out.println(this.border + " ".repeat(screenLength) + this.border);
    }
  }

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

  private void printBorder() {
    System.out.println("=".repeat(this.WIDTH));
  }

  private void printRowContent(int position, String content, int screenLength) {
    String positionedContent = " ".repeat(position) + content;

    int rightBorderPosition = screenLength - content.length() - position;
    String rightBorder = " ".repeat(rightBorderPosition) + this.border;

    System.out.println(this.border + positionedContent + rightBorder);
  }

  private void printPowerButton() {
    int screenLength = this.WIDTH - (this.border.length() * 2);
    String powerButton = this.isOn ? "(O) " : "( ) ";

    this.printBorder();
    this.printRowContent(41, powerButton, screenLength);
    this.printBorder();
  }

  private void delay() {
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void printVolume() {
    String dotted = ".".repeat(this.volume / 5);
    String content = "Volume: " + this.volume + ": " + dotted;

    this.render(2, 9, content);
  }
}

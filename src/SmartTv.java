public class SmartTv {
  private boolean isOn = false;
  private int channel = 1;
  private int volume = 25;

  public void toggleOnOff() {
    this.isOn = !this.isOn;

    String state = this.isOn ? "Ligada" : "Desligada";

    this.showScreen(5, 20, state);
  }

  public void increaseVolume() {
    if (this.isOn && this.volume >= 0 && this.volume <= 100) {
      this.volume++;

      System.out.println("Volume: " + this.volume);
    }
  }

  public void decreaseVolume() {
    if (this.isOn && this.volume >= 0 && this.volume <= 100) {
      this.volume--;

      System.out.println("Volume: " + this.volume);
    }
  }

  public void changeChannel(int channel) {
    if (this.isOn && this.channel > 0) {
      this.channel = channel;
      System.out.println("Canal " + channel);
    }
  }

  public void increaseChannel() {
    if (this.isOn) {
      this.channel++;
      System.out.println("Canal " + this.channel);
    }
  }

  public void decreaseChannel() {
    if (this.isOn && this.channel > 0) {
      this.channel++;
      System.out.println("Canal " + this.channel);
    }
  }

  private void showScreen(int vPos, int hPos, String data) {
    int width = 50;
    int height = 10;
    String border = "||";
    int bordersLength = border.length() * 2;

    System.out.println("=".repeat(width));

    for (int row = 0; row < height; row++) {
      if (row == vPos) {
        String conteudo = " ".repeat(hPos) + data;
        String bordaDir = " ".repeat(width - bordersLength - data.length() - hPos) + border;

        System.out.println(border + conteudo + bordaDir);
      }

      System.out.println(border + " ".repeat(width - bordersLength) + border);
    }

    String button = "(O) ";
    int emptyPixel = width - bordersLength - button.length();

    System.out.println("=".repeat(width));
    System.out.println(border + " ".repeat(emptyPixel) + button + border);
    System.out.println("=".repeat(width));
  }
}

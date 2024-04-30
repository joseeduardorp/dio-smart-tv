public class SmartTv {
  private boolean isOn = false;
  private int channel = 1;
  private int volume = 25;

  public void toggleOnOff() {
    this.isOn = !this.isOn;

    String state = this.isOn ? "Ligada" : "Desligada";
    System.out.println("A TV está " + state);

    if (this.isOn) {
      System.out.println("Canal " + this.channel);
    }
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
}

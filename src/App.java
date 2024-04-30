public class App {
    public static void main(String[] args) throws Exception {
        SmartTv tv = new SmartTv();

        tv.toggleOnOff();
        tv.changeChannel(52);
        tv.increaseVolume();
        tv.increaseVolume();
        tv.increaseVolume();
        tv.decreaseChannel();
        tv.toggleOnOff();
    }
}

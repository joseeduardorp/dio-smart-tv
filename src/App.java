public class App {
    public static void main(String[] args) throws Exception {
        SmartTv tv = new SmartTv();

        tv.render();
        tv.toggleOnOff();
        tv.increaseChannel();
        tv.changeChannel(52);

        for (int i = 0; i < 5; i++) {
            tv.increaseVolume();
        }

        tv.toggleOnOff();
        tv.render();
    }
}

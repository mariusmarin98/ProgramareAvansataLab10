package lab10;

public class Main {

    public static void main(String[] args) {
        GameClient gameClient = new GameClient("127.0.0.1",8100);
        gameClient.start();
    }
}

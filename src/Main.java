public class Main {
    public static void main(String[] args) {
        UI.welcomeMessage();
        int gameMode = UI.gameModeChoice();
        GameProcess game = new GameProcess(gameMode);
        game.startGame();
    }
}
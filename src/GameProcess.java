import java.util.ArrayList;

final public class GameProcess {
    private boolean isGameFinished = false;
    private DeskInfo desk;
    private char currentMove;
    private int gameMode;

    private ReverseBot bot;

    GameProcess(int gameMode) {
        this.gameMode = gameMode;
        if (gameMode == 0) {
            bot = new ReverseBot();
        }
        if (gameMode == 2) {
            isGameFinished = true;
        }
        desk = new DeskInfo();
        currentMove = 'O';
    }

    // Тут, в общем-то весь игровой процесс. Ужасно реализовано, но, опять же, работает
    public void startGame() {
        if (gameMode == 1) {
            while (!isGameFinished) {
                UI.showDesk(desk.getDesk());
                if (MovementCheck.isMovePossible(currentMove, desk.getDesk())) {
                    makeMove();
                } else {
                    changeCurrentMove();
                    if (MovementCheck.isMovePossible(currentMove, desk.getDesk())) {
                        UI.moveChangeMessage(currentMove);
                        makeMove();
                    } else {
                        UI.gameFinishMessage(countScore());
                        isGameFinished = true;
                    }
                }
            }
        }
        if (gameMode == 0) {
            while (!isGameFinished) {
                if (currentMove == 'O') {
                    UI.showDesk(desk.getDesk());
                    if (MovementCheck.isMovePossible(currentMove, desk.getDesk())) {
                        makeMove();
                    }
                    else {
                        changeCurrentMove();
                        if (MovementCheck.isMovePossible(currentMove, desk.getDesk())) {
                            UI.botMoveAlert();
                            int[] botMove = bot.MakeMove(desk.getDesk());
                            desk.switchTips(MovementCheck.checkTipLock(botMove[0], botMove[1], 'X', desk.getDesk()), 'X');
                            changeCurrentMove();
                        }
                        else {
                            int[] score = countScore();
                            UI.gameFinishMessage(score);
                            UI.bestResultMessage(Math.max(score[0], score[1]));
                            isGameFinished = true;
                        }
                    }
                }
                else {
                    if (MovementCheck.isMovePossible(currentMove, desk.getDesk())) {
                        UI.botMoveAlert();
                        int[] botMove = bot.MakeMove(desk.getDesk());
                        desk.switchTips(MovementCheck.checkTipLock(botMove[0], botMove[1], 'X', desk.getDesk()), 'X');
                        changeCurrentMove();
                    }
                    else {
                        changeCurrentMove();
                        if (MovementCheck.isMovePossible(currentMove, desk.getDesk())) {
                            UI.moveChangeMessage(currentMove);
                            makeMove();
                        }
                        else {
                            UI.gameFinishMessage(countScore());
                            isGameFinished = true;
                        }
                    }
                }
                UI.showDesk(desk.getDesk());
            }
        }
    }

    public boolean makeMove() {
        UI.moveMessage(currentMove);
        int[] coordinates = UI.inputCoordinates();
        ArrayList<int[]> moveChanges = MovementCheck.checkTipLock(coordinates[0], coordinates[1], currentMove, desk.getDesk());
        if (moveChanges.isEmpty()) {
            return makeMove();
        } else {
            desk.switchTips(moveChanges, currentMove);
            changeCurrentMove();
        }
        return true;
    }

    private void changeCurrentMove() {
        if (currentMove == 'O') {
            currentMove = 'X';
        } else {
            currentMove = 'O';
        }
    }

    public int[] countScore() {
        int xCount, oCount;
        xCount = oCount = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (desk.getDesk()[i][j] == 'O') {
                    oCount++;
                }
                else {
                    if (desk.getDesk()[i][j] == 'X') {
                        xCount++;
                    }
                }
            }
        }
        return new int[]{xCount, oCount};
    }
}

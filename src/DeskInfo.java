import java.util.ArrayList;

final public class DeskInfo {
    private char[][] desk = new char[8][8];

    public char[][] getDesk() {
        return desk;
    }
    public DeskInfo() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                desk[i][j] = 0;
            }
        }
        desk[3][3] = desk[4][4] = 'O';
        desk[3][4] = desk[4][3] = 'X';
    }

    public void switchTips(ArrayList<int[]> tipsToSwitch, char tipType) {
        for (int[] coordinates : tipsToSwitch) {
            desk[coordinates[0]][coordinates[1]] = tipType;
        }
    }

}

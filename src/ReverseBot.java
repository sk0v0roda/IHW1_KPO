// Этот бот ОЧЕНЬ плох, как вы видите, но меня не хватило на большее в 2 ночи простите
public class ReverseBot {
    public static int[] MakeMove(char[][] desk) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!MovementCheck.checkTipLock(i, j, 'X', desk).isEmpty()) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}

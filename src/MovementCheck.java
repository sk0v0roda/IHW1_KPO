import java.util.ArrayList;

final public class MovementCheck {
    /* МНЕ ОЧЕНЬ СТЫДНО ЗА ЭТОТ МЕТОД НО ОН РАБОТАЕТ
     Принимает на вход координаты фишки, которую поставили на поле, её "цвет" и игровую доску
     возвращает список из пар координат фишек, "цвет" которых нужно поменять.
     */
    public static ArrayList<int[]> checkTipLock(int xCoordinate, int yCoordinate, char tipType, char[][] desk) {
        xCoordinate--;
        yCoordinate--;
        try {
            if (desk[xCoordinate][yCoordinate] != 0) {
                return new ArrayList<>();
            }
        } catch (Exception ex) {
            return new ArrayList<>();
        }
        boolean flag = false;
        ArrayList<int[]> buffer = new ArrayList<>();
        ArrayList<int[]> retList = new ArrayList<>();
        for (int x = xCoordinate - 1, y = yCoordinate - 1; x > 0 && y > 0; x--, y--) {
            if (desk[x][y] == tipType) {
                break;
            } else {
                if (desk[x][y] == 0) {
                    buffer.clear();
                    break;
                } else {
                    buffer.add(new int[]{x, y});
                }
            }
        }
        retList.addAll(buffer);
        buffer.clear();
        for (int y = yCoordinate - 1; y > 0; y--) {
            if (desk[xCoordinate][y] == tipType) {
                break;
            } else {
                if (desk[xCoordinate][y] == 0) {
                    buffer.clear();
                    break;
                } else {
                    buffer.add(new int[]{xCoordinate, y});
                }
            }
        }
        retList.addAll(buffer);
        buffer.clear();
        for (int x = xCoordinate + 1, y = yCoordinate - 1; x < 8 && y > 0; x++, y--) {
            if (desk[x][y] == tipType) {
                break;
            } else {
                if (desk[x][y] == 0) {
                    buffer.clear();
                    break;
                } else {
                    buffer.add(new int[]{x, y});
                }
            }
        }
        retList.addAll(buffer);
        buffer.clear();
        for (int x = xCoordinate + 1; x < 8; x++) {
            if (desk[x][yCoordinate] == tipType) {
                break;
            } else {
                if (desk[x][yCoordinate] == 0) {
                    buffer.clear();
                    break;
                } else {
                    buffer.add(new int[]{x, yCoordinate});
                }
            }
        }
        retList.addAll(buffer);
        buffer.clear();
        for (int x = xCoordinate + 1, y = yCoordinate + 1; x < 8 && y < 8; x++, y++) {
            if (desk[x][y] == tipType) {
                break;
            } else {
                if (desk[x][y] == 0) {
                    buffer.clear();
                    break;
                } else {
                    buffer.add(new int[]{x, y});
                }
            }
        }
        retList.addAll(buffer);
        buffer.clear();
        for (int y = yCoordinate + 1; y < 8; y++) {
            if (desk[xCoordinate][y] == tipType) {
                break;
            } else {
                if (desk[xCoordinate][y] == 0) {
                    buffer.clear();
                    break;
                } else {
                    buffer.add(new int[]{xCoordinate, y});
                }
            }
        }
        retList.addAll(buffer);
        buffer.clear();
        for (int x = xCoordinate - 1, y = yCoordinate + 1; x > 0 && y < 8; x--, y++) {
            if (desk[x][y] == tipType) {
                break;
            } else {
                if (desk[x][y] == 0) {
                    buffer.clear();
                    break;
                } else {
                    buffer.add(new int[]{x, y});
                }
            }
        }
        retList.addAll(buffer);
        buffer.clear();
        for (int x = xCoordinate - 1; x > 0; x--) {
            if (desk[x][yCoordinate] == tipType) {
                break;
            } else {
                if (desk[x][yCoordinate] == 0) {
                    buffer.clear();
                    break;
                } else {
                    buffer.add(new int[]{x, yCoordinate});
                }
            }
        }
        retList.addAll(buffer);
        buffer.clear();
        if (!retList.isEmpty()) {
            retList.add(new int[]{xCoordinate, yCoordinate});
        }
        return retList;
    }

    // Метод определяет, возможно ли указанному в tipType игроку сделать ход
    public static boolean isMovePossible(char tipType, char[][] desk) {
        for (int i = 1; i < 9; i++) {
                for (int j = 1; j < 9; j++) {
                    if (!checkTipLock(i, j, tipType, desk).isEmpty()) {
                        return true;
                    }
                }
        }
        return false;
    }
}

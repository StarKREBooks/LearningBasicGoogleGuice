package lesson_1.bonuses;

import org.jetbrains.annotations.Contract;

public enum BonusMark {
    NORMAL, RARE, EPIC, LEGENDARY;

    @Contract(pure = true)
    public static BonusMark getMark(final String str) {
        BonusMark bonusMark = null;
        switch (str) {
            case "NORMAL":
                bonusMark =  BonusMark.NORMAL;
            break;
            case "RARE":
                bonusMark =  BonusMark.RARE;
            break;
            case "EPIC":
                bonusMark =  BonusMark.EPIC;
            break;
            case "LEGENDARY":
                bonusMark =  BonusMark.LEGENDARY;
        }
        return bonusMark;
    }
}

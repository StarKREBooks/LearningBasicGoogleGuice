package lesson_1.supplier;

import lesson_1.bonuses.BonusMark;
import org.jetbrains.annotations.Contract;

import static lesson_1.interfaces.Colors.*;

public final class SearchResponse{
    private final String name;
    private final int cost;
    private final String hero;
    private final BonusMark bonusMark;

    SearchResponse(final String name, final int cost, final String hero, BonusMark bonusMark) {
        this.name = name;
        this.cost = cost;
        this.hero = hero;
        this.bonusMark = bonusMark;
    }

    @Contract(pure = true)
    public String getHero() {
        return hero;
    }

    @Override
    public String toString() {
        return "Bonus name: " + ANSI_BLUE + name + ANSI_WHITE + " cost: " + ANSI_GREEN + cost + " " + ANSI_PURPLE
                + bonusMark + ANSI_WHITE;
    }
}

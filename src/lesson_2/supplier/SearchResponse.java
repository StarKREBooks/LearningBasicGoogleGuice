package lesson_2.supplier;

import lesson_2.bonuses.BonusMark;
import org.jetbrains.annotations.Contract;

import static lesson_2.interfaces.Colors.*;

public final class SearchResponse{
    private final String name;
    private final int cost;
    private final String hero;
    private final BonusMark bonusMark;

    public SearchResponse(final String name, final int cost, final String hero, BonusMark bonusMark) {
        this.name = name;
        this.cost = cost;
        this.hero = hero;
        this.bonusMark = bonusMark;
    }

    @Contract(pure = true)
    public final String getHero() {
        return hero;
    }

    @Override
    public final String toString() {
        return "Bonus name: " + ANSI_BLUE + name + ANSI_WHITE + " cost: " + ANSI_GREEN + cost + " " + ANSI_PURPLE
                + bonusMark + ANSI_WHITE;
    }
}

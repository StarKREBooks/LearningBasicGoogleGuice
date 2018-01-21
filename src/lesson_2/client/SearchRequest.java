package lesson_2.client;

import org.jetbrains.annotations.Contract;

public final class SearchRequest {

    @Contract(pure = true)
    public final String getHero() {
        return hero;
    }

    final void setHero(final String hero) {
        this.hero = hero;
    }

    private String hero;
}

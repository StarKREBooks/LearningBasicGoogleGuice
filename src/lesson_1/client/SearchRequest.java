package lesson_1.client;

import org.jetbrains.annotations.Contract;

public final class SearchRequest {

    @Contract(pure = true)
    public final String getHero() {
        return hero;
    }

    public final void setHero(String hero) {
        this.hero = hero;
    }

    private String hero;
}

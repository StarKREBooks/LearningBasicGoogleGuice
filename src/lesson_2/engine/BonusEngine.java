package lesson_2.engine;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import lesson_2.client.SearchRequest;
import lesson_2.supplier.bonusSupplier.HOA;
import org.jetbrains.annotations.Contract;
import lesson_2.supplier.SearchResponse;
import lesson_2.supplier.Supplier;

import java.util.ArrayList;
import java.util.List;

public final class BonusEngine {

    private int maxBonuses;

    private Supplier bonusSupplier;

    @Inject
    public BonusEngine(final @HOA Supplier bonusSupplier) {
        this.bonusSupplier = bonusSupplier;
    }

    public final List<SearchResponse> processRequest(final SearchRequest searchRequest) {
        final List<SearchResponse> list = new ArrayList<>();
        for (final SearchResponse response : bonusSupplier.getResults()){
            if (searchRequest.getHero().equals(response.getHero())){
                list.add(response);
            }
        }
        return list;
    }

    //Getters & setters:
    public final int getMaxBonuses() {
        return maxBonuses;
    }

    @Inject
    public final void setMaxBonuses(final @Named("maxBonuses") int maxBonuses) {
        this.maxBonuses = maxBonuses;
    }


    @Contract(pure = true)
    public final Supplier getBonusSupplier() {
        return bonusSupplier;
    }

    @Inject
    public final void setBonusSupplier(final @HOA Supplier bonusSupplier) {
        this.bonusSupplier = bonusSupplier;
    }
}

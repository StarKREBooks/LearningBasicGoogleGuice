package lesson_1.engine;

import lesson_1.client.SearchRequest;
import com.google.inject.Inject;
import org.jetbrains.annotations.Contract;
import lesson_1.supplier.SearchResponse;
import lesson_1.supplier.Supplier;

import java.util.ArrayList;
import java.util.List;

public final class BonusEngine {

    @Inject
    private Supplier supplier;

    @Contract(pure = true)
    public final Supplier getSupplier() {
        return supplier;
    }

    public final void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public final List<SearchResponse> processRequest(final SearchRequest searchRequest) {
        final List<SearchResponse> list = new ArrayList<>();
        for (final SearchResponse response : supplier.getResults()){
            if (searchRequest.getHero().equals(response.getHero())){
                list.add(response);
            }
        }
        return list;
    }
}

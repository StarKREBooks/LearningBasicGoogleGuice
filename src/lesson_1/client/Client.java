package lesson_1.client;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import lesson_1.engine.BonusEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lesson_1.supplier.BonusSupplier;
import lesson_1.supplier.SearchResponse;
import lesson_1.supplier.Supplier;

import java.util.List;

public final class Client {
    private final Logger logger = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        final int HERO_ARG = 0;
        final class BonusSupplierModule extends AbstractModule{
            @Override
            protected void configure() {
                bind(String.class).annotatedWith(Names.named("bonusPath")).toInstance(Supplier.getFilePath());
                bind(Supplier.class).to(BonusSupplier.class);
            }
        }
        final Injector injector = Guice.createInjector(new BonusSupplierModule());
        final Client client = injector.getInstance(Client.class);
        if (args.length > 0){
            client.makeRequest(args[HERO_ARG]);
        }
    }

    @Inject
    private BonusEngine bonusEngine;

    private void makeRequest(String heroRQ){
        final SearchRequest searchRequest = new SearchRequest();
        searchRequest.setHero(heroRQ);

        final List<SearchResponse> responseList = bonusEngine.processRequest(searchRequest);

        for (final SearchResponse response : responseList){
            logger.info(response.toString());
        }
    }
}

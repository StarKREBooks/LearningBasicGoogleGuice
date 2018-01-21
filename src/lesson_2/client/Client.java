package lesson_2.client;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import lesson_2.engine.BonusEngine;
import lesson_2.engine.BonusEngineModule;
import lesson_2.supplier.bonusSupplier.BonusSupplier;
import lesson_2.supplier.bonusSupplier.BonusSupplierModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lesson_2.supplier.SearchResponse;

import java.util.List;

public final class Client {
    private final Logger logger = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        final int HERO_ARG = 0;
        final Injector injector = Guice.createInjector(new BonusSupplierModule(), new BonusEngineModule());
        final Client client = injector.getInstance(Client.class);
        if (args.length > 0){
            client.makeRequest(args[HERO_ARG]);
        }
    }

    @Inject
    private BonusEngine bonusEngine;

    @Inject
    private SearchRequest searchRequest;

    private void makeRequest(String heroRQ){
        searchRequest.setHero(heroRQ);

        final List<SearchResponse> responseList = bonusEngine.processRequest(searchRequest);

        for (final SearchResponse response : responseList){
            logger.info(response.toString());
        }

        final BonusSupplier bonusSupplier = (BonusSupplier) bonusEngine.getBonusSupplier();
        logger.info("Properties: " + bonusSupplier.getProperty());
        logger.info("MaxBonuses: " + bonusEngine.getMaxBonuses());
    }
}

package lesson_2.engine;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import lesson_2.supplier.Supplier;
import lesson_2.supplier.bonusSupplier.BonusSupplier;
import lesson_2.supplier.bonusSupplier.BonusSupplierModule;
import lesson_2.supplier.bonusSupplier.HOA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static lesson_2.interfaces.Colors.ANSI_GREEN;
import static lesson_2.interfaces.Colors.ANSI_WHITE;

public final class BonusEngineModule extends AbstractModule {
    private final Logger logger = LoggerFactory.getLogger(BonusSupplierModule.class);

    @Override
    protected final void configure() {
        bind(Supplier.class).annotatedWith(HOA.class).to(BonusSupplier.class);
        bindConstant().annotatedWith(Names.named("maxBonuses")).to(200);
        logger.info(ANSI_GREEN + "BonusEngineModule is ready" + ANSI_WHITE);
    }
}

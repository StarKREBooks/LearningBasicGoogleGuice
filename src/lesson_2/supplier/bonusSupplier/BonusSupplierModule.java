package lesson_2.supplier.bonusSupplier;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static lesson_2.interfaces.Colors.ANSI_GREEN;
import static lesson_2.interfaces.Colors.ANSI_WHITE;

public final class BonusSupplierModule extends AbstractModule {
    private final Logger logger = LoggerFactory.getLogger(BonusSupplierModule.class);
    @Override
    protected final void configure() {
        bind(String.class).toInstance("./src/lesson_2/bonus_files/bonuses.hoa");
        Names.bindProperties(binder(), makeProperties());
        try {
            bind(File.class).toConstructor(File.class.getConstructor(String.class));
            logger.info(ANSI_GREEN + "BonusSupplierModule is ready" + ANSI_WHITE);
        } catch (final NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private Properties makeProperties() {
        final Properties properties = new Properties();
        final FileReader fileReader;
        try {
            fileReader = new FileReader(new File("./src/lesson_2/properties/bonus.properties"));
            try {
                properties.load(fileReader);
            } catch (final IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileReader.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (final FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return properties;
    }
}

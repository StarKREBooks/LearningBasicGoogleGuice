package lesson_2.supplier.bonusSupplier;

import com.google.inject.name.Named;
import lesson_2.bonuses.BonusMark;
import com.google.inject.Inject;
import lesson_2.supplier.SearchResponse;
import lesson_2.supplier.Supplier;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class BonusSupplier implements Supplier {

    private final List<SearchResponse> searchResponses = new ArrayList<>();

    @Inject
    @Named("property")
    private String property;

    private String bonusPath;

    private File file;

    public final List<SearchResponse> getResults() {
        if (searchResponses.isEmpty()) {
            loadFiles();
        }
        return searchResponses;
    }

    private void loadFiles() {
        try {
            final BufferedReader reader = new BufferedReader(new FileReader(file));
            final List<String> bonusList = reader.lines().collect(Collectors.toList());
            for (final String bonus : bonusList) {
                final String[] params = bonus.split(" ");

                final int NAME_INDEX = 0;
                final int COST_INDEX = 1;
                final int HERO_INDEX = 2;
                final int MARK_INDEX = 3;

                final SearchResponse searchResponse = new SearchResponse(params[NAME_INDEX]
                        , Integer.parseInt(params[COST_INDEX]), params[HERO_INDEX]
                        , BonusMark.getMark(params[MARK_INDEX]));
                searchResponses.add(searchResponse);
            }
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public final File getFile() {
        return file;
    }

    @Inject
    public final void setFile(final File file) {
        this.file = file;
    }

    public final String getBonusPath() {
        return bonusPath;
    }

    @Inject
    public final void setBonusPath(final String bonusPath) {
        this.bonusPath = bonusPath;
    }

    public String getProperty() {
        return property;
    }
}

package lesson_1.supplier;

import java.util.List;

public interface Supplier {

    List<SearchResponse> getResults();

    static String getFilePath(){
        return "src\\lesson_1\\bonus_files\\bonuses.hoa";
    }
}

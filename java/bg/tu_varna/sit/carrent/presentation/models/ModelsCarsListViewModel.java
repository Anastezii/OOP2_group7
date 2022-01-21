package bg.tu_varna.sit.carrent.presentation.models;

public class ModelsCarsListViewModel {
    private final String summary;
    private final String brand;

    public ModelsCarsListViewModel(String summary,  String brand) {
        this.summary = summary;
        this.brand = brand;
    }



    @Override
    public String toString() {
        return String.format(" %s  | %s ",summary,brand );
    }
}

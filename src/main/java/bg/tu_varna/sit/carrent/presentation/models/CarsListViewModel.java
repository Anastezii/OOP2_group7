package bg.tu_varna.sit.carrent.presentation.models;

public class CarsListViewModel {
    private final String summary;
    private final String model;
    private final String smoker;

    public CarsListViewModel(String summary, String model, String smoker) {
        this.summary = summary;
        this.model = model;
        this.smoker = smoker;
    }

    @Override
    public String toString() {
        return String.format(" %s  | %s  | %s  ",summary,model,smoker );
    }
}

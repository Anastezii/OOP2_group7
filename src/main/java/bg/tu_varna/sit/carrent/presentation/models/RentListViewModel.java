package bg.tu_varna.sit.carrent.presentation.models;

public class RentListViewModel {

    private final String summary;
    private final String cars;
    private final String operator;
    private final String client;
    private final String phirma;

    public RentListViewModel(String summary, String cars, String operator, String client, String phirma) {
        this.summary = summary;
        this.cars = cars;
        this.operator = operator;
        this.client = client;
        this.phirma = phirma;
    }

    @Override
    public String toString() {
        return String.format(" %s  | %s  | %s  | %s  | %s ",summary,cars,operator,client,phirma );
    }
}

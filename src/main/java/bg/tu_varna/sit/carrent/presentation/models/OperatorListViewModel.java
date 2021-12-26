package bg.tu_varna.sit.carrent.presentation.models;


public class OperatorListViewModel {
    private final String summary;
    private final String admin;

    public OperatorListViewModel(String summary,  String admin) {
        this.summary = summary;
        this.admin = admin;
    }



    @Override
    public String toString() {
        return String.format(" %s  | %s ",summary,admin );
    }
}

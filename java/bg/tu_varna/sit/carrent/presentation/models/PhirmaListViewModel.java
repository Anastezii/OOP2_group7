package bg.tu_varna.sit.carrent.presentation.models;

public class PhirmaListViewModel {
    private final String summary;
    private final String administr;

    public PhirmaListViewModel(String summary,  String administr) {
        this.summary = summary;
        this.administr = administr;
    }


    @Override
    public String toString() {
        return String.format(" %s  | %s ",summary,administr );
    }
}

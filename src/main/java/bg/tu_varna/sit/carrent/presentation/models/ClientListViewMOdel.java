package bg.tu_varna.sit.carrent.presentation.models;

public class ClientListViewMOdel {
    private final String summary;
    private final String operator;

    public ClientListViewMOdel(String summary,  String operator) {
        this.summary = summary;
        this.operator = operator;
    }



    @Override
    public String toString() {
        return String.format(" %s  | %s ",summary,operator );
    }
}

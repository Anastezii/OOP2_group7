package bg.tu_varna.sit.carrent.presentation.models;


public class OperatorListViewModel {
    private final String log;
    private final String pass;

    public OperatorListViewModel(String log, String pass) {
        this.log = log;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return String.format(" %s  | %s ",log,pass );
    }
}

package bg.tu_varna.sit.carrent.presentation.models;

public class ClientListViewMOdel {
    private final String logi;
    private final String passw;

    public ClientListViewMOdel(String logi, String passw) {
        this.logi = logi;
        this.passw = passw;
    }

    @Override
    public String toString() {
        return String.format(" %s  | %s ",logi,passw );
    }
}

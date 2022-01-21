package bg.tu_varna.sit.carrent.presentation.models;

public class UserListViewModel {
    private final String summary;
    private final String user_type;
    private final String operator;
    private final String client;
    private final String admin;

    public UserListViewModel(String summary, String user_type, String operator, String client, String admin) {
        this.summary = summary;
        this.user_type = user_type;
        this.operator = operator;
        this.client = client;
        this.admin = admin;
    }

    @Override
    public String toString() {
        return String.format(" %s  | %s  | %s  | %s  | %s ",summary,user_type,operator,client,admin );
    }
}

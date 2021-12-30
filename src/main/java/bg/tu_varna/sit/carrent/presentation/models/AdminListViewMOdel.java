package bg.tu_varna.sit.carrent.presentation.models;

import java.util.Objects;

public class AdminListViewMOdel {
    private final String textLogin;
    private final String textPassword;

    public AdminListViewMOdel(String textLogin, String textPassword) {
        this.textLogin = textLogin;
        this.textPassword = textPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminListViewMOdel that = (AdminListViewMOdel) o;
        return Objects.equals(textLogin, that.textLogin) && Objects.equals(textPassword, that.textPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textLogin, textPassword);
    }

    @Override
    public String toString() {
        return String.format(" %s  | %s   ",textLogin,textPassword );
    }
}

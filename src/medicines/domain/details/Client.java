package medicines.domain.details;

public class Client {
    private String user_id;
    private String user_tel;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    @Override
    public String toString() {
        return "Client{" +
                "user_id='" + user_id + '\'' +
                ", user_tel='" + user_tel + '\'' +
                '}';
    }
}

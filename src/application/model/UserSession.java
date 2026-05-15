package application.model;

public class UserSession {
    private static UserSession instance;
    private Client client;

    private UserSession() {}

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void cleanUserSession() {
        client = null;
    }
}

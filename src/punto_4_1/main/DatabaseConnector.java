package punto_4_1.main;

public class DatabaseConnector {
    private final String url;
    private final String user;
    private final String password;

    public DatabaseConnector(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public RecopiladorEnBaseDeDatos createRecopilador() {
        return new RecopiladorEnBaseDeDatos(url, user, password);
    }
}

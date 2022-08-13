package xfxpositions.LogoLibrary;

public class User {
    public String name;
    public String password;

    public String id;

    public String getId() {
        return id;
    }

    public User(String name, String password, String id, int securityLevel) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.securityLevel = securityLevel;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    public int securityLevel;

    public User(String name, String password, int securityLevel, long id){

        this.name = name;
        this.password = password;

    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }


}

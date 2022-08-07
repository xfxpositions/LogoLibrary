package xfxpositions.LogoLibrary;

public class User {
    public String name;
    public String password;
    public int securityLevel;
    public long id;

    public User(String name, String password, int securityLevel, long id){
        this.name = name;
        this.password = password;
        this.securityLevel = securityLevel;
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }
}

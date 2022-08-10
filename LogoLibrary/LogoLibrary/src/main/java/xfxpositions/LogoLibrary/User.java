package xfxpositions.LogoLibrary;

public class User {
    public String name;
    public String password;


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

package anjelloatoz.com.codetestapp.Model;

/**
 * Created by Anjelloatoz on 8/12/18.
 */

public class Repo {
    public String id;
    public String name;
    public String full_name;
    public Owner owner;

    public Repo(String id, String name, String full_name, Owner owner) {
        this.id = id;
        this.name = name;
        this.full_name = full_name;
        this.owner = owner;
    }
}

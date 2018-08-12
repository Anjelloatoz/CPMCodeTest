package anjelloatoz.com.codetestapp.Model;

/**
 * Created by Anjelloatoz on 8/11/18.
 */

public class GHToken {

    public String token_type;
    public String access_token;
    public String scope;

    @Override
    public String toString() {
        return "GHToken{" +
                "token_type='" + token_type + '\'' +
                ", access_token='" + access_token + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}

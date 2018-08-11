package anjelloatoz.com.codetestapp.Model;

/**
 * Created by Anjelloatoz on 8/11/18.
 */

public class LoginResult {

    public String token_type;
    public String access_token;
    public String code;

    @Override
    public String toString() {
        return "LoginResult{" +
                "token_type='" + token_type + '\'' +
                ", access_token='" + access_token + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}

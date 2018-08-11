package anjelloatoz.com.codetestapp.Network;


public interface CallbackNetwork {
    public void success(Object result);
    public void failure(int errorCode, String message);
    public void networkFailure();
    public void serverFailure();
}

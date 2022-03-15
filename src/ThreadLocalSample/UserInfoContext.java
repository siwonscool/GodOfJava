package ThreadLocalSample;

public class UserInfoContext {
    public static ThreadLocal<UserInfo> userInfoThreadLocal = new ThreadLocal<>();
}

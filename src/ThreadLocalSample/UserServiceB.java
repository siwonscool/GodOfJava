package ThreadLocalSample;

public class UserServiceB {
    public void logicB() {
        UserInfo userInfo = UserInfoContext.userInfoThreadLocal.get();

        System.out.println("logicB 의 user id : " + userInfo.getId());
    }
}

package ThreadLocalSample;

public class UserServiceA {
    private UserServiceB userServiceB;

    public void logicA(){
        UserInfoContext.userInfoThreadLocal.set(new UserInfo());
        userServiceB = new UserServiceB();
        userServiceB.logicB();

        System.out.println("logicA 의 user id : "+UserInfoContext.userInfoThreadLocal.get().getId());

        //UserInfoContext.userInfoThreadLocal.remove();
    }
}

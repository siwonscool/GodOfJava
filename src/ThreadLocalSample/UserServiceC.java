package ThreadLocalSample;

public class UserServiceC {

    public void logicC(){
        UserInfoContext.userInfoThreadLocal.set(new UserInfo());

        System.out.println("logicC 의 user id : "+UserInfoContext.userInfoThreadLocal.get().getId());

        UserInfoContext.userInfoThreadLocal.remove();
    }
}

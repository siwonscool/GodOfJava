package ThreadLocalSample;

import java.util.Random;

public class UserInfo {
    private String id;

    //기본 생성자로 id 에 random 값 삽입
    public UserInfo() {
        Random random = new Random();
        this.id = String.valueOf(random.nextInt(30));
    }

    public String getId() {
        return id;
    }
}

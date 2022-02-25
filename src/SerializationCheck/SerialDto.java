package SerializationCheck;

import java.io.Serializable;

public class SerialDto implements Serializable {
    static final long serialVersionUID = 1L;

    private String id;
    transient private String pw;
    private String name;
    transient private int phoneNum;
    private boolean vip;
    private long point;

    private String memeberType;

    public SerialDto(String id, String pw, String name, int phoneNum, boolean vip, long point, String memberType) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phoneNum = phoneNum;
        this.vip = vip;
        this.point = point;
        this.memeberType = memberType;
    }

    @Override
    public String toString() {
        return "[id = " + id + ", pw = " + pw + ", name = " + name +
                ", phoneNum = " + phoneNum + ", vip = " + vip + ", point = " + point +", memberTypes = "+memeberType+" ]";
    }
}

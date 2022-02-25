package FirstClassCollection;

import java.util.List;

public class VIPMembers {
    private final List<MemberVo> memberList;

    public VIPMembers(List<MemberVo> memberList) {
        this.memberList = memberList;
    }

    public void getVIPMembers(){
        for (MemberVo list : memberList){
            System.out.println("VIP : " + list.getName());
        }
    }
}

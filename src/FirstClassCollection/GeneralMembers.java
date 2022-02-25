package FirstClassCollection;

import java.util.List;

public class GeneralMembers {
    private final List<MemberVo> memberList;

    public GeneralMembers(List<MemberVo> memberList) {
        this.memberList = memberList;
    }

    public void getVIPMembers(){
        for (MemberVo list : memberList){
            System.out.println("VIP : " + list.getName());
        }
    }
}

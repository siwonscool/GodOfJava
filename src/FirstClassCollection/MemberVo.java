package FirstClassCollection;

public class MemberVo {
    private String name;
    private String grade;

    public MemberVo(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
}

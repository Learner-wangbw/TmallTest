package stu.wbw.pojo;
//用户表
public class User {
    //主键ID
    private Integer id;
    //用户账号
    private String name;
    //用户密码
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getAnonymousName(){
        if (name == null){
            return null;
        }
        if (name.length() <= 1){
            return "*";
        }
        if (name.length()==2){
            return name.substring(0,1)+"*";
        }
        char[] cs = name.toCharArray();
        for (int i = 1; i < cs.length-1; i++) {
            cs[i] = '*';
        }
        return new String(cs);
    }
}

package stu.wbw.pojo;
//友情链接
public class ReferalLink {
    //主键id
    private Integer id;
    //超链显示的文本
    private String text;
    //超链链接网址
    private String link;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

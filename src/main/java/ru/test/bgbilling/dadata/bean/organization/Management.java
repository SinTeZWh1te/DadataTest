package ru.test.bgbilling.dadata.bean.organization;

/**
 * @author sintezwh1te
 */
public class Management {
    private String name;
    private String post;
    private Boolean disqualified;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Boolean getDisqualified() {
        return disqualified;
    }

    public void setDisqualified(Boolean disqualified) {
        this.disqualified = disqualified;
    }

    @Override
    public String toString() {
        return "Management{" +
                "name='" + name + '\'' +
                ", post='" + post + '\'' +
                ", disqualified=" + disqualified +
                '}';
    }
}

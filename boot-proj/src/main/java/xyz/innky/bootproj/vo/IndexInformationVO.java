package xyz.innky.bootproj.vo;

import java.util.List;

public class IndexInformationVO {
    public List<Article> recentArticles;
    public List<String> types;
    public List<Inf> personalInf;

    public List<Article> getRecentArticles() {
        return recentArticles;
    }

    public void setRecentArticles(List<Article> recentArticles) {
        this.recentArticles = recentArticles;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<Inf> getPersonalInf() {
        return personalInf;
    }

    public void setPersonalInf(List<Inf> personalInf) {
        this.personalInf = personalInf;
    }
}

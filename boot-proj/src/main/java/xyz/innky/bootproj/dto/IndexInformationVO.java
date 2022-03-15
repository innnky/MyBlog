package xyz.innky.bootproj.dto;

import java.util.List;

public class IndexInformationVO {
    public List<DtoArticle> recentDtoArticles;
    public List<String> types;
    public List<Inf> personalInf;

    public List<DtoArticle> getRecentArticles() {
        return recentDtoArticles;
    }

    public void setRecentArticles(List<DtoArticle> recentDtoArticles) {
        this.recentDtoArticles = recentDtoArticles;
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

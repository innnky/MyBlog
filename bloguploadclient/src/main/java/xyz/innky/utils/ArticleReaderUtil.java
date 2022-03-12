package xyz.innky.utils;

import xyz.innky.Config;
import xyz.innky.entity.ArticleFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ArticleReaderUtil {
    public static ArticleFile readArticles(File file){
        ArticleFile articleFile = new ArticleFile();
        articleFile.setFile(file);
        articleFile.setaName(file.getName());
        articleFile.setLastModified(file.lastModified());
        File[] files = file.listFiles();
        if (files != null) {
            List<ArticleFile> childrens = new ArrayList<>();
            for (File children : files) {
                childrens.add(readArticles(children));
            }
            articleFile.setChildren(childrens);
        }
        return articleFile;
    }
    public static ArticleFile loadFromObjectFile(String path){
        ArticleFile articleFile = new ArticleFile();
        articleFile.load(Config.savingLocation);
        return articleFile;
    }
}

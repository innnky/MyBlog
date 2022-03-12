package xyz.innky.utils;

import xyz.innky.entity.ArticleFile;
import xyz.innky.entity.FileOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareArticlesUtil {
    public List<FileOperation> fileOperationList = new ArrayList<>();

    public void compare(ArticleFile oldFile, ArticleFile newFile) {
        Map<String, ArticleFile> newMap = new HashMap<>();
        Map<String, ArticleFile> oldMap = new HashMap<>();
        if (newFile.getChildren() != null) {
            for (ArticleFile child : newFile.getChildren()) {
                newMap.put(child.getaName(), child);
            }
        }
        if (oldFile.getChildren() != null) {
            for (ArticleFile child : oldFile.getChildren()) {
                oldMap.put(child.getaName(), child);
            }
        }
        if (newMap.size() != 0)
            for (Map.Entry<String, ArticleFile> stringArticleFileEntry : newMap.entrySet()) {
                ArticleFile oldFileFound = oldMap.get(stringArticleFileEntry.getKey());
                if (oldFileFound != null) {
                    if (oldFileFound.getLastModified() < stringArticleFileEntry.getValue().getLastModified() || oldFileFound.getChildren()!=null) {
                        compare(oldFileFound, stringArticleFileEntry.getValue());
                    }
                } else {
                    if (stringArticleFileEntry.getValue().getFile().isDirectory()) {
                        fileOperationList.add(new FileOperation(FileOperation.Operation.MKDIR, stringArticleFileEntry.getValue().getFile()));
                        ArticleFile articleFile = new ArticleFile();
                        articleFile.setChildren(null);
                        compare(articleFile, stringArticleFileEntry.getValue());

                    } else {
                        fileOperationList.add(new FileOperation(FileOperation.Operation.UPLOAD, stringArticleFileEntry.getValue().getFile()));
                    }
                }
            }
        else if (oldMap.size() == 0) {
            if (oldFile.getLastModified() < newFile.getLastModified()) {
                fileOperationList.add(new FileOperation(FileOperation.Operation.OVER_WRITE, newFile.getFile()));
            }
        } else {
            throw new RuntimeException("出错");
        }

        if (oldFile.getChildren() != null) {
            for (Map.Entry<String, ArticleFile> oldelement : oldMap.entrySet()) {
                ArticleFile articleFile = newMap.get(oldelement.getKey());
                if (articleFile == null) {
                    fileOperationList.add(new FileOperation(FileOperation.Operation.DEL, oldelement.getValue().getFile()));
                }
            }
        }


    }
}

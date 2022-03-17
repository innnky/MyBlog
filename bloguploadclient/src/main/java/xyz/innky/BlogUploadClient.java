package xyz.innky;

import cn.hutool.extra.mail.MailUtil;
import xyz.innky.entity.ArticleFile;
import xyz.innky.entity.FileOperation;
import xyz.innky.utils.ArticleReaderUtil;
import xyz.innky.utils.CompareArticlesUtil;
import xyz.innky.utils.FileUploader;
import xyz.innky.utils.HttpArticleUploader;

import java.io.File;

public class BlogUploadClient {
    public static void main(String[] args) {
        ArticleFile na = ArticleReaderUtil.readArticles(new File(Config.targetDirectory));
        ArticleFile oa;
        if ((new File(Config.savingLocation)).exists()){
            oa = ArticleReaderUtil.loadFromObjectFile(Config.savingLocation);
        }else {
            oa = new ArticleFile();
        }
        CompareArticlesUtil compareArticlesUtil = new CompareArticlesUtil();
        try{
            compareArticlesUtil.compare(oa, na);
            na.save(Config.savingLocation);
            System.out.println(compareArticlesUtil.fileOperationList);
        }catch (Exception e){
            e.printStackTrace();
//            MailUtil.send("xiyiji508@foxmail.com", "出错", "邮件来自Hutool测试", false);
        }


        HttpArticleUploader fileUploader = new HttpArticleUploader();
        for (FileOperation fileOperation : compareArticlesUtil.fileOperationList) {
            switch (fileOperation.operation){
                case DEL:
                case RMDIR:
                    fileUploader.del(fileOperation.file);
                    break;
                case MKDIR:
                    fileUploader.mkdir(fileOperation.file);
                    break;
                case UPLOAD:
                case OVER_WRITE:
                    fileUploader.upload(fileOperation.file);
                    break;
            }
        }
    }
}

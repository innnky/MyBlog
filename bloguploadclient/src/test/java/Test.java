import xyz.innky.Config;
import xyz.innky.utils.HttpArticleUploader;
import xyz.innky.utils.MdFileReaderUtil;

import java.io.File;

public class Test {
    public static void main(String[] args) {
//        System.out.println((new File("I:\\mc\\111\\新建 文本副本.txt").getAbsolutePath().substring(Config.targetDirectory.length())).replace('\\','/'));
//        System.out.println(new File("I:\\mc\\111\\新建 文本副本.txt").getParent());
//        System.out.println(MdFileReaderUtil.readFile("/Users/xiyiji/Nutstore Files/JavaLearning/Spring系列/SSM项目/米米商城.md"));
        HttpArticleUploader uploader = new HttpArticleUploader();
//        uploader.del(new File("/Users/xiyiji/Nutstore Files/JavaLearning/Spring系列/SSM项目/米米商城.md"));
        uploader.mkdir(new File("/Users/xiyiji/Nutstore Files/JavaLearning/项目"));
    }


}

import xyz.innky.Config;

import java.io.File;

public class Test {
    public static void main(String[] args) {
//        System.out.println((new File("I:\\mc\\111\\新建 文本副本.txt").getAbsolutePath().substring(Config.targetDirectory.length())).replace('\\','/'));
        System.out.println(new File("I:\\mc\\111\\新建 文本副本.txt").getParent());
    }

}

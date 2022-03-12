package xyz.innky.entity;

import java.io.*;
import java.util.List;

public class ArticleFile implements Serializable {
//    String path;
    String aName;
//    Byte[] content;
    File file;
    Long lastModified;

//    public Byte[] getContent() {
//        return content;
//    }

    List<ArticleFile> children;

    public Long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "ArticleFile{" +
                "aName='" + aName + '\'' +
                ", children=" + children +
                '}';
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }



    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<ArticleFile> getChildren() {
        return children;
    }

    public void setChildren(List<ArticleFile> children) {
        this.children = children;
    }

    public void save(String path){
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(new File(path)));
            out.writeObject(this);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void load(String path){
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(new File(path)));
            ArticleFile ina = (ArticleFile) in.readObject();
            this.file = ina.file;
            this.lastModified = ina.lastModified;
            this.children = ina.children;
            this.aName = ina.aName;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (in !=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
//    public void loadContent() throws Exception{
//        if (this.children !=null){
//            for (ArticleFile child : this.children) {
//                child.loadContent();
//            }
//        }else {
//
//        }
//    }
}

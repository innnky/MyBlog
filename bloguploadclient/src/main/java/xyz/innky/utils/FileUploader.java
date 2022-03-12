package xyz.innky.utils;

import com.jcraft.jsch.SftpException;
import xyz.innky.Config;

import java.io.*;

public class FileUploader {
    SFTPUtil sftp;

    public FileUploader() {
        sftp = new SFTPUtil("root", "L1N4Ja3dz0ngUWi23N", "107.172.157.101", 22);
        sftp.login();

    }

    public void del(File file) {
        String absolutePath = file.getAbsolutePath();
        String substring = absolutePath.substring(Config.targetDirectory.length() + 1);
        substring = substring.replace('\\', '/');
        sftp.rmdir(Config.remoteRootDir + substring);
    }

    public void upload(File file) {
        String absolutePath = file.getAbsolutePath();
        String substring = absolutePath.substring(Config.targetDirectory.length() + 1);
        substring = substring.replace('\\', '/');
        try {
            InputStream is = new FileInputStream(file);
            sftp.upload(Config.remoteRootDir + substring, is);
            is.close();
        } catch (IOException | SftpException e) {
            e.printStackTrace();
        }

    }

    public void mkdir(File file) {
        String absolutePath = file.getAbsolutePath();
        String substring = absolutePath.substring(Config.targetDirectory.length() + 1);
        substring = substring.replace('\\', '/');
        sftp.mkdir(Config.remoteRootDir + substring);
    }

    public void close() {
        sftp.logout();
    }
}

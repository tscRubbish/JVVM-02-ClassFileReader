package edu.nju;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * format : dir/subdir/target.jar
 */
public class ArchivedEntry extends Entry{
    public ArchivedEntry(String classpath) {
        super(classpath);
    }

    @Override
    public byte[] readClassFile(String className) throws IOException {
        try{
            //System.out.println(classpath);
            //System.out.println(className);
            ZipFile zipFile=new ZipFile(classpath);//或者ZipFile zipFile=new ZipFile(zipFile);
            for (Enumeration<? extends ZipEntry> e = zipFile.entries(); e.hasMoreElements();){
                ZipEntry entry=e.nextElement();
                System.out.println("文件名:"+entry.getName()+", 内容如下:");
                if (IOUtil.transform(entry.getName()).equals(IOUtil.transform(className))) return IOUtil.readFileByBytes(zipFile.getInputStream(entry));
            }
            throw new IOException();
        }catch (Exception e){
            throw new IOException();
        }
    }
}
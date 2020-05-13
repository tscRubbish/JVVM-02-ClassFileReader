package edu.nju;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * format : dir/subdir/.../
 */
public class DirEntry extends Entry{
    public DirEntry(String classpath) {
        super(classpath);
    }

    @Override
    public byte[] readClassFile(String className) throws IOException {
        try{
            return IOUtil.readFileByBytes(new FileInputStream(IOUtil.transform(classpath+FILE_SEPARATOR+className)));
        }catch (FileNotFoundException e){
            throw new IOException();
        }
    }
}

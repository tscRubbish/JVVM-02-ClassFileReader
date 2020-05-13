package edu.nju;

import java.io.IOException;

/**
 * format : dir/subdir;dir/subdir/*;dir/target.jar*
 */
public class CompositeEntry extends Entry{
    public CompositeEntry(String classpath) {
        super(classpath);
    }

    @Override
    public byte[] readClassFile(String className) throws IOException {
        String[] list=classpath.split(PATH_SEPARATOR);
        for (String path:list){
            Entry en=ClassFileReader.chooseEntryType(path);
            try{
                return en.readClassFile(className);
            }catch(Exception e){}
        }
        throw new IOException();
    }
}

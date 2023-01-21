package org.simplilearn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManipulation {

    private String base_directory=System.getProperty("user.dir");
    private Boolean result;
    Boolean addFile(String filename) throws IOException {
        String target=base_directory+"\\"+filename;
        File file=new File(target);
/*        if(file.exists()){
            throw new Exception("File already exists...You may want to choose a new filename");
        }*/
            result=file.createNewFile();
            if(result){
                return result;
            }else{
                return result;
            }
        }

    Boolean addFile(String filename,String content) throws IOException {
        String target=base_directory+"\\"+filename;
        File file=new File(target);
        if(!file.exists()){
            FileWriter fw=new FileWriter(file);
            fw.write(content);
            fw.close();
            result=true;
            return result;
        }else{
            result=false;
            return result;
        }
    }

    Boolean deleteFile(String filename) throws IOException {
        String target=base_directory+"\\"+filename;
        File file=new File(target);
        if(file.exists()){
            result=file.delete();
            return result;
        }else{
            result=false;
            return result;
        }
    }
}

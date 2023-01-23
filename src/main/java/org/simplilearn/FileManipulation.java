package org.simplilearn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
            return true;
        }else{
            return false;
        }
    }

    Boolean deleteFile(String filename) throws IOException {
        String target=base_directory+"\\"+filename;
        File file=new File(target);
        if(file.exists()){
            return file.delete();
        }else{
            return false;
        }
    }

    int searchFile(String filename) throws IOException {
        int res=-1;
        String target=base_directory+"\\"+filename;
        File file=new File(base_directory);
        List<String> filelist=new ArrayList<>();
        if(file.isDirectory()){

                File fileArr[]=file.listFiles();
                for(File a:fileArr){
                    if(!a.getName().startsWith(".")){       //excluding hidden files
                        filelist.add(String.valueOf(a));
                    }
                }
                        Collections.sort(filelist);
                        //System.out.println("filelist here "+filelist);
                        res=Collections.binarySearch(filelist,target);
                        //System.out.println("Result after search "+res);


                //Arrays.sort(fileArr,Collections.reverseOrder());

                //res=Arrays.binarySearch(fileArr,target);
                //Collections.binarySearch(fileArr)

            }

    return res;
    }

    public List<String> listFiles() {
        File file=new File(base_directory);
        List<String> filelist=new ArrayList<>();
        if(file.isDirectory()){
            File fileArr[]=file.listFiles();
            for(File a:fileArr){
                if(!a.getName().startsWith(".")){       //excluding hidden files
                    filelist.add(String.valueOf(a));
                }
            }
        }
        return filelist;
    }
}

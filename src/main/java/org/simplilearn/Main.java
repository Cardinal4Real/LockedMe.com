package org.simplilearn;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileManipulation fileManipulation = new FileManipulation();
        String user_input,user_input_sm;
        //String user_input_sm;
        String add_content;
        String msg;
        Boolean res;
        int searchresult;
        String errMessage="An error occurred during file manipulation";
        System.out.println("LockedMe.com application...Welcome!");
        System.out.println("****Powered by: John Edem Adamfo****");
        Label_entry:
        while (true) {
//            Label_mainMenu:
            System.out.println("Press '1' to list all files\n" +
                    "Press '2' for extra file operations\n" +
                    "Press 'q' to exit the application");
            user_input = sc.nextLine().toLowerCase();
            switch (user_input) {
                case "1":
                    try {
                        List<String> result = fileManipulation.listFiles();
                        if (result.size() > 0) {
                            for (String a : result) {
                                int position = a.lastIndexOf("\\");
                                System.out.println(a.substring(position + 1));
                            }

                            //break;
                        } else {
                            System.out.println("Empty directory...no files to display");
                            //break;
                        }
                    } catch (Exception e) {
                        fileManipulation.displayMessage(errMessage);
                        //e.printStackTrace();
                    } finally {
                        break;
                    }
                case "2":
                    Label_subMenu:
                    while (true) {
                        System.out.println("Press '1' to add a file\n" +
                                "Press '2' to delete for a file\n" +
                                "Press '3' to search for a file\n" +
                                "Press 'b' to go back to the main menu");

                        user_input_sm = sc.nextLine().toLowerCase();
                        switch (user_input_sm) {
                            case "1":

                                System.out.println("Please enter the name of the new file you want to add");
                                user_input = sc.nextLine();
                                if(!user_input.isEmpty()){
                                    System.out.println("Type content you want to add to your file...otherwise just press the enter key");
                                    add_content = sc.nextLine();
                                try {
                                    if (add_content.isEmpty()) {
                                        res = fileManipulation.addFile(user_input);
                                    } else {
                                        res = fileManipulation.addFile(user_input, add_content);
                                    }

                                    if (res) {
                                        msg="File created successfully.";
                                        fileManipulation.displayMessage(msg);
                                    } else {
                                        msg="File already exists..you may want to choose a different file name";
                                        fileManipulation.displayMessage(msg);
                                    }
                                } catch (Exception e) {
                                    fileManipulation.displayMessage(errMessage);
                                    //e.printStackTrace();
                                } finally {
                                    break;
                                }
                            }else{
                                   msg="File name cannot be empty!";
                                   fileManipulation.displayMessage(msg);
                                   break;
                                }

                            case "2":
                                System.out.println("Please enter the name of the file you want to delete");
                                user_input=sc.nextLine();
                                try {
                                    if(!user_input.isEmpty()) {
                                        res = fileManipulation.deleteFile(user_input);
                                    }else{
                                        msg="You need to enter a file name to delete";
                                        fileManipulation.displayMessage(msg);
                                        break;
                                    }
                                    if (res){
                                        msg="File deleted successfully.";
                                        fileManipulation.displayMessage(msg);
                                    }else{
                                        msg="File does not exist";
                                        fileManipulation.displayMessage(msg);
                                    }
                                }catch (Exception e){
                                    fileManipulation.displayMessage(errMessage);
                                    //e.printStackTrace();
                                }finally {
                                    break;
                                }

                                //break;
                            case "3":
                                System.out.println("Please enter the name of the file to be searched");
                                user_input=sc.nextLine();
                                try {
                                    if(!user_input.isEmpty()) {searchresult = fileManipulation.searchFile(user_input);
                                    }else{
                                        msg="You need to enter a file to be searched";
                                        fileManipulation.displayMessage(msg);
                                        break;
                                    }
                                    if (searchresult>=0){
                                        msg="The file has been found successfully at index "+searchresult;
                                        fileManipulation.displayMessage(msg);
                                    }else{
                                        msg="File not found";
                                        fileManipulation.displayMessage(msg);

                                    }
                                }catch (Exception e){
                                    fileManipulation.displayMessage(errMessage);
                                    //e.printStackTrace();
                                }finally {
                                    break;
                                }
                            case "b":
                                break Label_subMenu;
                        }
                    }
                    continue;
                case "q":
                    break Label_entry;
            }
        }
    }
}
package org.simplilearn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        FileManipulation fileManipulation=new FileManipulation();
        String user_input;
        String add_content;
        Boolean res;
        System.out.println("LockedMe.com application...Welcome!");
        System.out.println("****Powered by: John Edem Adamfo****");
        Label_entry:
        while(true){
            Label_mainMenu:
            System.out.println("Press '1' to add a file\n" +
                    "Press '2' to delete a file\n" +
                    "Press '3' to search for a file\n" +
                    "Press '4' to move back to the main menu\n" +
                    "Press 'q' to exit the application\n");
            user_input=sc.nextLine().toLowerCase();
            switch (user_input){
                case "1":
                    System.out.println("Please enter the name of the new file you want to add");
                    user_input=sc.nextLine();
                    System.out.println("Type content you want to add to your file...otherwise just press the enter key");
                    add_content=sc.nextLine();
                    try {
                        if(add_content.isEmpty()){
                            res=fileManipulation.addFile(user_input);
                        }else{
                            res=fileManipulation.addFile(user_input,add_content);
                        }

                        if (res){
                            System.out.println("File created successfully.");
                        }else{
                            System.out.println("File already exists..you may want to choose a different file name");
                        }
                    }catch (Exception e){
                        System.out.println("An error occurred during file manipulation");
                        e.printStackTrace();
                    }finally {
                        break;
                    }

                case "2":
                    System.out.println("Please enter the name of the file you want to delete");
                    user_input=sc.nextLine();
                    try {
                        if(!user_input.isEmpty()) {
                            res = fileManipulation.deleteFile(user_input);
                        }else{
                            System.out.println("You need to enter a file name to delete");
                            break;
                        }
                        if (res){
                            System.out.println("File deleted successfully.");
                        }else{
                            System.out.println("File does not exist");
                        }
                    }catch (Exception e){
                        System.out.println("An error occurred during file manipulation");
                        e.printStackTrace();
                    }finally {
                        break;
                    }

                    //break;
                case "3":

                    break;
                case "4":

                    break;
                case "q":
                    break Label_entry;
            }
        }
    }
}
package com.gordonmzizi.presentation;

import com.gordonmzizi.Config.AppConfigPreProd;
import com.gordonmzizi.Config.AppConfigProd;
import com.gordonmzizi.businesslogic.Business;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class App {
    public static void main( String[] args ) {
        //System.setProperty("spring.profiles.active","prod");
        System.setProperty("spring.profiles.active","pre-prod");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigProd.class, AppConfigPreProd.class);
        Business business = context.getBean(Business.class);


        boolean loopControl = true;

        Scanner scanner = new Scanner(System.in);
        menu();
        while (loopControl) {
            System.out.print("> ");
            String userChoice = scanner.next();
            if (userChoice.equals("1") || userChoice.equals("2") || userChoice.equals("3") || userChoice.equals("4") || userChoice.equals("5")
                    || userChoice.equals("6")) {
                Integer userIntChoice = Integer.parseInt(userChoice);


                int choice = userIntChoice;


                switch (choice) {
                    case 1:
                        inputInstruction();
                        System.out.println("Enter a Name");
                        String name = scanner.next();
                        System.out.println("Enter Phone Number");
                        String phoneNumber = scanner.next();

                        ArrayList<Map<String,String>> contact = new ArrayList<>();
                        Map<String,String> contactInfo = new HashMap<>();
                        contactInfo.put("name",name);
                        contactInfo.put("phoneNumber",phoneNumber);
                        contact.add(contactInfo);
                        business.addContact(contact);
                        break;
                    case 2:
                        System.out.println("VIEW CONTACTS");
                        contactsDisplay(business.viewContact());
                        break;
                    case 3:
                        System.out.println("UPDATE CONTACT");
                        System.out.println("Enter a Name");
                        name = scanner.next();
                        System.out.println("Enter Phone Number");
                       phoneNumber = scanner.next();

                        ArrayList<Map<String,String>> contact1 = new ArrayList<>();
                        Map<String,String> contactInfo1 = new HashMap<>();
                        contactInfo1.put("name",name);
                        contactInfo1.put("phoneNumber",phoneNumber);
                        contact1.add(contactInfo1);
                        business.updateContact(contact1);
                        break;
                    case 4:
                        System.out.println("DELETE CONTACT");
                        System.out.println("Enter a Name");
                        name = scanner.next();
                        business.deleteContact(name);
                        break;
                    case 5:
                        menu();
                        choice = userIntChoice;
                        break;
                    case 6:
                        loopControl = false;
                        System.out.println("\nTHANK YOU FOR USING CONTACTS MANAGER\n");
                        break;
                    default:
                        System.out.println("PLEASE PROVIDE VALID KEY");
                        break;
                }
            }else {
                userErrorInstruction();
            }
        }
    }
    public static void menu(){
        System.out.println("___________Contact Manager___________");
        System.out.println("_____________________________________");
        System.out.println("Enter : 1 for ADDING NEW CONTACT     ");
        System.out.println("Enter : 2 for VIEWING CONTACTS       ");
        System.out.println("Enter : 3 for DELETING CONTACT       ");
        System.out.println("Enter : 4 for UPDATING CONTACT       ");
        System.out.println("Enter : 5 for VIEW MENU              ");
        System.out.println("Enter : 6 for EXIT STORAGE           ");
        System.out.println("_____________________________________");
    }
    public static void inputInstruction(){
        System.out.println("____________________________ADDING NEW CONTACT___________________________");
        System.out.println("Provide :Contact Name   and  PhoneNumber                                 ");
        System.out.println("PLEASE NOTE : Contact Name PhoneNumber  Can not be empty                 ");
        System.out.println("_________________________________________________________________________");
        System.out.println();
    }

    public static void userErrorInstruction() {
        System.out.println("____________________________INPUT ERROR__________________________________");
        System.out.println("____________________NUMBER VALUE IS EXPECTED_____________________________");
    }

    public static void contactsDisplay(ArrayList<Map<String,String>> contacts){
        System.out.println("____________________________ CONTACTS ___________________________________\n");
        System.out.println(contacts.size());
        for(int i = 0; i < contacts.size(); ++i){
            System.out.println("Name  \t\t:  "+contacts.get(i).get("name"+i));
            System.out.println("Phone  \t\t:  "+contacts.get(i).get("phoneNumber"+i));
            System.out.println("\n");
        }
    }
}

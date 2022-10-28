package Main;

import DataLayer.Jdbc;
import UiLayer.HomeController;


public class Main {
    public static void main(String[] args){
        //------------------
        HomeController homeControllerObj =new HomeController();
        //---------------------
        System.out.println("Welcome");

        homeControllerObj.regOrLoginOrExitByUser();


    }
}

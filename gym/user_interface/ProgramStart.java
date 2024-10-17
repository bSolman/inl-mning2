package Sprint_Two.gym.user_interface;

import Sprint_Two.gym.MainController;
import Sprint_Two.gym.customer.Customer;

import java.io.IOException;

public class ProgramStart {
    MainController controller;
    UI ui = new UI();
    private final String path_logg = "src/Sprint_Two/gym/logg.txt";
    private final String path_users = "src/Sprint_Two/gym/users.txt";
    public ProgramStart(){
        try {
            controller = new MainController(path_users);
        } catch (IOException e) {
            e.printStackTrace();
        }

        runProgram();
    }

    private void runProgram() {
        String userInput = "";
        while(true){
            userInput = ui.promptWelcome();
            if(userInput.equals("exit")){
                System.exit(0);
            } else{
                if (controller.doesPersonExistString(userInput) != null){
                    Customer customer = controller.doesPersonExistString(userInput);
                    userFound(customer);
                } else if (controller.doesPersonExistLong(testLong(userInput)) != null){
                    Customer customer = controller.doesPersonExistLong(testLong(userInput));
                    userFound(customer);
                } else {
                    ui.promptUserDoesNotExist();
                }
            }
        }
    }


    private void userFound(Customer customer) {
        if (controller.doesPersonHaveValidAccount(customer)){
            ui.promptWelcomeUser(customer.getName());
            try {
                controller.writeToFile(path_logg, customer.getName(), String.valueOf(customer.getPersNr()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            ui.promptUserDontHaveValidAccount(customer);
        }
    }

    private long testLong(String userInput) {
        try {
            return Long.parseLong(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
            return 0;
        }
    }
}

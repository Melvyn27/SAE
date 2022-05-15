package SAE.exeption;

import SAE.graphics.error_interface.VerificationErrorScreen;

public class VerificationExeption extends Exception{
    public VerificationExeption(){
        new VerificationErrorScreen();
    }
    public VerificationExeption(String site){
        new VerificationErrorScreen(site);
    }
    public VerificationExeption(String site1,String site2){
        new VerificationErrorScreen(site1,site2);
    }
}

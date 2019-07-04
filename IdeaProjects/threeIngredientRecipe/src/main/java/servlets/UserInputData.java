package servlets;

import java.util.ArrayList;

public class UserInputData {

        String userRecipeName = null;
        ArrayList userIngredients = new ArrayList();
        String userInstructions = null;

        protected String getUserRecipeName() {
            return userRecipeName;
        }

        public void setUserRecipeName(String userRecipeName) {
            this.userRecipeName = userRecipeName;
        }

        protected ArrayList getUserIngredients() {
            return userIngredients;
        }

        public void setUserIngredients(ArrayList userIngredients) {
            this.userIngredients = userIngredients;
        }

        protected String getUserInstructions() {
            return userInstructions;
        }

        public void setUserInstructions(String userInstructions) {
            this.userInstructions = userInstructions;
        }
    }


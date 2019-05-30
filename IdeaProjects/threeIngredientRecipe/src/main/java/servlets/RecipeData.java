package servlets;

import java.util.ArrayList;

public class RecipeData {
    String recipeName = null;
    ArrayList ingredients = new ArrayList();
    String instructions = null;

    public String getRecipeName() {
        return recipeName;
    }
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public ArrayList getIngredients() {
        return ingredients;
    }
    public void setIngredients(ArrayList ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    }


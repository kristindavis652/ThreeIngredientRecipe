<form/"threeIngredientRecipe/recipe" method = "post">

<!DOCTYPE html>

<style>
body {
background: linear-gradient(#ac5353, #a65959, #9f6060);
          background-color: #ac5353;
          }
          </style>

<h2>Welcome to the Three Ingredient Recipe Site!</h2>


<select name = "recipes">
  <option value="Brownies">Brownies</option>
  <option value="Instant Pot BBQ Chicken">Instant Pot BBQ Chicken</option>
  <option value="Beer Bread">Beer Bread</option>
</select>
<input type="submit" value="Submit">
</form>

<h3>Would you like to enter your own Three Ingredient Recipe?</h3>
<form>
  Recipe Title:<br>
  <input type="text" title="recipeTitle"><br>
  Ingredient 1:<br>
  <input type="text" ingredient="ingredientOne"><br>
  Ingredient 2:<br>
  <input type="text" ingredient ="ingredientTwo"><br>
  Ingredient 3:<br>
  <input type="text" ingredient ="ingredientThree"><br>
  Instructions:<br>
  <input type="text" instructions="instructions"><br>

  <input type="submit" value="Submit">
</form>
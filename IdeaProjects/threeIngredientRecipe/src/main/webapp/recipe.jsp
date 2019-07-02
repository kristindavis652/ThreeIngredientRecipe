<form/"threeIngredientRecipe/recipe" method = "post">

<!DOCTYPE html>
<html lang="en">
<head>
<link href="https://fonts.googleapis.com/css?family=Montserrat:200&display=swap" rel="stylesheet">
<title>Page Title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: 'Montserrat', sans-serif;
  margin: 0;
}

.header {
  padding: 25px;
  text-align: center;
  background: #262626;
  color: MediumAquaMarine;
  font-size: 35px;
}
.content {padding:20px;}
</style>
</head>
<body>

<div class="header">
  <h1>THREE INGREDIENTS</h1>
  <p>ONE SIMPLE RECIPE.</p>
</div>

<h3>
<select name = "recipes">
  <option value="Brownies">Brownies</option>
  <option value="Instant Pot BBQ Chicken">Instant Pot BBQ Chicken</option>
  <option value="Beer Bread">Beer Bread</option>
</select>
<input type="submit" value="Submit">
</form>
</h3>

<p>Feeling inspired? <a href="http://localhost:8888/userrecipe">Create your own Three Ingredient Recipe.</a></p>


</body>
</html>

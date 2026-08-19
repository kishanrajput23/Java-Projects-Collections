const searchInput = document.getElementById('search-input');
const searchButton = document.getElementById('search-button');
const recipeList = document.getElementById('recipe-list');

searchButton.addEventListener('click', () => {
    const searchTerm = searchInput.value;
    if (searchTerm) {
        searchRecipes(searchTerm);
    }
});

function searchRecipes(query) {
    fetch(`https://www.themealdb.com/api/json/v1/1/search.php?s=${query}`)
        .then(response => response.json())
        .then(data => {
            recipeList.innerHTML = '';
            if (data.meals) {
                data.meals.forEach(meal => {
                    const recipeCard = createRecipeCard(meal);
                    recipeList.appendChild(recipeCard);
                });
            } else {
                recipeList.innerHTML = '<p>No recipes found. Please try a different search term.</p>';
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function createRecipeCard(meal) {


    const recipeCard = document.createElement('div');
    recipeCard.classList.add('col-lg-6');
   
    const card = document.createElement('div')
    card.classList.add('card')

    const img = document.createElement('img');
    img.classList.add('img-fluid')
    img.src = meal.strMealThumb;
    img.alt = meal.strMeal;
    card.appendChild(img);

    const title = document.createElement('h2');
    title.textContent = meal.strMeal;
    card.appendChild(title);

    const instructions = document.createElement('p');
     instructions.textContent = meal.strInstructions;
     card.appendChild(instructions);

     recipeCard.appendChild(card)
     
    return recipeCard;
}

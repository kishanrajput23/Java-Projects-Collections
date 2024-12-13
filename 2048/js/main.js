on(window, 'load', function () {
    var view = new View();
    var game = new Game();
    game.init(view);
    event(game);
});
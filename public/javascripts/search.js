'use strict';

var searchResult = $('.search-result');
var tbody = $('.search-result tbody');

// on Enter button
$('#title').keypress(function (e) {
  if (e.keyCode === 13 || e.keyCode === 10) search($('#title').val());
});

$('.search-button').click(function () {
  search($('#title').val());
});

function search(title) {
  if (!title) return;
  JSRouter.controllers.Search.get(title).ajax({
    success: function (games) {
      if (!games[0]) {
        searchResult.hide();
        return $('.info-message').html('Il n\'existe aucune réservation à ce nom.');
      }
      renderGames(games);
    },
    error: function () {
      $('.info-message').html('<div class="alert alert-danger" role="alert">Oops, nous n\'avons pas réussi à récupérer les réservations...</div>');
    }
  });
}

function renderGames(games) {
  $('.info-message').html('');
  searchResult.show();
  tbody.html('');
  _.forEach(games, function(game) {
    game.start_date = moment(game.start_date).format('D MMMM YYYY - HH:MM');
    game.action = '<a class="btn btn-primary" href="/games/' + game.id + '/edit">Modifier</a>';
    tbody.append(_.template('<tr class="result-line"><td>${name}</td><td>${alley}</td><td>${phone}</td><td>${start_date}</td><td>${action}</td></tr>')(game));
  })
}

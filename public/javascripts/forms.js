'use strict';

$('#start_date').val("2015-04-15T15:00"); // DEBUG: autofill date-time
var addPlayerButton = '<a class="btn btn-default add-player">Ajouter un joueur</a>';
var deletePlayerButton = '<a class="btn btn-default delete-player disabled">-</a>';

// modal to confirm deletion
$('.delete-button').click(function (e)  {
  e.preventDefault();
});

$('#confirm-delete').on('show.bs.modal', function (e) {
  $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
});

// dynamic form (add/delete lines with +/- buttons
$('.teams').parent().append(addPlayerButton);
$('.players').parent().append(deletePlayerButton);
var player;
$('.add-player').click(function () {
  player = $(this);
  var lastPlayer = $(this).parents().eq(2).children().last().children().last();
  var newPlayer = incrementIDs(lastPlayer.clone());
  $('#teams_0_players').append(newPlayer);
  $('.add-player').first().parent().parent().parent().find('.delete-player').removeClass("disabled", false);
});

// we need to do this because play use this id to render/save form
function incrementIDs(player) {
  var current = player.attr('id');
  var id = current.replace(/[0-9]+(?!.*[0-9])/, parseInt(current.match(/[0-9]+(?!.*[0-9])/), 10) + 1);
  player.attr('id', id);
  player.children().children().first().attr('for', id + '_name');
  player.find('input').attr('id', id + '_name');
  player.find('input').attr('name', toPlayFormat(id) + '.name');
  return player;
}

function toPlayFormat(id) {
  return id.split('').reduce(function(m, ltr) {
    if(ltr === '_') {
      m.even ? m.str += '[' : m.str += '].';
      m.even = !m.even;
    } else {
      m.str += ltr;
    }
    return m;
  }, {even: true, str: ''}).str + ']';
}

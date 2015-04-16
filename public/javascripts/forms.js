'use strict';

$('#start_date').val("2015-04-15T15:00"); // DEBUG: autofill date-time

/// Init
var addPlayerButton = '<a class="btn btn-default add-player">Ajouter un joueur</a>';
var deletePlayerButton = '<a class="btn btn-default delete-player disabled">-</a>';
$('.input-team').parent().append(addPlayerButton);
$('.players').parent().append(deletePlayerButton);

/// Modal to confirm deletion
$('.delete-button').click(function (e)  {
  e.preventDefault();
});

$('#confirm-delete').on('show.bs.modal', function (e) {
  $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
});

/// dynamic form (add/delete lines with +/- buttons
$('.add-player').click(function () {
  var index = getIndex.call($(this));
  var players = getPlayers(index);
  var playerlength = players.length;

  if (playerlength === 1) enableDelete(index, true);
  if (playerlength === 4) enableAdd(index, false);
  if (playerlength === 5) return;

  var newPlayer = players.last().clone();
  newPlayer.find('input').val('');
  $('#teams_' + index + '_players').append(newPlayer);
  updateIDs(getPlayers(index));
});

// we need to do this because players are dynamically created, thus not binded to event
$('body').on('click', '.delete-player', function () {
  var index = getIndex.call($(this));
  var players = getPlayers(index);

  if (players.length === 1) return;
  if (players.length === 2) enableDelete(index, false);

  $(this).parent().parents().eq(2).remove();
  updateIDs(getPlayers(index));
});


/// Buttons controls
function enableButton(button, index, enable) {
  var element = $('#teams').children().eq(index).find(button);
  if (enable) return element.removeClass('disabled');
  element.addClass('disabled');
}

function enableAdd(index, enable) {
  enableButton('.add-player', index, enable);
}

function enableDelete(index, enable) {
  enableButton('.delete-player', index, enable);
}

/// Helpers

// we need to do this because play use this id to render/save form
function updateIDs(players) {
  return $.each(players, function(index, player) {
    player = $(player);
    var current = player.attr('id');
    var id = current.replace(/[0-9]+(?!.*[0-9])/, index);
    player.attr('id', id);
    player.children().children().first().attr('for', id + '_name');
    player.find('input').attr('id', id + '_name');
    player.find('input').attr('name', toPlayFormat(id) + '.name');
    console.log(player.attr('id'));
  });
}

function toPlayFormat(id)  {
  return id.split('').reduce(function (m, ltr) {
    if (ltr === '_') {
      m.even ? m.str += '[' : m.str += '].';
      m.even = !m.even;
    } else {
      m.str += ltr;
    }
    return m;
  }, {
    even: true,
    str: ''
  }).str + ']';
}

function getIndex() {
  return this.siblings().first().attr('id').match(/^\d+|\d+\b|\d+(?=\w)/g)[0];
}

function getPlayers(index) {
  return $('#teams').find('#teams_' + index + '_players').children();
}

$('#start_date').val("2015-04-15T15:00"); // DEBUG: autofill date-time

// modal to confirm deletion
$('.delete-button').click(function (e)  {
  e.preventDefault();
});

$('#confirm-delete').on('show.bs.modal', function (e) {
  $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
});

// dynamic form (add/delete lines with +/- buttons
$('.teams').parent().append('<a class="btn btn-default add-player">Ajouter un joueur</a>');
$('.players').parent().append('<a class="btn btn-default delete-player">-</a>');

//$('.add-team').click(function() {
//  console.log($(this).parent());
//});

$('#start_date').val("2015-04-15T15:00"); // DEBUG: autofill date-time

// modal to confirm deletion
$('.delete-button').click(function (e)  {
  e.preventDefault();
});

$('#confirm-delete').on('show.bs.modal', function (e) {
  $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
});

// dynamic form (add/delete lines with +/- buttons



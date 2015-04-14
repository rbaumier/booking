// DEBUG: autofill date-time: $('#start_date').val("2015-04-14T15:00");

$('.delete-button').click(function(e) {
  e.preventDefault();
});

$('#confirm-delete').on('show.bs.modal', function (e) {
  $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
});

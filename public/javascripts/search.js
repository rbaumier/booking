$('.search-button').click(function () {
  // + on enterbutton
  var title = $('#title').val();
  JSRouter.controllers.Search.get(title).ajax({
    success: function (data) {
      console.log(data);
      // si data vide, afficher message
    },
    error: function () {
      $('.container').append('<div class="alert alert-danger" role="alert">Oops, nous n\'avons pas réussi à récupérer les réservations...</div>');
    }
  });
});

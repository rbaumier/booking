var calendar = $('#calendar');

function getGames() {
  JSRouter.controllers.Games.getAll().ajax({
    success: function (data) {
      console.log('data:', data);
    },
    error: function () {
      // TODO: bootstrap notify
      console.log('cannot recover games');
    }
  });

}

function initCalendar(events) {
  calendar.fullCalendar({
    header: {
      left: 'prev,next today',
      center: 'title',
      right: 'month,agendaWeek,agendaDay'
    },
    lang: 'fr',
    allDaySlot: false,
    defaultView: 'agendaDay',
    buttonIcons: true, // show the prev/next text
    weekNumbers: true,
    editable: true,
    events: events,
    minTime: "12:00",
    maxTime: "24:00"
  });
}

getGames();

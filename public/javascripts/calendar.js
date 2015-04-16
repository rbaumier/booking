var calendar = $('#calendar');
var AVERAGE_DURATION = 10; // in minutes => https://answers.yahoo.com/question/index?qid=20080802193426AAWE8pI
var COLORS = ['#e59d6b', '#8c0706', '#bac26f', '#438dbb', '#c4502a', '#69a8da', '#5d5f78', '#8099b5', '#4e54aa', '#2e6bf0'];

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
    editable: false,
    events: events,
    minTime: "12:00",
    maxTime: "24:00"
  });
}

(function getGames() {
  JSRouter.controllers.Games.getAll().ajax({
    success: function (data) {
      initCalendar(toEventObject(data));
    },
    error: function () {
      console.log('cannot recover games'); // TODO: bootstrap notify
    }
  });

}());

// http://fullcalendar.io/docs/event_data/Event_Object/
function toEventObject(games) {
  return _.map(games, function (game) {
    return {
      id: game.id,
      title: game.name,
      start: game.start_date,
      end: game.start_date + gameDuration(game),
      url: '/games/' + game.id + '/edit',
      // className: CSS class
      // source: ?
      color: COLORS[game.alley + 1]
    }
  });
}

function gameDuration(game) {
  return AVERAGE_DURATION * game.teams.length * _.reduce(game.teams, function (m, team) {
    return m + team.players.length;
  }, 0) * 60 * 1000; // min to ms
}

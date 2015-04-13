$(document).ready(function () {

  $('#calendar').fullCalendar({
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
    eventLimit: true, // allow "more" link when too many events
    events: [],
    minTime: "12:00",
    maxTime: "24:00"
  });

});

var calendar = $('#calendar');

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
  events: [],
  minTime: "12:00",
  maxTime: "24:00"
});


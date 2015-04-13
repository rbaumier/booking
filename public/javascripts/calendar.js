$(document).ready(function () {

// '2015-02-12'
function today() {
  return moment()
  .format('L')
  .replace(/\//g,'-');
}

  $('#calendar').fullCalendar({
    header: {
      left: 'prev,next today',
      center: 'title',
      right: 'month,basicWeek,basicDay'
    },
    defaultDate: today(),
    defaultView: 'basicDay',
    editable: true,
    eventLimit: true,
    events: []

  });

});

$(document).ready(function(){
	$('button').click(function(){
		$.get('http://localhost:8080/webService/api/velocities', function(notes, status){
			alert('\Status: '+ status);
			createTable(notes);
		});
	});
});

function createTable(notes) {
var txt= '<table class=\"table table-striped\"><tr><th>Tier</th><th>Maximalgeschwindigkeit</th></tr>';
	$.each(notes, function(key, note){
		txt+='<tr><td>'+note.animal+'</td><td>'+note.velocity+'</td></tr>';
	});
	txt+='</table>';
	$('p').html(txt);
}
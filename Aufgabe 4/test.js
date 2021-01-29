$(document).ready(function(){
	$('button').click(function(){
		$.get('http://localhost:8080/webService/api/velocities', function(notes, status){
			alert('\Status: '+ status);
			createTable(notes);
		});
	});
});

function createTable(notes) {};

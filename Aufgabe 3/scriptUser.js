function checkInputs()
{
var res = true;

var formular = document.formNewUser;
if(formular.name.value == '') {res = false;}
if(formular.passwordfield.value == '') {res = false;}
if(formular.email.value == '') {res = false;}

var reg1 = /(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{10,20}/;
var reg2 = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

if(reg1.test(formular.passwordfield.value) == false) {res = false;}
if(reg2.test(formular.email.value) == false) {res = false;}

if(res == false) {alert('Bitte Formular vollständig asufüllen')}
return res;
}
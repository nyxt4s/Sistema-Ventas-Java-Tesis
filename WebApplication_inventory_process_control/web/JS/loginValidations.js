/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




var inputUsername = document.getElementById("inputUsername");
var inputPassword = document.getElementById("inputPassword");
var buttonSubmit = document.getElementById("buttonSubmit");

buttonSubmit.disabled = true;


function inputsFormValidation() {
  if (inputUsername.value.length>0 && inputPassword.value.length>0){
    buttonSubmit.disabled = false;
    buttonSubmit.classList.remove("disabled");
    
  } else {
      buttonSubmit.disabled = true;
  }
}


// Get the modal
 var modal = document.getElementById('myModal');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
};
// When the user clicks on <span> (x), close the modal
function closeModal() {
    document.getElementById('myModal').style.display='none'
};



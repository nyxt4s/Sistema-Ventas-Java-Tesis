

/** Graficos 
var ctx = document.getElementById('myChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['01/12/2020', '02/12/2020', '03/12/2020', '04/12/2020', '05/12/2020', '06/12/2020',
        '07/12/2020', '08/12/2020', '09/12/2020', '10/12/2020', '11/12/2020'],
        datasets: [{
            label: '# Ventas',
            data: [12, 19, 3, 5, 2, 3, 5, 9, 10, 5, 25],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 99, 132, 0.2)'
           
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 99, 132, 1)'
                
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});



 END Graficos**/




(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();


function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}


function OcultarContenedor() {
    var x = document.getElementById("ContainerHeaderPanelBody");
    
    if (x.style.display === "none") {
        x.style.display = "block";
         document.querySelector('#OcultarBtn').innerText = 'Ocultar';
    } else {
        x.style.display = "none";
        document.querySelector('#OcultarBtn').innerText = 'Mostrar';
    }
   
}

function OcultarContenedorRevert() {
    var x = document.getElementById("ContainerHeaderPanelBody");
    
    if (x.style.display === "block") {
        x.style.display = "none";
         document.querySelector('#OcultarBtn').innerText = 'Mostrar';
    } else {
        x.style.display = "block";
        document.querySelector('#OcultarBtn').innerText = 'Ocultar';
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





function reduceNavbar(){
  var navbar2 = document.getElementById("navbar2");

  navbar2.classList.toggle("navbar-custom2-Responive"); 

}



/* SIMPLE DARK MODE FUNCTION*/
function cambiarModo() { 
  var cuerpoweb = document.body; 
  var Container = document.getElementById("Container");
  var containerHeader = document.getElementById("ContainerHeader");
  var ContainerContent = document.getElementById("ContainerHeaderPanelBody");
  
  var containerHeaderDatatable = document.getElementById("ContainerHeaderDatatable");
  var ContainerContentDatatable= document.getElementById("ContainerHeaderPanelBodyDatatable");
  
  
  
  cuerpoweb.classList.toggle("oscuroBody"); 
  
  containerHeader.classList.toggle("oscuroPanelHeader"); 
  ContainerContent.classList.toggle("oscuroPanelBody"); 
  containerHeaderDatatable.classList.toggle("oscuroPanelHeader"); 
  ContainerContentDatatable.classList.toggle("oscuroPanelBody"); 
 
} 


/* END SIMPLE DARK MODE FUNCTION*/


/* DARK MODE FUNCTIONS*/
/*
const toggleSwitch = document.querySelector('.theme-switch input[type="checkbox"]');
const currentTheme = localStorage.getItem('theme');

if (currentTheme) {
    document.documentElement.setAttribute('data-theme', currentTheme);
  
    if (currentTheme === 'dark') {
        toggleSwitch.checked = true;
    }
}

function switchTheme(e) {
    if (e.target.checked) {
        document.documentElement.setAttribute('data-theme', 'dark');
        localStorage.setItem('theme', 'dark');
    }
    else {        document.documentElement.setAttribute('data-theme', 'light');
          localStorage.setItem('theme', 'light');
    }    
}

toggleSwitch.addEventListener('change', switchTheme, false);
*/
/* END DARK MODE FUNCTIONS */


/*navbar-custom2-Responive */

jQuery(function ($) {
    
    

/* Hamburer Menu Animation */
  $(document).ready(function () {

    $('.first-button').on('click', function () {
  
      $('.animated-icon1').toggleClass('open');
    });
    $('.second-button').on('click', function () {
  
      $('.animated-icon2').toggleClass('open');
    });
    $('.third-button').on('click', function () {
  
      $('.animated-icon3').toggleClass('open');
    });
  });
/* End Hamburer Menu Animation */

  // Dropdown menu
  $('.sidebar-dropdown > a').click(function () {
    $('.sidebar-submenu').slideUp(200);
    if ($(this).parent().hasClass('active')) {
      $('.sidebar-dropdown').removeClass('active');
      $(this).parent().removeClass('active');
    } else {
      $('.sidebar-dropdown').removeClass('active');
      $(this).next('.sidebar-submenu').slideDown(200);
      $(this).parent().addClass('active');
    }
  });

  $("button").click(function(){
    $("button").removeClass("active");
    $(this).addClass("active");
  });

  //toggle sidebar
  $('#toggle-sidebar').click(function () {
    $('.page-wrapper').toggleClass('toggled');
   
  })
  
  
  ;
  

  // bind hover if pinned is initially enabled
  if ($('.page-wrapper').hasClass('pinned')) {
    $('#sidebar').hover(
      function () {
        console.log('mouseenter');
        $('.page-wrapper').addClass('sidebar-hovered');
      },
      function () {
        console.log('mouseout');
        $('.page-wrapper').removeClass('sidebar-hovered');
      }
    );
  }

  //Pin sidebar
  $('#pin-sidebar').click(function () {
    if ($('.page-wrapper').hasClass('pinned')) {
      // unpin sidebar when hovered
      $('.page-wrapper').removeClass('pinned');
      $('#sidebar').unbind('hover');
    } else {
      $('.page-wrapper').addClass('pinned');
      $('#sidebar').hover(
        function () {
          console.log('mouseenter');
          $('.page-wrapper').addClass('sidebar-hovered');
        },
        function () {
          console.log('mouseout');
          $('.page-wrapper').removeClass('sidebar-hovered');
        }
      );
    }
  });

  //toggle sidebar overlay
  $('#overlay').click(function () {
    $('.page-wrapper').toggleClass('toggled');
  });

  //switch between themes
  var themes =
    'default-theme legacy-theme chiller-theme ice-theme cool-theme light-theme';
  $('[data-theme]').click(function () {
    $('[data-theme]').removeClass('selected');
    $(this).addClass('selected');
    $('.page-wrapper').removeClass(themes);
    $('.page-wrapper').addClass($(this).attr('data-theme'));
  });

  // switch between background images
  var bgs = 'bg1 bg2 bg3 bg4';
  $('[data-bg]').click(function () {
    $('[data-bg]').removeClass('selected');
    $(this).addClass('selected');
    $('.page-wrapper').removeClass(bgs);
    $('.page-wrapper').addClass($(this).attr('data-bg'));
  });

  // toggle background image
  $('#toggle-bg').change(function (e) {
    e.preventDefault();
    $('.page-wrapper').toggleClass('sidebar-bg');
  });

  // toggle border radius
  $('#toggle-border-radius').change(function (e) {
    e.preventDefault();
    $('.page-wrapper').toggleClass('boder-radius-on');
  });

  //custom scroll bar is only used on desktop
  if (
    !/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(
      navigator.userAgent
    )
  ) {
    $('.sidebar-content').mCustomScrollbar({
      axis: 'y',
      autoHideScrollbar: true,
      scrollInertia: 300,
    });
    $('.sidebar-content').addClass('desktop');
  }
});

<%-- 
    Document   : index
    Created on : 26-nov-2020, 18:56:05
    Author     : claud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es-CL">
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
       
        <!--<link href="../CSS/LoginCSS.css" rel="stylesheet" />-->
        
        <!-- RUTAS RELATIVAS
        Forma 1
        ${pageContext.request.contextPath}
        
        Forma 2
        <%= request.getContextPath()%> -->
        <!-- <link rel=stylesheet type="text/css" href="/CSS/LoginCSS.css"> -->
        
        <!-- BOOSTRAP -->
     <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        
        <link rel=stylesheet type="text/css" href="<%= request.getContextPath()%>/CSS/LoginCSS.css">
        
          <script
        src="https://kit.fontawesome.com/64d58efce2.js"
        crossorigin="anonymous">
         </script>
        <title>Inicio de Sesión</title>
    </head>
   
    <body>
        <% try {
                  if (request.getAttribute("msg")!= null) {
                      
                      
               out.print("<div id='myModal' class='modal'>");
                  out.print("<div class='modal-content'>");
                    out.print("<div class='modal-header'>");
                      out.print("<span class='close' onclick='closeModal()'>&times;</span>");
                      out.print("<h2>Información</h2>");
                    out.print("</div>");
                    out.print("<div class='modal-body'>");
                      out.print("<p>"+request.getAttribute("msg")+"</p>");
                      
                    out.print("</div>");
                    out.print("<div class='modal-footer'>");
                      out.print("<h3></h3>");
                    out.print("</div>");
                  out.print("</div>");
               out.print("</div>  ");
               
                      /* out.print("<div id='id01' class='modal'>");
                          out.print("<div class='modal-content'>");
                            out.print("<header class='w3-container w3-teal'> ");
                              out.print("<span onclick='closeModal()'");
                              out.print("class='w3-button w3-display-topright'>&times;</span>");
                              out.print("<h2>Modal Header</h2>");
                            out.print("</header>");
                            out.print("<div class='w3-container'>");
                              out.print("<p>Some text..</p>");
                              out.print("<p>"+request.getAttribute("msg")+"</p>");
                            out.print("</div>");
                            out.print("<footer class='w3-container w3-teal'>");
                              out.print("<p>Modal Footer</p>");
                            out.print("</footer>");
                          out.print("</div>");
                        out.print("</div>");*/
                                                
                  }else{
                      
                  }  
                             }catch(Exception ex){}
                            %>
                            
    <div class="container">
        
      
      <div class="forms-container">

        <div class="signin-signup">
          
          <!-- Form -->
          <form action="/WebApplication_inventory_process_control/Auth" method="post" class="sign-in-form" >

            <!-- Title-->
            <div class="title-Form">
            <h2 class="title">Inicio de Sesión</h2>
            
             

            </div>

            <!-- Div Username input field-->
            <div class="Username-Label">
             <label >Nombre de usuario</label>
            </div>
            <div class="input-field">
                
              <i class="fas fa-user"></i>
              <input id="inputUsername" type="text" placeholder="Nombre de usuario" name="username" onkeyup="inputsFormValidation()" required/>
              
            </div>
            
            

            <!-- Div Password input field-->
            <div>
                <label class="Passwprd-Label" >Contraseña</label>
            </div>
            <div class="input-field">
                <i class="fas fa-lock"></i>
                <input id="inputPassword" type="password" placeholder="••••••••••••" name="password" onkeyup="inputsFormValidation()" required/>
            </div>

            <!-- Div Button Submit -->
            <div class="Div-Button-Submit"> 
                <input id="buttonSubmit" type="submit" value="Ingresar" class="btn" disabled/>
            </div>

          </form>
<% /**try {
                  if (request.getAttribute("msg")!= null) {
                 
                       out.print("<span class='spanMsgAuthenticationLogin'>"+request.getAttribute("msg")+"</span>");
                       
                        
                                                
                  }else{
                      
                  }  
                             }catch(Exception ex){}**/
                            %>
        </div>
        

      </div>

    </div>

    
  </body>
  
  <script src="<%= request.getContextPath()%>/JS/loginValidations.js"></script>
</html>


    <% /**
    <body>
        
        <form action="../Auth" method="POST">
        
            <div class="v1_3">
            <div class="v5_0">

            </div>
        <!-- Nombre del formulario-->
            <span class="v5_1">Iniciar sesión</span>
        <!-- Fin Nombre del formulario-->

        <!-- Input Nombre de usuario -->
            <!-- Label Nombre de Usuario-->
                <span class="v5_6">Nombre de Usuario</span>
            <!-- Fin Label Nombre de Usuario-->
     
            <div class="v14_4">

                    <input type="text" class="v8_10" > 
                  
            </div>
         <!-- Fin Input Nombre de usuario -->

            <!-- Input Contraseña -->
            <span class="v5_8">Contraseña</span>
                <div class="v14_3">
                    

                    <input type="text" class="v8_11" > 
                  
            </div>
            </div>
            <!-- Fin Input Contraseña -->

            <!-- <div class="v14_2">
                <span class="v8_17">Recordar credenciales</span>
                <div class="v8_16"></div>
            </div> -->

            
            <!-- Button Iniciar Sesión-->
                <div class="v8_12"> 
                    <div class="v5_5">
                        <input type="submit" class="v5_5" value="Iniciar sesión">
                    </div>
                </div>
            <!-- Fin Button Iniciar Sesión-->
 
        </form>
    </body>
    
    </html>
    **/
    %> 

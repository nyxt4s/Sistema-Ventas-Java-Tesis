<%-- 
    Document   : AdminstracionTipoUsuario
    Created on : 06-dic-2020, 19:17:21
    Author     : claud
--%>

<%@page import="MODEL.TipoDeUsuario"%>
<%@page import="java.util.LinkedList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    if (session.getAttribute("username") == null) {
       response.sendRedirect("index.jsp");
    } 
%>
<!DOCTYPE html>
<html lang="es_CL">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description"
        content="Responsive sidebar template with sliding effect and dropdown menu based on bootstrap 3">
    <title>Administración tipo de usuarios</title>

    <!-- using online links -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
        integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
        integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    <link rel="stylesheet" href="//malihu.github.io/custom-scrollbar/jquery.mCustomScrollbar.min.css">
    
    
  <!-- Link DATATABLE -->
     <!-- CSS personalizado --> 
     <link rel="stylesheet" href="<%= request.getContextPath()%>/DataTables/main.css">  
     <!--datables CSS básico-->
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/DataTables/datatables.min.css"/>
     <!--datables estilo bootstrap 4 CSS-->  
     <link rel="stylesheet"  type="text/css" href="<%= request.getContextPath()%>/DataTables/DataTables-1.10.22/css/dataTables.bootstrap4.min.css">
 <!-- Link DATATABLE custom-->
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/DataTables/datatables.css"/>
    
 <!-- LINK CSS Sidebar-->
    <link rel="stylesheet" href="<%= request.getContextPath()%>/CSS/main.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/CSS/sidebar-themes.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/CSS/style.css">
    <link rel="shortcut icon" type="image/png" href="<%= request.getContextPath()%>/img/favicon.png" />


   
</head>

<body>
    
    <%          System.out.println("Atributo: "+request.getAttribute("msg1"));
                  if (request.getAttribute("msg1")!= null) {
                      
                      //System.out.println(request.getAttribute("msg1"));
               out.print("<div id='myModal' class='modalInformacion'>");
                  out.print("<div class='modalInformacion-content'>");
                    out.print("<div class='modalInformacion-header'>");
                     out.print("<span class='closeModal' onclick='closeModal()'>&times;</span>"); 
                        out.print("<h2>Información</h2>");
                     
                     
                    out.print("</div>");
                    out.print("<div class='modalInformacion-body'>");
                    out.print("<h4>"+request.getAttribute("msg1")+"</h4>");
                      
                    out.print("</div>");
                    out.print("<div class='modalInformacion-footer'>");
                      out.print("<h3></h3>");
                    out.print("</div>");
                  out.print("</div>");
               out.print("</div>");
                           
                  }
                            %>

  
<!-- Navmenu -->
  <nav class="navbar navbar-expand-lg  navbar-dark  navbar-custom ">
    <a class="navbar-brand" href="#">Medina Celedonio System</a>
    <!-- HamburgerMenu-->
        <button class="navbar-toggler " type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    <!-- end HamburgerMenu-->

    <div class="collapse navbar-collapse " id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto navbar-nav-custom">
        <li class="nav-item ">
            <!--<button type="button" class="btn btn-dark" onclick="cambiarModo()">Oscuro / Claro</button>-->
          
            <!-- dark mode2 -->
            <div class="DarkMode2-margin">
                <input type="checkbox" class="checkboxSlider"  onclick="cambiarModo()" id="chk" />
                <label class="labelSlider" for="chk">
                    <i class="fas fa-sun"></i>
                    <i class="fas fa-moon"></i>
                    <div class="ball"></div>
                </label>
            </div>
            <!-- end dark mode 2-->

        <!-- dark mode1
            <div class="theme-switch-wrapper ">
            
                <label class="theme-switch" for="checkbox">
                    <input type="checkbox" id="checkbox"  onclick="cambiarModo()"/>
                    <div class="slider round"></div>
                </label>
            
           </div>-->
            <!-- end dark mode 1-->


        </li>
        
      </ul>
    
      <!-- Button drop down Nombre de usuario  -->
      <div class="btn-group ">
        <button type="button" class="btn  dropdown-toggle btn-username-custom" data-toggle="dropdown" data-display="static" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-user-circle fa-2x"></i>
          Nombre de usuario 
        </button>
        <div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-left">
            <button class="dropdown-item" type="button">Mi Perfil</button>
            <button class="dropdown-item" type="button">Bloquear Pantalla</button>
        <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Cerrar Sesión</a>
        </div>
      </div>
       <!-- END Button drop down Nombre de usuario  -->
    </div>
  </nav>
<!-- END Navmenu -->



<!-- end Navmenu -->

<!-- Navmenu 2-->

<nav class="navbar navbar-expand-lg  navbar-dark  navbar-custom2" id="navbar2">
    
    <div class="collapse navbar-collapse " id="navbarSupportedContent">

      <ul class="navbar-nav ml-auto navbar-nav-custom2">
          
        <li class="nav-item ">
            
        </li>
        <!-- Breadcrumb Navigation-->
        <li class="nav-item">
          <a class="nav-link"><i class="fa fa-tachometer-alt"></i> / Principal</a>
          
        </li>
        <li class="nav-item ">
            <a class="nav-link">/ Principal</a>
          </li>
          <li class="nav-item ">
            <a class="nav-link">/ Principal</a>
          </li>
        <!-- END Breadcrumb Navigation-->
      </ul>
    
    </div>
  </nav>
<!-- END Navmenu 2-->

    <!-- page-wrapper-->
    <div class="page-wrapper bg0 toggled legacy-theme">
      
        <nav id="sidebar" class="sidebar-wrapper">
          
         
          
            <div class="sidebar-content">
              <div class="sidebar-item sidebar-brand">
                
                
            </div>
               
               <div class=" sidebar-item sidebar-menu">
                    <ul>
                        <li class="header-menu">
                            <span></span>
                        </li>
                        <li >
                            <a href="Principal.jsp">
                                <i class="fa fa-tachometer-alt"></i>
                                <span class="menu-text">Principal</span>
                                
                            </a>
                            
                        </li>
                        
                        <li class="sidebar-dropdown">
                            <a href="#">
                                <i class="fa fa-shopping-cart"></i>
                                <span class="menu-text">Ventas</span>
                            </a>
                            <div class="sidebar-submenu">
                                <ul>
                                    <li>
                                        <a href="RealizarVenta.jsp">Realizar venta

                                        </a>
                                    </li>
                                    <li>
                                        <a href="HistorialDeVentas.jsp">Historial de ventas</a>
                                    </li>
                                   
                                </ul>
                            </div>
                        </li>
                        <li class="sidebar-dropdown">
                            <a href="#">
                                <i class="fas fa-dolly-flatbed"></i>
                                <span class="menu-text">Administración de inventario</span>
                            </a>
                            <div class="sidebar-submenu">
                                <ul>
                                    <li>
                                        <a href="ListaDeProductos.jsp">Lista de productos</a>
                                    </li>
                                    
                                   
                                </ul>
                            </div>
                        </li>
                        <li class="sidebar-dropdown">
                            <a href="#">
                                <i class="fas fa-boxes"></i>
                                <span class="menu-text">Administración de marcas</span>
                            </a>
                            <div class="sidebar-submenu">
                                <ul>
                                    <li>
                                        <a href="ListaDeMarcas.jsp">Lista de marcas</a>
                                    </li>
                                  
                                   
                                </ul>
                            </div>
                        </li>
                        <li class="sidebar-dropdown">
                            <a href="#">
                                <i class="fas fa-boxes"></i>
                                <span class="menu-text">Administración de categorias</span>
                            </a>
                            <div class="sidebar-submenu">
                                <ul>
                                    <li>
                                        <a href="ListaDeCategorias.jsp">Lista de categorias</a>
                                    </li>
                                   
                                </ul>
                            </div>
                        </li>
                      <li class="sidebar-dropdown">
                          <a href="#">
                            <i class="fas fa-users"></i>
                              <span class="menu-text">Administración de usuarios</span>
                          </a>
                          <div class="sidebar-submenu">
                              <ul>
                                  <li>
                                       <a href="AdministracionDeUsuarios.jsp" >Lista de usuarios</a>
                                  </li>
                                  <li>
                                      <a href="AdminstracionTipoUsuario.jsp">Tipo de usuario</a>
                                  </li>
                                  <li>
                                    <a href="ActividadDeUsuarios.jsp">Actividad de usuarios</a>
                                 </li>
                                <li>
                                    <a href="PermisosDeUsuarios.jsp">Permisos de usuarios</a>
                                </li>
                              </ul>
                          </div>
                      </li>
                      <li class="sidebar-dropdown">
                            <a href="#">
                                <i class="fas fa-parachute-box"></i>
                                <span class="menu-text">Proveedores</span>
                            </a>
                            <div class="sidebar-submenu">
                                <ul>
                                    <li>
                                        <a href="ListaDeProveedores.jsp">Lista de proveedores</a>
                                    </li>
                                    
                                </ul>
                            </div>
                        </li>
                        <li>
                            <a href="SolicitudDeMercaderia.jsp">
                                <i class="fa fa-calendar"></i>
                                <span class="menu-text">Solicitud de mercaderia</span>
                            </a>
                        </li>
                        <li>
                            <a href="AdministracionDeLocales.jsp">
                                <i class="fas fa-store-alt"></i>
                                <span class="menu-text">Administración de locales</span>
                            </a>
                        </li>
                       
                        
                        <li class="sidebar-dropdown">
                            <a href="#">
                                <i class="fas fa-exchange-alt"></i>
                                <span class="menu-text">Administracion de tipo de movimiento</span>
                            </a>
                            <div class="sidebar-submenu">
                                <ul>
                                    <li>
                                        <a href="ListaDeMovimientos.jsp">Lista de movimientos</a>
                                    </li>
                                    <li>
                                        <a href="RegistrarMovimiento.jsp">Registrar un movimiento
                                        </a>
                                    </li>
                                    <li>
                                        <a href="ListaDeTipoDeMovimientos.jsp">Lista de tipo de movimientos
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="sidebar-dropdown">
                            <a href="#">
                                <i class="far fa-chart-bar"></i>
                                <span class="menu-text">Reportes</span>
                            </a>
                            <div class="sidebar-submenu">
                                <ul>
                                    <li>
                                        <a href="ReportesDeVentas.jsp">Reporte de ventas</a>
                                    </li>
                                    <li>
                                        <a href="ReportesDeInventario.jsp">Reporte de inventario</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        
                    </ul>
                </div>
                <!-- sidebar-menu  -->
            </div>
            <!-- sidebar-footer  -->
        </nav>


        <!-- page-content  -->
        
        <main class="page-content pt-0">

            <div class="HamburgerMenuDiv">
                <button class="navbar-toggler second-button hamburgerButtonClass" onclick="reduceNavbar()" type="button" data-toggle="collapse" data-target="#navbarSupportedContent23" aria-controls="navbarSupportedContent23" aria-expanded="false" aria-label="Toggle navigation" id="toggle-sidebar">
                    <div class="animated-icon2 open"><span></span><span></span><span></span><span></span></div>
                </button>
            </div>
          
          <!-- DIV CONTAINER-XL -->
            <div class="container-xl ContainerCustom"  style="margin-top: 150px; border: 0px solid black;Margin-left:50px;Margin-right:50px; top: 500px;">
                <div class="row justify-content-md-center " id="Container"style="">
                    <div class="col-xl PanelHeader"  id="ContainerHeader" >
                        
                        <span class="close" id="OcultarBtn" onclick="OcultarContenedor()">Ocultar</span>
                        
                        <h4>Agregar nuevo tipo de usuario</h4>
                        
                        <br>
                           
                     </div>  
                </div>
               
                <div class="row justify-content-md-center" id="Container" style=" ">  
                    <div class="col-xl PanelBody"  id="ContainerHeaderPanelBody" >
                        <div class="col-xl " id="ContainerContent " style="border: 1px solid rgb(204, 204, 204);height: 100%;">
                            
                            <br>
                         <!-- CONTENIDO -->
                         
                        <form action="/WebApplication_inventory_process_control/cTipoDeUsuario" class="needs-validation" novalidate>
                                <div class="form-row">
                                  <div class="col-md-6 mb-3">
                                    <label for="validationCustom01">Tipo de usuario</label>
                                    <input type="text" class="form-control" id="validationCustom01" name="NombreTipoDeUsuario" placeholder="Ingrese el nuevo tipo de usuario a crear" >
                                    <div class="valid-feedback">
                                      
                                    </div>
                                    <div class="invalid-feedback">
                                    Debe ingresar un nombre al nuevo tipo de usuario 
                                  </div>
                                  </div>
                                    </div>
                                <div class="form-group">
                                  <div class="form-check">
                                   
                                  </div>
                                </div>
                                 <input type="hidden" value="Insert"  name="InputValue">
                                <button class="btn btn-primary" type="submit">Agregar</button>
                              
                        </form>


                          <!-- END CONTENIDO -->
                            <br>
                        </div>      
                    </div>
                </div> 

            </div>    
             <!-- END DIV CONTAINER-XL -->
             <!-- DIV CONTAINER-XL -->
             
            <div class="container-xl "  style="margin-top: 20px; border: 0px solid black;margin-left:50px;margin-right:50px; top: 500px;">
                
                <div class="row justify-content-md-center " id="Container"style="">
                    <div class="col-xl PanelHeader"  id="ContainerHeader" >
                
                        <h4>Tabla de tipos de usuarios</h4>
                        
                        <br>

                     </div>  
                </div>
               
                <div class="row justify-content-md-center" id="Container"style=" ">  
                    <div class="col-xl PanelBody"  id="ContainerHeaderPanelBody" >
                        <div class="col-xl " id="ContainerContent " style="border: 1px solid rgb(204, 204, 204);height: 100%;">
                            <br>
                         <!-- CONTENIDO -->
                         <div class="row">
                                        <div class="col-lg-12">
                                            <div class="table-responsive">        
                                                <table id="example" class="table table-striped table-bordered" style="width:100%">
                                                <thead>
                                                    <tr>
                                                        <th>ID</th>
                                                        <th>Nombre del tipo de usuario</th>
                                                        <th>Acciones</th>
                                                        
                                                    </tr>
                                                </thead>
                                                
                                                <tbody>
                                                     <%
             
                                LinkedList<TipoDeUsuario> lista = TipoDeUsuario.getTipoDeUsuario();
                                  for (int i=0;i<lista.size();i++){
                                  out.println("<tr>");
                                    out.println("<td>"+lista.get(i).getId_Tipo_Usuario()+"</td>");
                                    out.println("<td>"+lista.get(i).getTipo_Usuario()+"</td>");
                                    //;
                                    
                                    
                                    out.println("<td class='contenedorAction' >");
                                       //INPUT!!! el cual manda el la variable editar al servlet
                                       
                                       // out.print("<a class='datatableActionsEditar' href=\"cTipoDeUsuario?Id="+lista.get(i).getId_Tipo_Usuario()+"\">");
                                        //out.print("Editar");
                                          out.print("<form method='POST' action='/WebApplication_inventory_process_control/cTipoDeUsuario'>");
                                                 out.print("<button class='btn btn-warning btnAccionesMargin' type='submit' value='"+lista.get(i).getId_Tipo_Usuario()+"' name='IdTipoUsuario'> Editar </button>");
                                                 //pasar variable con input hidden
                                                 out.print("<input type='hidden' value='Editar' name='InputValue'>");
                                         out.print("</form>");
                                         
                                         out.print("<form method='POST' action='/WebApplication_inventory_process_control/cTipoDeUsuario'>");
                                                 out.print("<button class='btn btn-danger btnAccionesMargin' type='submit' value='"+lista.get(i).getId_Tipo_Usuario()+"' name='IdTipoUsuario'> Eliminar </button>");
                                                 //pasar variable con input hidden
                                                 out.print("<input type='hidden' value='Eliminar' name='InputValue'>");
                                         out.print("</form>");
                                        
                                       // out.print("<a class='datatableActionsEliminar' href=\"Eliminar.jsp?id="+lista.get(i).getId_Tipo_Usuario()+"\">");
                                        
                                       // out.print("Eliminar");

                                    out.println("</td");
                                   
                                  out.println("</tr>");
                                     
                                       
                                  }%>
                                               
                                                    
                                                                                                    
                                                </tbody>        
                                               </table>                  
                                            </div>
                                        </div>
                                </div>  
                         

                          <!-- END CONTENIDO -->
                            <br>
                        </div>      
                    </div>
                </div> 

            </div>    
             <!-- END DIV CONTAINER-XL -->
             
        </main>
        <!-- page-content" -->
    </div>
    <!-- END page-wrapper -->

    
    
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous">
    </script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous">
    </script>
    
    <script src="//malihu.github.io/custom-scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>


    <!-- using local scripts -->
    <!-- <script src="../node_modules/jquery/dist/jquery.min.js"></script>
    <script src="../node_modules/popper.js/dist/umd/popper.min.js"></script>
    <script src="../node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="../node_modules/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script> -->
<!-- SCRIPT DATATABLE-->
    <script type="text/javascript" src="<%= request.getContextPath()%>/DataTables/datatables.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath()%>/DataTables/main.js"></script> 

    <script src="<%= request.getContextPath()%>/JS/main.js"></script>
</body>

</html>


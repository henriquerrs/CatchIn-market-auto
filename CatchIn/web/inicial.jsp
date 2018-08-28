<%-- 
    Document   : inicial
    Created on : 27/08/2018, 14:00:58
    Author     : Henrique Silva
--%>

<%@include file="layout/master.jsp" %>
<style type="text/css">
            .datepicker-table-wrapper{
                color: black !important;
            }
            .select-dropdown{
                display: initial !important;
                color: white !important;
            }
            .select-wrapper .caret {
                fill: rgba(255, 255, 255, 0.9);
            }
            nav{
                background-color: #141861 !important;
            }
            body {
                background-color: #05abbf;
            }
            .dropdown-content li{
                text-align: center !important;
            }
            .select-wrapper input.select-dropdown {
                font-size: x-large !important;
            }
            nav i {
                font-size: xx-large !important;
            }
            nav ul a{
                font-size: x-large !important;
            }
        </style>
<div class="container-fluid">
            <img class="materialboxed" width="100%" src="banner.jpg">
        </div>
        <div class="container">
            <!--navbar itens dropdown-->
            <div class="container">
            <ul id="dropdown1" class="dropdown-content">
                 <li><a href="#">one</a></li>
                  <li><a href="#">two</a></li>
                  <li><a href="#">three</a></li>
            </ul>
            </div>
            <!--Opções de seleção-->
               <nav>
              <div class="nav-wrapper">
                <ul class="left hide-on-med-and-down">
                  <li><select>
                        <option value="" disabled selected>Categoria</option>
                        <option value="1">Option 1</option>
                        <option value="2">Option 2</option>
                        <option value="3">Option 3</option>
                    </select></li>
                    <li>
                        <a href="#"><i class="material-icons">date_range</i></a>
                    </li>
                  <!-- Dropdown Trigger -->
                  <li><a class="dropdown-trigger" href="#" data-target="dropdown1">Dropdown<i class="material-icons right">arrow_drop_down</i></a></li>
                </ul>
              </div>
            </nav>  
        </div>
        <script type="text/javascript">
            $(".dropdown-trigger").dropdown();
        </script>
        <script type="text/javascript">
            $(document).ready(function(){
                $('.datepicker').datepicker();
              }); $(document).ready(function(){
                $('select').formSelect();
              });
        </script>
<%@include file="layout/footer.jsp" %>

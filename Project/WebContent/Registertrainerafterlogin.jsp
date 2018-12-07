<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
       <head>
     <header>
       <div class="nav-bar"></div>
       <link rel="stylesheet" href="Registertrainerafterlogin.css">
        <a href="end.html"><img src="bg1.jpg"  width="30" height="30"></a>
        <title>Trainer Registration</title>
    </head>
       <body>
              <div id=otc>
                     <h1>Online Training Portal</h1>
      </div>
      <div class="topnav">
             <a href="Registertrainerafterlogin.jsp">Register Trainer</a>
                     <a href="RegisterTraineeafterlogin.jsp">Register Trainee</a>
                     <a href="SetQP.jsp">Set Question Paper</a>
                     <a href="AppearExam.jsp">Appear For Exam</a>
  <a href="GenerateExamReportlast.jsp">Generate Exam Report</a>
   <a href="index.jsp" style="float:right">Home</a>
              </div>
              <div class="registerdiv">
                     <div class="form">
                              <form class="registerform" action="trainer" method="post">

                                                       <h2><center>REGISTER TRAINER</center></h2><br>
                                                       <table  border='0' width='480px' cellpadding='0' cellspacing='0' align='center'>
                                  <tr>
                                  <td align='left'><font color=red>*</font><label>Name:</label></td>
                                  <td><input type="text" name="name" id="name" placeholder="Name" required></td>
                                 </tr>
                                  <tr> <td>&nbsp;</td> </tr> 
                                  
                                  
                                  <tr>
                                  <td align='left'><font color=red>*</font><label>Technology:</label></td>

                                  <td><select id="technology" name="technology" required>

                                         <option>  SELECT  </option>

                                         <option>   Java </option>

                                         <option>   .NET  </option>

                                         <option>  SAP  </option>
                                         <option>  C++  </option>

                                  </select></td>
                                  </tr>
                                    <tr> <td>&nbsp;</td> </tr> 

                                 
                                 
                                 
                                 
                                    <tr>
                                  <td align='left'><font color=red>*</font><label>Location:</label></td>

                                  <td><select id="location" name="location" required>

                                                <option>  SELECT  </option>

                                                <option>Hyderabad</option>

                                                <option>  Chennai  </option>

                                                <option>  Coimbtore  </option>

                                                <option>  pune  </option>

                                                <option>  kolkata  </option>

                                               

                                  </select></td>
                                  </tr>
                                                             <tr> <td>&nbsp;</td> </tr> 
                                 
                                                              <tr>
                                  <td align='left'><font color=red>*</font><label>Contact Number:</label></td>
                                  <td><input type="text" name="cn" id="cn" placeholder="MOBILE NUMBER" required></td>
                                 </tr>



                                 
                                                       <tr>
                                  <td align='left'><font color=red>*</font>
                                  <label>Email:</label></td><td><input type="email" name="email"  id="email" placeholder="E-MAIL ID" required></td>
                                  </tr>
                                                                     <tr> <td>&nbsp;</td> </tr> 
                                 

                          
                                                                
                                                       <tr>
                                  <td align='left'><font color=red>*</font>
                                  <label>UserName:</label></td><td><input type="text" name="uname" id="uname" pattern="[a-z0-9]+" placeholder="USERNAME" required></td>
                                  </tr>
                                                                     <tr> <td>&nbsp;</td> </tr> 
                    

                                 
                                                              <tr>
                                  <td align='left'><font color=red>*</font>
                                  <label>Password:</label></td><td><input type="password" name="pass" id="pass" placeholder="PASSWORD" required></td>
                                                              </tr>
                                        <tr> <td>&nbsp;</td> </tr> 

                                 
                                                              <tr>
                                  <td align='left'><font color=red>*</font>
                                  <label>Confirm Password:</label></td><td><input type="password" name="cpass" id="cpass" placeholder="CONFIRM PASSWORD" required></td>
                                  </tr>
                                                                     <tr> <td>&nbsp;</td> </tr>
           
                                  <tr> <td align='center'><button type="submit" value="Submit" id="sub">register</button></td>
                                    <td align='center'><button type="reset" value="Reset" id="res">reset</button></td></tr>
                                                              
                                              <tr> <td>&nbsp;</td> </tr>                      
                           
                                                              
                                                              
                       </table>                                        
                     </form>
                     {err}
                     </div>
              </div>
  </header>
</body>
</html>


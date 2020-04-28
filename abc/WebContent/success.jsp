<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);

* {
  font-family: Roboto;
}

section {
  width: 100%;
  display: inline-block;
  background: #ccc;
  height: 60vh;
  text-align: center;
  font-size: 22px;
  font-weight: 700;
  
}

.footer-distributed {
  background-color: #454a4f;
  box-shadow: 0 1px 1px 0 rgba(0, 0, 0, 0.12);
  box-sizing: border-box;
  width: 100%;
  text-align: center;
  font: normal 16px sans-serif;
  padding: 25px 50px;
}

.footer-distributed .footer-left p {
  color: #000000;
  text: bold;
  font-size: 20px;
  margin: 0;
}
/* Footer links */

.footer-distributed p.footer-links {
  font-size: 18px;
  font-weight: bold;
  color: #ffffff;
  margin: 0 0 10px;
  padding: 0;
  transition: ease .25s;
}

.footer-distributed p.footer-links a {
  display: inline-block;
  line-height: 1.8;
  text-decoration: none;
  color: inherit;
  transition: ease .25s;
}

.footer-distributed .footer-links a:before {
  content: "·";
  font-size: 20px;
  left: 0;
  color: #fff;
  display: inline-block;
  padding-right: 15px;
}

.footer-distributed .footer-links .link-1:before {
  content: none;
}

.footer-distributed .footer-right {
  float: right;
  margin-top: 6px;
  max-width: 180px;
}

.footer-distributed .footer-right a {
  display: inline-block;
  width: 35px;
  height: 35px;
  background-color: #33383b;
  border-radius: 2px;
  font-size: 20px;
  color: #ffffff;
  text-align: center;
  line-height: 35px;
  margin-left: 3px;
  transition:all .25s;
}

.footer-distributed .footer-right a:hover{transform:scale(1.1); -webkit-transform:scale(1.1);}

.footer-distributed p.footer-links a:hover{text-decoration:underline;}

/* Media Queries */

@media (max-width: 600px) {
  .footer-distributed .footer-left, .footer-distributed .footer-right {
    text-align: center;
  }
  .footer-distributed .footer-right {
    float: none;
    margin: 0 auto 20px;
  }
  .footer-distributed .footer-left p.footer-links {
    line-height: 1.8;
  }
}
.bottom{
  position: ;
  left: 0;
  bottom: 0;
  width: 100%;
}



.input-container {
  display: -ms-flexbox;
  display: flex;
  width: 100vh;
  margin-bottom: 15px;
}
body{
margin: px;
text-align: center;
align: center;
font-family: 'Nunito', sans-serif;
  color: #384047;
}

button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #4CAF50;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
button:hover, button:active,button:focus {
  background: #43A047;
}


.container {
  border-radius: px;
  background-color: #f2f2f2;
  padding: 60px;
  margin-left:7%;
  margin-right:60%;
}
.input-field {
  width: 30%;
  padding: 10px;
  outline: none;
}

.input-field:focus {
  border: 2px solid dodgerblue;
}

.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
}

.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}

.header a.logo {
  font-size: 25px;
  font-weight: bold;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

.header a.active {
  background-color: dodgerblue;
  color: white;
}

.header-right {
  float: right;
}

 @media screen and (max-width: 500px) {
 .header a {
    float: none;
    display: block;
    text-align: left;
  }
  
  .header-right {
    float: none;
  }
  

}




</style>
<meta charset="ISO-8859-1">
<title>Successfully Registered</title>
</head>
<header>
<div class="header">
  <a class="logo">Abc jobs</a>
  <div class="header-right">
    <a href="index.jsp">Home page</a>
    <a href="register.jsp">Register</a>
  </div>
</div><br><br>
</header>

<body>

<div class="pic">
<img align="right" src="images/wel.jpg">
</div>

<div class="container">
<h1 class="abs">Welcome to Abc jobs</h1>
<h2><s:property value="fname" /></h2>
<h3 style="color: gray">You are all set.! Click the Button below to sign in.</h3>

  <a href="login.jsp"><button>Sign in</button></a>
  </div>
</body><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<div class="bottom">
 <footer class="footer-distributed">
	
	

			<div class="footer-left">

				<p class="footer-links">
					<a class="link-1" href="index.jsp">Home</a>

					<a href="#">Blog</a>

					<a href="#">Pricing</a>

					<a href="#">About</a>

					<a href="#">Faq</a>

					<a href="#">Contact</a>
				</p>

				<p>Abc jobs &copy; 2020</p>
			</div>

		</footer>
		</div>
</html>
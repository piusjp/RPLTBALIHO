<%-- 
    Document   : pesan
    Created on : Nov 9, 2014, 8:23:45 AM
    Author     : Pace_2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cek Sewa</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Img/Icon.png" rel="ICON">
        <link rel="stylesheet" type="text/css" href="CSSbaliho.css"/>
    </head>
    <body>
        <div class="head">
            <a href="Home.jsp"><img src="Img/Logo.png" height="80px" width="400px" style="position: inherit; top: 10px; left: 10px;"/></a>
        </div>

        <ul id="menu">
            <li><a href="Home.jsp">Home</a></li>
            <li><a href="#">Baliho</a>
                <ul class="sub-menu">
                    <li><a href="LihatBaliho.jsp">Lihat Baliho</a></li>
                    <li><a href="CekSewa.jsp">Cek Sewa</a></li>
                </ul>
            </li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
        </br>
        <form  action="ControlCheckOut" method="post">
            <table cellpadding="8">
                <tr>
                    <td>Nama Lengkap</td>
                    <td><input type="text" name="nama"/></td>
                </tr>
                <tr>
                    <td>Alamat</td>
                    <td><input type="text" name="alamat"/></td>
                </tr>
                <tr>
                    <td>Nama Perusahaan</td>
                    <td><input type="text" name="perusahaan"/></td>
                </tr>
                <tr>
                    <td>Alamat Perusahaan</td>
                    <td><input type="text" name="alamatP"/></td>
                </tr>
                <tr>
                    <td>No. HP</td>
                    <td><input type="text" name="hp"/></td>
                </tr>
                <tr>
                    <td>email</td>
                    <td><input type="text" name="email"/></td>
                </tr>
                <tr>
                    <td>Mulai sewa</td>
                    <td><input type="text" name="mulai"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="right"><input type="submit" name="button" value="Pesan"/></td>
                </tr>            
            </table>
        </form>
        </br></br></br>
        <div class="footer"><table width="2400"><tr><td>
                        <font face="Trebuchet MS, Arial, Helvetica, sans-serif" color="#FFFFFF" size="-1">&nbsp;&nbsp;&nbsp;Porewed by :</font><br/>
                        <a href="#"><img src="Img/PJP.png" hspace="10" height="40px" width="40px" title="PJP" /></a>
                        <a href="http://usd.ac.id/" target="_blank"><img src="Img/LOGO UNIVERSITAS SANATA DHARMA 2.png" height="40px" width="40px" title="Universitas Sanata Dharma"/></a>
                        <a href="#atas"><img src="Img/totop.png" hspace="10" height="30px" width="30px" align="right" title="back to top" style="position: fixed; bottom:10px; right:1px;"/></a>
                    </td><td><font face="Trebuchet MS, Arial, Helvetica, sans-serif" color="#FFFFFF" size="-1">[ Created by : Pius Juan 125314054,Dian Saktian 125314042,Dionisius Wisnu 125314059,Kevindha Mahatma 125314067 ]</font></td></tr></table>
        </div>
    </body>
</html>

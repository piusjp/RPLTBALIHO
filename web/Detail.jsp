<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<jsp:useBean id="blh" scope="session" class="BalihoBean.DBbaliho"/>
<html>
    <%String kl = request.getParameter("kode");%>
    <head>
        <title>Detail Baliho</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Img/Icon.png" rel="ICON">
        <link rel="stylesheet" type="text/css" href="CSSbaliho.css"/>
    </head>

    <body>
        <div class="head">
            <a name="atas"></a>
            <a href="Home.jsp"><img src="Img/Logo.png" height="80px" width="400px" style="position: inherit; top: 10px; left: 10px;"/></a>
        </div>

        <%=blh.search(kl, "LOKASI")%>
        <%=blh.search(kl, "STATUS")%>
        <%=blh.search(kl, "HARGA_SEWA")%>

        <div class="footer"><table width="2400"><tr><td>
                        <font face="Trebuchet MS, Arial, Helvetica, sans-serif" color="#FFFFFF" size="-1">&nbsp;&nbsp;&nbsp;Porewed by :</font><br/>
                        <a href="#"><img src="Img/PJP.png" hspace="10" height="40px" width="40px" title="PJP" /></a>
                        <a href="http://usd.ac.id/" target="_blank"><img src="Img/LOGO UNIVERSITAS SANATA DHARMA 2.png" height="40px" width="40px" title="Universitas Sanata Dharma"/></a>
                        <a href="#atas"><img src="Img/totop.png" hspace="10" height="30px" width="30px" align="right" title="back to top" style="position: fixed; bottom:10px; right:1px;"/></a>
                    </td><td><font face="Trebuchet MS, Arial, Helvetica, sans-serif" color="#FFFFFF" size="-1">[ Created by : Pius Juan 125314054,Dian Saktian 125314042,Dionisius Wisnu 125314059,Kevindha Mahatma 125314067 ]</font></td></tr></table>
        </div>
    </body>
</html>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<jsp:useBean id="blh" scope="session" class="BalihoBean.DBbaliho"/>
<html>
    <head>
        <title>Pesan Baliho</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Img/Icon.png" rel="ICON">
        <link rel="stylesheet" type="text/css" href="CSSbaliho.css"/>
    </head>

    <body>
        <%
            ArrayList a = (ArrayList) session.getAttribute("cart");
        %>
        <div class="head">
            <a name="atas"></a>
            <a href="Home.jsp"><img src="Img/Logo.png" height="80px" width="400px" style="position: inherit; top: 10px; left: 10px;"/></a>
        </div>

        <ul id="menu">
            <li><a href="Home.jsp">Home</a></li>
            <li><a href="#">Baliho</a>
                <ul class="sub-menu">
                    <li><a href="PesanBaliho.jsp">Pesan Baliho</a></li>
                    <li><a href="CekSewa.jsp">Cek Sewa</a></li>
                </ul>
            </li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
        </ul>

        <h1>Produk Kami</h1>
        <table cellspacing="0" width="700" height="30" style=" border: 2px ridge #ABCDEF">
            <tr>
                <td>
                    <table cellspacing="0" width="700" height="30" style=" border: 2px ridge #ABCDEF">
                        <tr>
                            <%
                                ResultSet data_baliho = blh.data_baliho();
                                int n = 1;
                                while (data_baliho.next()) {
                                    if (n % 6 == 0) {
                            %>
                        <tr>
                            <%}
                            %>
                            <td>
                                <img src="Img/<%=data_baliho.getString("KODE_BALIHO")%>.jpg" width="200px" height="200px"/><br/>
                                <%=data_baliho.getString("KODE_BALIHO")%><br/>
                                <%=data_baliho.getString("LOKASI")%><br/>
                                <%=data_baliho.getString("HARGA_SEWA")%><br/>
                                <%=data_baliho.getString("STATUS")%><br/>
                                <%=data_baliho.getString("UKURAN")%><br/>
                                <form action="Detail.jsp" method="post">
                                    <input type="hidden" name="kode" value="<%=data_baliho.getString("KODE_BALIHO")%>"/>
                                    <input type="submit" value="Detail"/>
                                </form>
                                <%int dbl = 0;
                                    if (session.getAttribute("cart") != null) {
                                        for (int i = 0; i < a.size(); i++) {
                                            if (a.get(i).equals(data_baliho.getString("KODE_BALIHO"))) {
                                                dbl++;
                                            }
                                        }
                                    }
                                    if (dbl == 0) {
                                %>
                                <form action="ControlCart" method="post">
                                    <input type="hidden" name="kode" value="<%=data_baliho.getString("KODE_BALIHO")%>"/>
                                    <input type="submit" value="Add To Cart"/>
                                </form>
                                <%}%>
                            </td>
                            <%if (n % 5 == 0) {%>
                        </tr>
                        <%}
                                n++;
                            }%>
                    </table>
                </td>
                <td>

                </td>
            </tr>
        </table>
        <%if (session.getAttribute("cart") != null) {
                for (int i = 0; i < a.size(); i++) {%>
        <%=a.get(i)%>
        <form action="ControlDelCart" method="post">
            <input type="hidden" name="kode" value="<%=a.get(i)%>"/>
            <input type="submit" value="Hapus"/>
        </form>
        <%
                }
            }
        %>
        <form action="CheckOut.jsp" method="post">
            <input type="hidden" name="cart" value="<%=a%>"/>
            <input type="submit" value="CheckOut"/>
            <%--<input type="image" src="Img/PJP.png" width="30px" height="30px" alt="submit button"/>--%>
        </form>
        <div class="footer"><table width="2400"><tr><td>
                        <font face="Trebuchet MS, Arial, Helvetica, sans-serif" color="#FFFFFF" size="-1">&nbsp;&nbsp;&nbsp;Porewed by :</font><br/>
                        <a href="#"><img src="Img/PJP.png" hspace="10" height="40px" width="40px" title="PJP" /></a>
                        <a href="http://usd.ac.id/" target="_blank"><img src="Img/LOGO UNIVERSITAS SANATA DHARMA 2.png" height="40px" width="40px" title="Universitas Sanata Dharma"/></a>
                        <a href="#atas"><img src="Img/totop.png" hspace="10" height="30px" width="30px" align="right" title="back to top" style="position: fixed; bottom:10px; right:1px;"/></a>
                    </td><td><font face="Trebuchet MS, Arial, Helvetica, sans-serif" color="#FFFFFF" size="-1">[ Created by : Pius Juan 125314054,Dian Saktian 125314042,Dionisius Wisnu 125314059,Kevindha Mahatma 125314067 ]</font></td></tr></table>
        </div>
    </body>
</html>

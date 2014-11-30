<%-- 
    Document   : FormLaporanBulananOwner
    Created on : Nov 28, 2014, 9:47:24 AM
    Author     : Dion Wisnu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Laporan Bulanan</title>
    </head>

    <body>
        <h1 class="title" align="center">Laporan Bulanan</h1>
        <p>&nbsp;</p>
        <form action="OwnerCekMenu" method="post">
            <table width="200" border="0" align="center">
                <tr>
                    <td><input type="submit" name="tombolMenuOwner" id="menuUtama" value="Menu Utama" /></td>
                    <td>&nbsp;</td>
                    <td>
                        <input type="submit" name="tombolMenuOwner" id="logOut" value="Logout" />
                    </td>
                </tr>
            </table>
        </form>
        <p>&nbsp;</p>
        <form action="OwnerCekLaporan" method="post">
            <table width="245" border="0" align="center">
                <tr>
                    <td width="125">
                        <label for="pilihBulan">Pilih Bulan</label>
                        <select name="pilihBulan" id="pilihBulan">
                            <option value="januari">Januari</option>
                            <option value="februari">Februari</option>
                            <option value="maret">Maret</option>
                            <option value="april">April</option>
                            <option value="mei">Mei</option>
                            <option value="juni">Juni</option>
                            <option value="juli">Juli</option>
                            <option value="agustus">Agustus</option>
                            <option value="september">September</option>
                            <option value="oktober">Oktober</option>
                            <option value="november">November</option>
                            <option value="desember">Desember</option>
                        </select></td>
                    <td width="110">
                        <label for="pilihTahun">Pilih Tahun</label>
                        <select name="pilihTahun">
                            <option value="2012">2012</option>
                            <option value="2013">2013</option>
                            <option value="2014">2014</option>
                            <option value="2015">2015</option>
                        </select></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>
                        <input type="submit" name="submitLaporan" id="submit" value="Submit" />
                    </td>
                </tr>
            </table>
        </form>
        <p>&nbsp;</p>
        <%
            
            //HttpSession session = request.getSession(false);
            String n = (String) session.getAttribute("uname");
            String bulan = (String) session.getAttribute("plhBln");
            String tahun = (String) session.getAttribute("plhThn");
            try {
                if (request.getParameter("laporan").equals("y")) {

        %>

        <h3 align="center" style="color: black">Laporan Bulanan</h3>
        <h3 align="center" style="color: black">Bulan : <% out.print(bulan); %> Tahun : <% out.print(tahun); %> </h3>
        <p>&nbsp;</p>
         <table width="736" border="2" align="center">
            <tr>
                <td width="90" align="center">ID</td>
                <td width="150" align="center">Nama</td>
                <td width="150" align="center">No Telp</td>
                <td width="300" align="center">Alamat</td>
            </tr>
            <% 
                    //for(int i=0;i<listSupir.size();i++){ %>
            <tr>
                <td>&nbsp <% //out.print(listSupir.get(i).getIdSupir()); %> </td>
                <td>&nbsp <% //out.print(listSupir.get(i).getNamaSupir()); %> </td>
                <td>&nbsp <% //out.print(listSupir.get(i).getNomorHP()); %> </td>
                <td>&nbsp <% //out.print(listSupir.get(i).getAlamat()); %> </td>
            </tr>
           <%}%>
        </table>
        
            <%                             } else if (request.getParameter("laporan").equals("n")) {
                %>
                <h3 align="center" style="color: red">Gagal Membuat Laporan,</h3>
            <%
            }
                } catch (Exception e) {
                }
            %>
    </body>
</html>

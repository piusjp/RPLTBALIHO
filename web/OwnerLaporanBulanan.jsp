<%-- 
    Document   : OwnerLaporanBulanan
    Created on : Dec 7, 2014, 6:46:15 PM
    Author     : Dion Wisnu
--%>

<%@page import="BalihoBean.ControlLaporanBulanan"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BalihoBean.DBtransaksi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
            <p>&nbsp;</p>
            <table width="200" border="0" align="center">
                <tr>
                    <td>
                        <input type="submit" name="tombolMenuOwner" id="logOut" value="Kembali" />
                    </td>
                </tr>
            </table>
        </form>

        <%
            session = request.getSession(false);
            String plhBln = (String) session.getAttribute("plhBln");
            String plhThn = (String) session.getAttribute("plhThn");
            DBtransaksi dbTrans = new DBtransaksi();
            ControlLaporanBulanan clb = new ControlLaporanBulanan();
            List<DBtransaksi> listTrans = new ArrayList<DBtransaksi>();
            listTrans = clb.lihatLaporanBulanan(plhBln, plhThn);
        %>
        <p>&nbsp;</p>
        <table width="736" border="2" align="center">
            <tr>
                <td width="90" align="center">Kode Baliho</td>
                <td width="150" align="center">Lokasi</td>
                <td width="150" align="center">Nama Customer</td>
                <td width="300" align="center">Tanggal Mulai</td>
                <td width="300" align="center">Tanggal Berakhir</td>
                <td width="300" align="center">Total Bayar</td>
            </tr>
            <%
                int pendapatan = 0;
                for (int i = 0; i < listTrans.size(); i++) { %>
            <tr>
                <td>&nbsp <% out.print(listTrans.get(i).getKodeSewa().getKode_baliho().getKodeBaliho()); %> </td>
                <td>&nbsp <% out.print(listTrans.get(i).getKodeSewa().getKode_baliho().getLokasi()); %> </td>
                <td>&nbsp <% out.print(listTrans.get(i).getKodeSewa().getNama_customer()); %> </td>
                <td>&nbsp <% out.print(listTrans.get(i).getKodeSewa().getTanggal_mulai()); %> </td>
                <td>&nbsp <% out.print(listTrans.get(i).getKodeSewa().getTanggal_berakhir()); %> </td>
                <td>&nbsp <% out.print(listTrans.get(i).getTotal_bayar());
                    pendapatan += listTrans.get(i).getTotal_bayar(); %> </td>
            </tr>
            <%}%>
            <tr>
                <td>&nbsp</td>
                <td>&nbsp</td>
                <td>&nbsp</td>
                <td>&nbsp</td>
                <td>Total Pemasukan</td>
                <td>&nbsp <% out.print(pendapatan);%> </td>
            </tr>
        </table>
    </body>
</html>

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
        <table width="200" border="0" align="center">
            <tr>
                <td><input type="submit" name="menuUtama" id="menuUtama" value="Menu Utama" /></td>
                <td>&nbsp;</td>
                <td>
                    <input type="submit" name="logOut" id="logOut" value="Log Out" />
                </td>
            </tr>
        </table>

        <p>&nbsp;</p>
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
                    <input type="submit" name="submit" id="submit" value="Submit" />
                </td>
            </tr>
        </table>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
    </body>
</html>

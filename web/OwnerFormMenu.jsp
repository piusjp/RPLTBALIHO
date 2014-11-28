<%-- 
    Document   : FormMenuAdmin
    Created on : Nov 17, 2014, 9:57:43 PM
    Author     : Dion Wisnu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Untitled Document</title>
    </head>

    <body>
        <h1 align="center" class="title">Menu Owner</h1>
        <p align="center">&nbsp;</p>
        <form action="OwnerCekMenu" method="post">
            <table width="457" height="265" border="0" align="center">
                <tr>
                    <td width="205"><img src="Gambar/Book.png" width="200" height="200" /></td>
                    <td width="30">&nbsp;</td>
                    <td width="208"><img src="Gambar/Clipboard.png" width="200" height="200" /></td>
                </tr>
                <tr>
                    <td height="15">&nbsp;</td>
                    <td height="15">&nbsp;</td>
                    <td height="15">&nbsp;</td>
                </tr>
                <tr>
                    <td align="center">
                        <input type="submit" name="tombolMenuOwner" id="lihatBaliho" value="Lihat Baliho"  />
                    </td>
                    <td>&nbsp;</td>
                    <td align="center">
                        <input type="submit" name="tombolMenuOwner" id="laporanBulanan" value="Laporan Bulanan" />
                    </td>
                </tr>
            </table>

            <p>&nbsp;</p>
            <table width="200" border="0" align="center">
                <tr>
                    <td align="center">
                        <input type="submit" name="tombolMenuOwner" id="logout" value="Logout" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>

<%@page import="BalihoBean.ControlCart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<jsp:useBean id="blh" scope="session" class="BalihoBean.DBbaliho"/>
<html lang="id" class="csstransforms csstransforms3d csstransitions" style="height: auto;"><!--<![endif]--><head>
        <link rel="stylesheet" href="CSS/font-awesome.css">

        <!-- Basic Page Needs
        ================================================== -->
        <meta charset="utf-8">
        <title>Daftar Baliho</title>
        <meta name="description" content="BiasPromosindo">
        <meta name="author" content="PJP">

        <!-- Mobile Specific Metas
        ================================================== -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

        <!-- Favicons
        ================================================== -->
        <link rel="shortcut icon" href="img/favicon.ico">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png">


        <link rel="stylesheet" type="text/css" href="CSS/template.css">
        <link rel="stylesheet" type="text/css" href="CSS/template-2.css">
        <link rel="stylesheet" type="text/css" href="CSS/custom.css">

        <style>
            .bg-img-1 {
                background-image: url('Baliho1.jpg');
            }
            .bg-img-2 {
                background-image: url('Baliho2.jpg');
            }
            .bg-img-3 {
                background-image: url('Baliho3.jpg');
            }
            .bg-img-4 {
                background-image: url('4.jpg');
            }
        </style><script type="text/javascript" charset="UTF-8" src="JScript/common.js"></script><script type="text/javascript" charset="UTF-8" src="JScript/util.js"></script><script type="text/javascript" charset="UTF-8" src="JScript/stats.js"></script></head>

    <!-- Slideshow Images
    ================================================== -->


    <body style="position: relative; width: auto;">
        <!-- MODAL / KATEGORI
    ================================================== -->
        <div id="back-modal" style="display: none;"></div>
        <div id="modal" style="display: none;">
            <a href="#" class="modal-close modal-btn"><i class="fa fa-compress"></i></a>
            <div class="modal-nav">
                <a href="#" class="modal-previous modal-btn"><i class="fa fa-angle-left"></i></a><!---->
                <a href="#" class="modal-next modal-btn"><i class="fa fa-angle-right"></i></a><!---->
            </div>
            <div id="modal-inner">
                <%
                    ResultSet data1 = blh.data_baliho();
                    while (data1.next()) {
                %>
                <div class="contentModal personModal" id="<%=data1.getString("KODE_BALIHO")%>">
                    <div class="container">
                        <div class="row">
                            <div class="sixteen columns">
                                <h1 class="super-title"><span class="color1">#</span><%=data1.getString("KODE_BALIHO")%></h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="six columns">
                                <div class="photo">
                                    <h4>Gambar</h4>
                                    <figure><img src="Img/Baliho/<%=data1.getString("KODE_BALIHO")%>.jpg" alt="<%=data1.getString("KODE_BALIHO")%>" width="250" height="250"></figure>
                                    <h4>Peta Lokasi</h4>
                                    <figure><img src="Img/Lokasi/<%=data1.getString("KODE_BALIHO")%>.jpg" alt="<%=data1.getString("KODE_BALIHO")%>" width="250" height="250"></figure>
                                    <h4>Konstruksi</h4>
                                    <figure><img src="Img/Konstruksi/<%=data1.getString("KODE_BALIHO")%>.jpg" alt="<%=data1.getString("KODE_BALIHO")%>" width="250" height="250"></figure>
                                </div>
                            </div>
                            <div class="ten columns">
                                <h3>Kode Baliho</h3>
                                <p class="nomargintop" align="justify"><%=data1.getString("KODE_BALIHO")%></p>
                                <h3>Ukuran</h3><%=data1.getString("UKURAN")%>
                                <h3>Lokasi</h3><%=data1.getString("LOKASI")%>
                                <h3>View</h3><%=data1.getString("VIEW")%>
                                <h3>Intensitas Kendaraan</h3><%=data1.getString("INTENSITAS_KENDARAAN")%>
                                <h3>Lingkungan</h3><%=data1.getString("LINGKUNGAN")%>
                                <h3>Harga</h3>Rp.<%=data1.getString("HARGA_SEWA")%>/bulan
                                <h3>Status</h3><%=data1.getString("STATUS")%>
                                <br/><br/><br/><br/><br/>
                                <h5 style="color:#009933">Masukan Lama Sewa:</h5>
                                <form action="ControlCart" method="post">
                                    <input type="hidden" name="kode" value="<%=data1.getString("KODE_BALIHO")%>"/>
                                    <select name="lamaSewa" style="background-color: white">
                                        <%for (int i = 0; i < 12; i++) {%>
                                        <option value="<%=i + 1%>"/><%=i + 1%> Bulan
                                        <%}%>
                                    </select>
                                    <input type="submit" value="Add To Cart"/>
                                </form>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div> <%}%>
            </div>
        </div>

        <!-- END OF MODAL
        ================================================== -->
        <%
            ArrayList<ControlCart> a = (ArrayList<ControlCart>) session.getAttribute("cart");
        %>
        <!-- Start - Used on #to-top click -->
        <div id="start"></div>

        <div id="top" class="">
            <div class="container">
                <div class="four columns clearfix"> 
                    <figure class="logo"><a href="#start" class="goto"><img src="Img/Logo.png" alt="baliho" width="286" height="80"></a></figure>
                    <!-- Mobile Menu -->
                    <nav id="mobile-top-menu">
                        <a href="#" class="mobile-nav-button"><i class="fa fa-bars"></i></a>
                        <div id="menu-list" style="max-height: 287px;"><div id="menu-content">
                                <ul>
                                    <li><a href="Home.html" style="font-size:14px">Home</a></li>
                                    <li><a href="#berita" class="goto" style="font-size:14px">Baliho <i class="fa fa-angle-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="PesanBaliho.jsp">Lihat Baliho</a></li>
                                            <li><a href="https://baliho.ugm.ac.id/daftarberita">Lihat Sewa</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="Home.html#contact" class="goto" style="font-size:14px">Kontak</a></li>
                                    <li><a href="#" style="font-size:14px">Login Admin</a>
                                    </li>
                                </ul>
                            </div></div>
                    </nav>
                </div>


                <div class="twelve columns">
                    <!-- Main Menu -->
                    <nav id="top-menu">
                        <ul>
                            <li><a href="Home.html" style="font-size:14px">Home</a></li>
                            <li><a href="#berita" class="goto" style="font-size:14px">Baliho <i class="fa fa-angle-down"></i></a>
                                <ul class="sub-menu">
                                    <li><a href="PesanBaliho.jsp">Lihat Baliho</a></li>
                                    <li><a href="https://baliho.ugm.ac.id/daftarberita">Lihat Sewa</a></li>
                                </ul>
                            </li>
                            <li><a href="Home.html#contact" class="goto" style="font-size:14px">Kontak</a></li>
                            <li><a href="#" style="font-size:14px">Login Admin</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /#top -->
        <!-- top hmmm -->
        <!-- Don't remove #top-space! -->
        <div id="top-space"></div>
        <!-- Don't remove #top-space! -->

        <!-- Our amazing team... -->
        <section id="about" class="first-section page">
            <div id="team">
                <div class="over-pattern diagonal opacity50"></div>
                <div class="container">
                    <!-- Person #1 -->
                    <h2 class="title"><span class="color5">Daftar Baliho</span></h2>
                    <br/><br/>
                    <div id="kelompok1">
                        <%
                            ResultSet data2 = blh.data_baliho();
                            while (data2.next()) {
                        %>
                        <div class="three columns person go">
                            <a href="#<%=data2.getString("KODE_BALIHO")%>" class="open-modal photo">
                                <div class="over-pattern diagonal opacity30"></div><div class="over-color"></div>
                                <figure>
                                    <img class="smallscreen" src="Img/Baliho/<%=data2.getString("KODE_BALIHO")%>.jpg" alt="<%=data2.getString("KODE_BALIHO")%>" width="220" height="220">
                                    <img class="largescreen" src="Img/Baliho/<%=data2.getString("KODE_BALIHO")%>.jp" alt="<%=data2.getString("KODE_BALIHO")%>" width="450" height="450">
                                </figure>
                            </a>
                            <div class="info">
                                <h3><%=data2.getString("KODE_BALIHO")%></h3>
                                <h4>Rp.<%=data2.getString("HARGA_SEWA")%>/bln</h4>
                                <br/>
                                <form action="ControlCart" method="post">
                                    <input type="hidden" name="kode" value="<%=data2.getString("KODE_BALIHO")%>"/>
                                    <select name="lamaSewa" style="background-color: white">
                                        <%for (int i = 0; i < 12; i++) {%>
                                        <option value="<%=i + 1%>"/><%=i + 1%> Bulan
                                        <%}%>
                                    </select>
                                    <input type="submit" value="Add To Cart"/>
                                </form>
                            </div>
                        </div>
                        <%}%>
                    </div>
                </div><!-- /.container -->
            </div><!-- /#team -->
        </section><!-- /#about -->

        <!--### -->
        <!-- #Project Page -->
        <section id="project" class="page nopaddingbottom">
            <div class="container">
                <!-- Detil Berita -->
                <div class="row">
                    <div class="sixteen columns" align="justify">
                        <h2 class="title" style="margin-top: 20px">Peraturan Penyewaan:</h2>
                        <%ArrayList<ControlCart> b = (ArrayList<ControlCart>) session.getAttribute("cart");
                            if (b != null) {
                                for (int i = 0; i < a.size(); i++) {%>
                                <%=b%>
                        <%=a.get(i)%>
                        <%=a.get(i).getKodeBaliho()%>
                        <form action="ControlDelCart" method="post">
                            <input type="hidden" name="kode" value="<%=a.get(i).getKodeBaliho()%>"/>
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
                    </div>
                </div>
            </div>
        </section>

        <!-- #Footer -->
        <section id="footer" class="pattern diagonal">
            <div class="shadow"></div>
            <div class="container">
                <div class="row">
                    <!-- Logo -->
                    <div class="sixteen columns">
                        <figure class="logo"><img src="img/style1/logo-gemastik.png" alt="gemastik"></figure>
                    </div>

                    <!-- Social Icons -->
                    <div class="sixteen columns">
                        <div class="social-icons">
                            <a href="https://www.facebook.com/Gemastik" title="Facebook"><i class="fa fa-facebook"></i></a>
                            <a href="https://twitter.com/_gemastik" title="Twitter"><i class="fa fa-twitter"></i></a>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div><!-- /.container -->
        </section><!-- /#footer -->

        <!-- #Copyright -->
        <section id="copyright">
            <div class="container">
                <div class="row">
                    <div class="sixteen columns">
                        <p>Copyright 2014 Pagelaran Mahasiswa Nasional bidang TIK by <a href="http://www.dikti.go.id/">Direktorat Jenderal Pendidikan Tinggi.</a></p>
                    </div>
                </div>
            </div><!-- /.container -->
        </section><!-- /#copyright -->

        <!-- Back to Top -->
        <a id="to-top" class="menu" href="#start"><i class="fa fa-angle-up"></i></a>

        <!-- jQuery Library
        ================================================== -->
        <script src="JScript/jquery-1.11.0.min.js"></script>

        <!-- Retina Images
        ================================================== -->
        <script src="JScript/retina.min.js"></script>

        <!-- Stone Actions (You can insert your scripts here)
        ================================================== -->
        <script src="JScript/stone.errorpage.actions.min.js"></script>

        <!-- Stone Actions (You can insert your scripts here)
        ================================================== -->
        <script src="JScript/stone.actions.min.js"></script><div id="lightbox" style="display:none;"><a href="#" class="lightbox-close lightbox-button"><i class="fa fa-compress"></i></a><div class="lightbox-nav" style="display: none;"><a href="#" class="lightbox-previous lightbox-button"><i class="fa fa-angle-left"></i></a><a href="#" class="lightbox-next lightbox-button"><i class="fa fa-angle-right"></i></a></div><div href="#" class="lightbox-caption"><p></p></div></div>

        <script>
            $('#colorSelector li a').on('click', function () {
                var style = $(this).attr('id');
                var splitstyle = style.split('style-');
                style = splitstyle[1];
                $('#style').attr('href', 'CSS/template-' + style + '.css');
                $('.logo img').each(function () {
                    var getsrc = $(this).attr('src');
                    var splitsrc = getsrc.split('/style');
                    var imagename = splitsrc[1].split('http://ararazu.com/');
                    var newsrc = splitsrc[0] + '/style' + style + '/' + imagename[1];
                    $(this).attr('src', newsrc);
                });
                return false;
            });
            $('#controlSelector').on('click', function () {
                $('#colorSelector').toggleClass('open');
            });
            $('#controlSelector').click();
        </script>
        <!-- End Color Selector (YOU CAN REMOVE)
        ================================================== -->


    </body></html>
<%-- 
    Document   : index
    Created on : Oct 18, 2013, 10:33:12 AM
    Author     : ajmiro
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <!-- jQuery library (served from Google) -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
        <!-- bxSlider Javascript file -->
        <script src="js/jquery.bxslider.min.js"></script>
        <!-- bxSlider CSS file -->
        <link type="text/css" rel="stylesheet" href="pandoAFPPipeLine.css"/>
        <link href="lib/jquery.bxslider.css" rel="stylesheet" />
        
        <title>PandoAFP</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script type="text/javascript">
        $(document).ready(function(){
           $('.bxslider').bxSlider({infiniteLoop: false, 
               controls: true,
               nextSelector: '.slider-next',
               prevSelector: '.slider-prev',
               nextText: 'Next →',
               prevText: '← Prev'}); 
        });
    </script>
    </head>
    <body>
        <%@taglib prefix="pandoAFP" uri="/WEB-INF/tlds/pandoAFP_tag_library.tld" %>        
        <jsp:useBean id="pipeline" class="PandoAFP.Pipeline" scope="session"/>        
        <jsp:setProperty name="pipeline" property="id" value="1"/>                        
        
        <section id="document">          
            <jsp:include page="Reusable_Parts/SiteHeader.jsp">
                <jsp:param name="pageTitle" value="Document Viewer" />
            </jsp:include>
        
            <jsp:include page="Reusable_Parts/SearchBar.html"/>      
            
             <section id="breadcrumb"> 
                 <!-- Branch 2 -->
                 <a href="index.jsp?pipeline=${pipeline.id}"> ${pipeline.name} </a> &gt;  
                 <a href="DocTypeServlet?candidate=${candidateOBJ.id}"> ${candidateOBJ.lastName}, ${candidateOBJ.firstName} </a> &gt;
                 <a href="Documents?doctype=${documenttype.id}"> ${documenttype.name} </a> &gt; ${document.name}
            </section>
            
            <section id="dataSectionImageOnly">                
                <section id="mainSectionImageOnly">
                    <section id="dataHeader">
                        <div id="listTitle"> 
                            <!--&lt; Description based on current selection level &gt;-->
                            <span id="backgroundHighlight">Document</span>
                        </div>
                    </section>                                
                   <!-- <section id="mainSectionContentImageOnlyTop">                            
                                <div id="pageDownImageOnlyTop">
                                    <a href="DocumentView?candidate=${candidateOBJ.id}&document=${document.id}&page=${document.prevPage}"> <img src="Images/back arrow.png" height="100" width="100"/> </a>
                                </div>
                                <div id="pageUpImageOnlyTop">
                                    <a href="DocumentView?candidate=${candidateOBJ.id}&document=${document.id}&page=${document.nextPage}"> <img src="Images/forward arrow.png" height="100" width="100"/> </a>
                                </div>
                            </section>
                    </section>-->
                    <section id="mainSectionContentImageOnly">                                                   
                        
                        <!--<img id="pageImage" src="DocumentImage?page=${param.page}&documentID=${param.document}"/>-->
                        <div class="pager">
                            <p><span class="slider-prev"></span> | <span class="slider-next"></span></p>
                        </div>
                        <ul class="bxslider">
                            <!--<li><img id="pageImage" src="DocumentImage?page=1&documentID=${param.document}"</li>-->
                            <!--<li><img id="pageImage" src="DocumentImage?page=2&documentID=${param.document}"</li>-->
                                                        
                            <c:forEach begin="1" end="${document.numPages}" varStatus="loop">
                                <li><img id="pageImage" src="DocumentImage?page=${loop.count}&documentID=${param.document}"</li>
                            </c:forEach>
                        </ul>
                        <div class="pager">
                            <p><span class="slider-prev"></span> | <span class="slider-next"></span></p>
                        </div>
                            
                        <section id="pageControlsImageOnly">
                            <!--<div id="pageDownImageOnly">
                                <a href="DocumentView?candidate=${candidateOBJ.id}&document=${document.id}&page=${document.prevPage}"> <img src="Images/back arrow.png" height="100" width="100"/> </a>
                            </div>
                            <div id="pageUpImageOnly">
                                <a href="DocumentView?candidate=${candidateOBJ.id}&document=${document.id}&page=${document.nextPage}"> <img src="Images/forward arrow.png" height="100" width="100"/> </a>
                            </div>-->
                        </section>
                    </section>
                 </section>
            </section>
        </section>
    </body>
</html>

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
        <link type="text/css" rel="stylesheet" href="pandoAFPPipeLine.css"/>
        <title>PandoAFP</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@taglib prefix="pandoAFP" uri="/WEB-INF/tlds/pandoAFP_tag_library.tld" %>        
        <jsp:useBean id="pipeline" class="PandoAFP.Pipeline" scope="session"/>        
        <jsp:setProperty name="pipeline" property="id" value="1"/>
                
        <section id="document">
            <section id="header">
                <div id="headerColumn1">
                    <img src="Images/Pando AFP.png"/>
                </div>
            
                <div id="headerColumn2">
                    Document Viewer
                </div>
                
                <div id="rightSideHeader">
                    
                </div>
            </section>
        
            <!--<section id="keyword">
                <div id="filtersText">FILTERS:</div>
                <div id="text">Keyword:</div>
                <div id="txtInput">
                    <input id="keywordInput" type="text" name="txtkeyword" value="" />
                </div>
                <div id="buttondiv">
                    <button id="goButton">GO</button>
                </div>
            </section> -->
            <form action="Search" method="POST">
            <section id="keyword">
                <div id="filtersText">FILTER:</div>
                <div id="text">Search:</div>
                
                    <div id="txtInput">
                        <input id="keywordInput" type="text" name="txtkeyword" value="" />
                    </div>
                    <div id="buttondiv">
                        <!--<button id="goButton">GO</button>-->
                        <input type="submit" value="GO"/>
                    </div>
            </section>
        </form>          
            
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
                    <section id="mainSectionContentImageOnlyTop">                            
                            <section id="pageControlsImageOnlyTop">
                                <div id="pageDownImageOnlyTop">
                                    <a href="DocumentView?candidate=${candidateOBJ.id}&document=${document.id}&page=${document.prevPage}"> <img src="Images/back arrow.png" height="100" width="100"/> </a>
                                </div>
                                <div id="pageUpImageOnlyTop">
                                    <a href="DocumentView?candidate=${candidateOBJ.id}&document=${document.id}&page=${document.nextPage}"> <img src="Images/forward arrow.png" height="100" width="100"/> </a>
                                </div>
                            </section>
                    </section>
                    <section id="mainSectionContentImageOnly">                                                   
                        <img id="pageImage" src="DocumentImage?page=${param.page}&documentID=${param.document}"/>
                        <section id="pageControlsImageOnly">
                            <div id="pageDownImageOnly">
                                <a href="DocumentView?candidate=${candidateOBJ.id}&document=${document.id}&page=${document.prevPage}"> <img src="Images/back arrow.png" height="100" width="100"/> </a>
                            </div>
                            <div id="pageUpImageOnly">
                                <a href="DocumentView?candidate=${candidateOBJ.id}&document=${document.id}&page=${document.nextPage}"> <img src="Images/forward arrow.png" height="100" width="100"/> </a>
                            </div>
                        </section>
                    </section>
                 </section>
            </section>
        </section>
    </body>
</html>

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
                    PandoAFP
                </div>
            
                <div id="headerColumn2">
                    Document Viewer
                </div>
                
                <div id="rightSideHeader">
                    
                </div>
            </section>
        
            <section id="keyword">
                <div id="filtersText">FILTERS:</div>
                <div id="text">Keyword:</div>
                <div id="txtInput">
                    <input id="keywordInput" type="text" name="txtkeyword" value="" />
                </div>
                <div id="buttondiv">
                    <button id="goButton">GO</button>
                </div>
            </section>
            
             <section id="breadcrumb">                
                 <a href="index.jsp?pipeline=${pipeline.id}"> ${pipeline.name} </a> &gt;  
                 <a href="DocTypeServlet?candidate=${candidateOBJ.id}"> ${candidateOBJ.lastName}, ${candidateOBJ.firstName} </a> &gt;
                 <a href="Documents?doctype=${documenttype.id}"> ${documenttype.name} </a> &gt; ${document.name}
            </section>
            
            <section id="dataSection">                
                <section id="mainSection">
                    <section id="dataHeader">
                        <div id="listTitle"> 
                            <!--&lt; Description based on current selection level &gt;-->
                            &lt; Pipeline Information &gt;
                        </div>
                    </section>  
                    <section id="mainSectionContent">
                        <img src="DocumentImage?page=${param.page}&documentID=${param.document}"/>
                        <section id="pageControls">
                            <div id="pageDown">
                               <a href="DocumentView?candidate=${candidateOBJ.id}&document=${document.id}&page=${document.prevPage}"> &lt;</a>
                            </div>
                            <div id="pageUp">
                               <a href="DocumentView?candidate=${candidateOBJ.id}&document=${document.id}&page=${document.nextPage}"> &gt;</a>
                            </div>
                        </section>
                    </section>
                 </section>
            </section>
        </section>
    </body>
</html>

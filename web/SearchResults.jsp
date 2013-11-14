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
        <jsp:useBean id="results" class="PandoAFP.Results" scope="session"/> 
        <jsp:setProperty name="pipeline" property="id" value="1"/>
                
        <section id="document">           
             <jsp:include page="Reusable_Parts/SiteHeader.jsp">
                <jsp:param name="pageTitle" value="Search Results"/>
            </jsp:include>
        
           <jsp:include page="Reusable_Parts/SearchBar.html"/>
            
            <section id="breadcrumb">
                <!-- <a href="foo.com">PipeLineName</a> &gt; <a href="foo.com">AJ Miro</a> &gt; Resume -->
                <a href="index.jsp?pipeline=${pipeline.id}"> ${pipeline.name} </a> &gt;                  
            </section>      
            
            <section id="dataSectionImageOnly">                
                <section id="mainSectionImageOnly">
                    <section id="dataHeader">
                        <div id="listTitle"> 
                            <!--&lt; Description based on current selection level &gt;-->
                            <span id="backgroundHighlight">Search Results</span>
                        </div>
                    </section>                                
                    
                    <section id="mainSectionContentSearchResults">                                                                           
                        <c:forEach var="item" items="<%=results.getSearchResults()%>" varStatus="loop">
                            <div id="resultDocumentType">
                                <a href="DocumentView?candidate=${item.candidate.id}&dt=${item.documentType.id}&document=${item.documentID}&page=1">${item.documentType.name}</a></br>
                            </div>                            
                            <div id="resultCandidateName">                                
                                ${item.candidate.lastName}, ${item.candidate.firstName}</br></br>
                            </div>                            
                        </c:forEach>
                    </section>
                 </section>
            </section>
        </section>
    </body>
</html>

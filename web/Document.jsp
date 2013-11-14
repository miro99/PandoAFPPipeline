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
        <section id="document">
             <jsp:include page="Reusable_Parts/SiteHeader.jsp">
                <jsp:param name="pageTitle" value="Candidate Documents" />
            </jsp:include>
        
            <jsp:include page="Reusable_Parts/SearchBar.html"/>
            
            <section id="breadcrumb">                
                 <a href="index.jsp?pipeline=${pipeline.id}"> ${pipeline.name} </a> &gt;  
                 <a href="DocTypeServlet?candidate=${candidateOBJ.id}"> ${candidateOBJ.lastName}, ${candidateOBJ.firstName} </a> &gt;
                 ${documenttype.name}
            </section>
            
            <section id="dataSection">
                <section id="dataList">
                    <section id="dataHeader">
                        <div id="listTitle"> <span id="backgroundHighlight">Document</span><div>
                    </section>  
                           
                    <section id="listItemSection">
                        <c:forEach var="item" items="${documenttype.documents}" varStatus="loop">
                            <div class="listItem">
                               <a href="DocumentView?candidate=${candidateOBJ.id}&document=${item.id}&page=1">
                                    ${item.name}
                                </a>                                     
                            </div>
                        </c:forEach>
                            
                    </section>                                       
                </section>          
                <section id="mainSection">
                    <section id="dataHeader">
                        <div id="listTitleDocument">                             
                            <span id="backgroundHighlight">Document Type</span>
                        </div>
                    </section>  
                    <section id="mainSectionContent">
                             <div id="documentTypeData">
                                 ${documenttype.name}
                             </div>
                    </section>
                 </section>
            </section>
        </section>
    </body>
</html>

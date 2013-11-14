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
            <section id="header">
                <div id="headerColumn1">
                    <img src="Images/Pando AFP.png"/>
                    <!--<img src="Images/PandoAFP - Version 2.png"/>-->
                </div>
            
                <div id="headerColumn2">
                    Document Viewer
                </div>
                
                <div id="rightSideHeader">
                    
                </div>
            </section>
        
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
                        <!-- <div class="listItem"><a href="foo.com"> Miro, AJ </a></div>
                        <div class="listItem"><a href="foo.com">Dub, Adam</a></div>
                        <div class="listItem"><a href="foo.com">Dub, Eitan</a></div> -->
                            
                        <c:forEach var="item" items="${documenttype.documents}" varStatus="loop">
                            <div class="listItem">
                               <a href="DocumentView?candidate=${candidateOBJ.id}&document=${item.id}&page=1">
                                <!-- <a href="DocumentImage?candidate=${candidateOBJ.id}&documentID=${item.id}&page=1"> -->
                                    ${item.name}
                                </a>                                     
                            </div>
                        </c:forEach>
                            
                    </section>                                       
                </section>          
                <section id="mainSection">
                    <section id="dataHeader">
                        <div id="listTitleDocument"> 
                            <!--&lt; Description based on current selection level &gt;-->
                            <span id="backgroundHighlight">Document Type</span>
                        </div>
                    </section>  
                    <section id="mainSectionContent">
                        <!--<div>-->
                        <!-- <img src='Images/testImage.jpg'/> -->
                             <!--<div id="candidateDetails">
                                <div id="imageBorder">                                    
                                    <img id="candidateImage" src="CandidateImage/?candidate=100"/>
                                </div>
                                <div id="candidateData">
                                        AJ Miro<br/>
                                        1013 East 156 St<br/>
                                        Bronx NY, 10455 apt 2
                                </div>
                            </div>-->       
                             <!--<div id="pipelineData">-->
                             <div id="documentTypeData">
                                 ${documenttype.name}
                             </div>
                        <!--</div>-->
                    </section>
                 </section>
            </section>
        </section>
    </body>
</html>

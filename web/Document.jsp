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
                    <!-- PandoAFP -->
                    <img src="Images/PandoAFP - Version 2.png"/>
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
                 ${documenttype.name}
            </section>
            
            <section id="dataSection">
                <section id="dataList">
                    <section id="dataHeader">
                        <div id="listTitle">Candidates<div>
                    </section>  
                           
                    <section id="listItemSection">
                        <!-- <div class="listItem"><a href="foo.com"> Miro, AJ </a></div>
                        <div class="listItem"><a href="foo.com">Dub, Adam</a></div>
                        <div class="listItem"><a href="foo.com">Dub, Eitan</a></div> -->
                            
                        <c:forEach var="item" items="${documenttype.documents}" varStatus="loop">
                            <div class="listItem">
                               <a href="DocumentView?document=${item.id}">
                                    ${item.name}
                                </a>                                     
                            </div>
                        </c:forEach>
                            
                    </section>                                       
                </section>          
                <section id="mainSection">
                    <section id="dataHeader">
                        <div id="listTitle"> 
                            <!--&lt; Description based on current selection level &gt;-->
                            &lt; Pipeline Information &gt;
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
                             <div id="pipelineData">
                                 Name: ${pipeline.name}
                             </div>
                        <!--</div>-->
                    </section>
                 </section>
            </section>
        </section>
    </body>
</html>

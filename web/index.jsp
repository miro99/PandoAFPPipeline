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
                <div id="filtersText">FILTER:</div>
                <div id="text">Keyword:</div>
                <div id="txtInput">
                    <input id="keywordInput" type="text" name="txtkeyword" value="" />
                </div>
                <div id="buttondiv">
                    <button id="goButton">GO</button>
                </div>
            </section>
            
            <section id="breadcrumb">                
                <%= pipeline.getName()%> &gt;
            </section>
            
            <section id="dataSection">
                <section id="dataList">
                    <section id="dataHeader">
                        <div id="listTitle">Candidate<div>
                    </section>  
                           
                    <section id="listItemSection">
                        <!-- <div class="listItem"><a href="foo.com"> Miro, AJ </a></div>
                        <div class="listItem"><a href="foo.com">Dub, Adam</a></div>
                        <div class="listItem"><a href="foo.com">Dub, Eitan</a></div> -->
                            
                        <c:forEach var="item" items="<%=pipeline.getCandidates()%>" varStatus="loop">
                            <div class="listItem">
                               <a href="DocTypeServlet?candidate=${item.id}">
                                    ${item.lastName}, ${item.firstName}
                                </a>                                     
                            </div>
                        </c:forEach>
                            
                    </section>                                       
                </section>          
                <section id="mainSection">
                    <section id="dataHeader">
                        <div id="listTitle">                             
                            <!-- &lt; Pipeline Information &gt; -->
                            ${pipeline.name}
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
                                ${pipeline.note}
                             </div>
                        <!--</div>-->
                    </section>
                 </section>
            </section>
        </section>
    </body>
</html>

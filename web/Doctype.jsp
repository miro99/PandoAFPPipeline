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
        <jsp:useBean id="pipeline" class="PandoAFP.Pipeline" scope="session"/>
        <jsp:useBean id="doctype" class="PandoAFP.DocumentType" scope="session"/>
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
        
        <!--    <section id="keyword">
                <div id="filtersText">FILTERS:</div>
                <div id="text">Search:</div>
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
                <!-- <a href="foo.com">PipeLineName</a> &gt; <a href="foo.com">AJ Miro</a> &gt; Resume -->
                <a href="index.jsp?pipeline=${pipeline.id}"> ${pipeline.name} </a> &gt;  
                ${candidateOBJ.lastName}, ${candidateOBJ.firstName}
            </section>                      
            
            <section id="dataSection">
                <section id="dataList">
                    <section id="dataHeader">
                        <div id="listTitle">Document Types<div>
                    </section>  
                           
                    <section id="listItemSection">                                             
                        <c:forEach var="item" items="<%=pipeline.getDocumentTypes()%>" varStatus="loop">
                            <div class="listItem">
                               <a href="Documents?doctype=${item.id}">
                                    ${item.name}
                                </a>                                     
                            </div>
                        </c:forEach>    
                    </section>                                       
                </section>          
                <section id="mainSection">
                    <section id="dataHeader">
                        <div id="listTitle"> 
                            Candidate
                        </div>
                    </section>  
                    <section id="mainSectionContent">
                        <!--<div>-->
                            <!-- <img src='Images/testImage.jpg'/> -->
                            <div id="candidateDetails">
                                <div id="imageBorder">                                    
                                    <img id="candidateImage" src="CandidateImage/?candidateID=${candidateOBJ.id}"/>
                                </div>
                                <div id="candidateData">
                                        <!-- AJ Miro<br/>
                                        1013 East 156 St<br/>
                                        Bronx NY, 10455 apt 2 -->
                                        ${candidateOBJ.firstName}, 
                                        ${candidateOBJ.lastName}
                                        <br/>
                                        ${candidateOBJ.title}
                                </div>
                            </div>
                        <!--</div>-->
                    </section>
                 </section>
            </section>
        </section>
    </body>
</html>

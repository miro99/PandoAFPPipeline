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
             <jsp:include page="Reusable_Parts/SiteHeader.jsp">
                <jsp:param name="pageTitle" value="Candidate Document Types" />
            </jsp:include>
        
            <jsp:include page="Reusable_Parts/SearchBar.html"/>       
            
            <section id="breadcrumb">
                <!-- <a href="foo.com">PipeLineName</a> &gt; <a href="foo.com">AJ Miro</a> &gt; Resume -->
                <a href="index.jsp?pipeline=${pipeline.id}"> ${pipeline.name} </a> &gt;  
                ${candidateOBJ.lastName}, ${candidateOBJ.firstName}
            </section>                      
            
            <section id="dataSection">
                <section id="dataList">
                    <section id="dataHeader">
                        <div id="listTitleDT"><span id="backgroundHighlight">Document Types</span><div>
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
                        <div id="listTitleDTCandidate"> 
                            <span id="backgroundHighlight">Candidate</span>
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
                                <section id="CommentSection">                                           
                                    <br/><br/>
                                    Add Comment:
                                    <form action="Comment" method="post">
                                        <!-- <input id="commentText" type="text"/> -->
                                        <textarea id="commentText" name="comment">
                                        </textarea>
                                        <section id="GoodBad">
                                            <input type="radio" checked="checked" name="goodBad" value="1"><img id="positiveInput" src="Images/thumb up.png"/>
                                            <input type="radio" name="goodBad" value="0"><img id="negativeInput" src="Images/thumb down.png"/>
                                            <!-- <input type="radio" name="goodBad" value="-1">n/a -->                                            
                                        </section>
                                        <input id="postCommentButton" type="submit" value="Post"/>
                                    </form>
                                </section>
                        <!--</div>-->
                    </section>
                 </section>
            </section>
        </section>
    </body>
</html>

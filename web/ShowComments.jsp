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
                    <img src="Images/Pando AFP.png"/>
                </div>
            
                <div id="headerColumn2">
                    Comments
                </div>
                
                <div id="rightSideHeader">
                    
                </div>
            </section>
        <form action="Search" method="POST">
            <section id="keyword">
                <div id="filtersText">FILTER:</div>
                <div id="text">Search:</div>
                
                    <div id="txtInput">
                        <input id="keywordInput" type="text" name="txtkeyword" value="" />
                    </div>
                    <div id="buttondiv">                        
                        <input type="submit" value="GO"/>
                    </div>

            </section>
        </form>            
            <section id="breadcrumb">
                <!-- <a href="foo.com">PipeLineName</a> &gt; <a href="foo.com">AJ Miro</a> &gt; Resume -->
                <a href="index.jsp?pipeline=${pipeline.id}"> ${pipeline.name} </a> &gt;  
                ${candidateOBJ.lastName}, ${candidateOBJ.firstName}
            </section>  
            
            <section id="dataSectionComments">                     
                <section id="mainSectionComments">
                    <section id="dataHeader">                        
                        <div id="listTitleComments">   
                            <span id="backgroundHighlight">
                                ${candidateOBJ.lastName} , ${candidateOBJ.firstName} - User Comments
                            </span>
                        </div>                        
                    </section>  
                    <section id="mainSectionContentComments">                       
                        <div id="commentsSection">
                             <c:forEach var="item" items="${candidateOBJ.comments}" varStatus="loop">
                            <div class="listItemComment"> 
                                <div class="thumb">
                                    <img src="ThumbImage?score=${item.score}"/>
                                </div>
                                <div class="userAndTimeStampComment">                                                                        
                                    ${item.timeStamp} &nbsp;
                                    (${item.user.lastName} , ${item.user.firstName}) <br/>
                                </div>                                
                            </div>
                            <div class="comment">
                                ${item.review}
                            </div>
                        </c:forEach>
                        </div>
                    </section>
                 </section>
            </section>
        </section>
    </body>
</html>

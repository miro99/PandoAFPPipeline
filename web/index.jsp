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
            <jsp:include page="Reusable_Parts/SiteHeader.jsp">
                <jsp:param name="pageTitle" value="Document Viewer" />
            </jsp:include>
        <jsp:include page="Reusable_Parts/SearchBar.html"/>

        <section id="breadcrumb">                
            <%= pipeline.getName()%> &gt;
        </section>

        <section id="dataSection">
            <section id="dataList">
                <section id="dataHeader">
                    <div id="titleborder">
                        <div id="listTitle"><span id="backgroundHighlight">Candidate</span><div>
                    </div>
                </section>  

                <section id="listItemSectionCandidateList">
                    <!-- <div class="listItem"><a href="foo.com"> Miro, AJ </a></div>
                    <div class="listItem"><a href="foo.com">Dub, Adam</a></div>
                    <div class="listItem"><a href="foo.com">Dub, Eitan</a></div> -->

                    <Table id="tbl">
                        <c:forEach var="item" items="<%=pipeline.getCandidates()%>" varStatus="loop">
                            <tr>
                                <div class="listItem">
                                   <td>
                                       <div class="wordWrap">
                                           <a class="candidateItem" href="DocTypeServlet?candidate=${item.id}">
                                                ${item.lastName}, ${item.firstName}
                                           </a>
                                       </div>
                                    </td>
                                    <div class="posNegCount">
                                        <td class="posNegCount">
                                            &nbsp;&nbsp;<a class="commentCounts" href="ShowComment?candidate=${item.id}"> 
                                                <img id="InputMainPage" src="Images/thumb up.png">${item.positiveCommentCount}&nbsp;
                                                <img id="InputMainPage" src="Images/thumb down.png">${item.negativeCommentCount}&nbsp;
                                            </a>
                                        </td>
                                    </div>
                                </div>
                            </tr>
                        </c:forEach>
                    </table>

                </section>                                       
            </section>          
            <section id="mainSection">
                <section id="dataHeader">
                    <div id="listTitle2">                             
                        <!-- &lt; Pipeline Information &gt; -->
                        <span id="backgroundHighlight">Pipeline Description</span>
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
                         <div id="pipelinename">${pipeline.name}</div>
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

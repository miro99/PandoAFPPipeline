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
                <jsp:param name="pageTitle" value="Pipeline Candidates" />
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
                    <Table id="tbl">
                        <tr>
                            <th class="tableHeader">Name</th>
                            <th class="tableHeader">Comment</th>
                            <th class="tableHeader">
                            <section id="ETSFilter">
                                <div id="ETSFilterText"> ETS</div>
                                <div id="ETSFilterSelect">
                                    <form action="foo" method="post">
                                        <select onchange="this.form.submit()">
                                            <option value="All">All</option>
                                            <option value="5">5</option>
                                            <option value="4">4</option>
                                            <option value="3">3</option>
                                            <option value="2">2</option>
                                            <option value="1">1</option>
                                        </select>
                                    </form>
                                </div>
                            </section>
                            </th>
                        </tr>
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
                                    <jsp:include page="Reusable_Parts/PositiveNegativeCommentCount.jsp">
                                        <jsp:param name="candidateID" value="${item.id}"/>
                                        <jsp:param name="positiveCount" value="${item.positiveCommentCount}"/>
                                        <jsp:param name="negativeCount" value="${item.negativeCommentCount}"/>
                                    </jsp:include>
                                    <td id="rankNumber">
                                        ${item.rank}
                                    </td>
                                </div>
                            </tr>
                        </c:forEach>
                    </table>

                </section>                                       
            </section>          
            <section id="mainSection">
                <section id="dataHeader">
                    <div id="listTitle2">                                                     
                        <span id="backgroundHighlight">Pipeline Description</span>
                    </div>
                </section>  
                <section id="mainSectionContent">                     
                     <div id="pipelinename">${pipeline.name}</div>
                     <div id="pipelineData">
                        ${pipeline.note}
                     </div>                    
                </section>
             </section>
        </section>
        </section>
    </body>
</html>

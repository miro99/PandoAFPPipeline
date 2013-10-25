<%-- 
    Document   : index
    Created on : Oct 18, 2013, 10:33:12 AM
    Author     : ajmiro
--%>

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
                <!-- <a href="foo.com">PipeLineName</a> &gt; <a href="foo.com">AJ Miro</a> &gt; Resume -->
                <a href="foo.com"> ${pipeline.name} </a> &gt;                
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
                        <% PandoAFP.Candidate[] candidates = pipeline.getCandidates(); 
                            for(int i = 0; i < candidates.length; i++){ %>
                            <div class="listItem"><a href="Doctype.jsp?candidate=<%=candidates[i].getId()%>"><%= candidates[i].getLastName()%>, <%= candidates[i].getFirstName() %></a></div>
                            <%}%>                        
                    </section>                                       
                </section>          
                <section id="mainSection">
                    <section id="dataHeader">
                        <div id="listTitle"> &lt; Description based on current selection level &gt;<div>
                    </section>  
                    <section id="mainSectionContent">
                        <!--<div>-->
                            <img src='Images/testImage.jpg'/>
                        <!--</div>-->
                    </section>
                 </section>
            </section>
        </section>
    </body>
</html>

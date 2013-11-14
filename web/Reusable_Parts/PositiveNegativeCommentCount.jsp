<%-- 
    Document   : PositiveNegativeCommentCount
    Created on : Nov 14, 2013, 2:48:01 PM
    Author     : ajmiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <div class="posNegCount">
            <td class="posNegCount">
                <a class="commentCounts" href="ShowComment?candidate=${param.candidateID}"> 
                    <img id="InputMainPage" src="Images/thumb up.png">${param.positiveCount}&nbsp;
                    <img id="InputMainPage" src="Images/thumb down.png">${param.negativeCount}&nbsp;
                </a>
            </td>
        </div>
    </body>
</html>

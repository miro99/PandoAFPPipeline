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
        <!-- <div> -->
            <td class="posNegCount">
                <a class="commentCounts" href="ShowComment?candidate=${param.candidateID}">
                    <img class="InputMainPage" src="Images/thumb%20up.png">
                    ${param.positiveCount}&nbsp;
                    <img class="InputMainPage" src="Images/thumb%20down.png">
                    ${param.negativeCount}&nbsp;
                </a>
            </td>
        <!-- </div> -->
    </body>
</html>

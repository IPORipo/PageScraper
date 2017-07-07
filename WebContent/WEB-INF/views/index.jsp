<%@include file="includes/header.jsp" %>
            <section id="search">
                <img src="all_resources/resources/img/Idea.gif" alt="სურათი წაშლილია :(">
                <h2>Enter link to see all its links and immages</h2>
                
                <%//message ill appear if request goes to server and error(invalid url) is recognized by server
                	String errorMessage = (String)request.getParameter("message");
                	if(errorMessage==null) 
                		errorMessage="";
                %>
                <h3 id="message"><%=errorMessage%></h3>
                

                
                <form id="search-form" method="get" action="results" >
                    <input id="site-path" type="text" name="site-path" class="search-filed" value="http://">
                    <input id="search" type="submit" name="search" value="search" class="search-btn">
                </form>
            </section>
<%@include file="includes/footer.jsp" %>


        
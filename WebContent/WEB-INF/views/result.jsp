<%@include file="includes/header.jsp" %>
            <h2><%=request.getAttribute("requested_link") %></h2>
            <h1>Results</h1>
            
            <section id="links-img-switcher">
                <a id="imgs-switch">Immages</a>
                <a id="links-switch">Links</a>
            </section>
            
            <section id="immages">
             <%
	            Set result_imgs =(Set)request.getAttribute("result_imgs");
	          //access via Iterator
	            Iterator imgs = result_imgs.iterator();
	            while(imgs.hasNext()){
	            	String img = (String)imgs.next();	            	
	            %>
	                <img src="<%=img%>" class="box">
				<%            	
	            }
	         %>
            	</section>
            
            
            <section id="links">
            
            <%
	            Set result_links =(Set)request.getAttribute("result_links");
	          //access via Iterator
	            Iterator iterator = result_links.iterator();
	            while(iterator.hasNext()){
	            	String lnk = (String)iterator.next();	            	
	            %>
	                <a href="<%=lnk%>" class="box"><%=lnk%></a>
				<%            	
	            }
	         %>
			</section>
<%@include file="includes/footer.jsp" %>

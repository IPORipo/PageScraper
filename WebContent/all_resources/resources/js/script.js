$(document).ready(function(){

    $('#search-form').submit(function() {
        var path = $("#site-path").val();/* site path */
        var regexp = /https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9]\.[^\s]{2,}//* rool which identifies is url correct or not*/
        
        if(regexp.test(path)){    
            return true;/* returns true if url is correct*/
        }else {
            $("#message").html("please fill in path using: http//site format");
            return false; /* return false if url is not correct and dont submits*/
        };
    });
});



$(window).on("load",function(){
        $("#wraper").addClass("load-cube").css("visibility","visible");
        $(".box").addClass("leaves");
        $(".loader").fadeOut("3000");
});
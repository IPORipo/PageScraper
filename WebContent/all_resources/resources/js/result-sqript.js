$(document).ready(function(){

    $('#imgs-switch').click(function() {
  
        $(this).css("opacity","1");
        $("#links-switch").css("opacity","0.3");
        
        $("#links").fadeOut(1);
        $("#immages").fadeIn(1000);
    });
    $('#links-switch').click(function() {
        
        $(this).css("opacity","1");
        $("#imgs-switch").css("opacity","0.3");
        
        $("#immages").fadeOut(1);
        $("#links").fadeIn(1000);
    });

});
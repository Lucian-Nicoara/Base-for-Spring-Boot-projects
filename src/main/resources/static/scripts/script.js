$(window).on('resize', function () {
	if($(window).width() > 767){		
		$("#mySidenav").width("200px");
		$("#main").css("margin-left", "200px");
	}else{
		$("#mySidenav").width("0px");
		$("#main").css("margin-left", "0px");
	}
});

function toggleSideNav(){
	if($("#mySidenav").width() >= 1 ){
		$("#btnMenu").removeClass("fa-close");
		$("#btnMenu").addClass("fa-bars");
		
		$("#mySidenav").width("0px");
		$("#main").css("margin-left", "0px");
	}else{
		$("#btnMenu").removeClass("fa-bars");
		$("#btnMenu").addClass("fa-close");
		
		$("#mySidenav").width("200px"); //use 100% for full cover of screen
		if($(window).width() > 767){
			$("#main").css("margin-left", "200px");
		}
	}
}
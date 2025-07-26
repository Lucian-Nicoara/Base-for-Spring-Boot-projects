$(window).on('resize', function () {
	if($(window).width() > 767){		
		//show sidenav
		$("#mySidenav").css("position", "");
		$("#mySidenav").width("200px");
		$("#mySidenav").css("height", "");
		$("#mySidenav").css("top", "71px");
	}else{
		//hide sidenav
		$("#mySidenav").css("box-shadow", "");
		$("#mySidenav").width("0px");
		$("#mySidenav").css("margin-left", "0px");
		$("#mySidenav").css("position", "");
	}
});

function toggleSideNav(){
	if($("#mySidenav").width() >= 1 ){
		//hide sidenav
		$("#btnMenu").removeClass("fa-close");
		$("#btnMenu").addClass("fa-bars");
		$("#mySidenav").css("box-shadow", "");
		$("#mySidenav").width("0px");
		$("#mySidenav").css("margin-left", "0px");
	}else{
		//show sidenav
		$("#btnMenu").removeClass("fa-bars");
		$("#btnMenu").addClass("fa-close");
		
		$("#mySidenav").css("transition", "0s");
		$("#mySidenav").css("margin-left", "12px");
		$("#mySidenav").css("height", "100%");
		$("#mySidenav").css("top", "71px");
		$("#mySidenav").css("position", "fixed");
		$("#mySidenav").css("box-shadow", "10px 10px 10px rgba(100, 100, 100, 0.5)");
		$("#mySidenav").css("transition", "0.5s"); //animate only width
		$("#mySidenav").width("200px"); //use 100% for full cover of screen		
	}
}
var sideNavOpened = false;

$(window).on('resize', function () {
	if($(window).width() > 700){
		$("#mySidenav").width("250px");
		$("#main").css("margin-left", "250px");
		$("#btnMenu").fadeOut(500);
		$("#btnCloseSidenav").fadeOut(500);
		
	}else{
		$("#btnMenu").fadeIn(500);
		$("#btnCloseSidenav").fadeIn(500);
		if(!sideNavOpened){
			$("#mySidenav").width("0px");
			$("#main").css("margin-left", "0px");
		}else{
			$("#main").css("margin-left", "250px");
		}
	}
});

/* Set the width of the side navigation to 250px */
function openNavOver() {
	sideNavOpened = true;
	$("#mySidenav").width("250px"); //use 100% for full cover of screen
	if($(window).width() > 700){
		$("#main").css("margin-left", "250px");
	}
}

/* Set the width of the side navigation to 0 */
function closeNavOver() {
	sideNavOpened = false;
	$("#mySidenav").width("0px");
	$("#main").css("margin-left", "0px");
}
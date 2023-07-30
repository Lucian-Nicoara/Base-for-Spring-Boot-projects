var sideNavOpened = false;

$(window).on('resize', function () {
	if($(window).width() > 700){
		$("#mySidenav").width("200px");
		$("#main").css("margin-left", "200px");
		$("#btnMenu").fadeOut(500);
		$("#btnCloseSidenav").fadeOut(500);
		
	}else{
		if(sideNavOpened){
			$("#main").css("margin-left", "200px");
			$("#btnCloseSidenav").fadeIn(500);
			$("#btnMenu").fadeOut(500);
		}else{
			$("#mySidenav").width("0px");
			$("#main").css("margin-left", "0px");
			$("#btnCloseSidenav").fadeOut(500);
			$("#btnMenu").fadeIn(500);
		}
	}
});

function openNavOver() {
	sideNavOpened = true;
	$("#mySidenav").width("200px"); //use 100% for full cover of screen
	if($(window).width() > 700){
		$("#main").css("margin-left", "200px");
	}
	$("#btnMenu").hide();
	$("#btnCloseSidenav").show();
}

/* Set the width of the side navigation to 0 */
function closeNavOver() {
	sideNavOpened = false;
	$("#mySidenav").width("0px");
	$("#main").css("margin-left", "0px");
	$("#btnMenu").show();
	$("#btnCloseSidenav").hide();
}
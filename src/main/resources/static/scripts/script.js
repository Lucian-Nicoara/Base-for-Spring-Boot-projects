function getTodayDate(){
	const today = new Date();
	const yyyy = today.getFullYear();
	let mm = today.getMonth() + 1; // Months start at 0!
	let dd = today.getDate();

	if (dd < 10) dd = '0' + dd;
	if (mm < 10) mm = '0' + mm;

	return dd + '.' + mm + '.' + yyyy;
}

function verificaData(dataInput){
	var dateArray = dataInput.split(".");
	var ziuaOk = false;
	var lunaOk = false;
	var anulOk = false;
	if(dateArray.length == 3){
		if(parseInt(dateArray[0]) > 0 && parseInt(dateArray[0]) <= 31){
			ziuaOk = true;
		}
		if(parseInt(dateArray[1]) > 0 && parseInt(dateArray[1]) <= 12){
			lunaOk = true;
		}
		if(dateArray[2].length == 4 && parseInt(dateArray[2]) > 1900 && parseInt(dateArray[2]) <= 2199){
			anulOk = true;
		}
	}else{
		return "notok";
	}
	
	if(!ziuaOk || !lunaOk || !anulOk){
		return "notok";
	}else{
		return "ok";
	}
}
function handleHtmlError(htmlError){
	$(".modal").modal("hide");
	$("#divEroareHtml").html(htmlError);
	$("#modalHandleHtmlError").modal({backdrop: "static", keyboard: false}).modal("show");
}
	
function inchideModalHandleHtmlError(){
	$("#divEroareHtml").html("");
	$("#modalHandleHtmlError").modal("hide");
	window.location.reload();
}

function copiazaEroarea(){
	navigator.clipboard.writeText($("#divEroareHtml").html()).then(function () {
	    alert("Textul a fost copiat. Poti folosi CTRL+V")
	}, function () {
	    alert("Textul nu a putut fi copiat. Trebuie selectat si copiat manual.")
	});
}
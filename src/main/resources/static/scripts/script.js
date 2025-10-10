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
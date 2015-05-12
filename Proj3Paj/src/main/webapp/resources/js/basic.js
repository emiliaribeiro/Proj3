$(document).ready(function(){
	$('#hist li').on("click",function(e){
		document.getElementById("teste:basicdisplay").value=e.target.innerHTML;
	});
	window.onkeydown = function () {
		$('#basicdisplay').on('focus',function(){return false;});
	}	
});

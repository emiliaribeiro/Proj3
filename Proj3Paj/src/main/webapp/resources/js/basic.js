
document.onkeydown = function (e) {
    return false;
}	

$(document).ready(function(){
	$(function(){
		setInterval(function(){$('#btn-refresh').trigger('click')},500);
		
	});
	
	
	
	$('#hist > li').on("click",function(e){
		document.getElementById("basicform:basicdisplay").value=e.target.innerHTML;
	});
});

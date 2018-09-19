jQuery(document).ready(function($){
	//smart links
	jQuery('a[href="#"]').on('click', function(e){ 
		e.preventDefault();
		$(this).toggleClass("btn-success");
	});
	
});
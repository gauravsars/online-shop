$(function() {
	
	//solving the active menu problem.
	switch(menu) {
	
	case 'About Us' :
		$('#about').addClass('active');
		break;
	case 'Contact Us' :	
		$('#contact').addClass('active');
		break;	
	default :
		if(menu=='Home')break;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');	
		break;
	}
	
	//code for jquery dataTable
	//create a dataset

	var products = [
	            	['1','ABC'],
	            	['1','DEF'],
	            	['1','GHI'],
	            	['1','JKL'],
	            	['1','MNO'],
	            	['1','PQR'],
	            	['1','STU'],
	            	['1','VWX'],
	            	['1','YZA'],
	            	['1','BCA']
	            ];

	var $table = $('#productListTable');
	//execute the below code only where we have this table.

	if($table.length) {
		$table.DataTable({
			lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','All Records']],
			data:products,
			pageLength:8
		});
		
	}
});


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
	//create a database

	var $table = $('#productListTable');
	//execute the below code only where we have this table.

	if($table.length) {
		if(window.categoryId==''){
			
			jsonUrl =window.contextRoot + '/json/data/all/products';
		}
		else{
			jsonUrl=window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		}
		$table.DataTable({
			lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','All Records']],
			pageLength:5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
			          
			          {
			        	  data: 'name',
			          },
			          {
			        	  data: 'brand',
			          },
			          {
			        	  data: 'unitPrice',
			          },
			          {
			        	  data: 'quantity',
			          }
			          
			          ]
		});
		
	}
});


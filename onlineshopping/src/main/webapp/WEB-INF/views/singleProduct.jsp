<div class ="container">
<!-- Breadcrumb -->
<div class="row">
	
	<div class="col-xs-12">
	
		<ol class="breadcrumb">
		
			<li><a href="${contextRoot}/home">Home</a></li>
			<li><a href="${contextRoot}/show/all/products">Products</a></li>
			<li class="active">${productInfo.name}</li>
		</ol>
	
	
	</div>


</div>

<div class="row">
<!-- Display product image -->
<div class="col-xs-12 col-sm-4">
<div class="thumbnail">

<img src="${images}/${productInfo.code}.jpg" class="img img-responsive"/>

</div>


</div>
<!-- Display the product Information -->
<div class="col-xs-12 col-sm-8">
<h3>${productInfo.name}</h3>
</hr>

<p>${productInfo.description}</p>
</hr>

<h4>Price: <strong>&#8377; ${productInfo.unitPrice} /-</strong></h4>
</hr>
<br>
<h6>Qty. Available : ${product.quantity}</h6>
<br>
<a href = "${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">
			<span class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</a>
			
<a href="${contextRoot}/show/all/products" class="btn btn-success">Back</a>		
</div>
</div>
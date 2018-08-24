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
<br>
<p>${productInfo.description}</p>
</hr>
<br>
<h4>Price: <strong>&#8377; ${productInfo.unitPrice} /-</strong></h4>
</hr>
<br>

<c:choose>

	<c:when test ="${productInfo.quantity < 1}">
	
		<h6>Qty. Available : <span style = "color:red">Out of Stock!</span></h6>
	</c:when>
	
	
	<c:otherwise>
	
	<h6>Qty. Available : ${productInfo.quantity}</h6>
	
	</c:otherwise>

</c:choose>
<br>

<c:choose>

	<c:when test ="${productInfo.quantity < 1}">
	
		<a href = "javascript:void(0)" class="btn btn-success disabled"></strike>
			<span class="button"></span>Add To Cart</strike></a>
	</c:when>
	
	
	<c:otherwise>
	
	<a href = "${contextRoot}/cart/add/${productInfo.id}/product" class="btn btn-success">
			<span class="glyphicon glyphicon-shopping-cart" ></span>Add To Cart</a>
	
	</c:otherwise>

</c:choose>

&nbsp

<a href="${contextRoot}/show/all/products" class="btn btn-success">Back</a>		
</div>
</div>
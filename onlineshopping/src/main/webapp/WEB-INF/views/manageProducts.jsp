<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div clas="row">
	<c:if test="${not empty message}">
	<div class="alert alert-success alert-dismissable">
	<button type="button" class="close" data-dismiss="alert">&times;</button>
	${message}
	</div>
	</c:if>
	<div class="col-xs-12">


		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product Management</h4>

				</div>




				<div class="panel-body">

					<!-- FORM ELEMENTS -->

					<sf:form class="form-horizontal" modelAttribute="product"
						action ="${contextRoot}/manage/products" method="POST">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter Product Name</label>
							<div class=col-md-8>
							<sf:input type="text" path="name" id="name" placeholder="Product Name" /> 
							<em class="help-block">Enter enter Product name!</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter Brand Name</label>
							<div class=col-md-8>
							<sf:input type="text" path="brand" id="name" placeholder="Product Brand" /> 
							<em class="help-block">Enter Brand name!</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="product-Description">Enter Description About Product</label>
							<div class=col-md-8>
							<sf:textarea rows="4" cols="50" path="description" placeholder="Product Description" />
							<em class="help-block"> Enter Product Description!</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Enter Unit Price</label>
							<div class=col-md-8>
						    <sf:input type="number" path="unitPrice" id="name" placeholder="Unit Price" />
						    <em class="help-block">Enter Unit Price</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Enter Quantity</label>
							<div class=col-md-8>
							<sf:input type="number" path="quantity" id="name" placeholder="Quantity Available" />
							<em class="help-block">Enter Quantity Available</em>
							</div>
						</div>

							<div class="form-group">

								<label class="control-label col-md-4" for="categoryId">Select Category</label>
								<div class=col-md-8>
									<sf:select class="form-control" id="categoryId" path="categoryId"
									items="${categories}"
									itemLabel="name"
									itemValue="id"
									/>
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
									<input type="submit" name="submit" id="submit" value="submit"
										class="btn btn-primary" />
										
										<!-- HIDDEN FIELDS FOR PRODUCTS-->
										<sf:hidden path="id"/>
										<sf:hidden path="code"/>
										<sf:hidden path="supplierId"/>
										<sf:hidden path="purchases"/>
										<sf:hidden path="views"/>
										<sf:hidden path="id"/>										
								</div>
							</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>



</div>
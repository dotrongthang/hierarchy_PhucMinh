<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="productAPI" value="/api/product" />
<c:url var="userURL" value="/quan-tri/thanh-vien/danh-sach" />
<c:url var="addUserURL" value="/quan-tri/them-moi" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách thành viên</title>
</head>

<body>
	<div class="main-content">


		<form action="<c:url value='/quan-tri/thanh-vien/danh-sach'/>"
			id="formSubmit" method="get">

			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a
							href="<c:url value= '/trang-chu'/>">Trang chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<input type="hidden" value="1" id="page" name="page" /> 
							<input type="hidden" value="50" id="limit" name="limit" />
							<span class="input-icon"> <input type="text"
								placeholder="Tìm F1" class="nav-search-input" name="search"
								id="nav-search-input" autocomplete="off" /> <i
								class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- /.nav-search -->

				</div>
				<div class="page-content">
				
				<div class="nav-search" id="nav-search">
						<form class="form-search">
							<input type="hidden" value="1" id="page" name="page" /> 
							<input type="hidden" value="50" id="limit" name="limit" />
							<span class="input-icon"> <input type="text"
								placeholder="Tìm ID" class="nav-search-input" name="searchId"
								id="nav-search-input" autocomplete="off" /> <i
								class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- /.nav-search -->
				
					<h2>Danh sách thành viên</h2>

					<div class="row">
						<div class="col-xs-12">
							<c:if test="${not empty message}">
								<div class="alert alert-${alert}">${message}</div>
							</c:if>
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
											<c:url var="createProductURL"
												value="/quan-tri/san-pham/chinh-sua"></c:url>
											<a flag="info"
												class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Thêm thành viên'
												href='${addUserURL}'> <span> <i
													class="fa fa-plus-circle bigger-110 purple"></i>
											</span>
											</a>
											<button id="btnDelete" type="button"
												onclick="warningBeforeDelete()"
												class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Xóa sản phẩm'>
												<span> <i class="fa fa-trash-o bigger-110 pink"></i>
												</span>
											</button>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th><input type="checkbox" id="checkAll"></th>
													<th>Tên tài khoản</th>
													<th>Người giới thiệu</th>
													<th>Ngày kích hoạt</th>
													<th>Tổng doanh thu (x2,000,000 VNĐ)</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult}">
													<tr>
														<td><input type="checkbox" id="checkbox_${item.id}"
															value="${item.id}"></td>
														<td>${item.username}</td>
														<td>${item.parentname}</td>
														<td>${item.createdDate}</td>
														<td>${item.count}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<ul class="pagination" id="pagination"></ul>
										<input type="hidden" value="" id="page" name="page" /> 
										<input type="hidden" value="" id="limit" name="limit" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- /.main-content -->
	<script>
	var totalPages = ${model.totalPage};
	var currentPage = ${model.page};
	$(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
            	if (currentPage != page) {
            		$('#limit').val(2);
					$('#page').val(page);
					$('#formSubmit').submit();
				}
            }
        });
    });

		function warningBeforeDelete() {
			swal({
				title : "Xác nhận xóa",
				text : "Bạn có chắc chắn muốn xóa không?",
				type : "warning",
				showCancelButton : true,
				confirmButtonClass : "btn-success",
				cancelButtonClass : "btn-danger",
				confirmButtonText : "Xác nhận",
				cancelButtonText : "Hủy bỏ",

			}).then(
					function(isConfirm) {
						if (isConfirm) {
							/* swal("Deleted!", "Your imaginary file has been deleted.", "success"); */
							//call api delete
							var data = {};
							var ids = $('tbody input[type=checkbox]:checked')
									.map(function() {
										return $(this).val();
									}).get();
							deleteProduct(ids);
						}
					});
		}

		function deleteProduct(data) {
			$
					.ajax({
						url : '${productAPI}',
						type : 'DELETE',
						contentType : 'application/json',
						data : JSON.stringify(data),
						success : function(result) {
							window.location.href = "${productURL}?page=1&limit=2&message=delete_success";
						},
						error : function(error) {
							window.location.href = "${productURL}?page=1&limit=2&message=error_system";
						}
					});
		}
	</script>
</body>
</html>
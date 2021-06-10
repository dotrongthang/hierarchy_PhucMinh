<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="productAPI" value="/api/product" />
<c:url var="logURL" value="/quan-tri/thanh-vien/thong-ke" />
<c:url var="addUserURL" value="/quan-tri/them-moi" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thống kê doanh thu</title>
</head>

<body>
	<div class="main-content">

			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a
							href="<c:url value= '/trang-chu'/>">Trang chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->

				</div>
				<div class="page-content">
				
				<div class="nav-search" id="nav-search">
						<form class="form-search">
							<input type="hidden" value="1" id="page" name="page" /> 
							<input type="hidden" value="50" id="limit" name="limit" />
							<span class="input-icon"> <input type="text" style="width: 200px; height: 50px;"
								placeholder="Nhập username(xem chi tiết)" class="nav-search-input" name="search"
								id="search" autocomplete="off" /> <i
								class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
							<label>Nhập ngày bắt đầu</label>
							<input type="text" id="start" placeholder="DD/MM/YYYY" class="nav-search-input" name="start" />
							<label>Nhập ngày kết thúc</label>
							<input type="text" id="end" placeholder="DD/MM/YYYY" class="nav-search-input" name="end" /> 
							
							<button class="btn btn-info" type="button" id="btnFindLog">
										<i class="ace-icon fa fa-check bigger-110"></i>
										Tìm kiếm
									</button>
						</form>
					</div>
					<!-- /.nav-search -->
				
					<h2>Thống kê doanh thu</h2>

					<div class="row">
						<div class="col-xs-12">
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Thời gian</th>
													<th>Tên tài khoản</th>
													<th>Tổng doanh thu (x2,000,000 VNĐ)</th>
													<th>Người giới thiệu</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult}">
													<tr>
														<td>${item.createdDate}</td>
														<td>${item.username}</td>
														<td>${item.count}</td>
														<td>${item.parentname}</td>
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
	</div>
	<!-- /.main-content -->
	
	<script>
/* 	var totalPages = ${model.totalPage};
	var currentPage = ${model.page};
	$(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
            	if (currentPage != page) {
            		$('#limit').val(50);
					$('#page').val(page);
					$('#formSubmit').submit();
				}
            }
        });
    }); */

	$('#btnFindLog').click(function (e) {
		window.location.href = "${logURL}?start="+$('#start').val()+"&search="+$('#search').val()+"&end="+$('#end').val()+"&limit=50&page="+$('#page').val()+"";
	});
	</script>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="editUserURL" value="/quan-tri/thanh-vien/chinh-sua"/>
<c:url var="userAPI" value="/api/user"/>
<html>
<head>
<title>Thêm mới người dùng</title>
</head>
<body>
<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {
				}
			</script>

			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a href="<c:url value= '/quan-tri/trang-chu'/>">Trang quản trị</a>
				</li>

				<li><a href="<c:url value= '/quan-tri/san-pham/danh-sach?page=1&limit=2'/>">Quản lý thành viên</a></li>
				<li class="active">Thêm mới</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>
		
		<div class="page-content">
			<div class="row">
				<div class="col-xs-12">
				<c:if test="${not empty message}">
				<div class="alert alert-${alert}">
				  	${message}
				</div>
				</c:if>
				
					<form:form class="form-horizontal" method="post" role="form" id="formSubmit" modelAttribute="model">
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Tên Id </label>
								<div class="col-sm-9">
									<form:input path="username" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Ngày kích hoạt</label>
								<div class="col-sm-9">
									<form:input path="date" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						
						<form:hidden path="id" id="productId"/>
						
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								
									<button class="btn btn-info" type="button" id="btnAddUser">
										<i class="ace-icon fa fa-check bigger-110"></i>
										Cập nhật thông tin
									</button>
											&nbsp; &nbsp; &nbsp;
								<button class="btn" type="reset">
									<i class="ace-icon fa fa-undo bigger-110"></i>
									Hủy
								</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<script>

	$('#btnAddUser').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
	    
        updateUser(data);

	});
	
	function updateUser(data){
		$.ajax({
            url: '${userAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editUserURL}?message=update_success";
            },
            error: function (error) {
            	window.location.href = "${editUserURL}?message=error_system";
            }
        });
	}
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row" >
            <h2>Xem danh sách mã rơi sau khi kích hoạt một ID mới !!!</h2>
            
            <br/>
                <div class="col-xs-12">
				<div class="search">
					<form>
						<input type="text" name="search"
							style="width: 200px; heigh: 50px;" class="rounded-sm"
							placeholder="Nhập số thứ thự ID" /> 
					</form>
				</div>
				<br/>
				<div class="form-group">
					<h4>Kết quả</h4>
				</div>
				
				<div class="form-group">
					<p> ${result}
				</div>
                </div>
            </div>
        </div>
    </div>
</div><!-- /.main-content -->
</body>
</html>
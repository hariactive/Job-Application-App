<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>File upload here</title>
</head>
<body>

<div class= "container">

<form method="post" action="MoreDocs" enctype="multipart/form-data" >
<div class="apply_box">
	
			
	<table border="0">
	<div class="form_container">
	
	<h1>Upload Your <span class="title_small">(Documents)</span> </h1>
	
		<tr>
		<div class="form_control">
			<td>Upload Your 10th-Marksheet..</td>
			<td><input type="file" name="ten" size="50" required /></td>
				</div>
		</tr>
	
		<tr>
			<div class="form_control">
			<td>Upload Your 12th-Marksheet..</td>
			<td><input type="file" name="twelve" size="50" required /></td>
			</div>
		</tr>
		<tr>
		<div class="form_control">
			<td>Upload Your graduation-Marksheet..</td>
			<td><input type="file" name="graduation" size="50" required /></td>
			</div>
		</tr>
		<tr>
		<div class="form_control">
			<td>Upload Your Caste Certificate(Not for General)..</td>
			<td><input type="file" name="caste" size="50" required /></td>
		</div>
		</tr>
		<tr>
			<td colspan ="2">
			<div class="button_container">
				<input type="submit" value="save">
				</div>
			</td>
		</tr>
	</div>
	</table>
	</div>
</form>



</div>

</body>
</html>
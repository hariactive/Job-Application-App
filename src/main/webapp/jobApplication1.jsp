<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Application Form</title>
<link rel="stylesheet" href="css/jobApplication1.css">
</head>
<body>
<div class="container">
<div class="apply_box">
	<h1>Job Application
	<span class="title_small">(Web)</span>
	</h1>
	<form action="JobApplication1" method="post" enctype="multipart/form-data">
		<div class="form_container">
			<div class="form_control">
				<label for="first_name">First Name *</label>
				<input
				id="first_name"
				name="first_name"
				placeholder="Enter first name"
				required />
			</div>
			<div class="form_control">
				<label for="last_name">Last Name *</label>
				<input
				id="last_name"
				name="last_name"
				placeholder="Enter Last name"
				required />
			</div>
			<div class="form_control">
				<label for="email">Email *</label>
				<input
				type="email"
				id="email"
				name="email"
				placeholder="Enter Email.."
				required 
				/>
			</div>
			<div class="form_control">
  <label for="job_role">Job Role *</label>
  <select id="job_role" name="job_role" required >
    <option value="#">Select Job Role</option>
    <% 
    String[] jobRoles = { "Software Developer", "Software Tester", "Ethical Hacking Expert", "ERP Management", "System Analyst" };
    for (String role : jobRoles) { %>
      <option value="<%= role %>"><%= role %></option>
    <% } %>
  </select>
</div>

			<div class="textarea_control">
				<label for="address">Address</label>
				<textarea 
				id="address"
				name="address"
				row="4"
				cols="50"
				placeholder="Enter Address"
				></textarea>
			</div>
				<div class="form_control">
				<label for="city">City *</label>
				<input
				id="city"
				name="city"
				placeholder="Enter city name"
				required 
				 />
			</div>
				<div class="form_control">
				<label for="Pincode">Pincode *</label>
				<input
				type="number"
				id="pincode"
				name="pincode"
				placeholder="Enter Pincode"
				required 
				 />
			</div>
				<div class="form_control">
				<label for="date">D.O.B</label>
				<input
				value="2022-05-24"
				type="date"
				id="date"
				name="date"/>
			</div>
			<div class="form_control">
				<label for="upload">Upload your CV *</label>
				<input
				value="2022-05-24"
				type="file"
				id="upload"
				name="upload"
				required 
				/>
			</div>
			<div class="button_container">
				
				<input type="submit" value="Next">
			</div>

		</div>
	</form>
</div>

</div>
</body>
</html>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Timesheet</title>
	</head>
	<body>
		<form method="post" action="../TimesheetController">
		<table style="width:100%" border="1px" id="tableToModify">
		  <tr>
		  	<td>Type</td>
		  	<td>Start</td>
		  	<td>End</td>
		  	<td>Description</td>
		  	<td>Resolution</td>
		  </tr>
		  <tr id="rowToClone">
		    <td>
		    	<select name="type">
		  			<option value="oncall">On-Call</option>
		  			<option value="overtime">Overtime</option>
		  			<option value="callout">Callout</option>
		  			<option value="other">Other</option>
				</select>
		    </td>
		    <td><input type="text" name="start"></td>
		    <td><input type="text" name="end"></td> 
		    <td><input type="text" name="desc"></td>
		    <td><input type="text" name="res"></td>
		  </tr>
		</table>
		
		<input type="button" value="AddNewLine" onclick="cloneRow()">
		
		<input type="submit" value="Submit">
		</form>
		<script type="text/javascript">
			function cloneRow()
			{
				var row = document.getElementById("rowToClone"); // find row to copy
				var table = document.getElementById("tableToModify"); // find table to append to
				var clone = row.cloneNode(true); // copy children too
				clone.id = "newID"; // change id or other attributes/contents
				table.appendChild(clone); // add new row to end of table
			}
	
			function createRow()
			{
				var row = document.createElement('tr'); // create row node
				var col = document.createElement('td'); // create column node
				var col2 = document.createElement('td'); // create second column node
				var col3 = document.createElement('td');
				var col4 = document.createElement('td');
				var col5 = document.createElement('td');
				row.appendChild(col); // append first column to row
				row.appendChild(col2); // append second column to row
				row.appendChild(col3);
				row.appendChild(col4);
				row.appendChild(col5);
				var table = document.getElementById("tableToModify"); // find table to append to
				table.appendChild(row); // append row to table
			}
		</script>
		
	</body>
</html>
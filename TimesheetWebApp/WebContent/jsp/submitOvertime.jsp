<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<div class="wrapper">
		<form method="post" action="../OvertimeController">
		<table class="overtimeTable" id="tableToModify">
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
		
		<div>
			<input class="addLines" type="button" value="AddNewLine" onclick="cloneRow()">
			
			<input class="submitOvertime" type="submit" value="Submit">
		</div>
		</form>
	</div>
	<script type="text/javascript">
		function cloneRow()
		{
			var row = document.getElementById("rowToClone"); // find row to copy
			var table = document.getElementById("tableToModify"); // find table to append to
			var clone = row.cloneNode(true); // copy children too
			clone.id = "newID"; // change id or other attributes/contents
			table.appendChild(clone); // add new row to end of table
		}
	</script>
</t:master>
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
		  	<td>Start Time</td>
		  	<td>End</td>
		  	<td>End Time</td>
		  	<td>Description</td>
		  	<td>Resolution</td>
		  </tr>
		  <tr id="rowToClone">
		    <td>
		   		<select name="type">
		    		<c:forEach items="${overtimeEntries}" var="entry">
		    			<option value="${entry}">${entry}</option>
		  			</c:forEach>
				</select>
		    </td>
		    <td><input type="text" name="start" id="startDatepicker"></td>
		    <td><input type="text" name="startTime"></td>
		    <td><input type="text" name="end" id="endDatePicker"></td>
		    <td><input type="text" name="endTime"></td>
		    <td><textarea name="desc"></textarea></td>
		    <td><textarea name="res"></textarea></td>
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
		
		$(function() {
		    $( "#startDatepicker" ).datepicker();
		    $( "#endDatePicker" ).datepicker();
		});
	</script>
</t:master>
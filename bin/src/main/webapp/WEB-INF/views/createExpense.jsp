<!DOCTYPE html>
<html>
<head>
    <title>Add Expense</title>
	<style>	body {
	  font-family: Arial, sans-serif;
	  text-align: center;
	  margin: 20px;
	}

	form {
	  display: inline-block;
	  text-align: left;
	  padding: 20px;
	  border: 1px solid #ccc;
	  border-radius: 5px;
	  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	  width: 400px; /* Adjust width as needed */
	}

	label {
	  display: block;
	  margin-bottom: 5px;
	}

	input, select {
	  width: 100%;
	  padding: 10px;
	  margin-bottom: 10px;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	}

	button {
	  background-color: #4CAF50;
	  color: white;
	  padding: 10px 20px;
	  border: none;
	  border-radius: 4px;
	  cursor: pointer;
	}

	#splitFields {
	  margin-top: 10px;
	}

	p {
	  color: red;
	  margin-top: 10px;
	}
 </style>
    <script>
        function updateFields() {
            var method = document.getElementById("splitMethod").value;
            var participants = document.getElementById("participants").value;
            var participantsArray = participants.split(',').map(part => part.trim()); // Trim any extra spaces
            var splitFields = document.getElementById("splitFields");

            splitFields.innerHTML = '';

            if (method === 'EQUAL') {
                splitFields.innerHTML = 'All participants will split the expense equally.';
            } else if (method === 'EXACT') {
                splitFields.innerHTML = '<label>Enter each participant\'s exact amount:</label><br/>';
                participantsArray.forEach(function(participant) {
                    splitFields.innerHTML += '<label>' + participant + ':</label><input type="number" step="0.01" name="splits[' + participant + ']" required/><br/>';
                });
            } else if (method === 'PERCENTAGE') {
                splitFields.innerHTML = '<label>Enter each participant\'s percentage (must add up to 100%):</label><br/>';
                participantsArray.forEach(function(participant) {
                    splitFields.innerHTML += '<label>' + participant + ':</label><input type="number" step="0.01" name="splits[' + participant + ']" required/><br/>';
                });
            }
        }
    </script>
</head>
<body>
    <h2>Add New Expense</h2>
    <form action="/expenses" method="post">
        <label>Description:</label>
        <input type="text" name="description" required/><br/>
        <label>Amount:</label>
        <input type="number" step="1" name="amount" required/><br/>
        <label>Split Method:</label>
        <select id="splitMethod" name="splitMethod" onchange="updateFields()">
            <option value="EQUAL">Equal</option>
            <option value="EXACT">Exact</option>
            <option value="PERCENTAGE">Percentage</option>
        </select><br/>
        <label>Participants (comma-separated emails):</label>
        <input type="text" id="participants" name="participants" onchange="updateFields()" required/><br/>
        <div id="splitFields"></div>
        <input type="submit" value="Add Expense"/>
    </form>
    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>
</body>
</html>

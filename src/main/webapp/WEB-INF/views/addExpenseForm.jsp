<!DOCTYPE html>
<html>
<head>
    <title>Add Expense</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            text-align: center;
            margin-top: 50px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
        }
        input, select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
        }
        .button {
            background-color: green;
            color: white;
            padding: 10px 20px;
            margin: 5px;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Add Expense</h2>
        <form action="/api/users/addExpense" method="post">
            <div class="form-group">
                <label for="description">Description:</label>
                <input type="text" id="description" name="description" required>
            </div>
            <div class="form-group">
                <label for="totalAmount">Total Amount:</label>
                <input type="number" id="totalAmount" name="totalAmount" required>
            </div>
            <div class="form-group">
                <label for="splitType">Split Type:</label>
                <select id="splitType" name="splitType" required>
                    <option value="EQUAL">Equal</option>
                    <option value="EXACT">Exact</option>
                    <option value="PERCENTAGE">Percentage</option>
                </select>
            </div>
            <div class="form-group" id="sharesContainer">
                <h3>Shares</h3>
                <div id="shareTemplate" style="display: none;">
                    <label>User ID:</label>
                    <input type="number" name="shares[].userId">
                    <label>Amount:</label>
                    <input type="number" name="shares[].amount">
                    <label>Percentage:</label>
                    <input type="number" name="shares[].percentage">
                </div>
            </div>
            <button type="button" class="button" onclick="addShare()">Add Share</button>
            <button type="submit" class="button">Submit Expense</button>
        </form>
    </div>

    <script>
        function addShare() {
            var container = document.getElementById('sharesContainer');
            var template = document.getElementById('shareTemplate');
            var clone = template.cloneNode(true);
            clone.style.display = 'block';
            container.appendChild(clone);
        }
    </script>
</body>
</html>

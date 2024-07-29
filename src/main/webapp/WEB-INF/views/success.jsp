<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Successful</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background-color: #f0f0f0;
        }

        .dashboard {
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            padding: 20px;
            width: 80%;
            max-width: 600px;
            text-align: center;
        }

        h2 {
            color: #333;
        }

        p {
            color: #666;
        }

        .profile {
            margin-bottom: 20px;
        }

        .actions button {
            padding: 10px 20px;
            margin: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .actions button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="dashboard">
        <h2>${message}</h2>
        <div class="profile">
            <p>Welcome to your Dashboard, ${user.name}!</p>
            <p>Email: ${user.email}</p>
            <p>Mobile: ${user.mobile}</p>
        </div>
        <div class="actions">
            <button onclick="window.location.href='/users/addExpense?email=${user.email}'">Add Expense</button>
            <button onclick="window.location.href='/users/viewProfile?email=${user.email}'">View Profile</button>
            <button onclick="window.location.href='/users/logout'">Logout</button>
        </div>
    </div>
</body>
</html>

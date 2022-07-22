<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Marketplace</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
<div>
    Add user
    <form action="/add-user" method="post">
        <div>
            <label>First Name:</label>
            <div>
                <input type="text" name="firstname" placeholder="First name"/>
            </div>
            <label>Last Name:</label>
            <div>
                <input type="text" name="lastname" placeholder="Last name"/>
            </div>
        </div>
        <div>
            <label>Amount of money:</label>
            <div>
                <input type="text" name="amountOfMoney" placeholder="Amount of money"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Add</button>
    </form>
</div>
<br>
<div>
    Add product
    <form action="/add-product" method="post">
        <div>
            <label>Name:</label>
            <div>
                <input type="text" name="name" placeholder="Name"/>
            </div>
        </div>
        <div>
            <label>Price:</label>
            <div>
                <input type="text" name="price" placeholder="Price"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Add</button>
    </form>
</div>
<br>
<div>
    Buy product
    <form action="/buy-product" method="post">
        <div>
            <label>User Id:</label>
            <div>
                <input type="text" name="userId" placeholder="User Id"/>
            </div>
        </div>
        <div>
            <label>Product Id:</label>
            <div>
                <input type="text" name="productId" placeholder="Product Id"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Buy</button>
    </form>
</div>

</body>
</html>